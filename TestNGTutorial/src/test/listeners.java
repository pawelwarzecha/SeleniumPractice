package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        //screenshot
    }

}
