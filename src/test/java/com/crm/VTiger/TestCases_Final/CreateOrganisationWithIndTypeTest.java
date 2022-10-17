package com.crm.VTiger.TestCases_Final;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.HomePageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrgPageClass;
import ObjectRepository.organisationInfoPageClass;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;

public class CreateOrganisationWithIndTypeTest extends BaseClass {

	@Test(groups = "integration")
	public void creteOrgwithDD() throws Throwable {

		ExcelFileUtility eFU=new ExcelFileUtility();
		String orgName = eFU.readDataFromExcelFile("sheet1", 4, 1)+JavaUtility.generateRanNum();
		String indType = eFU.readDataFromExcelFile("sheet1", 4, 2);

		HomePageClass hpc=new HomePageClass(driver);
		hpc.getOrgButton().click();

		OrgPageClass opc =new OrgPageClass(driver);
		opc.getCreOrg().click();

		NewOrgPageClass npc=new NewOrgPageClass(driver);
		npc.orgTF(orgName);
		npc.IndustryDD(indType);

		npc.sButton();

		organisationInfoPageClass oipc=new organisationInfoPageClass(driver);

		Assert.assertEquals(orgName, oipc.headT());	
	}
}
