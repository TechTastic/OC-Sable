package io.github.techtastic.ocsable.oc;

import dev.ryanhcode.sable.companion.math.Pose3dc;
import dev.ryanhcode.sable.physics.config.dimension_physics.BezierResourceFunction;
import dev.ryanhcode.sable.physics.config.dimension_physics.DimensionPhysics;
import io.github.techtastic.ocsable.util.BezierResourceFunctionCallback;
import li.cil.oc.api.driver.Converter;
import org.joml.*;
import java.util.Map;

public class SableConverters implements Converter {
    @Override
    public void convert(Object value, Map<Object, Object> output) {
        switch (value) {
            case Pose3dc pose -> {
                output.put("position", pose.position());
                output.put("orientation", pose.orientation());
                output.put("scale", pose.scale());
                output.put("rotationPoint", pose.rotationPoint());
            }
            case DimensionPhysics dim -> {
                output.put("dimension", dim.dimension().toString());
                output.put("priority", dim.priority());
                dim.baseGravity().ifPresent(gravity -> output.put("gravity", gravity.get(new Vector3d())));
                dim.basePressure().ifPresent(pressure -> output.put("pressure", pressure));
                dim.magneticNorth().ifPresent(magneticNorth -> output.put("magneticNorth", magneticNorth.get(new Vector3d())));
                dim.universalDrag().ifPresent(drag -> output.put("universalDrag", drag));
                dim.pressureFunction().ifPresent(func -> output.put("pressureFunction", new BezierResourceFunctionCallback(func)));
            }
            case BezierResourceFunction.BezierPoint p -> {
                output.put("altitude", p.altitude());
                output.put("value", p.value());
                output.put("slope", p.slope());
            }
            default -> {}
        }
    }
}
