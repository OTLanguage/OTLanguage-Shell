package origin.variable;

import origin.item.KeyValueItem;
import origin.item.Setting;
import origin.item.kind.VarType;
import origin.item.work.VariableWork;

import java.util.regex.Pattern;

public class FloatP extends Setting implements VariableWork {
    public static final String SPECIFIED = "ㅇㅅㅇ";
    public static final String patternText = "(\\n|^)\\s*ㅇㅅㅇ\\s";
    private final Pattern pattern = Pattern.compile(patternText);

    @Override
    public boolean check(String line) {
        return pattern.matcher(line).find();
    }

    @Override
    public void start(String line) throws Exception {
        KeyValueItem keyValue = setKeyValue(SPECIFIED, line);
        String key = keyValue.getKey();
        String value = keyValue.getValue();
        if (!varCheck.check(value, VarType.Float)) throw new Exception(typeErrorMessage);
        FM.put(key, Float.valueOf(value));
        set.add(key);
    }
}
