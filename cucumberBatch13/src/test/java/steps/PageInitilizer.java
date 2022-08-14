package steps;

import pages.DashboardPage;
import pages.EmployeeInformationPage;
import pages.LoginPage;

public class PageInitilizer {

    public static LoginPage login;
    public static DashboardPage dash;
    public static EmployeeInformationPage emp;

    public static void initilizePageObject(){
        login = new LoginPage();
        dash = new DashboardPage();
        emp = new EmployeeInformationPage();
    }
}
