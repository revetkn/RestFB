/*
 * Copyright (c) 2010-2025 Mark Allen, Norbert Bartels.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.restfb.types.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.restfb.Facebook;
import com.restfb.json.Json;
import com.restfb.json.JsonObject;
import com.restfb.types.features.HasCreatedTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the <a href="https://developers.facebook.com/docs/marketing-api/reference/ad-account">AdGroup Account
 * Type</a>.
 */
public class AdAccount extends NamedAdsObject implements HasCreatedTime {

  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  @Facebook("ad_account_creation_request")
  private AdAccountCreationRequest adAccountCreationRequest;

  @Getter
  @Setter
  @Facebook("ad_account_promotable_objects")
  private AdAccountPromotableObjects adAccountPromotableObjects;

  @Facebook("account_groups")
  private List<AdAccountGroup> accountGroups = new ArrayList<>();

  @Getter
  @Setter
  @Facebook("account_id")
  private String accountId;

  @Getter
  @Setter
  @Facebook("account_status")
  private Integer accountStatus;

  @Getter
  @Setter
  @Facebook
  private Float age;

  @Getter
  @Setter
  @Facebook("agency_client_declaration")
  private AgencyClientDeclaration agencyClientDeclaration;

  @Getter
  @Setter
  @Facebook("business_city")
  private String businessCity;

  @Getter
  @Setter
  @Facebook("business_country_code")
  private String businessCountryCode;

  @Getter
  @Setter
  @Facebook("business_name")
  private String businessName;

  @Getter
  @Setter
  @Facebook("business_state")
  private String businessState;

  @Getter
  @Setter
  @Facebook("business_street")
  private String businessStreet;

  @Getter
  @Setter
  @Facebook("business_street2")
  private String businessStreet2;

  @Getter
  @Setter
  @Facebook("business_zip")
  private String businessZip;

  @Facebook
  private List<String> capabilities = new ArrayList<>();

  @Getter(onMethod_ = {@Override})
  @Setter
  @Facebook("created_time")
  private Date createdTime;

  @Getter
  @Setter
  @Facebook
  private String currency;

  @Getter
  @Setter
  @Facebook("disable_reason")
  private Integer disableReason;

  @Getter
  @Setter
  @Facebook("end_advertiser")
  private String endAdvertiser;

  @Getter
  @Setter
  @Facebook("end_advertiser_name")
  private String endAdvertiserName;

  @Getter
  @Setter
  @Facebook("extended_credit_invoice_group")
  private ExtendedCreditInvoiceGroup extendedCreditInvoiceGroup;

  @Facebook("failed_delivery_checks")
  private List<AdDeliveryCheck> failedDeliveryChecks = new ArrayList<>();

  @Getter
  @Setter
  @Facebook("funding_source")
  private String fundingSource;

  @Getter
  @Setter
  @Facebook("funding_source_details")
  private FundingSourceDetails fundingSourceDetails;

  @Getter
  @Setter
  @Facebook("has_migrated_permissions")
  private Boolean hasMigratedPermissions;

  @Getter
  @Setter
  @Facebook("io_number")
  private String ioNumber;

  @Getter
  @Setter
  @Facebook("is_personal")
  private String isPersonal;

  @Getter
  @Setter
  @Facebook("is_prepay_account")
  private Boolean isPrepayAccount;

  @Getter
  @Setter
  @Facebook("is_tax_id_required")
  private Boolean isTaxIdRequired;

  @Facebook("line_numbers")
  private List<Integer> lineNumbers = new ArrayList<>();

  @Getter
  @Setter
  @Facebook("media_agency")
  private String mediaAgency;

  @Getter
  @Setter
  @Facebook("min_campaign_group_spend_cap")
  private String minCampaignGroupSpendCap;

  @Getter
  @Setter
  @Facebook("min_daily_budget")
  private Integer minDailyBudget;

  @Getter
  @Setter
  @Facebook
  private String owner;

