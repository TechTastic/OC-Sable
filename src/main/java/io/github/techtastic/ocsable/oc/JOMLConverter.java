package io.github.techtastic.ocsable.oc;

import li.cil.oc.api.driver.Converter;
import org.joml.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class JOMLConverter implements Converter {
    @Override
    public void convert(Object value, Map<Object, Object> output) {
        switch (value) {
            case Vector3dc v -> {
                output.put("x", v.x());
                output.put("y", v.y());
                output.put("z", v.z());
            }
            case Vector3fc v -> {
                output.put("x", v.x());
                output.put("y", v.y());
                output.put("z", v.z());
            }
            case Quaterniondc q -> {
                output.put("x", q.x());
                output.put("y", q.y());
                output.put("z", q.z());
                output.put("w", q.w());
            }
            case Quaternionfc q -> {
                output.put("x", q.x());
                output.put("y", q.y());
                output.put("z", q.z());
                output.put("w", q.w());
            }
            case Matrix2dc m -> convertMatrix(2, 2, output, (r, c) -> m.get(c, r));
            case Matrix2fc m -> convertMatrix(2, 2, output, (r, c) -> m.get(c, r));
            case Matrix3dc m -> convertMatrix(3, 3, output, (r, c) -> m.get(c, r));
            case Matrix3fc m -> convertMatrix(3, 3, output, (r, c) -> m.get(c, r));
            case Matrix4dc m -> convertMatrix(4, 4, output, (r, c) -> m.get(c, r));
            case Matrix4fc m -> convertMatrix(4, 4, output, (r, c) -> m.get(c, r));
            default -> {}
        }
    }

    private void convertMatrix(int rows, int columns, Map<Object, Object> output, BiFunction<Integer, Integer, Object> getter) {
        for (int i = 0; i < rows; i++) {
            Map<Integer, Object> row = new HashMap<>();
            for (int j = 0; j < columns; j++) {
                row.put(j + 1, getter.apply(i, j));
            }
            output.put(i + 1, row);
        }
    }
}
