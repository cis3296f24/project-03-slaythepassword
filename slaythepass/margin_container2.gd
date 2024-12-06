extends MarginContainer

# Variables for UI components
@onready var feedback_label = $MarginContainer/Panel/Label  # Label to display feedback
@onready var hint_label = $MarginContainer/Panel/HintLabel  # Label to display hints
@onready var input_field = $MarginContainer/Panel/LineEdit  # LineEdit for user input
@onready var fight_button = $MarginContainer/Panel/FightButton  # Button to "Fight"

# Password condition description
var password_condition_description = "Password must contain at least three types of characters: letters, digits, and special characters."

func _ready():
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
		feedback_label.text = "Access Granted! You passed the challenge."
	else:
		feedback_label.text = "Access Denied! Your password does not meet the requirements."
		update_hints(input_password)

func check_password_conditions(password: String) -> bool:
	# Conditions: Password must have letters, digits, and special characters
	if password == null:
		return false

	var has_letter = password.find("[a-zA-Z]") != -1
	var has_digit = password.find("[0-9]") != -1
	var has_special = password.find("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]") != -1
	return (has_letter + has_digit + has_special) >= 3

func update_hints(password: String):
	# Generate hints based on the missing conditions
	var missing = []

	if password.find("[a-zA-Z]") == -1:
		missing.append("letters")
	if password.find("[0-9]") == -1:
		missing.append("digits")
	if password.find("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]") == -1:
		missing.append("special characters")

	hint_label.text = "Hint: Your password is missing " + missing.join(", ") + "."
