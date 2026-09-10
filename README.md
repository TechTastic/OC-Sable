![Sable Card GIF](https://github.com/TechTastic/OC-Sable/blob/master/src/main/resources/animated_logo.gif?raw=true)
# OC: Sable
**OC: Sable** is an addon for [**OpenComputers: Rebooted**](https://www.curseforge.com/minecraft/mc-mods/opencomputers-rebooted) which adds a new card to allow computer direct access to [**Sable**](https://modrinth.com/mod/sable) sub-levels!

This is similar in functionality to [**CC: Sable**](https://modrinth.com/mod/cc-sable)!

### Features:
- Sable Card (`component.sable`)  
    - `isInPlotGrid` - function: determines whether the computer is located within a sub-level  
    - `uniqueId` - field: the unique ID of the sub-level the computer is on or null  
    - `name` - field: allows the computer ot get or set the name of the sub-level or null  
    - `logicalPose` - field: the logical pose of the sub-level as a table or null  
    - `lastPose` - field: the last pose of the sub-level as a table or null  
    - `velocity` - field: the velocity of the sub-level or a unit vector  
    - `linearVelocity` - field: the linear velocity of the sub-level or null  
    - `angularVelocity` - field: the angular velocity of the sub-level or null  
    - `centerOfMass` - field: the center of mass of the sub-level in the plot grid or null  
    - `mass` - field: the mass of the sub-level or null  
    - `inverseMass` - field: the inverse mass of the sub-level or null  
    - `inertiaTensor` - field: the inertia tensor 3x3 matrix of the sub-level or null  
    - `inverseInertiaTensor` - field: the inverse inertia tensor 3x3 matrix of the sub-level or null  
    - `getAirPressure` - function: gets the air pressure at a given position in the same dimension  
    - `gravity` - field: the gravity vector of the dimension  
    - `magneticNorth` - field: the magnetic north vector of the dimension  
    - `universalDrag` - field: the universal drag constant of the dimension  
    - `dimensionPhysics` - field: the dimension physics settings of the dimension as a table  
    - `defaultDimensionPhysics` - field: the default dimension physics settings as a table  

### To Do:
- Manual Entry
- Creative Tab
- Physics-Enabled Drones
- Separate CC: Advanced Math clone for OC

### FAQ
Q) Why should I use this over Aeronautic's existing computer behaviour?  
A) You don't have to at all. While my card does give far greater access to internal physics information, it is not impossible to derive most of these values using the existing drivers.***However, this is an addon for Sable, not Aeronautics!*** While the two will likely be used together, others can use Sable without Aeronautics at all!