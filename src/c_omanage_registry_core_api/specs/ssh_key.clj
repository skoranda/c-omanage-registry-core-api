(ns c-omanage-registry-core-api.specs.ssh-key
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def ssh-key-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :comment) string?
   (ds/req :type) string?
   (ds/req :skey) string?
   (ds/opt :ssh_key_authenticator_id) string?
   })

(def ssh-key-spec
  (ds/spec
    {:name ::ssh-key
     :spec ssh-key-data}))
