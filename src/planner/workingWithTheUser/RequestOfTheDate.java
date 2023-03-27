package planner.workingWithTheUser;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface RequestOfTheDate {
    static LocalDate requestOfTheDate() {
        DateTimeFormatter ft = DateTimeFormatter.ofPattern ("dd.MM.yyyy");
        String str = Request.request();
        LocalDate parsingDate = null;
        try {
            parsingDate = LocalDate.parse(str, ft);
        }catch (DateTimeParseException e) {
            System.out.println("Не верные данные попробуйте еще раз");
            requestOfTheDate();
        }
        return parsingDate;
    }
}
