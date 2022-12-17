<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetMyPaidAds</name>
   <tag></tag>
   <elementGuidId>1f6e6266-ab8e-4415-8508-711631eef617</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>accept-language</name>
      <type>Main</type>
      <value>ar</value>
      <webElementGuid>48107f4b-2d9c-4c52-887b-9d954c4b2b55</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>source</name>
      <type>Main</type>
      <value>Android</value>
      <webElementGuid>49999017-8586-4164-8aad-af698f1e8982</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>country</name>
      <type>Main</type>
      <value>jo</value>
      <webElementGuid>11e34049-b250-44aa-b0a5-4d3d388d0c73</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic MDA5NjI3MDE5OTE5OTU6MTIzNDU2</value>
      <webElementGuid>d8239180-a9be-4fe0-ae92-d527b4fdf593</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.4.1</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://api.opensooq.com/v2.1/posts/my-post?acceptDecimalPrice=1&amp;supportCurrency=true&amp;filter=&amp;searchTerm=&amp;status=301&amp;expand=postViews%2CphoneVerificationAction%2CpostDetails%2CstatsReport%2CviewsProgress%2Cstatus%2Cexpired_in_days%2Cposted_days%2Cfirst_image_uri%2CstatusReasonDetails%2Cactions%2Cchat_enabled%2CisPendingWithOverLimit%2CvasExpiryMessages%2CimagesCount%2CmediasCount%2Cprice_list%2CisOverLimit%2CfreeRepost%2CjobApplicantCount%2Cview_type%2Ccv_id%2Cid&amp;VasExpiryMessagesList=VIP%2CPremium%2CTurbo%2CBumpup&amp;page=1&amp;per-page=14&amp;PostSearch%5BcategoryId%5D=0&amp;PostSearch%5BsubCategoryId%5D=0&amp;PostSearch%5BcityId%5D=0&amp;PostSearch%5Bneighborhood_id%5D=0&amp;PostSearch%5BpriceFrom%5D=0.0&amp;PostSearch%5BpriceTo%5D=0.0&amp;PostSearch%5Bprice_currency%5D=0&amp;abBucket=5</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
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
