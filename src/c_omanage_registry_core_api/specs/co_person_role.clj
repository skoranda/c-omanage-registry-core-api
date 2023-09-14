(ns c-omanage-registry-core-api.specs.co-person-role
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            [c-omanage-registry-core-api.specs.address :refer :all]
            [c-omanage-registry-core-api.specs.ad-hoc-attribute :refer :all]
            [c-omanage-registry-core-api.specs.telephone-number :refer :all]
            )
  (:import (java.io File)))


(def co-person-role-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :cou_id) string?
   (ds/opt :title) string?
   (ds/opt :o) string?
   (ds/opt :ou) string?
   (ds/opt :valid_from) inst?
   (ds/opt :valid_through) inst?
   (ds/req :status) string?
   (ds/opt :sponsor_co_person_id) string?
   (ds/req :affiliation) string?
   (ds/opt :ordr) string?
   (ds/opt :Address) (s/coll-of address-spec)
   (ds/opt :AdHocAttribute) (s/coll-of ad-hoc-attribute-spec)
   (ds/opt :TelephoneNumber) (s/coll-of telephone-number-spec)
   })

(def co-person-role-spec
  (ds/spec
    {:name ::co-person-role
     :spec co-person-role-data}))
