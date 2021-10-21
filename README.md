# Medicia Api
Medicia is a medical bio data application with which users can keep track of their Checkups. Doctors and Users can register in the app and create their profile, which will give them control as to who can see their data.

<https://medicia-api.herokuapp.com/>

## Problem Statement
When we go to see a doctor, most of the times we have to answer a lot of questions about our medical conditions and previous medical records. It is quite common to have health implications because of not enough information about the patients’ medical history. It’s crucial to have our medical data recorded and stored. In addition to that, this medical data/record should only be available to the doctor with the patients’ permission. Medicia does exactly that. 

## Solution
Create an online Medical history data base that would allow us to have access to our medical history regardless of where we are. Provide access to our medical history to those doctors who are going to treat us, which would form a better understanding of the patients’ medical history for prescribing medicines, and lastly, update the data base with each new medicine/treatment.

## Contributing to the Project
 Step 1 : Fork the repository.
 Step 2 : Clone the repository in your local machine.
 Step 3 : Build the Application in your local machine, Use JDK >= 1.8.
 Step 4 : Use postman to check the API.
 Step 5 : Create a PR by making the Commit Message in format : [#<Issue id>] <Issue title>
 Step 6 : Keep the Screenshot in PR Description shows the Before and After result.

## PATIENT

| GET REQUESTS                                         | URL                                                                           | Return Type   |
|------------------------------------------------------|-------------------------------------------------------------------------------|---------------|
| Get all the patients record                          | /Patients                                                                     | List<Patient> |
| Get Patient By Patient Id                            | /Patients/{PatientId}                                                         | Patient       |
| Get Doctor By Medical Histoy Id                      | /Patients/HisId/{HisId}                                                       | Doctor        |
| Count Pending Requests of Doctors to View Profile    | /Patients/countOfPendingRequest/{PatientId}                                   | int           |
| Get Doctors whose requests are still pending         | /Patients/getPendingDoctorsRequest/{PatientId}                                | List<Doctor>  |
| Count Doctors approved to View Profile               | /Patients/countOfDoctorsApproved/{PatientId}                                  | int           |
| Get Doctors who are allowed to view Patient's record | /Patients/getDoctorsAllowedToViewProfile/{PatientId}                          | List<Doctor>  |
|                                                      |                                                                               |               |
| POST REQUESTS                                        | URL                                                                           | Return Type   |
| Adding Patient record                                | /Patients                                                                     | -             |
| Approving doctor to view Patient Profile             | /Patients/addDoctorToApprove/PatientId/{PatientId}/doctorId/{docId}           | -             |
| Reject doctor to view Patient Profile                | /Patients/rejectDoctorToViewProfile/PatientId/{PatientId}/doctorId/{DoctorId} | -             |
|                                                      |                                                                               |               |
| PUT REQUESTS                                         | URL                                                                           | Return Type   |
| Updating the Patient record                          | /Patients                                                                     | -             |
|                                                      |                                                                               |               |
| DELETE REQUESTS                                      | URL                                                                           | Return Type   |
| Delete Patient record by Patient Id                  | /Patients/{PatientId}                                                         | -             |
  
# DOCTOR
  
| GET REQUESTS                                         | URL                                                                           | Return Type   |
|------------------------------------------------------|-------------------------------------------------------------------------------|---------------|
| Get all the patients record                          | /Patients                                                                     | List<Patient> |
| Get Patient By Patient Id                            | /Patients/{PatientId}                                                         | Patient       |
| Get Doctor By Medical Histoy Id                      | /Patients/HisId/{HisId}                                                       | Doctor        |
| Count Pending Requests of Doctors to View Profile    | /Patients/countOfPendingRequest/{PatientId}                                   | int           |
| Get Doctors whose requests are still pending         | /Patients/getPendingDoctorsRequest/{PatientId}                                | List<Doctor>  |
| Count Doctors approved to View Profile               | /Patients/countOfDoctorsApproved/{PatientId}                                  | int           |
| Get Doctors who are allowed to view Patient's record | /Patients/getDoctorsAllowedToViewProfile/{PatientId}                          | List<Doctor>  |
|                                                      |                                                                               |               |
| POST REQUESTS                                        | URL                                                                           | Return Type   |
| Adding Patient record                                | /Patients                                                                     | -             |
| Approving doctor to view Patient Profile             | /Patients/addDoctorToApprove/PatientId/{PatientId}/doctorId/{docId}           | -             |
| Reject doctor to view Patient Profile                | /Patients/rejectDoctorToViewProfile/PatientId/{PatientId}/doctorId/{DoctorId} | -             |
|                                                      |                                                                               |               |
| PUT REQUESTS                                         | URL                                                                           | Return Type   |
| Updating the Patient record                          | /Patients                                                                     | -             |
|                                                      |                                                                               |               |
| DELETE REQUESTS                                      | URL                                                                           | Return Type   |
| Delete Patient record by Patient Id                  | /Patients/{PatientId}                                                         | -             |
  
# Medical History Controller		
  
| GET REQUESTS                                         | URL                                                                           | Return Type   |
|------------------------------------------------------|-------------------------------------------------------------------------------|---------------|
| Get all the patients record                          | /Patients                                                                     | List<Patient> |
| Get Patient By Patient Id                            | /Patients/{PatientId}                                                         | Patient       |
| Get Doctor By Medical Histoy Id                      | /Patients/HisId/{HisId}                                                       | Doctor        |
| Count Pending Requests of Doctors to View Profile    | /Patients/countOfPendingRequest/{PatientId}                                   | int           |
| Get Doctors whose requests are still pending         | /Patients/getPendingDoctorsRequest/{PatientId}                                | List<Doctor>  |
| Count Doctors approved to View Profile               | /Patients/countOfDoctorsApproved/{PatientId}                                  | int           |
| Get Doctors who are allowed to view Patient's record | /Patients/getDoctorsAllowedToViewProfile/{PatientId}                          | List<Doctor>  |
|                                                      |                                                                               |               |
| POST REQUESTS                                        | URL                                                                           | Return Type   |
| Adding Patient record                                | /Patients                                                                     | -             |
| Approving doctor to view Patient Profile             | /Patients/addDoctorToApprove/PatientId/{PatientId}/doctorId/{docId}           | -             |
| Reject doctor to view Patient Profile                | /Patients/rejectDoctorToViewProfile/PatientId/{PatientId}/doctorId/{DoctorId} | -             |
|                                                      |                                                                               |               |
| PUT REQUESTS                                         | URL                                                                           | Return Type   |
| Updating the Patient record                          | /Patients                                                                     | -             |
|                                                      |                                                                               |               |
| DELETE REQUESTS                                      | URL                                                                           | Return Type   |
| Delete Patient record by Patient Id                  | /Patients/{PatientId}                                                         | -             |
