(ns lt.plugins.{{name}}
  (:require
    [lt.object           :as object]
    [lt.objs.editor      :as editor]
    [lt.objs.editor.pool :as pool]
    [lt.objs.command     :as cmd])
  (:require-macros
   [lt.macros :refer [behavior]]))

(defn {{name}}-task
  []
  (println "hello"))

(cmd/command {:command :{{name}}-task
              :desc "{{name}}: task"
              :exec {{name}}-task})

