#!/bin/bash

led_path=( /sys/class/leds/sys_led/brightness /sys/class/leds/usr_led/brightness )

for i in "${led_path[@]}"
do
	echo "$i"
done

# Check if the user provided an argument
if [ $# -ne 1 ]; then
    >&2 echo "Usage: $0 <0 or 1>"
    exit 1
fi


# Get the value from the command line argument
value="$1"

# Check if the provided value is either 0 or 1
if [ "$value" -ne 0 ] && [ "$value" -ne 1 ]; then
    >&2 echo "Error: Input must be either 0 or 1."
    exit 1
fi

# Write the value to the hardcoded output file
for i in "${led_path[@]}"
do
	echo "$value" > "$i"
	# Check if the write was successful
	if [ $? -eq 0 ]; then
		echo "Value '$value' written to '$i' successfully."
	else
		>&2 echo "Error writing to '$i'."
		exit 1
	fi
done
exit 0
