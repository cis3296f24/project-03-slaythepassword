extends Sprite2D

# Local variables for fade-in effect
var fade_duration = 0.5  # Duration of fade-in (in seconds)
var elapsed_time = 0.0  # Tracks fade-in progress
var fading = false  # Whether the sprite is currently fading in
var fade_delay = 2.0  # Delay before the fade-in starts

func _ready():
	# Start with the sprite fully transparent
	modulate = Color(1, 1, 1, 0)

	# Create a timer to start the fade-in process after the delay
	var timer = Timer.new()
	timer.wait_time = fade_delay
	timer.one_shot = true
	timer.connect("timeout", Callable(self, "_start_fade_in"))
	add_child(timer)
	timer.start()

func _process(delta):
	if fading:
		# Increment elapsed time and calculate fade progress
		elapsed_time += delta
		var progress = clamp(elapsed_time / fade_duration, 0, 1)
		modulate = Color(1, 1, 1, progress)  # Update the alpha value

		# Stop fading once fully visible
		if progress >= 1.0:
			fading = false

func _start_fade_in():
	# Start the fade-in process
	fading = true
	elapsed_time = 0.0
