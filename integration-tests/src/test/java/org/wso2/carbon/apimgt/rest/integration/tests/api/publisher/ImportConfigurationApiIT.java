/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *  WSO2 API Manager - Publisher API
 *  This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification.
 *
 *  OpenAPI spec version: 0.10.0
 *  Contact: architecture@wso2.com
 *
 *  NOTE: This class is auto generated by the swagger code generator program.
 *  https://github.com/swagger-api/swagger-codegen.git
 *  Do not edit the class manually.
 *
 */

package org.wso2.carbon.apimgt.rest.integration.tests.api.publisher;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.ApiException;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APICollectionApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APIIndividualApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APIList;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.ImportConfigurationApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.API;

import java.io.File;

import org.testng.annotations.Test;

/**
 * API tests for ImportConfigurationApi
 */
public class ImportConfigurationApiIT {

    private final ImportConfigurationApi api = new ImportConfigurationApi();
    private final APICollectionApi apiSetup = new APICollectionApi();
    private final APIIndividualApi apiIndividualApi = new APIIndividualApi();
    private final TestUtils testUtils = new TestUtils();

    @Test
    public void importApisPostTest() throws ApiException {
        File file = new File(getClass().getResource("/sampleapi.zip").getFile());
        String provider = "admin";

        APIList response = api.importApisPost(file, provider);
        Assert.assertEquals(response.getList().get(0).getName(), "SampleAPI", "API name mismatch");
        Assert.assertEquals(response.getList().get(0).getContext(), "/sample-api", "API context mismatch");
        Assert.assertEquals(response.getList().get(0).getLifeCycleStatus(), "Created", "API lifecycle status mismatch");
        Assert.assertEquals(response.getList().get(0).getVersion(), "1.0.0", "API version mismatch");
        testUtils.deleteApi();

    }

    /*
        FAILS
        please refer https://github.com/wso2/product-apim/issues/1644
     */
    @Test(enabled = false)
    public void importApisPost_failureTest() throws ApiException {
        File file = new File(getClass().getResource("/file1.txt").getFile());
        String provider = "admin";

        try {
            api.importApisPost(file, provider);
            assert false;
        } catch (ApiException apiException) {
            int statusCode = apiException.getCode();
            Assert.assertEquals(statusCode, 400, "status code mismatch");
        }

    }

    /**
     * FAILS
     * Please refer https://github.com/wso2/product-apim/issues/1625
     * Therefore disabling this test.
     */
    @Test(enabled = false)
    public void importApisPutTest() throws ApiException {
        String apiId = testUtils.createApi("sampleapi", "1.0.0", "/sample-api");
        File file = new File(getClass().getResource("/sampleapi.zip").getFile());
        API body = apiIndividualApi.apisApiIdGet(apiId, null, null);
        System.out.println(body);
        String provider = "admin";
        APIList response = api.importApisPut(file, provider);
        System.out.println(response);

        // TODO: test validations
    }

    @AfterClass
    public void afterClass() throws ApiException {
        APIList response = apiSetup.apisGet(10, 0, null, null);
        for (int i = 0; i < response.getCount(); i++) {
            apiIndividualApi.apisApiIdDelete(response.getList().get(i).getId(), null, null);
        }
    }
}