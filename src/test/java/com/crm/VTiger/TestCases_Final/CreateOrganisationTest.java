package com.crm.VTiger.TestCases_Final;

import org.testng.annotations.Test;

import ObjectRepository.HomePageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrgPageClass;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;

public class CreateOrganisationTest extends BaseClass{

	@Test(groups = "smoke")
	public void createOrgTest() throws Throwable{

		ExcelFileUtility efu=new ExcelFileUtility();
		String orgName = efu.readDataFromExcelFile("sheet1", 1, 1)+JavaUtility.generateRanNum();

		HomePageClass hpc=new HomePageClass(driver);
		hpc.getOrgButton().click();

		OrgPageClass opc =new OrgPageClass(driver);
		opc.getCreOrg().click();

		NewOrgPageClass npc=new NewOrgPageClass(driver);
		npc.orgTF(orgName);
		npc.getSaveButton().click();

	}

}
