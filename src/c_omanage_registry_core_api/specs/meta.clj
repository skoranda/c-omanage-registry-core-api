(ns c-omanage-registry-core-api.specs.meta
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def meta-data
  {
   (ds/req :id) string?
   (ds/opt :actor_identifier) string?
   (ds/opt :created) inst?
   (ds/opt :deleted) boolean?
   (ds/opt :modified) inst?
   (ds/opt :revision) string?
   })

(def meta-spec
  (ds/spec
    {:name ::meta
     :spec meta-data}))
