/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.model;

import dev.ikm.tinkar.terms.ConceptFacade;
import network.ike.foundation.ike.bindings.IkeConcept;

import java.util.List;
import java.util.Optional;

/**
 * The bridges and readings authored beside the model files: what a retrievable class stands
 * for in IKE's own terms, and which statement reading each of its elements answers. Written on
 * the class and element records at import, so that a library written against the model
 * evaluates over statements (IKE-Network/ike-issues#1116). A row names the model and the
 * class as the file spells them, and applies to every version of the model imported.
 */
public final class ModelBridges {

    /**
     * What a retrievable class stands for.
     *
     * @param model            the model's name
     * @param className        the class's local name
     * @param circumstanceKind the circumstance kind a statement must hold
     * @param disposition      the disposition a statement must carry, empty when the class fixes none
     * @param relation         the relation kind the bridge claims
     */
    public record Bridge(String model, String className, ConceptFacade circumstanceKind,
                         Optional<ConceptFacade> disposition, ConceptFacade relation) {
    }

    /**
     * Which statement reading an element answers.
     *
     * @param model       the model's name
     * @param className   the local name of the class declaring the element
     * @param elementName the element's name
     * @param reading     the reading
     */
    public record Reading(String model, String className, String elementName, ConceptFacade reading) {
    }

    /**
     * The bridges: the corpus's classes first. A condition, an observation, and an encounter
     * are performances; a prescription is a request; QDM's positive encounter performed is a
     * performance whose disposition, that the act was done, waits on a disposition vocabulary
     * and is left unfixed here. Every class carries more than a statement says, so each
     * bridge claims a conservative extension.
     */
    public static final List<Bridge> BRIDGES = List.of(
            new Bridge("QUICK", "Condition", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("QUICK", "Observation", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("QUICK", "Encounter", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("QUICK", "MedicationPrescription", IkeConcept.REQUEST_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("FHIR", "Condition", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("FHIR", "Observation", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("FHIR", "Encounter", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("FHIR", "MedicationRequest", IkeConcept.REQUEST_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION),
            new Bridge("QDM", "PositiveEncounterPerformed", IkeConcept.PERFORMANCE_CIRCUMSTANCE, Optional.empty(), IkeConcept.CONSERVATIVE_EXTENSION));

    /**
     * The readings: the corpus's paths first, on the classes that declare the elements. A
     * code element answers the topic; onset and abatement the timing's start and end; a period
     * the timing; an issued or written instant the statement time; a value the result; the
     * patient's birth date the subject's birth date.
     */
    public static final List<Reading> READINGS = List.of(
            new Reading("QUICK", "Condition", "code", IkeConcept.TOPIC_READING),
            new Reading("QUICK", "Condition", "onsetDateTime", IkeConcept.TIMING_START_READING),
            new Reading("QUICK", "Condition", "abatementDate", IkeConcept.TIMING_END_READING),
            new Reading("QUICK", "Observation", "code", IkeConcept.TOPIC_READING),
            new Reading("QUICK", "Observation", "valueQuantity", IkeConcept.RESULT_READING),
            new Reading("QUICK", "Observation", "issued", IkeConcept.STATEMENT_TIME_READING),
            new Reading("QUICK", "Encounter", "type", IkeConcept.TOPIC_READING),
            new Reading("QUICK", "Encounter", "period", IkeConcept.TIMING_READING),
            new Reading("QUICK", "MedicationPrescription", "medication", IkeConcept.TOPIC_READING),
            new Reading("QUICK", "MedicationPrescription", "dateWritten", IkeConcept.STATEMENT_TIME_READING),
            new Reading("QUICK", "Patient", "birthDate", IkeConcept.SUBJECT_BIRTH_DATE_READING),
            new Reading("FHIR", "Condition", "code", IkeConcept.TOPIC_READING),
            new Reading("FHIR", "Condition", "onset", IkeConcept.TIMING_START_READING),
            new Reading("FHIR", "Condition", "abatement", IkeConcept.TIMING_END_READING),
            new Reading("FHIR", "Observation", "code", IkeConcept.TOPIC_READING),
            new Reading("FHIR", "Observation", "value", IkeConcept.RESULT_READING),
            new Reading("FHIR", "Observation", "issued", IkeConcept.STATEMENT_TIME_READING),
            new Reading("FHIR", "Encounter", "type", IkeConcept.TOPIC_READING),
            new Reading("FHIR", "Encounter", "period", IkeConcept.TIMING_READING),
            new Reading("FHIR", "MedicationRequest", "medication", IkeConcept.TOPIC_READING),
            new Reading("FHIR", "MedicationRequest", "authoredOn", IkeConcept.STATEMENT_TIME_READING),
            new Reading("FHIR", "Patient", "birthDate", IkeConcept.SUBJECT_BIRTH_DATE_READING),
            new Reading("QDM", "QDMBaseType", "code", IkeConcept.TOPIC_READING),
            new Reading("QDM", "EncounterPerformed", "relevantPeriod", IkeConcept.TIMING_READING),
            new Reading("QDM", "Patient", "birthDatetime", IkeConcept.SUBJECT_BIRTH_DATE_READING));

    private ModelBridges() {
    }

    /**
     * The bridge authored for a class.
     *
     * @param model         the model's name
     * @param qualifiedName the class's qualified name as the file spells it
     * @return the bridge, or empty when none is authored
     */
    public static Optional<Bridge> bridgeFor(String model, String qualifiedName) {
        String local = localName(model, qualifiedName);
        for (Bridge bridge : BRIDGES) {
            if (bridge.model().equals(model) && bridge.className().equals(local)) {
                return Optional.of(bridge);
            }
        }
        return Optional.empty();
    }

    /**
     * The reading authored for an element.
     *
     * @param model         the model's name
     * @param qualifiedName the declaring class's qualified name as the file spells it
     * @param elementName   the element's name
     * @return the reading, or empty when none is authored
     */
    public static Optional<Reading> readingFor(String model, String qualifiedName, String elementName) {
        String local = localName(model, qualifiedName);
        for (Reading reading : READINGS) {
            if (reading.model().equals(model) && reading.className().equals(local) && reading.elementName().equals(elementName)) {
                return Optional.of(reading);
            }
        }
        return Optional.empty();
    }

    private static String localName(String model, String qualifiedName) {
        return qualifiedName.startsWith(model + ".") ? qualifiedName.substring(model.length() + 1) : qualifiedName;
    }
}
