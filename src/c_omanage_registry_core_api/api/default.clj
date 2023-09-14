(ns c-omanage-registry-core-api.api.default
  (:require [c-omanage-registry-core-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [c-omanage-registry-core-api.specs.identifier :refer :all]
            [c-omanage-registry-core-api.specs.co-person-role :refer :all]
            [c-omanage-registry-core-api.specs.co-person-message :refer :all]
            [c-omanage-registry-core-api.specs.co-person :refer :all]
            [c-omanage-registry-core-api.specs.address :refer :all]
            [c-omanage-registry-core-api.specs.ssh-key :refer :all]
            [c-omanage-registry-core-api.specs.email-address :refer :all]
            [c-omanage-registry-core-api.specs.telephone-number :refer :all]
            [c-omanage-registry-core-api.specs.url :refer :all]
            [c-omanage-registry-core-api.specs.get-co-person-200-response :refer :all]
            [c-omanage-registry-core-api.specs.co-group-member :refer :all]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            [c-omanage-registry-core-api.specs.name :refer :all]
            [c-omanage-registry-core-api.specs.ad-hoc-attribute :refer :all]
            [c-omanage-registry-core-api.specs.org-identity :refer :all]
            )
  (:import (java.io File)))


(defn-spec add-co-person-with-http-info any?
  "Create a CO Person
  Create a CO Person and related models/objects"
  [coid int?, co-person-message co-person-message]
  (check-required-params coid co-person-message)
  (call-api "/api/co/{coid}/core/v1/people" :post
            {:path-params   {"coid" coid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    co-person-message
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["basicAuth"]}))

(defn-spec add-co-person (s/coll-of identifier-spec)
  "Create a CO Person
  Create a CO Person and related models/objects"
  [coid int?, co-person-message co-person-message]
  (let [res (:data (add-co-person-with-http-info coid co-person-message))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of identifier-spec) res st/string-transformer)
       res)))


(defn-spec delete-co-person-with-http-info any?
  "Delete a CO Person
  Use an **Identifier** value to delete a CO Person and related models/objects.
Note that whether or not the delete is soft or hard (expunge) is configurable
using the COmanage Registry Configuration Core API menu."
  [coid int?, identifier string?]
  (check-required-params coid identifier)
  (call-api "/api/co/{coid}/core/v1/people" :delete
            {:path-params   {"coid" coid }
             :header-params {}
             :query-params  {"identifier" identifier }
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    ["basicAuth"]}))

(defn-spec delete-co-person any?
  "Delete a CO Person
  Use an **Identifier** value to delete a CO Person and related models/objects.
Note that whether or not the delete is soft or hard (expunge) is configurable
using the COmanage Registry Configuration Core API menu."
  [coid int?, identifier string?]
  (let [res (:data (delete-co-person-with-http-info coid identifier))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec get-co-person-with-http-info any?
  "Retrieve one or more CO Person and related objects
  Use the **identifier** query parameter to retrieve a single object.
No query parameters retrieves all CO Person objects. Use the
**direction**, **limit**, and **page** query parameters to
control the order and number of returned objects."
  ([coid int?, ] (get-co-person-with-http-info coid nil))
  ([coid int?, {:keys [identifier direction limit page]} (s/map-of keyword? any?)]
   (check-required-params coid)
   (call-api "/api/co/{coid}/core/v1/people" :get
             {:path-params   {"coid" coid }
              :header-params {}
              :query-params  {"identifier" identifier "direction" direction "limit" limit "page" page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["basicAuth"]})))

(defn-spec get-co-person get-co-person-200-response-spec
  "Retrieve one or more CO Person and related objects
  Use the **identifier** query parameter to retrieve a single object.
No query parameters retrieves all CO Person objects. Use the
**direction**, **limit**, and **page** query parameters to
control the order and number of returned objects."
  ([coid int?, ] (get-co-person coid nil))
  ([coid int?, optional-params any?]
   (let [res (:data (get-co-person-with-http-info coid optional-params))]
     (if (:decode-models *api-context*)
        (st/decode get-co-person-200-response-spec res st/string-transformer)
        res))))


(defn-spec update-co-person-with-http-info any?
  "Update a CO Person
  Update a CO Person and related models/objects"
  [coid int?, identifier string?, co-person-message co-person-message]
  (check-required-params coid identifier co-person-message)
  (call-api "/api/co/{coid}/core/v1/people" :put
            {:path-params   {"coid" coid }
             :header-params {}
             :query-params  {"identifier" identifier }
             :form-params   {}
             :body-param    co-person-message
             :content-types ["application/json"]
             :accepts       []
             :auth-names    ["basicAuth"]}))

(defn-spec update-co-person any?
  "Update a CO Person
  Update a CO Person and related models/objects"
  [coid int?, identifier string?, co-person-message co-person-message]
  (let [res (:data (update-co-person-with-http-info coid identifier co-person-message))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


