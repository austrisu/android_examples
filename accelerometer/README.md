# Accelerometer

The accelerometer is a sensor that measures the device's acceleration in three dimensions: x, y, and z. It is commonly used in Android apps to detect the device's movement and orientation. This is an example Android app that displays the current values of the device's accelerometer on the screen.

Basicaly this code registers a listener for sensor events. It specifies that the `eventListener` object should be notified whenever there are changes in the values of the `sensor` (which is the accelerometer sensor in this case).