(ns c-omanage-registry-core-api.specs.email-address
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def email-address-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :mail) string?
   (ds/opt :type) string?
   (ds/opt :verified) boolean?
   })

(def email-address-spec
  (ds/spec
    {:name ::email-address
     :spec email-address-data}))
