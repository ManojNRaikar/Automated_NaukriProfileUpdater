@NaukriUpdate
Feature: Update Naukri Profile

  @UserLoginVerify
  Scenario: Login to Naukri
    Given user navigates to Naukri login page
    When user enters username and password
    Then user is logged in

  @UpdateKeySkills
  Scenario: Update Key Skills in profile
    Given user is on Naukri profile page
    When user added Key skill "Automation Test"
    Then skill is updated successfully

  @UploadResume
  Scenario: Upload resume to profile
    Given user is on Naukri profile page
    When user uploads new resume from "C:\Users\Manoj N Raikar\Downloads\Manoj_Raikar_Resume_QA_Engineer_2025 (2).pdf"
    Then resume is uploaded successfully
