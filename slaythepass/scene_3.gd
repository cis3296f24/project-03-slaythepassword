extends Node2D

@onready var music_player = $TheHeart
# Variables for UI components
@onready var feedback_label = $MarginContainer/Panel/Label  # Label to display feedback
@onready var hint_label = $MarginContainer/Panel/HintLabel  # Label to display hints
@onready var input_field = $MarginContainer/Panel/LineEdit  # LineEdit for user input
@onready var fight_button = $MarginContainer/Panel/FightButton  # Button to "Attack"

# Password condition description
var password_condition_description = "Password must contain at least three types of characters: letters, digits, and special characters."

func _ready():
	music_player.play()
	# Initialize the UI
	feedback_label.text = "Enter your password and press FIGHT!"
	hint_label.text = "Hint: " + password_condition_description

	# Connect the "pressed" signal of the fight button
	fight_button.connect("pressed", Callable(self, "_on_fight_button_pressed"))

func _on_fight_button_pressed():
	# Get the user input from the LineEdit
	var input_password = input_field.text.strip_edges()
	if input_password == "":
		feedback_label.text = "You must enter a password to fight!"
		return

	# Validate the password
	var is_valid = check_password_conditions(input_password)
	if is_valid:
		feedback_label.text = "HIT! You defeated the boss!"
		hint_label.text = "Congratulations! You guessed the correct password."
		fight_button.disabled = true  # Disable further attacks on success
	else:
		feedback_label.text = "MISS!"
		hint_label.text = "Hint: Your password does not meet the requirements. Try again!"
		update_hints(input_password)

func check_password_conditions(password: String) -> bool:
	# Conditions: Password must have letters, digits, and special characters
	if password == null:
		return false

	var has_letter = password.find("[a-zA-Z]") != -1
	var has_digit = password.find("[0-9]") != -1
	var has_special = password.find("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]") != -1

	# Count how many conditions are met
	var conditions_met = (1 if has_letter else 0) + (1 if has_digit else 0) + (1 if has_special else 0)
	return conditions_met >= 3

func update_hints(password: String):
	# Generate hints based on the missing conditions
	var missing = []

	if password.find("[a-zA-Z]") == -1:
		missing.append("letters")
	if password.find("[0-9]") == -1:
		missing.append("digits")
	if password.find("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]") == -1:
		missing.append("special characters")

	# Use String with separator to join the array elements
	hint_label.text = "Hint: Your password is missing " + String(", ").join(missing) + "."
