import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateTimeSerializer implements JsonSerializer<Date> {

	@Override
	public JsonElement serialize(Date data, Type typeOfSrc,
			JsonSerializationContext context) {
		return new JsonPrimitive(new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(data));
	}
}