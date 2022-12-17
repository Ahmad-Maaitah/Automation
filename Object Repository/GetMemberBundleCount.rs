<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetMemberBundleCount</name>
   <tag></tag>
   <elementGuidId>ef51616e-f41b-4c41-b27c-1deb74a68e23</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic MDA5NjI3MDE5OTE5OTU6MTIzNDU2</value>
      <webElementGuid>a69d15ad-da99-4ec2-845a-b77041bbfc43</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>country</name>
      <type>Main</type>
      <value>jo</value>
      <webElementGuid>4c2eb827-4d77-4fcd-8c58-400eadec8e3d</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>source</name>
      <type>Main</type>
      <value>android</value>
      <webElementGuid>4f3cb96c-2950-41e4-be54-1cb7bfdad150</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>always-200</name>
      <type>Main</type>
      <value>1</value>
      <webElementGuid>c82cfe57-d294-40a8-bfab-7f196696b984</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>session-id</name>
      <type>Main</type>
      <value>78E9601B-79B6-4B0D-8462-711A7BEA3B6A</value>
      <webElementGuid>578a4766-93a8-4d25-b6c8-0992ddf108ca</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Tracking-UUID</name>
      <type>Main</type>
      <value>_50FF7130-76B3-43A2-940A-FEF23FDBFC34</value>
      <webElementGuid>92bf1f97-388b-47b5-88be-b4af276a4a94</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>release-version</name>
      <type>Main</type>
      <value>9.3.09</value>
      <webElementGuid>65994708-666e-4e2f-943d-5ad778f1c980</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.4.1</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://apiv.sooqtest.com/v2.1/members/63826025?expand=bundle_count&amp;abBucket=7</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
