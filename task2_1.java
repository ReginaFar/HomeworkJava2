/**
 * Задание 1.
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * 
 * Входная строка:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * 
 * Выходная строка:
 * select * from students where name = "Ivanov" and country = "Russia" and city
 * = "Moscow"
 */

public class task2_1 {
    public static void main(String[] args) {
        String strFirst = "select * from students where";
        String strInput = "{ \"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"} ";
        String str1 = strInput.replace("{", "").replace("}", "");
        String[] str2 = str1.split(",");
        StringBuilder finalStr = new StringBuilder(strFirst);
        for (int i = 0; i < str2.length; i++) {
            String[] str3 = str2[i].replace('"', ' ').split(":");
            if (!"null".equals(str3[1].trim())) {
                finalStr.append(str3[0]).append("=").append('"').append(str3[1].trim()).append('"');
            }
            if (i < str2.length - 2)
                finalStr.append(" and ");
        }
        System.out.println(finalStr);
    }
}