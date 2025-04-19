import driver.BaseTest;
import org.junit.Test;
import page.*;

public class testMain extends BaseTest {




    @Test
    public void webTest(){

        HomePage homePage = new HomePage();
        homePage.acceptCookies();
        homePage.checkPageOpen();
        homePage.clickCareersMenu();

        CareerPage careerPage= new CareerPage();
        careerPage.checkPageOpen();
        careerPage.goToQaDepartmant();

        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
        qualityAssurancePage.clickAllJobs();

        JobSearchPage jobSearchPage = new JobSearchPage();
        jobSearchPage.setLocation();
        jobSearchPage.setDepartment();
        jobSearchPage.checkJobList();
        jobSearchPage.clickViewRole();

        JobPage jobPage = new JobPage();
        jobPage.checkJobPage();
    }
}
