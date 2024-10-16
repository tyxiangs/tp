package seedu.address.model.person;


/**
 * Represents an appointment between a patient and a doctor, with additional remarks.
 * This class uses generics to allow flexible types for the patient ID, doctor ID, and remarks.
 *
 * @param <T1> The type of the patient ID and doctor ID.
 * @param <T2> The type of the remarks for the appointment.
 */
public class Appointment<T1, T2> {


    private final T1 doctorId;
    private final T1 patientId;
    private T2 remark;

    /**
     * Constructs an Appointment object.
     *
     * @param patientId The unique identifier for the patient.
     * @param doctorId The unique identifier for the doctor.
     * @param remark A remark or comment about the appointment (e.g., treatment details, condition, etc.).
     */
    public Appointment(T1 doctorId, T1 patientId, T2 remark) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.remark = remark;
    }

    /**
     * Returns the patient ID for this appointment.
     *
     * @return The patient ID.
     */
    public T1 getPatientId() {
        return this.patientId;
    }

    /**
     * Returns the doctor ID for this appointment.
     *
     * @return The doctor ID.
     */
    public T1 getDoctorId() {
        return this.doctorId;
    }

    /**
     * Returns the remarks or comments for this appointment.
     *
     * @return The remarks for the appointment.
     */
    public T2 getRemark() {
        return this.remark;
    }

    /**
     * Appends a new remark to the existing remark.
     * A blank line is added to separate the previous remark from the new one.
     *
     * @param newRemark The new remark to append.
     */
    @SuppressWarnings("unchecked")
    public void appendRemark(T2 newRemark) {
        if (this.remark == null) {
            this.remark = newRemark;
        } else {
            this.remark = (T2) (this.remark + "\n\n" + newRemark);
        }
    }

    /**
     * Replaces the current remark with a completely new one.
     * This will discard any previous remarks.
     *
     * @param newRemark The new remark to set.
     */
    public void replaceRemark(T2 newRemark) {
        this.remark = newRemark;
    }

    /**
     * Checks if this appointment is equal to another object.
     *
     * @param obj The other object to compare to.
     * @return True if the two appointments are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if both objects are the same
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // Check if obj is not null and both are of the same class
        }

        Appointment<?, ?> other = (Appointment<?, ?>) obj; // Cast the object to Appointment

        return doctorId.equals(other.doctorId)
                && patientId.equals(other.patientId)
                && (remark == null ? other.remark == null
                : remark.equals(other.remark)); // Compare remark, handle nulls
    }

    /**
     * Returns a string representation of the appointment.
     *
     * @return A string that represents the appointment.
     */
    @Override
    public String toString() {
        return String.format("Appointment[Doctor ID: %s, Patient ID: %s] : %s",
                doctorId.toString(),
                patientId.toString(),
                remark != null ? remark : "No remarks");
    }

}

