CS-537 Swarm Rover Projecit

We are making a harvester/ excavator with following characteristics:
1)Wheels
2)Harvestor
3)Radar_Sensor

Properties:
1)Wheels:

Wheels can move over terrain the fastest of any drive system.
Wheels can travel over Soil and Gravel.
Wheels cannot travel into or through Rock terrain
Wheels will immediately get stuck upon entering Sand terrain.

2)Harvestor:
Excavators can extract samples of science from Soil or Sand terrain.

3)Radar_Sensor:
RADAR_SENSOR -> mineral Science
Swarm Server Communications Protocols:
Communications between the rover and the server is all text based.
Connection hand-shaking are a series of sent and received Strings to establish a connection between
the rover and the swarm server.
Commands are one way. They are sent to the server but will generate no text reply back from the
server.
Requests are two directional. A request is sent to the server which responds with one or more lines of
text. The responses can be simple text or can be objects encoded using json.
Connection:
After starting the server will wait and listen on port 9537.
After the Rover connects to this port the Swarm Server will send it the string “SUBMITNAME”.
When the Rover receives the string “SUBMITNAME” it needs to respond by sending back to the server
the pre-defined RoverName (Enum) String that corresponds to that particular Rover. This string will be
of the format “ROVER_XX” where the XX is a numeric digit between the values 01 to 20. The leading
zero is necessary for the first 1-9 names in the series.
Server Commands:
MOVE
This command will be a string with the format “MOVE #”
Where the # is an uppercase letter {N, S, E, W} representing the direction the rover is requesting to
move. 
If there are no obstructions on the map for that particular rover’s drive system, the rover location will be
moved one map tile in the requested direction. If the tile contains an obstruction such as un-traversable
terrain or another rover, then the location of the rover will remain the same as before the move
request.
No response is returned by the server. To confirm the move was successful requires doing a request for
the rover position and checking if it has changed.
GATHER
This command will be a string of the format “GATHER”
It will have no additional parameters and will generate no response from the server.
When this command is issued if the rover is positioned on a tile that contains a sample of science, and if
the rover has the proper extraction tool for that particular tile terrain, then the science is removed from
the map and placed in the rover’s cargo storage.
Server Requests:
LOC
The command sent to the server will consist of the string “LOC”
The server will respond to this request with a single line of string text of the format:
“LOC xxx yyy”
Specifically the string will start with the upper case letters LOC then a space then one or more numerical
digits another space and an additional one or more digits.
The first set of digits will be the x coordinate of the tile the rover currently occupies.
The second set of digits will be the y coordinate of the tile the rover currently occupies.
The returned coordinate values may not have the same number of digits. The returned coordinate
values may or may not have leading zeros. The format of the two sets of digits may be different from
each other (number of digits, leading zeros, etc).
SCAN
The command sent to the server will consist of the string “SCAN”
The result returned by the server will consist of a series of text strings. The number of lines of text
returned is variable.
The first line of text returned will be the string “SCAN”
The following lines will be a ScanMap object that has been converted to a string json format.
The last line of text returned will be the string “SCAN_END”.
The ScanMap object contains a 2D MapTile[][] array of the area surrounding the rover. Each MapTile in
the array will contain attributes with Terrain features and whether the tile has another rover on it. The
MapTile will contain an attribute field for Science samples – but it will only contains those types that the
rover can sense based on the ScanningTools that it has equipped.
CARGO
The command sent to the server will consist of the string “CARGO”
The result returned by the server will consist of a series of text strings. The number of lines of text
returned is variable.
The first line of text returned will be the string “CARGO”
The following lines will be an ArrayList<Science> object that has been converted to a string json format.
The last line of text returned will be the string “CARGO_END”.
When reconstructed the ArrayList will contain a listing of all the Science samples held in the rovers cargo
hold.
EQUIPMENT
The command sent to the server will consist of the string “EQUIPMENT”
The result returned by the server will consist of a series of text strings. The number of lines of text
returned is variable.
The first line of text returned will be the string “EQUIPMENT”
The following lines will be an ArrayList<String> object that has been converted to a string json format.
The last line of text returned will be the string “EQUIPMENT _END”.
When reconstructed the ArrayList will contain a listing of the Rover Drive system Type and the two
RoverToolType attachments. The Drive and ToolTypes will be listed by their string converted names.
Index (0) in the array list will contain the Drive Type.

