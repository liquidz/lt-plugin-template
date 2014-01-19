(ns leiningen.new.lt-plugin
  (:require
    [leiningen.new.templates :refer [renderer ->files name-to-path]]))

(def render (renderer "lt-plugin"))

(defn lt-plugin
  "FIXME: write documentation"
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)
              :year      "{{year}}"
              :month     "{{month}}"
              :filename  "{{filename}}"}]

    (->files
      data
      ["CONTRIBUTING.md" (render "CONTRIBUTING.md" data)]
      ["LICESE.md" (render "LICENSE.md" data)]
      ["README.md" (render "README.md" data)]
      ["plugin.edn" (render "plugin.edn" data)]
      ["project.clj" (render "project.clj" data)]
      [".gitignore"   (render ".gitignore" data)]
      ["{{sanitized}}.behaviors" (render "core.behaviors" data)]
      ["src/lt/plugins/{{sanitized}}.cljs" (render "core.cljs" data)])

    ;(->files
    ;  data
    ;  ["project.clj"  (render "project.clj" data)]
    ;  ["README.md"    (render "README.md" data)]
    ;  ["doc/intro.md" (render "intro.md" data)]
    ;  [".gitignore"   (render ".gitignore" data)]
    ;  ["sample/_config.clj" (render "_config.clj" data)]
    ;  ["sample/template/foo.txt" (render "foo.txt" data)]
    ;  ["src/misaki/compiler/{{sanitized}}/core.clj"  (render "core.clj" data)]
    ;  ["test/misaki/compiler/{{name}}/core_test.clj" (render "core_test.clj" data)])
    ))

