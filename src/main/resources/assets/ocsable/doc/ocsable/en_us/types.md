# Types

OC: Sable uses a lot of tables returning various values which may be of use. This page exists to explain those tables.

*If you need any further explanation of these types or how to use them, I'd highly recommend looking them up as most are commonplace names for mathematical concepts!*

## Vectors

Methods and fields returning vectors as tables will return a table with the `x`, `y`, and `z` keys and matching number values.

For example, the position of `(4, 61, -17)` is returned as a table of `{["x"] = 4, ["y"] = 61, ["z"] = 17}`.

## Quaternions

Methods and fields returning quaternions as tables will return a table with the `x`, `y`, `z`, and `w` keys and matching number values.

For example, the unit quaternion of `(0, 0, 0, 1)` is returned as a table of `{["x"] = 0, ["y"] = 0, ["z"] = 0, ["w"] = 1}`.

## Matrices

Methods and fields returning matrices as tables will return a table representing a 2-dimensional array of varying *unit* sizes (*2x2*, *3x3*, *4x4*).

## Pose

Methods and fields returning poses as tables will return a table with the following key-value pairs:
- `position: table`: a vector representing the position stored within the pose
- `orientation: table`: a quaternion representing the orientation stored within the pose
- `scale: table`: a vector representing the scale within the pose
- `rotationPoint: table`: a vector representing the pivot/rotation point within the pose

## Dimension Physics

Methods and fields returning dimension physics settings will return a table with the following key-value pairs:
- `dimension: string`: the dimension's resource location
- `priority: number`: the priority of these settings versus other settings
- `gravity: table`: a vector representing the constant gravitational pull
- `pressure: number`: the pressure multiplier applied everywhere in the dimension
- `magneticNorth: table`: a directional vector representing magnetic (true) north
- `universalDrag: number`: the universal drag constant
- `pressureFunction: table`: a bezier function representing air pressure at various altitudes

### Bezier Function

Methods and fields returning bezier functions will return a value with the following methods:
- `evaluateFunction(position: number): number`: computes the air pressure at the given altitude
- `getPoints(): table`: returns an array of control points along the bezier curve (read below)

#### Bezier Function Control Points

Methods and fields returning control points along a bezier function curve will return a table with the following key-value pairs:
- `altitude: number`: the altitude at which this point sits
- `value: number`: the air pressure at this point
- `slope: number`: the slope from this point to the next