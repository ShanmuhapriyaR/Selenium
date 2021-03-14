package listener;

import Base.Driver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends Driver implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failure");
        try {
            takeSnapShot(driver,System.getProperty("user.dir") + "/" + "src/screenshots");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish");
    }
}
