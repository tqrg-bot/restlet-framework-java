/**
 * Copyright 2005-2019 Talend
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * https://restlet.talend.com/
 * 
 * Restlet is a registered trademark of Talend S.A.
 */

package org.restlet.test.ext.odata.deepexpand.model;

import java.util.List;

import org.restlet.test.ext.odata.deepexpand.model.CoOp;
import org.restlet.test.ext.odata.deepexpand.model.Company;
import org.restlet.test.ext.odata.deepexpand.model.CompanyPerson;
import org.restlet.test.ext.odata.deepexpand.model.Job;
import org.restlet.test.ext.odata.deepexpand.model.JobPostingPart;
import org.restlet.test.ext.odata.deepexpand.model.Multilingual;
import org.restlet.test.ext.odata.deepexpand.model.Professor;
import org.restlet.test.ext.odata.deepexpand.model.Registration;

/**
 * Generated by the generator tool for the OData extension for the Restlet
 * framework.<br>
 * 
 * @see <a
 *      href="http://praktiki.metal.ntua.gr/CoopOData/CoopOData.svc/$metadata">Metadata
 *      of the target OData service</a>
 * 
 */
public class JobPosting {

    private int id;

    private int seatsNumber;

    private Benefits benefits;

    private Tracking tracking;

    private Company company;

    private CoOp coOp;

    private Multilingual description;

    private List<JobPostingPart> jobPostingParts;

    private List<Job> jobs;

    private CompanyPerson managingCompanyPerson;

    private Multilingual name;

    private List<Registration> preferredByRegistrations;

    private Professor supervisingProfessor;

    /**
     * Constructor without parameter.
     * 
     */
    public JobPosting() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param id
     *            The identifiant value of the entity.
     */
    public JobPosting(int id) {
        this();
        this.id = id;
    }

    /**
     * Returns the value of the "id" attribute.
     * 
     * @return The value of the "id" attribute.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the value of the "seatsNumber" attribute.
     * 
     * @return The value of the "seatsNumber" attribute.
     */
    public int getSeatsNumber() {
        return seatsNumber;
    }

    /**
     * Returns the value of the "benefits" attribute.
     * 
     * @return The value of the "benefits" attribute.
     */
    public Benefits getBenefits() {
        return benefits;
    }

    /**
     * Returns the value of the "tracking" attribute.
     * 
     * @return The value of the "tracking" attribute.
     */
    public Tracking getTracking() {
        return tracking;
    }

    /**
     * Returns the value of the "company" attribute.
     * 
     * @return The value of the "company" attribute.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Returns the value of the "coOp" attribute.
     * 
     * @return The value of the "coOp" attribute.
     */
    public CoOp getCoOp() {
        return coOp;
    }

    /**
     * Returns the value of the "description" attribute.
     * 
     * @return The value of the "description" attribute.
     */
    public Multilingual getDescription() {
        return description;
    }

    /**
     * Returns the value of the "jobPostingParts" attribute.
     * 
     * @return The value of the "jobPostingParts" attribute.
     */
    public List<JobPostingPart> getJobPostingParts() {
        return jobPostingParts;
    }

    /**
     * Returns the value of the "jobs" attribute.
     * 
     * @return The value of the "jobs" attribute.
     */
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * Returns the value of the "managingCompanyPerson" attribute.
     * 
     * @return The value of the "managingCompanyPerson" attribute.
     */
    public CompanyPerson getManagingCompanyPerson() {
        return managingCompanyPerson;
    }

    /**
     * Returns the value of the "name" attribute.
     * 
     * @return The value of the "name" attribute.
     */
    public Multilingual getName() {
        return name;
    }

    /**
     * Returns the value of the "preferredByRegistrations" attribute.
     * 
     * @return The value of the "preferredByRegistrations" attribute.
     */
    public List<Registration> getPreferredByRegistrations() {
        return preferredByRegistrations;
    }

    /**
     * Returns the value of the "supervisingProfessor" attribute.
     * 
     * @return The value of the "supervisingProfessor" attribute.
     */
    public Professor getSupervisingProfessor() {
        return supervisingProfessor;
    }

    /**
     * Sets the value of the "id" attribute.
     * 
     * @param id
     *            The value of the "id" attribute.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the value of the "seatsNumber" attribute.
     * 
     * @param seatsNumber
     *            The value of the "seatsNumber" attribute.
     */
    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    /**
     * Sets the value of the "benefits" attribute.
     * 
     * @param benefits
     *            The value of the "benefits" attribute.
     */
    public void setBenefits(Benefits benefits) {
        this.benefits = benefits;
    }

    /**
     * Sets the value of the "tracking" attribute.
     * 
     * @param tracking
     *            The value of the "tracking" attribute.
     */
    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    /**
     * Sets the value of the "company" attribute.
     * 
     * @param company
     *            " The value of the "company" attribute.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Sets the value of the "coOp" attribute.
     * 
     * @param coOp
     *            " The value of the "coOp" attribute.
     */
    public void setCoOp(CoOp coOp) {
        this.coOp = coOp;
    }

    /**
     * Sets the value of the "description" attribute.
     * 
     * @param description
     *            " The value of the "description" attribute.
     */
    public void setDescription(Multilingual description) {
        this.description = description;
    }

    /**
     * Sets the value of the "jobPostingParts" attribute.
     * 
     * @param jobPostingParts
     *            " The value of the "jobPostingParts" attribute.
     */
    public void setJobPostingParts(List<JobPostingPart> jobPostingParts) {
        this.jobPostingParts = jobPostingParts;
    }

    /**
     * Sets the value of the "jobs" attribute.
     * 
     * @param jobs
     *            " The value of the "jobs" attribute.
     */
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * Sets the value of the "managingCompanyPerson" attribute.
     * 
     * @param managingCompanyPerson
     *            " The value of the "managingCompanyPerson" attribute.
     */
    public void setManagingCompanyPerson(CompanyPerson managingCompanyPerson) {
        this.managingCompanyPerson = managingCompanyPerson;
    }

    /**
     * Sets the value of the "name" attribute.
     * 
     * @param name
     *            " The value of the "name" attribute.
     */
    public void setName(Multilingual name) {
        this.name = name;
    }

    /**
     * Sets the value of the "preferredByRegistrations" attribute.
     * 
     * @param preferredByRegistrations
     *            " The value of the "preferredByRegistrations" attribute.
     */
    public void setPreferredByRegistrations(
            List<Registration> preferredByRegistrations) {
        this.preferredByRegistrations = preferredByRegistrations;
    }

    /**
     * Sets the value of the "supervisingProfessor" attribute.
     * 
     * @param supervisingProfessor
     *            " The value of the "supervisingProfessor" attribute.
     */
    public void setSupervisingProfessor(Professor supervisingProfessor) {
        this.supervisingProfessor = supervisingProfessor;
    }

}