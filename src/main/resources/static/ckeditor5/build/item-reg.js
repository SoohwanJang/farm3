ClassicEditor.create(document.querySelector(".editor"), {
  toolbar: {
    items: [
      "heading",
      "bold",
      "italic",
      "link",
      "bulletedList",
      "numberedList",
      "indent",
      "outdent",
      "blockQuote",
      "insertTable",
      "mediaEmbed",
      "undo",
      "redo",
      "ckFinder",
      "fontColor",
      "fontBackgroundColor",
      "fontsize",
      "fontFamily",
      "highlight",
      "horizontalLine",
      "underline",
    ],
  },
  language: "ko",
  licenseKey: "",
  ckfinder: {
    // Upload the images to the server using the CKFinder QuickUpload command.
    uploadUrl: "http://localhost:8080/api/img/img",
    resourceType: "Images",
  },
  image: {
    toolbar: ["imageTextAlternative", "imageStyle:full", "imageStyle:side"],
  },
  table: {
    contentToolbar: ["tableColumn", "tableRow", "mergeTableCells"],
  },
})
  .then((editor) => {
    window.editor = editor;

    // 임시저장버튼 변수담기
    const dtlBtn = document.querySelector(".detail-button");
    const dtlData = document.querySelector(".detail-data");
    // 임시저장버튼 눌렀을 시 input에 담는 콜백함수
    dtlBtn.addEventListener("click", () => {
      let editorData = editor.getData();
      dtlData.value = editorData;
      alert("임시 저장이 완료되었습니다");
    });
  })
  .catch((error) => {
    console.error("Oops, something gone wrong!");
    console.error(
      "Please, report the following error in the https://github.com/ckeditor/ckeditor5 with the build id and the error stack trace:"
    );
    console.warn("Build id: 10ge4teti4fh-7y3lpv23ta33");
    console.error(error);
  });
