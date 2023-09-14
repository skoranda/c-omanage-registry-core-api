(ns c-omanage-registry-core-api.specs.identifier
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def identifier-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :identifier) string?
   (ds/opt :type) string?
   (ds/opt :login) boolean?
   (ds/opt :status) string?
   })

(def identifier-spec
  (ds/spec
    {:name ::identifier
     :spec identifier-data}))
