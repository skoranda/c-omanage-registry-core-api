(ns c-omanage-registry-core-api.specs.co-group-member
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def co-group-member-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :co_group_id) string?
   (ds/opt :member) boolean?
   (ds/opt :owner) boolean?
   (ds/opt :co_group_nesting_id) string?
   (ds/opt :valid_from) inst?
   (ds/opt :valid_through) inst?
   })

(def co-group-member-spec
  (ds/spec
    {:name ::co-group-member
     :spec co-group-member-data}))
