package planner.workingWithTheUser;

import planner.erorrs.Checking;
import planner.erorrs.IncorrectArgumentException;

interface RequestTitle {
    static String requestTitle() {
        String str = Request.request();
        try {
            Checking.checking(str);
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
            requestTitle();
        }
        return str;
    }
}
