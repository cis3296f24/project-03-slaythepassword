extends Node2D

@onready var music_player = $slayy
 # Reference the Sprite node

func _process(delta):
	music_player.play()
	# Check if the Enter key (ui_accept) is pressed
	if Input.is_action_just_pressed("ui_accept"):
		print("Enter key pressed!")
		get_tree().change_scene_to_file("res://scene3.tscn")
