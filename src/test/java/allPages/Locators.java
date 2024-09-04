package allPages;




import org.testng.annotations.Test;
import org.utility.BaseClass;

public class Locators extends BaseClass{

	public String Email="email";
	public String ValidEmailID="thirumaran0828@outlook.com";
	public String Password="password";
	public String ValidPassword="Thirumaran@1995";
	public String LoginBtn="kt_sign_in_submit";
	public String InvalidEmailID="thirumara0828@outlook.com";
	public String InvalidPassword="Thirumaran1995";
	public String DisabledEmailID="disabledmail@yopmail.com";
	public String Disabledpass="123123123123";
	public String EmailReq="//*[@id=\"kt_login_signin_form\"]/div[3]/div[1]/div/span";
	public String EmailLockMsg="//*[@id=\"kt_login_signin_form\"]/div[3]/div/span";
	//public String PassReq="//*[@id=\"kt_login_signin_form\"]/div[4]/div[2]/div/span";
	public String PassReq="//*[@id=\"kt_login_signin_form\"]/div[4]/div[3]/div/span";
	public String ForgetPassword="//div[@class='link-primary fs-6 fw-bolder']";
	public String TwoFAEmail="thirumaran@yopmail.com";
	public String TwoFAPass="123123123123";
	public String ValidEmailID1="test@yopmail.com";
	public String ValidPassword1="123412341234";
	public String SubmitBtn="btn btn-primary";
	public String OtpBox="twoFA";

