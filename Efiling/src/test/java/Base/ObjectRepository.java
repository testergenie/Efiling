package Base;

public class ObjectRepository {
	
	// # login page
		public static String username = "//*[@id=\"user\"]";
		public static String password = "//*[@id=\"password\"]";
		public static String captcha = "//*[@id=\"captcha\"]";
		public static String captchaText = "//*[@id=\"captcha1\"]";
		public static String LogIn = "//*[@id=\"save\"]";

		//#dashboard
		public static String efiling="/html/body/app-root/div/div/div/div/app-main-login/div[2]/div[1]/a/div/div[1]/div[2]/h2";
		public static String Taxfiling="//*[@id=\"tax-filling\"]/div/div/div/h2";
		public static String Demonewbutn="/html/body/app-root/div/div/div/div/app-main-login/div[1]/div[2]/div/p-table/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button";
		public static String Maharastra="//*[@id=\"27AAACC1645G1ZZ\"]/span";
		public static String Audit="//*[@id=\"breadcrumb\"]/li[1]/a";
		public static String CFODashboard="//*[@id=\"breadcrumb\"]/li[2]/a";
		public static String CompnayAdmin="//*[@id=\"breadcrumb\"]/li[3]/a";
		public static String Recon="//*[@id=\"breadcrumb\"]/li[5]/a";

		public static String Dashboard="//*[@id=\"breadcrumb\"]/li[7]/a";
		public static String Home="/html/body/app-root/div[1]/app-main/div/div/ul/li[7]/a";
		public static String logout="/html/body/app-root/div[1]/app-main/div/div/ul/li[5]/a";
		public static String Year="//div[@class='col-lg-12 ']/div[2]/ng-select/div/div/span/i[2]";
		public static String month="//div[@class='col-lg-12 ']/div[1]/ng-select/div/div/span/i[2]";
		
		//#efiling
		public static String Upload="//*[@id=\"breadcrumb-menu\"]/li[2]/a";
		public static String salesupload="//app-main-footer/div/div/ul/li[2]/a";
		public static String purchaseupload="//app-main-footer/div/div/ul/li/a";
		public static String Choosetemplatetype="//div[@class='panel-body tab-content ']/div[2]/div/div/div/ng-select/div/div/span/i[2]";
		public static String choose="//p-fileupload/div/div/span";
		public static String cancelbutton="//*[@id=\"row\"]/div[2]/p-fileupload/div/div[1]/button[2]/span[2]";
		public static String uploadbutton="//*[@id=\"row\"]/div[2]/p-fileupload/div/div[1]/button[1]/span[2]";
		public static String GSTR1="//*[@id=\"breadcrumb-menu\"]/li[1]/a";
		public static String GSTR2="//*[@id=\"breadcrumb-menu\"]/li[2]/a";
		public static String GSTR3B="//*[@id=\"breadcrumb-menu\"]/li[3]/a";
		
		//#GSTR-1 Summary
		public static String ViewB2B="//*[@id=\"tbl_invoice_summ\"]/tr/td[10]/a";
		public static String ViewB2C="//tbody[@id='tbl_invoice_summ_others'][1]/tr[1]/td/a";
		public static String ViewAOF="//tbody[2]/tr[1]/td/a";
		public static String ViewADVREC="//tbody[3]/tr[1]/td/a";
		public static String viewNILRATED="//tbody[@id='tbl-nil-rated-details-1']/tr[1]/td/a";
		public static String ViewHSN="//tbody[@id='tbl_hsn_summary_os']/tr[1]/td/a";
		public static String ViewDOX="//tbody[@id='tbl_docx_summary']/tr[1]/td/a";
		public static String ViewTrunover="//tbody[@id='tbl_turnover_details']/tr[1]/td/a";
		
		//#Admin
		//#TGDSCREATION
		public static String TGDSGSTINFIELD="/html/body/app-root/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[1]/div/div/input";
		public static String TGDSPRODUCTSELECTION="/html/body/app-root/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[2]/div/div/ng-select/div";
		public static String TGDSNAME="/html/body/app-root/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[3]/div/div/input";
		public static String AddressTab="/html/body/app-root/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[4]/div/div/textarea";
		
		//upload
		public static String temclick="//*[@id=\"setFootertopmargin\"]/app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select";
		public static String filetypelist="//app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span";
		public static String finyearclick="//*[@id=\"setFootertopmargin\"]/app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/div/div/div[3]";
		public static String finyearlist="//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/ng-dropdown-panel/div[1]/div[2]/div[1]/span";
		public static String MONTHCLICK="//*[@id=\"setFootertopmargin\"]/app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/div/div/div[3]";
		public static String monhtlist="//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span";
		
		public static String chooseFile="//app-upload-data/div/div[1]/div/div/div/div[2]/div[3]/p-fileupload/div/div[1]/span/span[1]";
		
}
