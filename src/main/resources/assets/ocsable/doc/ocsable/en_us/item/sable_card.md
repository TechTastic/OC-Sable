# Sable Card

![How Did I Trap a Sable in a Card...](item:ocsable:sable_card)

The Sable Card is a utility card that provides access to the internal physics information of Sable's sub-levels under the component name `sable`.

*Note: If you have questions about the tables returned by certain fields or methods, explanations can be found [here](../types.md).

## Methods
- `isInPlotGrid() -> boolean`: Determines whether the attached computer is in the Plot Grid of a Sub-Level (aka being on a Sub-Level)
- `getAirPressure(x: number, y: number, z: number) -> number`: Gets the air pressure at the given position based upon the dimension's physics settings

## Fields
- `uniqueId: string`: Gets the string version of the Sub-Level's Unique ID or null
- `name: string`: Gets the current name of the Sub-Level or null as well as sets the current name of the Sub-Level
- `logicalPose: table`: Gets the logical pose of the Sub-Level as a table or null
- `lastPose: table`: Gets the last pose of the Sub-Level as a table or null
- `velocity: table`: Gets the velocity vector of the Sub-Level as a table or a unit vector as a table
- `linearVelocity: table`: Gets the linear velocity vector of the Sub-Level as a table or null
- `angularVelocity: table`: Gets the angular velocity vector of the Sub-Level as a table or null
- `centerOfMass: table`: Gets the Center of Mass vector of the Sub-Level as a table or null
- `mass: number`: Gets the mass of the Sub-Level or null
- `inverseMass: number`: Gets the inverse mass of the Sub-Level or null
- `inertiaTensor: table`: Gets the inertia tensor 3x3 matrix of the Sub-Level as a table or null
- `inverseInertiaTensor: table`: Gets the inverse inertia tensor 3x3 matrix of the Sub-Level as a table or null
- `gravity: table`: Gets the dimension's gravity vector as a table
- `magneticNorth: table`: Gets the dimension's magnetic north vector as a table
- `universalDrag: number`: Gets the dimension's universal drag constant
- `dimensionPhysics: table`: Gets the dimension's physics settings as a table or null
- `defaultimensionPhysics: table`: Gets the default physics settings as a table or null