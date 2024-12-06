extends Node2D

# Variables
var fade_duration = 2.0  # Duration of the fade-in effect in seconds
var fade_delay = 2.0  # Delay before the fade-in starts
var elapsed_time = 0.0  # Tracks time for the fade-in
var fading = false  # Whether the fade-in is active

onready var character: Sprite2D = $SlayTheSpireMainCharacters  # Reference your Sprite2D node

func _ready():
	# Ensure the character starts invisible
	character.modulate = Color(1, 1, 1, 0)
	print(character)


	# Start a timer for the fade delay
	var timer = Timer.new()
	timer.wait_time = fade_delay
	timer.one_shot = true
	timer.connect("timeout", Callable(self, "_start_fade_in"))
	add_child(timer)
	timer.start()

func _process(delta):
	if fading:
		# Gradually increase opacity during the fade duration
		elapsed_time += delta
		var progress = elapsed_time / fade_duration
		progress = clamp(progress, 0, 1)  # Ensure progress is between 0 and 1
		character.modulate = Color(1, 1, 1, progress)

		# Stop fading once fully visible
		if progress >= 1.0:
			fading = false
			_switch_to_scene()

func _start_fade_in():
	fading = true
	elapsed_time = 0.0

func _switch_to_scene():
	get_tree().change_scene("res://scene3.tscn")
