/*
 * Copyright 2015 A.Solyankin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qantium.uisteps.serenity.run;

import com.qantium.uisteps.serenity.SerenityUtils;
import java.util.Map;
import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;
import net.thucydides.core.webdriver.WebdriverInstances;

/**
 *
 * @author A.Solyankin
 */
public class Listener implements StepListener {

    @Override
    public void testSuiteStarted(Class<?> storyClass) {

    }

    @Override
    public void testSuiteStarted(Story story) {
    }

    @Override
    public void testSuiteFinished() {
        closeAllBrowser();
    }

    @Override
    public void testStarted(String description) {
    }

    @Override
    public void testFinished(TestOutcome result) {
        closeAllBrowser();
    }

    @Override
    public void testRetried() {
    }

    @Override
    public void stepStarted(ExecutedStepDescription description) {
    }

    @Override
    public void skippedStepStarted(ExecutedStepDescription description) {
    }

    @Override
    public void stepFailed(StepFailure failure) {
    }

    @Override
    public void lastStepFailed(StepFailure failure) {
    }

    @Override
    public void stepIgnored() {

    }

    @Override
    public void stepPending() {
    }

    @Override
    public void stepPending(String message) {
    }

    @Override
    public void stepFinished() {
    }

    @Override
    public void testFailed(TestOutcome testOutcome, Throwable cause) {
        closeAllBrowser();
    }

    @Override
    public void testIgnored() {
    }

    @Override
    public void testSkipped() {
    }

    @Override
    public void testPending() {
    }

    @Override
    public void notifyScreenChange() {
    }

    @Override
    public void useExamplesFrom(DataTable table) {
    }

    @Override
    public void exampleStarted(Map<String, String> data) {
    }

    @Override
    public void exampleFinished() {
        closeAllBrowser();
    }

    @Override
    public void assumptionViolated(String message) {
    }

    protected void closeAllBrowser() {
        WebdriverInstances drivers = new SerenityUtils().getDrivers();
        drivers.closeAllDrivers();
    }

    public void register() {
        new SerenityUtils().registerListener(this);
    }

    
    public void addNewExamplesFrom(DataTable table) {
    }

}