  @Getter
  @Setter
  @Facebook("offsite_pixels_tos_accepted")
  private Boolean offsitePixelsTosAccepted;

  @Getter
  @Setter
  @Facebook
  private String partner;

  @Getter
  @Setter
  @Facebook("tax_id")
  private String taxId;

  @Getter
  @Setter
  @Facebook("tax_id_status")
  private Integer taxIdStatus;

  @Getter
  @Setter
  @Facebook("tax_id_type")
  private String taxIdType;

  @Getter
  @Setter
  @Facebook("timezone_id")
  private Integer timezoneId;

  @Getter
  @Setter
  @Facebook("timezone_name")
  private String timezoneName;

  @Getter
  @Setter
  @Facebook("timezone_offset_hours_utc")
  private Float timezoneOffsetHoursUtc;

  @Getter
  @Setter
  @Facebook("rf_spec")
  private ReachFrequencySpec rfSpec;

  @Facebook("tos_accepted")
  private String tosAccepted;

  @Getter
  @Setter
  @Facebook("user_role")
  @Deprecated
  private String userRole;

  @Getter
  @Setter
  @Facebook("vertical_name")
  private String verticalName;

  @Getter
  @Setter
  @Facebook("amount_spent")
  private String amountSpent;

  @Getter
  @Setter
  @Facebook("spend_cap")
  private String spendCap;

  @Getter
  @Setter
  @Facebook
  private String balance;

  @Getter
  @Setter
  @Facebook
  private Business business;

  @Getter
  @Setter
  @Facebook("owner_business")
  private Business ownerBusiness;

  @Getter
  @Setter
  @Facebook("last_used_time")
  private Date lastUsedTime;

  @Getter
  @Setter
  @Facebook("user_access_expire_time")
  private Date userAccessExpireTime;

  @Facebook("user_tasks")
  private List<String> userTasks = new ArrayList<>();

  public JsonObject getTosAccepted() {
    if (tosAccepted != null) {
      return Json.parse(tosAccepted).asObject();
    } else {
      return null;
    }
  }

  public void setTosAccepted(JsonObject tosAccepted) {
    if (tosAccepted != null) {
      this.tosAccepted = tosAccepted.toString();
    }
  }

  public boolean addUserTask(String userTask) {
    return userTasks.add(userTask);
  }

  public boolean removeUserTask(String userTask) {
    return userTasks.remove(userTask);
  }

  public List<String> getUserTasks() {
    return Collections.unmodifiableList(userTasks);
  }

  public boolean addAdAccountGroup(AdAccountGroup adAccountGroup) {
    return accountGroups.add(adAccountGroup);
  }

  public boolean removeAdAccountGroup(AdAccountGroup adAccountGroup) {
    return accountGroups.remove(adAccountGroup);
  }

  public List<AdAccountGroup> getAccountsGroups() {
    return Collections.unmodifiableList(accountGroups);
  }

  public boolean addCapability(String capability) {
    return capabilities.add(capability);
  }

  public boolean removeCapability(String capability) {
    return capabilities.remove(capability);
  }

  public List<String> getCapabilities() {
    return Collections.unmodifiableList(capabilities);
  }

  public boolean addFailedDeliveryCheck(AdDeliveryCheck adDevliveryCheck) {
    return failedDeliveryChecks.add(adDevliveryCheck);
  }

  public boolean removeFailedDeliveryCheck(AdDeliveryCheck adDevliveryCheck) {
    return failedDeliveryChecks.remove(adDevliveryCheck);
  }

  public List<AdDeliveryCheck> getFailedDeliveryChecks() {
    return Collections.unmodifiableList(failedDeliveryChecks);
  }

  public boolean addLineNumber(Integer lineNumber) {
    return lineNumbers.add(lineNumber);
  }

  public boolean removeLineNumber(Integer lineNumber) {
    return lineNumbers.remove(lineNumber);
  }

  public List<Integer> getLineNumbers() {
    return Collections.unmodifiableList(lineNumbers);
  }
}
