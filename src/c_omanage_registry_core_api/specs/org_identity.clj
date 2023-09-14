(ns c-omanage-registry-core-api.specs.org-identity
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            [c-omanage-registry-core-api.specs.address :refer :all]
            [c-omanage-registry-core-api.specs.ad-hoc-attribute :refer :all]
            [c-omanage-registry-core-api.specs.email-address :refer :all]
            [c-omanage-registry-core-api.specs.identifier :refer :all]
            [c-omanage-registry-core-api.specs.name :refer :all]
            [c-omanage-registry-core-api.specs.telephone-number :refer :all]
            [c-omanage-registry-core-api.specs.url :refer :all]
            )
  (:import (java.io File)))


(def org-identity-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :co_id) string?
   (ds/opt :title) string?
   (ds/opt :o) string?
   (ds/opt :ou) string?
   (ds/opt :valid_from) inst?
   (ds/opt :valid_through) inst?
   (ds/opt :status) string?
   (ds/opt :affiliation) string?
   (ds/opt :date_of_birth) inst?
   (ds/opt :Address) (s/coll-of address-spec)
   (ds/opt :AdHocAttribute) (s/coll-of ad-hoc-attribute-spec)
   (ds/opt :EmailAddress) (s/coll-of email-address-spec)
   (ds/opt :Identifier) (s/coll-of identifier-spec)
   (ds/opt :Name) (s/coll-of name-spec)
   (ds/opt :TelephoneNumber) (s/coll-of telephone-number-spec)
   (ds/opt :Url) (s/coll-of url-spec)
   })

(def org-identity-spec
  (ds/spec
    {:name ::org-identity
     :spec org-identity-data}))
