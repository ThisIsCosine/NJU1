import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Stream {

	// 使用命令式范式实现
	public static String getNamesStringImperatively(List<String> nameList) {
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).length() != 1) {
				r.append(nameList.get(i).substring(0, 1).toUpperCase()).append(nameList.get(i).substring(1)).append(",");

			}
		}
		if (r.length() != 0)
			r.deleteCharAt(r.length() - 1);

		if (r.toString().length() != 0)
			return r.toString();
		else
			return "";
	}

	// 使用函数式范式实现
	public static String getNamesStringFunctionally(List<String> nameList) {
		List<String> result = nameList.stream().filter(map -> map.length() != 1).collect(Collectors.toList());
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			StringBuilder a = new StringBuilder();
			a.append(Character.toUpperCase(result.get(i).charAt(0)));
			for (int i1 = 1; i1 < result.get(i).length(); i1++) {
				a.append(result.get(i).charAt(i1));
			}
			r.append(a);
			if (i != result.size() - 1)
				r.append(",");
		}
		return r.toString();
	}
}
