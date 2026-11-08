# Social preview

`social-preview.png` (1280×640) is the image GitHub shows when the repo link is shared.
It is set manually in **Settings → General → Social preview**; GitHub has no API for it.

To regenerate it after editing `social-preview.html`, run from this folder (macOS, Google Chrome):

```sh
"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --headless=new --hide-scrollbars \
  --force-device-scale-factor=1 --window-size=1280,640 --virtual-time-budget=5000 \
  --screenshot="$PWD/social-preview.png" "file://$PWD/social-preview.html"
```

Chrome may keep running after writing the file; stop it once `social-preview.png` appears.
Keep the PNG under 1 MB (GitHub's limit), then re-upload it in Settings.

`java.svg` and `kotlin.svg` are the official logos from [Devicon](https://devicon.dev).
