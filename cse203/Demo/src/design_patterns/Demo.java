package design_patterns;

public class Demo {
    public static void main(String[] args) {
        CompanyInfo companyInfo1 = CompanyInfo.getInstance();
        companyInfo1.setAddress("Viet Nam");
        CompanyInfo companyInfo2 = CompanyInfo.getInstance();
        companyInfo2.setAddress("Han Xeng");
        System.out.println(companyInfo2);
        System.out.println(companyInfo1);
        
    }
}
