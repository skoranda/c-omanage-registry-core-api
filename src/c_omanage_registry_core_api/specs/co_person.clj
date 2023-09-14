(ns c-omanage-registry-core-api.specs.co-person
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def co-person-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :co_id) string?
   (ds/opt :date_of_birth) inst?
   (ds/req :status) string?
   (ds/opt :timezone) string?
   })

(def co-person-spec
  (ds/spec
    {:name ::co-person
     :spec co-person-data}))
