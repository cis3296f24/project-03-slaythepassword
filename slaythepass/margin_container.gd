extends MarginContainer

# The text to display
var full_text = "Welcome to Slay the Password, a text-based game where you have to guess the password. Will you succeed, or will you fail? Let the challenge begin!"
var displayed_text = ""  # What has been displayed so far
var text_index = 0  # Current position in the text

# Timer for displaying characters
var type_timer: Timer
var typing_speed = 0.05  # Delay between each character in seconds

var is_skipping = false  # Whether the text is being skipped


func _ready():
	# Ensure a Label exists as a child to display text
	if not $Panel.has_node("Label"):
		print("Error: Missing Label node under Panel.")
		return

	# Create a Timer node for typing effect
	type_timer = Timer.new()
	type_timer.wait_time = typing_speed
	type_timer.one_shot = false
	type_timer.connect("timeout", Callable(self, "_on_type_timer_timeout"))
	add_child(type_timer)
	type_timer.start()

func _process(delta):
	# Check for spacebar press to skip to the end
	if Input.is_action_just_pressed("ui_accept") and not is_skipping:
		is_skipping = true
		skip_to_end()

func _on_type_timer_timeout():
	# Add the next character to displayed_text
	if text_index < full_text.length():
		displayed_text += full_text[text_index]
		text_index += 1
		update_label()
	else:
		type_timer.stop()  # Stop the timer when text is fully displayed

func skip_to_end():
	# Show the full text instantly
	displayed_text = full_text
	text_index = full_text.length()
	update_label()
	type_timer.stop()  # Stop the timer

func update_label():
	# Update the Label node with the currently displayed text
	$Panel/Label.text = displayed_text
