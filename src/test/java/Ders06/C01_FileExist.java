package Ders06;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\Roma\IdeaProjects\JUnitFramework

        String anaDizin=System.getProperty("user.home");//C:\Users\Roma
        System.out.println(anaDizin);
        //String file="C:\\Users\\Roma\\Desktop\\Bootstrap_Proje\\responsive_display.html";
        String file="C:/Users/Roma/Desktop/Bootstrap_Proje/responsive_display.html";
        Assert.assertTrue(Files.exists(Paths.get(file)));
    }
}