	public String AdminBtn="/html/body/div/div[2]/div[1]/div[2]/div/div/div[7]/span/span[2]";
	public String ViewUserBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[1]/div/span[2]";
	public String ViewUserStsDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/span[2]/div/select";
	public String ViewUserAct="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[2]/a";
	public String VUAccRgtsAct="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[4]/div/div/button";
	public String VUAccRgtsAct1="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div[3]/div/div/div/button";
	public String VUAccRgtsActBckBtn="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[4]/div/div/div/a/div/div/div";
	public String VUAccRgtsActBckBtn1="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String ViewUserBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String VUBckBtn="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[4]/div/div/div/a/div/div/div";
	public String ViewUserSrchBtn="//input[@class='form-control form-control-solid w-250px ps-14 fs-6']";
	public String ViewUserSrchEditBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8]/div/div/a/span";
	public String VUEmailEditBtn="//*[@id=\"kt_content_container\"]/div[2]/div/div[2]/div[3]/img";
	public String VUPassEditBtn="//*[@id=\"kt_content_container\"]/div[2]/div/div[3]/div[3]/img";
	public String VUNewPassBtn="(//input[@class='form-control form-control-lg form-control-solid' and @type='password' and @style='background-color: rgb(238, 243, 247);'])[1]";
	public String VUCnfrmPassBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[2]/input";
	public String VUNewEmailID="//*[@id=\":r1:\"]/div[3]/div[2]/div[1]/input";
	public String VUNewEmailVerCode="//div[@class='btn btn-success' and text()='Get Verification Code']";
	public String VUNewEmailEtrOTP="//input[@class='form-control form-control-lg form-control-solid' and @type='text']";
	public String VUNewEmailUpdBtn="//button[text()='Update']";
	public String VUNewPassUpdBtn="//button[text()='Reset']";
	public String VUNewEmailClsBtn="//button[@class='ant-modal-close']";
	public String VUNewPassClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String VUStsClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String VUStusEditBtn="//*[@id=\"kt_content_container\"]/div[2]/div/div[4]/div[3]/img";
	public String VUStusEditRdoYes="//input[@name='yes']";
	public String VUStusUpdBtn="//button[@title='Click here to update status']";
	public String VU2FAEditBtn="//*[@id=\"kt_content_container\"]/div[3]/div/div[3]/div[3]/img";
	public String VU2FAYesBtn="(//input[@type='radio' and @class='form-check-input cursor-pointer' and @name='radioOption' and @value='Y'])[1]";
	public String VU2FAUpdBtn="//button[text()='Update']";
	public String VU2FAClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String VUAccRgtsBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/ul/li[2]/a";
	public String VUAccRgtsRepCB="REP";//name
	public String VUAccRgtsActSubBtn="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[4]/div/div/div/div[2]/div/div";
	public String VUAccRgtsActSubBtn1="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String VUTimeShtAccBtn="//*[text()='Timesheet Access']";
	public String VUTimeShtAccEnblBtn="yes";//name
	public String VUTimeShtAccDsblBtn="no";//name
	public String VUInstMap="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[2]/a/span";
	public String VUInstMapSpcInst="no";
	public String VUSpcInstTestCckbx="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/input";
	public String VUTestCckbxActEdtUsr="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div/div/div[4]/div/div/div/div[1]/div/a";
	public String VUTestCckbxActEdtUsr1="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";




	public String AddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button"; 
	public String SaveBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String MandatoryPopUp="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div/div/div[6]/button";
	public String FirstName="FirstName";
	public String ClearBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String LastName="LastName";
	public String EmailField="Email";
	public String UserRole="userRole";
	public String PhoneNum="Phone";
	public String Address1="Address1";
	public String Address2="Address2";
	public String City="City";
	public String ZipCode="ZipCode";
	public String EditButtonSymbol="//*[@id=\"kt_table_users\"]/tbody/tr/td[8]/div/div/a/span";
	public String BankSetupBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[2]/div/span[2]";
	public String BankAddBtn="//*[@id=\"kt_content_container\"]/div/div/div[1]/div[2]/div/button";
	public String SaveBtnBankSetup="//button[@class='btn btn-primary btn-md']";
	public String WarningMsg="//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div";
	public String BankName="bankName";
	public String AccNum="AccountNumber";
	public String ClrBtn="reset";
	public String Location="Location";
	public String DropDown="dropdownValue";
	public String AddAccntBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[3]/div[3]";
	public String SaveAccntBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/div[3]/button[2]";
	public String AccntGrpName="AccountGroup";
	public String AccntGrpEditBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[3]/div[4]";
	public String StatusEnable="/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[5]/div[2]/div/input";
	public String StatusDisable="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[5]/div[2]/div/span/input";
	public String AuthorizeYes="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[7]/div[2]/div/input";
	public String AuthorizeNo="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[7]/div[2]/div/span/input";
	public String UpdateBtn="//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String ClrBankBtn="//*[@id=\"reset\"]";
	public String AccountNameDropDown="dropdownValuenew";
	public String SearchBox="search-txt";
	public String EditBttn="//*[@id=\"kt_table_users\"]/tbody/tr/td[8]/div/div/a";
	public String ModifiedBankname="BankName";
	public String BnkStpStsDsbl="//input[@class='form-check-input cursor-poniter' and @value='N']";
	public String BnkStpStsDsblSveBtn="//button[@title='Click here to save']";


	public String AuthorizedNetClick="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[3]/div/span[2]";
	public String AuthorizeAddBtn="//*[@id=\"kt_content_container\"]/div/div/div[1]/div[2]/div/a/div/button";
	public String AuthorizeSaveBtn="//*[@id=\"kt_content_container\"]/form/div/div[6]/button[2]";
	public String AuthorizeWarningMsg="/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/div[4]/button";
	public String AuthorizeName="Name";
	public String AuthorizeTKey="TransactionKey";
	public String AuthorizeLoginID="LoginID";
	public String AuthorizeNotes="Notes";
	public String AuthoStatusRun="Running";
	public String AuthoStatusStop="Stop";
	public String AuthoSave="//*[@id=\"kt_content_container\"]/form/div/div[6]/button[2]";
	public String AuthoClr="//*[@id=\"kt_content_container\"]/form/div/div[6]/button[1]";
	public String AuthoBackBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[2]/a/a";
	public String AuthoSearchBtn="search-txt";
	public String AuthoEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr/td[7]/div/div/a/span";
	public String AutExistBackBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div[1]/div[2]/a";
	public String AutExistClrBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/div[5]/button[1]";
	public String AutExistUpdBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/div[5]/button[2]";
	public String AuthorizeExistName="Name";
	public String AuthorizeExistNotes="Notes";
	public String AuthoExistRun="Running";
	public String AuthoExistStop="Stop";

	public String IPWhitelistBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[4]/div/span[2]";
	public String IpSearchBtn="search-txt";
	public String IpAddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/button";
	public String IpAddress="ipAddress";
	public String IpResPerson="ResponsiblePerson";
	public String IpLocation="IPLocation";
	public String IpNotes="Notes";
	public String IpStatusEnbl="yes";
	public String IpStatusDSbl="no";
	public String IpAdressClr="reset1";
	public String IpAdressSave="//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String IpCloseBtn="//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div/button/span/span";

	public String UsrLog="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[5]/div/span[2]";
	public String UsrLogSrch="//*[@id=\"kt_content_container\"]/div[1]/div/span[2]/div/input";
	public String UsrLogView="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[9]/span/a";
	public String UsrLogBackBtn="//*[@id=\"kt_content_container\"]/div/div/div[1]/div[5]/a/div";

	public String EventLogBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[6]/div/span[2]";
	public String EventLogSearchBtn="//*[@id=\"kt_content_container\"]/div[1]/div/span[2]/div/input";
	public String EventLogViewBtn="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[8]/span/a";
	public String EventLogCloseBtn="//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div/button";

	public String ExceptionLogBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[7]/div/span[2]";
	public String ExceSearchBtn="//*[@id=\"kt_content_container\"]/div[1]/div/span[2]/div/input";

	public String HelpBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[8]/div/span[2]";
	public String HelpAddBtn="/html/body/div/div[3]/div[1]/div/div[1]/div[2]/div[1]";
	public String HelpAddBackBtn="/html/body/div/div[4]/div/div[1]/div[2]/a/button";
	public String HelpAddSaveBtn="/html/body/div/div[4]/div/div[1]/div[2]/button";
	public String HelpAddGrpBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[1]/div[2]/select";
	public String HelpAddGrpAddBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[1]/div[3]";
	public String HelpAddGrpAddClsBtn="/html/body/div[2]/div/div[2]/div/div[2]/div/button/span/span";
	public String HelpAddGrpAddClrBtn="txt-clear";
	public String HelpAddGrpAddSaveBtn="/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/form/div/button[2]";
	public String HelpAddGrpAddGrpTab="/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/form/input";
	public String HelpAddTitleBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[2]/div/div/div[2]/input";
	public String HelpAddStatusActBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[3]/div/div[2]/div/input";
	public String HelpAddStatusInActBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[3]/div/div[2]/div/span/input";
	public String HelpAddQuestionBtn="/html/body/div/div[4]/div/div[3]/div[2]/div[1]/div/div/div[2]/input";
	public String HelpAddAttachmentBtn="/html/body/div/div[4]/div/div[3]/div[1]/div[4]/div/div[2]/div/div/label/div/h6";
	public String HelpAddAnswerBtn="/html/body/div/div[4]/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div";
	public String HelpActiveBtn1="/html/body/div/div[3]/div[1]/div/div[3]/ul/li[1]/span";
	public String HelpActiveBtn2="/html/body/div/div[3]/div[1]/div/div[3]/ul/li[2]/span";
	public String HelpActiveBtn3="/html/body/div/div[3]/div[1]/div/div[4]/ul/li[1]/span";
	public String HelpActiveBtn4="/html/body/div/div[3]/div[1]/div/div[4]/ul/li[2]/span";
	public String HelpActiveBtn5="/html/body/div/div[3]/div[1]/div/div[4]/ul/li[3]/span";
	public String HelpActiveBtn6="/html/body/div/div[3]/div[1]/div/div[5]/ul/li[1]/span";
	public String HelpActiveBtn7="/html/body/div/div[3]/div[1]/div/div[5]/ul/li[2]/span";
	public String HelpActiveBtn8="/html/body/div/div[3]/div[1]/div/div[6]/ul/li/span";
	public String HelpActiveBtn9="/html/body/div/div[3]/div[1]/div/div[7]/ul/li[2]/span";
	public String HelpActiveEditBtn="/html/body/div/div[3]/div[2]/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/div[1]/div[3]/span/a/span";
	
	
	
	
	
	
	
	public String SubscriptionBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[7]/div/div[9]/div/span[2]";
	
	
	
	public String SetupBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[6]/span/span[2]";
	public String InstallerBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[6]/div/div[1]/div/span[2]";
	public String InstSearchBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input";
	public String InstAddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button";
	public String InstEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr/td[8]/div/div/a/span";
	public String InstBackBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[1]/div[2]/a/a";
	public String InstSaveBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/form/div/div[3]/button[2]";
	public String InstClrBtn="reset1"; //ID
	public String InstAlrtMsg="/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/div[8]/button";
	public String InstName="Installer";  
	public String InstStatusEnbl="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[2]/div[2]/label/div/input";
	public String InstStatusDSbl="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[2]/div[2]/label/div/span/input";
	public String InstCntryDD="status";
	public String InstStateDD="state";
	public String InstAdres1="Address1";
	public String InstAdres2="Address2";
	public String InstCity="City";
	public String InstZipCode="ZipCode";
	public String InstPhone ="Phone";
	public String InstEmail="Email";
	public String InstWebsite="Website";
	public String InstInvoiceCpy="SendInvoiceCopyto";
	public String InstCrmName="CRMName";
	public String InstCrmUrl="CRMUrl";
	public String InstApiActYes="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[15]/div[2]/label/div/input";
	public String InstApiActNo="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[15]/div[2]/label/div/span/input";	
	public String InstActionsBtn="//*[text()='Actions']";
	public String EditInstaller="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String InstUpdateBtn="//*[@id=\"kt_content_container\"]/form/div/div[3]/button[2]";
	public String InstResetBtn="reset1";
	public String InvstDetails="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstClseBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String InvstTraDate="Transactiondate"; //name
	public String InvstAmount="Amount"; //name
	public String InvstBankname="Bankname"; //name
	public String InvstAccnum="Accountnumber"; //name
	public String InvstRemarks="Remarks"; //name
	public String InvstDocAttach="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[6]/label[2]";
	public String InvstClrBtn="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[7]/button[1]";
	public String InvstSaveBtn="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[7]/button[2]";
	public String InvstBackBtn="//div[text()='Back']";
	public String InstStatusDD="status"; //name
	public String InvstEditBtn="//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr/td[9]/span/a/span";
	public String InvstCloseBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String InvstBankSetupBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[2]/a";
	public String InvstNSFSetupBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[3]/a";
	public String InvstNSFSetupUpdBtn="//*[@id=\"kt_content_container\"]/form/div/div/div[6]/button[2]";
	public String InvstNSFSetupAlrtBtn="//div[text()='Updated Successfully']";
	public String InvstNSFStpNoRadBtn="//*[@id=\"kt_content_container\"]/form/div/div/div[1]/div[2]/div/input";
	public String InvstNSFStpYesRadBtn="//*[@id=\"kt_content_container\"]/form/div/div/div[1]/div[2]/div/span/input";
	public String InvstNSFStpAtmptBtn="attempts";//id
	public String InvstNSFStpIntvBtn="intervals";//id
	public String InvstNSFStpClrBtn="//button[@class=\"btn btn-light me-3 btn-sm\"]";
	public String InvstNSFStpUpdBtn="//*[@id=\"kt_content_container\"]/form/div/div/div[4]/button[2]";
	public String InvstNSFStpUpdBtn1="//*[@id=\"kt_content_container\"]/form/div/div/div[6]/button[2]";
	public String InvstNSFStpAmtBtn="Amount";//name 
	public String InvstNSFStpSepTranBtn="ST";//name
	public String InvstNSFStpMonPayBtn="MP";//name
	public String InvstNSFStpActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div[4]/div/div/div/button";
	public String InvstNSFStpActBckBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";




	public String InvestorBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[6]/div/div[2]/div/span[2]";
	public String InvstrSrch="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input";
	public String InvstrStatusDD="status";
	public String InvstrAddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button";
	public String InvstrExcelBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/div/button";	
	public String InvstrEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[8]/div/div/a/span";
	public String InvstrWarningMsg="/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/button";
	//*[@id="kt_body"]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/button
	public String InvstrName="Investor";//name
	public String InvstrEnblBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[2]/div[2]/label/div/input";
	public String InvstrDsblBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[2]/div[2]/label/div/span/input";
	public String InvstrCntry="status";//name
	public String InvstrState="state";//name
	public String InvstrAdd1="Address1";//name
	public String InvstrAdd2="Address2";//name
	public String InvstrCity="City";//name
	public String InvstrZipCode="ZipCode";//name
	public String InvstrPhone="Phone";//name
	public String InvstrEmail="Email";//name
	public String InvstrWebsite="Website";//name
	public String InvstrClrBtn="reset1";//id
	public String InvstrSaveBtn="//*[@id=\"kt_content_container\"]/form/div/div[3]/button[2]";
	public String InvstrBackBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[1]/div[2]/a/a";
	public String InvstrActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div[4]/div/div/div/button";
	public String EditInvstrBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String InvstrTransBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[2]/a";
	public String InvstrAddTans="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstrTranDate="Transactiondate";//name
	public String InvstrTranAmt="Amount";//name
	public String InvstrTranBank="Bankname";//name
	public String InvstrTranAccNum="AccountNumber";//name
	public String InvstrTranRemarks="Remarks";//name
	public String InvstrAttachBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[6]/div[2]/label[2]/div/h6";
	public String InvstrTranSavBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[7]/button[2]";
	public String InvstrTranClrBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[7]/button[1]";
	public String InvstrTranBckBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[2]/a/a";
	public String InvstrTranExcelBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String InvstrActBckBtn="/html/body/div[3]/div[3]/ul/li[4]/div/div/span/i";
	public String InvstrAddCusBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstrSelInstlrDD="//*[@id=\"kt_content_container\"]/div[2]/div/div[2]/select";
	public String InvstrCusName="//*[@id=\"kt_content_container\"]/div[2]/div[1]/div[3]/input";
	public String InvstrCusChckBox="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/table/tbody/tr/td[8]/input";
	public String InvstrCusSavBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String SettingSymbol="//*[@id=\"kt_aside_toolbar\"]/div[1]/div[2]/div/div[2]/a/span";
	public String SignOutBtn="/html/body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div[10]/a/div";
	public String InvstrTranEditbtn="//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr/td[9]/span/a/span";
	public String InvstrTranUpdBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[3]/button[2]";
	public String InvstrTranEditBckBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/div[2]/a/div";
	public String InvstrDwldBtn="//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr/td[4]";
	public String InvstrCusEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[9]/div/div/a/span";
	public String InvstrCusSrch="//*[@id=\"kt_content_container\"]/div[2]/div/div[1]/div[3]/input";
	public String InvstrCusSelBtn="//*[@id=\"kt_content_container\"]/div[2]/div/div[2]/div/table/tbody/tr/td[8]/input";
	public String InvstrCusUpdBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstrDocuBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[3]/a";
	public String InvstrViewBtn="//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr[1]/td[8]/span/a/span";
	public String InvstrDocUpdBtn="//button[@class='btn btn-primary btn-sm']";
	public String InvstrDocBckBtn="//*[@id=\"kt_content_container\"]/form/div/div[1]/a/div/div";
	public String InvstrDocDwldBtn="//*[@id=\"kt_content_container\"]/div[2]/div/table/tbody/tr[1]/td[3]";
	public String InvstrAddDocBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstrFileName="Filename"; //name
	public String InvstrFileToast="/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/button";
	public String InvstrFileUpldBtn="//*[@id=\"kt_content_container\"]/form/div/div[3]/div[2]/label[2]/div/h6";
	public String InvstrFileSaveBtn="//*[@id=\"kt_content_container\"]/form/div/div[5]/button";
	public String InvstrShowDashBrdYes="yes"; //name
	public String InvstrShowDashBrdNo="no"; //name
	public String InvstrShowToInvstrYes="//*[@id=\"kt_content_container\"]/form/div/div[5]/div[2]/div/input";
	public String InvstrShowToInvstrNo="//*[@id=\"kt_content_container\"]/form/div/div[5]/div[2]/div/span/input";
	public String InvstrFileAddSaveBtn="//*[@id=\"kt_content_container\"]/form/div/div[6]/button";
	public String InvstrNewFeedBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[4]/a";
	public String InvstrNewFeedViewIcon="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[7]/div/div/a/span";
	public String InvstrNewFeedUpdBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[5]/button";
	public String InvstrAddFeedBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvstrAddFeedSaveBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[4]/button";
	public String InvstrFeedClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String InvstrAddFeedTitBtn="Title"; //name
	public String InvstrAddNewsFeedBtn="NewsFeeds";//name
	public String InvstrDashBrdYes="yes";//name
	public String InvstrDashBrdNo="no";//name
	public String InvstrAddShwYes="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[4]/div/div/input";
	public String InvstrAddShwNo="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[4]/div/div/span/input";	
	public String InvstrNewFeedSaveBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div/div[5]/button";
	public String InvstrRepBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/ul/li[5]/a";
	public String InvstrSubBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String CusGrpBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[6]/div/div[3]/div/span[2]";

	public String CusSrchBox="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input";
	public String CusStsDD="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[1]/span[2]/div/select";//name
	public String CusAddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/button";
	public String CusSelInstlrDD="dropdownValue";//id
	public String CusGrpName="Groupname";
	public String CusGrpStsEnbl="yes";//name
	public String CusGrpStsDsbl="no";//name
	public String CusGrpClrBtn="reset1";//id
	public String CusGrpSavBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/button[2]";
	public String CusGrpCloseBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/button";
	public String CusGrpEditBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div/table/tbody/tr/td[8]/a/span/span";
	public String CusGrpEditStsEnbl="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div/form/div/div[1]/div[4]/div[2]/label/div/input";
	public String CusGrpEditStsDsbl="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div/div[1]/div[4]/div[2]/label/div/span/input";
	public String CusGrpEditClrBtn="search-txt";//id
	public String CusGrpEditUpdBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/button[2]";

	public String CustomerBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[5]/span/span[2]";
	public String CusListBtn="//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[1]/div/span[2]";
	public String CusBankDD="installer";//name
	public String CusListNameBox="searchtxt";//id
	public String CusLisActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/button";
	public String CusAddActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/form/div/div[1]/div[2]/div/button";
	public String CusListAddBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String CusListActSavBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String CustID="CustomerId";//name
	public String CustName="CustomerName";//name
	public String CusInstDD="client";//id
	public String CusPort="portfolio";//name
	public String CusPTODate="date";//name
	public String CusCrdScre="Creditscore";//name
	public String CusPrjSts="Projectstatus";//name
	public String CusStsYes="yes";//name
	public String CusStsNo="no";
	public String CusEnblStsYes="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[9]/div[2]/label/div/input";
	public String CusEnblStsNo="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[9]/div[2]/label/div/span/input";
	public String CusTypLTF="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[11]/div[2]/label/div/input";
	public String CusTypPre="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[11]/div[2]/label/div/span[1]/input";
	public String CusTypMP="manualpay";//name
	public String CusMonPay="Monthlypayment";//name
	public String CusTotYrs="Totalyears";//name
	public String CusEscal="Escalation";//name
	public String CusTotConAmt="TotalContrcatAmount";//name
	public String CusPhone="Phone";//name
	public String CusEmail="Email";//name
	public String CusCntryDD="status";//name
	public String CusStDD="State";//id
	public String CusAdd1="Address1";//name
	public String CusAdd2="Address2";//name
	public String CusCity="City";//name
	public String CusZipCde="Zipcode";//name
	public String CusFinancing="Financing";//name
	public String CusProjCost="Projecctcost";//name
	public String CusSysCost="Systemcost";//name
	public String CusSysSize="Systemsize";//name
	public String CusProd="production";
	public String CusPipLn="Pipeline";
	public String CusLeadPipLn="Leadpipeline";
	public String CusPanels="Panels";
	public String CusBatt="Batteries";
	public String CusWattPerPan="Watts";
	public String CusInvBrnd="Inventor";
	public String CusPayoffAmtYes="payYes";
	public String CusPayoffAmtNo="payNo";
	public String CusAddClrBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[37]/button[1]";
	public String CusAddSavBtn="(//button[text()='Save'])";
	public String CussAddActBackBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusPortAddBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[4]/div[3]";
	public String CusAddPortName="addPortfolio";//name
	public String CusAddPortEditBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div[4]/div[4]";
	public String CusAddPortClrBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[1]";
	public String CusAddPortSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String CusAddPortClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String CusActBckbtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusNameEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span";
	public String CusAddNotesBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/div[1]/div/a";
	public String CusNotesBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div/div/textarea";
	public String CusNotesSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div/div/div[3]/div";
	public String CusNotesClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String CusEditActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div[3]/div/button";
	public String CusEditActBtn1="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/form/div/div[1]/div[2]/div/button";
	public String CusEditCusBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String CusEditClrBtn="(//button[text()='Clear'])";
	public String CusEditUpdBtn="(//button[text()='Update'])";
	public String CusEditUpdBtn1="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String CusEditBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusEditActBtn2="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/form/div/div[1]/div[2]/div/button";
	public String CusEditInstAddBtn="//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[3]";
	public String CusEditPortSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String CusEditPortName="addPortfolio";//name
	public String CusEditPortClrBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[1]";
	public String CusEditPortClseBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String CusEditPortEditBtn="//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[4]";
	public String CusEditLTFBtn="//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/input";
	public String CusEditPreBtn="prepaid";//name
	public String CusEditUpdBtn2="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String CusEditBckBtn2="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusEditPaySchBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String CusEditPayUpdBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/button";
	public String CusEditActPayBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div/button";
	public String CusEditActPayBckBtn="/html/body/div[3]/div[3]/ul/li[12]/div/div/span";
	public String CusEditActPayMergeBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusEditActMergeBckBtn="/html/body/div[3]/div[3]/ul/li[12]/div/div/span";
	public String CusEditMrgeAgreBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[3]/div[2]/div/input";
	public String CusEditMrgeBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[4]/div[2]/button";
	public String CusEditChoseMrgDD="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div";
	public String CusEditViewRcdPaymtsBtn="/html/body/div[3]/div[3]/ul/li[4]/div/div/span";
	public String CusEditRcdPymntPrntbtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div[1]/div/div";
	public String CusEditRcdPymtActBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/a";
	public String CusEditMntlyPymnBtn="/html/body/div[3]/div[3]/ul/li[5]/div/div/span";
	public String CusEditMntlyPymnSavBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div[4]/button";
	public String CusEditMnthlyPymnActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div/button";
	public String CusEditMnthlyPymnBckBtn="/html/body/div[3]/div[3]/ul/li[12]/div/div/span";
	public String CusEditMntlyPayTab="monthlypay";//name
	public String CusEditMntlyEffFrom="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div[2]/div/div[2]/div/div/div/input";
	public String CusEditMntlyRsonTab="reason";//name
	public String CusEditCRMMonitBtn="/html/body/div[3]/div[3]/ul/li[10]/div/div/span";
	public String CusEditCRMUpdBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/form/div/div[3]/div[5]/div[2]/button";
	public String CusEditCRMDD="crm";//id
	public String CusEditCRMNameDD="crmname";//id
	public String CusEditProdEsc="productionescalation";//name
	public String CusEditFrstYrProd="firstyearproduction";//name
	public String CusEditCRMActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div[3]/div/button";
	public String CusEditCrmBckBtn="/html/body/div[3]/div[3]/ul/li[12]/div/div/span";
	public String CusEditDocStup="/html/body/div[3]/div[3]/ul/li[7]/div/div/span";
	public String CusEditDocChckBox="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[4]/div/input";
	public String CusEditDocStupSveBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[5]/button";
	public String CusEditDocUpldBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/label/div/h6";
	public String CusEditDocActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/button";
	public String CusEditDocBckBtn="/html/body/div[3]/div[3]/ul/li[10]/div/div/span";
	public String CusEditDocEscProg="/html/body/div[3]/div[3]/ul/li[9]/div/div/span";
	public String CusEditEscAgreBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div/input";
	public String CusEditEscRobtBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[1]/div/div/div/input";
	public String CusEditEscUpdBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[3]/div/button";
	public String CusEditBackBtn="/html/body/div[3]/div[3]/ul/li[11]/div/div/span";
	public String CusEditViewBtn="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[6]/span/a";
	public String CusEditViewClseBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";


	public String ACHFormBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[5]/div/div[2]/div/span[2]";
	public String ACHBankNameDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select";
	public String ACHBnkSrch="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[4]/input";
	public String ACHNameEditBtn="//*[@id=\"kt_table_users\"]/tbody/tr/td[10]/div/div/a/span";
	public String ACHEditClsBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/button";
	public String ACHType="type";//name
	public String ACHStatus="status";//name
	public String ACHEditManEtry="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/input";
	public String ACHEditUpdBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div[2]/button";
	public String ACHEditRobChckBox="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[5]/div[12]/div[3]/div/div/div[1]/div/div/div/input";
	public String ACHCheckBox1="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[5]/div[12]/div[3]/div/div/div[2]/div/div/div/input";
	public String ACHCheckBox2="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[5]/div[12]/div[3]/div/div/div[3]/div/div/div/input";
	public String ACHEditUpdBtn1="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[5]/div[12]/div[3]/div/div/div[4]/div/button";
	public String ACHEditMandChck="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[6]/button";
	public String ACHEditBckBtn="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[5]/div[12]/div[3]/div/div/div[4]/div/a/button";
	public String ACHNamOnAcc="nameonaccount";//name
	public String ACHBnkNam="bankname";//name
	public String ACHAccNum="bankaccountnumber";//name
	public String ACHAccRoutNum="bankroutingnumber";
	public String ACHBnkLoc="banklocation";//name
	public String ACHSndToCus="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/span[1]/input";
	public String ACHScdToCusBckBtn="/html/body/div[3]/div[3]/ul/li[5]/div/div/span";
	public String ACHActBckBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div[2]/div/a/div/div/div";
	public String ACHSndBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[8]/div/button";

	public String ACHActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/div[2]/div/button";
	public String ACHActSndToSls="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String ACHActCngPayDte="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String ACHActCngPayDteBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[3]/button";
	public String ACHActCngPayMandChk="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button";
	public String ACHCngPayDteEffFrm="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[1]/div/div/div/input";
	public String ACHCngpayDate="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[2]/select";
	public String ACHPayStsActBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div[2]/a";
	public String ACHSkipPay="/html/body/div[3]/div[3]/ul/li[4]/div/div/span";
	public String ACHSkipPayAgreBtn="confirm";//name
	public String ACHSkipPymntBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[5]/button";
	public String ACHSkipPymntMandMsg="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button";
	public String ACHSkpPyStrtMnth="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[1]/div/div/div/input";
	public String ACHSkpPyEndMnth="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[2]/div/div/div/input";
	public String ACHSkpPyRsn="reason";//name
	public String ACHSndToSlsPerBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/span[2]/input";
	public String ACHSndToSlsSndBtn="//*[@id=\"kt_account_deactivate_account_submit\"]";
	public String ACHCngpayDateBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[3]/button";
	public String ACHSndToCusToMailId="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/input";
	public String ACHSndToCusSkpPyBtn="/html/body/div[3]/div[3]/ul/li[4]/div/div/span";
	public String ACHSndToCusSkpPyMan="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button";
	public String ACHSndToCusSkpPySrtMnt="startmonth";//name
	public String ACHSndToCusSkpPyEndMnt="endmonth";//name



	public String ACHUploadBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[5]/div/div[3]/div/span[2]";
	public String ACHSubBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/button";
	public String ACHManMsgChk="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/div";
	public String ACHUploadFileBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/label/div/h6";
	public String ACHUploadDateBtn="//*[@id=\"kt_content_container\"]/div[2]/div[1]/div[2]";
	public String ACHUpldSampFilBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[1]/div[3]/a";
	public String ACHFrmStupBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/a/button";
	public String ACHUpldInstlrDD="installer";//id
	public String CusLisExclUpldBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String CusLisExclUplSumBtn="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[3]/button";
	public String CusLisExclMandMsg="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[1]/div/div";
	public String CusListExclUpldFilUpld="//*[@id=\"kt_content_container\"]/div[1]/div[2]/form/div[2]/div/label/div/h6";
	public String CusListExclUpldDateBtn="//*[@id=\"kt_content_container\"]/div[2]/div[1]/div[2]/input";

	public String ReportsBtn="//*[@id=\"#kt_aside_menu\"]/div[2]/span/span[2]";
	public String OSReportBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div/span[2]";
	public String OSReportExpBtn="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[7]/button";
	public String OSBankName="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[3]/select";
	public String OSPyType="status";//name
	public String OSPySts="status";//name
	public String OSCusName="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[6]/input";
	public String OSEditBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div/table/tbody/tr[1]/td[10]/a/span";
	public String OSAddNotes="//*[@id=\"kt_content_container\"]/div/div[2]/div[5]/div[1]/div[2]/button";
	public String OSAddNtSavBtn="//div[@class='btn btn-primary btn-sm']";
	public String OSAddNtTxtBox="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div/div/textarea";
	public String OSAddNtClsBtn="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/button/span/span";
	public String OSAddNtViewBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div[1]/span[3]/a";
	public String OSAddNtViewClsBtn="/html/body/div[3]/div/div[2]/div/div[2]/button";
	public String OSAddNtActBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div[2]/div/button";
	public String OSAddRcdPymt="/html/body/div[3]/div[3]/ul/li[1]/span[1]";
	public String OSAddRcdPySubBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div[2]/button[2]";
	public String OSAddRcdPyClsBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/button/span/span";
	public String OSAddManPymnt="/html/body/div[3]/div[3]/ul/li[2]/div/span";
	public String OSAddManSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button";
	public String OSAddManClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button/span/span";
	public String OSAddManDueMnt="Duemonth";
	public String OSAddManPayBtn="yes";//name
	public String OSAddManPyNSF="no";//name
	public String OSAddMonPayAmt="Monthlypay";//name
	public String OSAddMonPayRsn="Reason";//name
	public String OSAddManSchDate="Scheduledate";//name
	public String OSAddRcdPyTranDate="TransactionDate";//name
	public String OSAddRcdPyTranDes="Transactiondescription";//name
	public String OSAddRcdPyAmnt="Amount";//name
	public String OSAddRcdPyMode="credit";//id
	public String OSAddRcdPyBnkName="ACHdropdown";//name
	public String OSAddRcdPyTyp="ACHdropdown";//id
	public String OSAddRcdPyCLrBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/form/div[2]/button[1]";
	public String OSACtBckBtn="/html/body/div[3]/div[3]/ul/li[4]/div/i";

	public String TapeReprtBtn="//*[@id=\"#kt_aside_menu\"]/div[2]/div/div[2]/div/span[2]";
	public String TapeRepInstlrDD="//*[@id=\"kt_content_container\"]/div[1]/div/div[3]/div[2]/select";
	public String TapeRepRunRep="btnRunReport";//id
	public String TapeRepDwldBtn="//*[@id=\"dvdownload\"]/div/div/div/div/div/button";

	public String ACHTransBtn="//*[@id=\"#kt_aside_menu\"]/div[2]/div/div[3]/div/span[2]";
	public String ACHTransInstDD="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[1]/div[2]/select";//name
	public String ACHTransFrmDte="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[3]/div[2]/input";
	public String ACHCusSrch="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[5]/div[2]/input";
	public String ACHTransActBtn="//*[@id=\"kt_content_container\"]/div[1]/div[1]/div[6]/div/button";
	public String ACHTransFileLog="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String ACHTransExcelExp="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String ACHTransBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/i";
	public String ACHTransCusEditBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div/table/tbody/tr[1]/td[11]/a/span";
	public String ACHTransCusEditBCkBtn="achback";//id

	public String InvoiceLogBtn="//*[@id=\"#kt_aside_menu\"]/div[2]/div/div[5]/div/span[2]";
	public String InvLogBankDD="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[1]/select";
	public String InvLogPyType="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[2]/div/select";
	public String InvLogCusNam="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/div[5]/div/input";
	public String InvLogExprtBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[6]/button";
	public String InvLogCusEdtBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div/table/tbody/tr[1]/td[10]/a";
	public String InvLogFrmDate="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[3]/input";
	public String InvLogToDate="//*[@id=\"kt_content_container\"]/div/div[1]/div/div/div[4]/input";
	public String InvLogPymtUrl="lblPaymentUrl";//id
	public String InvLogRobBtn="//*[@id=\"ContentPlaceHolder1_checkRobot\"]";
	public String InvLogAgrBtn="ContentPlaceHolder1_checkTerms2";//id
	public String InvLogPayNw="ContentPlaceHolder1_inkbtnpaynow";//id
	public String InvLogCusEdtActBtn="invback";//id
	public String InvLogCusEdtActBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/i";
	public String InvLogRsndInv="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String InvLogRsndYes="/html/body/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div/button[2]";//id
	public String InvLogRsndNo="/html/body/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div/button[1]";
	public String InvLogDwldInv="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String InvLogDwldRecp="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvLogDwldAll="//*[@id=\"btndownloadall\"]/div/div";
	public String InvLogVoidInv="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String InvLogVoidRmrk="Remarks";//name
	public String InvLogVoidYes="btnConfirmationYes";//id
	public String InvLogVoidNo="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[1]/button";
	public String InvLogPayURLRob="//*[@id=\"hello\"]/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div[5]/div[2]/div/div[1]/div/div/div/input";//name
	public String InvLogPayURLAgre="//*[@id=\"hello\"]/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div[5]/div[2]/div/div[2]/div/div/div/input";//name
	public String InvLogPayURLPay="//*[@id=\"hello\"]/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div[5]/div[2]/div/div[3]/div/button";//name
	public String InvLogPayURLName="accountName";//name
	public String InvLogPayURLAcc="bankAccount";//name
	public String InvLogPayURLRout="bankRouting";//name


	public String ActRepBtn="//*[@id=\"#kt_aside_menu\"]/div[2]/div/div[6]/div/span[2]";
	public String ActRepoDD="status";
	public String ActRepoSearch="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div[4]/div/input";
	public String ActRepoViewBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[10]/i";
	public String ActRepoClsBtn="/html/body/div[3]/div/div[2]/div/div[2]/div/button/span/span";
			
			
	public String CusAudRepBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[7]/div/span[2]";
	public String CustAudRepDD="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/select";
	public String CustAudStatus="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/select";
	public String CustAudSearch="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[3]/div/input";
	public String CustAudExpBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[4]/button";
	public String CustAudViewBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div/table/tbody/tr[1]/td[10]/i";
	public String CustAudViewBtn1="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div/table/tbody/tr[1]/td[11]/i";
	public String CustAudViewAccNumCls="/html/body/div[3]/div/div[2]/div/div[2]/div/button/span/span";
	public String CustAudViewAccNumSub="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[5]/center/button[2]";
	public String CustAudViewAccNumCancel="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[5]/center/button[1]";
	public String CustAudViewAccNumCls1="/html/body/div[3]/div/div[2]/div/div[2]/div/button/span/span";
	public String CustAudViewAccNumSub1="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[5]/center/button[2]";
	public String CustAudViewAccNumCancel1="/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[5]/center/button[1]";
	
	
	
	public String SchedBtn="//*[@id=\"#kt_aside_menu\"]/div[4]/span/span[2]";
	public String ACHSchBtn="//*[@id=\"#kt_aside_menu\"]/div[4]/div/div[1]/div/span[2]";
	public String SchBankDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/select";
	public String SchFrmDte="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/input";
	public String SchActBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[4]/div/button";
	public String SchCusViewBtn="//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr[1]/td[10]/a/span";
	public String SchCusActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div[6]/div/button";
	public String SchCusFileLogBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String SchCusFileExcelExpBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String SchExcelExpBtn="//*[@id=\"simple-menu\"]/div[3]/ul/li[1]/div/div/i";
	public String SchCusFileBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/i";
	public String SCHAchSchBtn="//*[@id=\"simple-menu\"]/div[3]/ul/li[2]/div/div/div/i";

	public String SCHNoPayBtn="//*[@id=\"#kt_aside_menu\"]/div[4]/div/div[2]/div/span[2]";
	public String NoPayActBtn="//*[@id=\"kt_content_container\"]/div[1]/div/div/div[4]/div/button";
	public String NoPayStopBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/div";
	public String NoPayRunBtn="//*[@id=\"simple-menu\"]/div[3]/ul/li[2]/div/div/div/span";
	public String NoPaySunBtn="SUNDAY";//name
	public String NoPayMonBtn="MONDAY";//name
	public String NoPayTueBtn="TUESDAY";//name
	public String NoPayWedBtn="WEDNESDAY";//name
	public String NoPayThurBtn="THURSDAY";//name
	public String NoPayFriBtn="FRIDAY";//name
	public String NoPaySatBtn="SATURDAY";//name
	public String NoPayAddUsr="//*[@id=\"kt_content_container\"]/div[3]/div[1]/div/a";
	public String NoPayAddUsrSavBtn="//div[@class='btn btn-primary btn-sm text-end mb-3']";
	public String NoPayAddUSrNameBtn="//a[@class='text-dark text-hover-primary  fs-6 ']";
	public String NoPayAddUsrClsBtn="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/button";
	public String NoPayExtAddUsrBtn="//*[@id=\"kt_content_container\"]/div[4]/div[1]/div[2]/a";
	public String NoPayExtAddUsrClrBtn="//button[@class='btn btn-light me-3 btn-sm']";
	public String NoPayExtAddUsrSavBtn="//button[@class='btn btn-primary btn-sm']";
	public String NoPayExtAddUsrName="Name";//name
	public String NoPayExtAddUsrMail="Emailid";//name
	public String NoPayExtAddUsrTyp="usertype";//name
	public String NoPayExtClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String NoPaySavBtn="//*[@id=\"kt_content_container\"]/div[5]/div[2]/div[2]/div[2]/div/a";
	public String NoPayEmailSign="//*[@id=\"kt_content_container\"]/div[5]/div[2]/div[1]/div[2]/div[1]/select";

	public String InvoicePayBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[5]/div/div[4]/div/span[2]";
	public String IPBankDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select";
	public String IPPySts="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/select";
	public String IPSrchBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[3]/input";
	public String IPExcelBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/button";
	public String IPCusEditBtn="//*[@id=\"kt_content_container\"]/div/div[3]/div[1]/table/tbody/tr[1]/td[10]/a/span/span";
	public String IPChngInvDate="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/div/div/div[1]/div[1]/a/label/a";
	public String IPChngInvPayDatBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[3]/button";
	public String IPEffMonFrm="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[1]/div/div/div/input";
	public String IPPyDate="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[2]/select";
	public String IPChPyActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/button";
	public String IPChPyEditPyBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String IPChPyDepAccName="bankValue";//id
	public String IPChPyRobChck="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input";
	public String IPChPyAgrBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input";
	public String IPChPyUpdBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button";
	public String IPChPyBckBtn="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[1]/div[2]/a/button";
	public String IPChPyStpPy="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[1]/div/div/div[3]/a/div/div";
	public String IPChPyStpActBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[1]/div[2]/a";
	public String IPChPySkpPy="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String IPSkpPyStrtMnt="startmonth";//name
	public String IPSkpPyEndMnt="endmonth";//name
	public String IPSkpPyRsn="reason";//name
	public String IPSkpPyCnfrm="confirm";//name
	public String IPSkpPyBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[5]/button";
	public String IPChPyBackBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String IPChMntPyBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[3]/div/div/div[2]/div/a/label/a";
	public String IPChMntPyAmt="monthlypay";//name
	public String IPChMntPyEffDate="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div[2]/div/div[2]/div/div/div/input";
	public String IPChMntPyRsn="reason";//name
	public String IPChMntPySavBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/form/div/div[4]/button";
	public String IPChMntPyActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div/button";
	public String IPChMntPyEditCus="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String IPChMntPyEditActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/form/div/div[1]/div[2]/div/button";
	public String IPChMntPyEditClrBtn="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String IPChMntPyEditSavBtn="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String IPChMntPyEditBckBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String IPChMntPyAddCusPort="//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[3]";
	public String IPChMntPyAddCusPortName="addPortfolio";//name
	public String IPChMntPyAddCusPortClr="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[1]";
	public String IPChMntPyAddCusPortSav="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String IPChMntPyAddCusPortCls="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String IPChMntPyEdtCusPort="//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[4]/div[4]";
	public String IPChMntPyEdtCusPortClr="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[1]";
	public String IPChMntPyEdtCusPortSav="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/button[2]";
	public String IPChMntPyEdtCusPortCls="/html/body/div[4]/div/div[2]/div/div[2]/div/button";
	public String IPChMntPyEdtCusPortName="addPortfolio";//name
	public String IPChMntPyViwCusBtn="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String IPChMntPyEdPySch="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String IPChMntPyEdPySchUpd="//*[@id=\"kt_content_container\"]/div[2]/div/div/div[1]/div/button";
	public String IPChMntPyMrgCus="/html/body/div[3]/div[3]/ul/li[4]/div/div/span";
	public String IPChMntPyMrgCusMan="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[3]/div[2]/div/input";
	public String IPChMntPyMrgeBtn="//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[4]/div[2]/button";
	public String IPChMntPyMrgeCusDD="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div";
	public String IPChMntPyRcdPymts="/html/body/div[3]/div[3]/ul/li[5]/div/div/span";
	public String IPChMntPyRcdPyPrnt="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div[1]/div/div";
	public String IPChMntPyMonCRM="/html/body/div[3]/div[3]/ul/li[11]/div/div/span";
	public String IPChMntPyMonCRMUpd="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/form/div/div[3]/div[5]/div[2]/button";
	public String IPChMntPyMonCRMDD="crm";//id
	public String IPChMntPyMonCRMName="crmname";//id
	public String IPChMntPyMonCRMEsc="productionescalation";//name
	public String IPChMntPyMonCRMProd="firstyearproduction";//name
	public String IPChMntPyDocStup="/html/body/div[3]/div[3]/ul/li[8]/div/div/span";
	public String IPChMntPyDocStupAgree="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[4]/div/input";
	public String IPChMntPyDocStupSav="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[5]/button";
	public String IPChMntPyDocStupUpld="//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/label/div/h6";
	public String IPChMntPyBckBtn="/html/body/div[3]/div[3]/ul/li[12]/div/div/span";
	public String IPEditCusAct="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/button";
	public String IPEditCusEditPy="/html/body/div[3]/div[3]/ul/li[1]/div/div/span";
	public String IPEditCusRob="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[1]/div/div/div/input";
	public String IPEditCusAgree="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[2]/div/div/div/input";
	public String IPEditCusUpd="//*[@id=\"kt_content_container\"]/form/div/div[2]/div/div[2]/div[10]/div[3]/div/div/div[3]/div/button";
	public String IPEditCusChngInvDt="/html/body/div[3]/div[3]/ul/li[2]/div/div/span";
	public String IPEditCusChngPyDt="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[3]/button";
	public String IPEditCusChngMan="/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button";
	public String IPEditCusChngInvEff="effectivefrom";
	public String IPEditCusChngInvPyDte="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div/div[2]/select";
	public String IPEditCusStpPy="/html/body/div[3]/div[3]/ul/li[3]/div/div/span";
	public String IPEditCusStpPyCnfrm="confirm";//name
	public String IPEditCusStpPyCnfrmBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[3]/div/div[4]/button";
	public String IPEditCusStpFrm="stopsfrom";//name
	public String IPEditCusStpRsn="Reason";//name
	public String IPQckUpld="/html/body/div[3]/div[3]/ul/li[4]/div/div/span";
	public String IPQckUpldBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/button";
	public String IPQckUpldTost="//*[@id=\"1\"]/div[1]/div[2]";
	public String IPQckUpldSamFile="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/a";
	public String IPQckUpldFile="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/label/div/h6";
	public String IPQckUpldMonth="//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/div[1]/div[2]/input";
	public String IPEditCusBckBtn="/html/body/div[3]/div[3]/ul/li[5]/div/div/span";

	public String CretInvBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[5]/div/div[5]/div/span[2]";
	public String CIBnkDD="//*[@id=\"kt_content_container\"]/div/div[1]/div/div[1]/select";
	public String CIPyOpt="//*[@id=\"kt_content_container\"]/div/div[1]/div/div[2]/select";
	public String CISrchCus="//*[@id=\"kt_content_container\"]/div/div[1]/div/div[4]/input";
	public String CIViewCusBtn="//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[9]/div/div/a/span";
	public String CIViewCusAct="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div/div/div/div[5]/a";
	public String CIViewCusAddLine="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/a";
	public String CIViewCusBckBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div/div/div/div/div[5]/div/a/div/div/div";
	public String CIViewCusSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/button";
	public String CIViewCusMPBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div/span/input";
	public String CIViewCusMPDueMnt="duemonth";//name
	public String CIViewCusMPDes="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[2]/div/input";
	public String CIViewCusMPAmt="amount";//name
	public String CIViewCusMPClrBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[5]/button[1]";
	public String CIViewCusMPSavBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[5]/button[2]/span";
	public String CIViewCusMPRadBtn="MP";//name
	public String CIViewCusMPChrgRadBtn="MPC";//name
	public String CIViewCusMPLFRadBtn="LF";//name
	public String CIViewCusMPClsBtn="/html/body/div[4]/div/div[2]/div/div[2]/div/button";

	public String CheckPayBtn="//*[@id=\"#kt_aside_menu\"]/div[5]/div/div[6]/div/span[2]";
	public String CPBankDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[1]/select";
	public String CPBankSrch="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/input";
	public String CPAddBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a/div/button";
	public String CPAddInstDD="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[1]/div/select";
	public String CPAddCustName="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[2]/div/div/input";
	public String CPAddSrchBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/button";
	public String CPAddSrchSugBtn="//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div";
	public String CPCusEditRobBtn="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[3]/div[3]/div/div/div[1]/div/div/div/input";
	public String CPCusEditSavBtn="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[3]/div[3]/div/div/div[2]/button";
	public String CPCusEditBckBtn="//button[@class='btn btn-light me-3 btn-md']";
	public String CPCusEditDocBtn="//*[@id=\"kt_content_container\"]/div/div[2]/form/div/div[2]/label/div/p";
	public String CPCusEdiChkNam="check";//name
	public String CPCusEdiChkDate="checkdate";//name
	public String CPCusEdiChkAmt="amount";//name
	public String CPCusEdiNamAcc="nameaccount";//name
	public String CPCusEdiBnkAcc="bankaccountnumber";//name
	public String CPCusEdiBnkAccRout="bankroutingnumber";//name


	public String TicketsBtn="/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[8]/a/span/span[2]";
	public String TktDueMntCal="//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div[2]/input";
	public String TktInstDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[3]/div[2]/select";
	public String TktStsDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[4]/div[2]/select";
	public String TktRsnDD="//*[@id=\"kt_content_container\"]/div/div[1]/div[5]/div[2]/select";
	public String TktCusName="//*[@id=\"kt_content_container\"]/div/div[1]/div[6]/div[2]/input";
	public String TktExpBtn="//*[@id=\"kt_content_container\"]/div/div[1]/div[7]/button";
	public String TktViewBtn="//*[@id=\"kt_content_container\"]/div/div[3]/div/table/tbody/tr/td[9]/a";
	public String TktViewBtnActBtn="/html/body/div[1]/div[2]/div[2]/div[2]/div/div/form/div/div[1]/div[2]/div/button";
	public String TktViewBtnAddCmt="/html/body/div[3]/div[3]/ul/li[1]/div/div/i";
	public String TktViewBtnAddCmtSave="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/button";
	public String TktViewBtnAddCmtMan="//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div/div/div/div/center/button";
	public String TktViewBtnAddCmtCls="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/button";
	public String TktViewBtnAddCmtBox="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/textarea";
	public String TktViewBtnSndMail="//*[@id=\"simple-menu\"]/div[3]/ul/li[2]/div/div/i";
	public String TktViewBtnSndMailSav="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[4]/button";
	public String TktViewBtnSndMailMan="//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div/div/div/div/center/button";
	public String TktViewBtnSndMailSubj="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/input";
	public String TktViewBtnSndMailMsg="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[3]/textarea";
	public String TktViewBtnSndMailCls="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/button";
	public String TktViewBtnClsTkt="//*[@id=\"simple-menu\"]/div[3]/ul/li[3]/div/div/i";
	public String TktViewBtnClsTktSav="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/button";
	public String TktViewBtnClsTktMan="//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div/div/div/div/center/button";
	public String TktViewBtnClsTktClr="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div";
	public String TktViewBtnClsTktCls="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/button";
	public String TktViewBtnClsTktDes="//*[@id=\"kt_body\"]/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/textarea";


	public String TktViewBtnViewPyHstry="//*[@id=\"simple-menu\"]/div[3]/ul/li[4]/div/div/i";






































































}