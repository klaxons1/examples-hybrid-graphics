package p000;

import com.alcatelonetouchx.CanvasPlus;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.IndexBuffer;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Sprite3D;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreNotFoundException;

/* JADX INFO: loaded from: C:\Temp\jadx-10702457258892078492\classes.dex */
public class TheGame extends CanvasPlus implements Runnable {
    static int[] fadeDistance;
    static int fade_block_height;
    static int fade_block_width;
    static int fade_max_block;
    static int fade_max_distance;
    static int fade_x_offset;
    static int fade_y_offset;
    static String[] game_msg;
    static Graphics m_CurrentGraphics;
    private static AppMain m_Midlet;
    static int menu_camerCarAngle;
    static int realMaxCols;
    static int realMaxRows;
    static Graphics system_graphicsFirstSoftkey;
    static Graphics system_graphicsSecondSoftkey;
    static Image system_imageFirstSoftkey;
    static Image system_imageSecondSoftkey;
    int ActivePlayer;
    VertexArray POSITION_ARRAY;
    CSoundPlayerMIDP2[] Player;
    VertexArray TEX_ARRAY;
    CCollisionResult aiPathCollision;
    Car[] allCarsList;
    Appearance appearance;
    int[] asset_DataArray;
    int[] asset_PaletteFilterParams;
    CSoundObject[] asset_SoundArray;
    int asset_nTileImageID;
    Background background;
    Sprite3D brakelights;
    Camera camera;
    int cameraScopeMask;
    int car_rot;
    int car_rot_count;
    int car_rot_offset;
    int[] cheatCode;
    int cheatPosition;
    CompositingMode compositingMode_ZNONE;
    CompositingMode compositingMode_ZNONE_AlphaAdd;
    CompositingMode compositingMode_ZREAD_Alpha;
    CompositingMode compositingMode_ZWRITE;
    CompositingMode compositingMode_ZWRITEREAD;
    CompositingMode compositingMode_ZWRITE_Alpha;
    CompositingMode compositingMode_ZWRITE_AlphaAdd;
    Car[] cops;
    long[] crc_table;
    int crc_table_computed;
    int currentColor;
    int currentConfirm;
    int currentConfirmString;
    int currentDialogItem;
    String currentPage;
    short[] dialogData;
    int dialogItemCount;
    int docEnd;
    int docID;
    int docStart;
    Sprite3D[] fire_sprites;
    boolean firstUpdate;
    Sprite3D flash_effect_sprite;
    CFont font_headings;
    CFont font_ingame;
    CFont font_text;
    int frameCount;
    NFSMW_Mission[] g_missions;
    public int g_nLastRoadSideCopIndex;
    public int g_nParam1;
    public int g_nParam2;
    public int g_nParam3;
    public int g_nTimePlayerStuck;
    NFSMW_Profile g_player;
    NFSMW_Race g_race;
    Car g_roadsideCop;
    String[] g_statNames;
    int gameOver_stage;
    int game_Time;
    int game_TimeLimit;
    long game_TimeUpdate;
    boolean game_TimerCountdown;
    int game_angX;
    int game_angY;
    int game_angZ;
    boolean game_animationsLoaded;
    boolean game_bDrawBackgroundOnly;
    boolean game_bPauseNextUpdate;
    int game_cameraAngX;
    int game_cameraAngZ;
    int game_camlagX;
    int game_camlagY;
    int game_closestEvasionPickup;
    int game_currentGear;
    byte game_difficulty;
    boolean game_done;
    int game_fire;
    Graphics game_gMapBuffer;
    Image game_imageMapBuffer;
    boolean game_isLoading;
    int game_lastAngZ;
    byte game_level;
    int game_loadState;
    int game_mode;
    short game_nBackgroundMap;
    int game_nKeyFlags;
    byte game_nKeyPressed;
    byte game_nLastKeyTap;
    short game_nTimeInState;
    short game_nTimeKeyHeld;
    int game_numSpawnedCops;
    int game_playerPosition;
    boolean game_playingStateHadUpdate;
    int game_posX;
    int game_posY;
    int game_posZ;
    int game_random_number_gen;
    long game_random_state;
    boolean game_reloading;
    int game_score;
    int game_seed;
    byte game_state;
    byte game_state_before_pause;
    int game_tachometer_vel;
    int game_timeSinceLastCopSpawn;
    boolean game_trackFirstRender;
    boolean game_waitForInit;
    int game_xArrowPos;
    int game_yArrowPos;
    boolean gameover_pause;
    int[] gearImgsOn;
    int goingToNextMenu;
    CGroundCollision groundCollision;
    Sprite3D headlights;
    short[] hudLGImages;
    short[] hudMPHImages;
    short[] hudSMImages;
    int itemColor;
    int lastBustedness;
    int lastMenuDirection;
    int lastTacko;
    int level_start_score;
    int loadingCar;
    long loading_previousTime;
    long loading_timeTotal;
    boolean m_bKeyUnhang;
    boolean m_bPaintHourglass;
    boolean m_bWait;
    int map_dataPointer;
    NFSMW_Menu menuCarBrakesSelect;
    NFSMW_Menu menuCarEngineSelect;
    NFSMW_Menu menuCarFrontBmprsSelect;
    NFSMW_Menu menuCarFuelSelect;
    NFSMW_Menu menuCarNitrousSelect;
    NFSMW_Menu menuCarPaint;
    NFSMW_MenuItem[] menuCarPaintItems;
    NFSMW_Menu menuCarPaintLayout;
    NFSMW_Menu menuCarPaintSelect1;
    NFSMW_Menu menuCarPaintSelect2;
    NFSMW_Menu menuCarPaintSelect3;
    NFSMW_Menu menuCarRearBmprsSelect;
    NFSMW_Menu menuCarRimsSelect;
    NFSMW_Menu menuCarSelect;
    NFSMW_Menu menuCarSpoilerSelect;
    NFSMW_Menu menuCarTireSelect;
    NFSMW_Menu menuCarTransmissionSelect;
    NFSMW_Menu menuCarTurboSelect;
    NFSMW_Menu menuCarVinylSelect;
    NFSMW_Menu menuCarWindTintSelect;
    NFSMW_Menu menuCareer;
    NFSMW_MenuItem[] menuCareerItems;
    NFSMW_MenuItem[] menuCareerStatItems;
    NFSMW_Menu menuCareerStats;
    NFSMW_Menu menuCurrent;
    NFSMW_Menu menuCustomize;
    NFSMW_MenuItem[] menuCustomizeItems;
    NFSMW_Menu menuCustomizePerf;
    NFSMW_MenuItem[] menuCustomizePerfItems;
    NFSMW_Menu menuCustomizeVis;
    NFSMW_MenuItem[] menuCustomizeVisItems;
    NFSMW_Menu menuHelp;
    NFSMW_MenuItem[] menuHelpItems;
    NFSMW_Menu menuMissionChallenge;
    NFSMW_Menu menuMissionCheckpoints;
    NFSMW_Menu menuMissionCircuits;
    NFSMW_Menu menuMissionKnockout;
    NFSMW_Menu menuMissionOutrun;
    NFSMW_Menu menuMissionSpeedCam;
    NFSMW_MenuItem[] menuMissionTypeItems;
    NFSMW_Menu menuMissionTypes;
    NFSMW_Menu menuOptions;
    NFSMW_MenuItem[] menuOptionsItems;
    NFSMW_Menu menuProfile;
    NFSMW_MenuItem[] menuProfileItems;
    NFSMW_Menu menuQRCarSelect;
    NFSMW_Menu menuRoot;
    NFSMW_MenuItem[] menuRootItems;
    short menuRowCount;
    int menuTimer;
    NFSMW_Menu menuTrackSelect;
    Group menu_Group;
    boolean menu_IsPaused;
    boolean menu_SplashPause;
    boolean menu_bBlacklistLoaded;
    boolean menu_bMissionLoaded;
    int menu_canvasHeight;
    int menu_car;
    int menu_carUpdateTime;
    short menu_current_top_row;
    String[] menu_docArray;
    int[] menu_docLineAttr;
    int menu_docLineCount;
    boolean menu_drawCar;
    boolean menu_hourGlass;
    boolean menu_intromusicloaded;
    int menu_lastCar;
    short menu_level;
    short menu_max_row_count;
    short menu_mode;
    short menu_mode_param;
    String menu_msg;
    int menu_nDocument;
    int menu_nItemsHeight;
    int menu_nItemsYSpacing;
    int menu_nKeyFlags;
    int menu_nextCar;
    boolean menu_noRender;
    int menu_paintCarTimer;
    boolean menu_playmusic;
    Mesh menu_reflectionMesh;
    boolean menu_refreshCar;
    int menu_rowHeight;
    int menu_sceneLoadStage;
    int menu_scrollSpeed;
    boolean menu_scrolling;
    byte menu_show_mode;
    int menu_startupStage;
    int[] menu_tmpCarStatData;
    boolean menu_updateCarPaint;
    int menu_xOffset;
    int menu_yCanvasOffset;
    int menu_yDocStart;
    int menu_yOffset;
    int menu_yScrollOffset;
    int nPngDataSize;
    int numPlayers;
    int numRoadsideCops;
    int numTrackItems;
    int pagePos;
    int paused_action;
    boolean paused_hourglass;
    Car[] players;
    byte[] pngImageDataArray;
    Sprite3D policelights;
    PolygonMode polygonMode_NoPersp;
    PolygonMode polygonMode_Persp;
    PolygonMode polygonMode_Persp_Back;
    int popupTimer;
    byte prevShowMode;
    Sprite3D scene_OpenModel_Sprite3D;
    Mesh scene_UI_arrow;
    Mesh scene_UI_evasion_ind;
    Mesh scene_UI_indicator;
    Transform scene_cameraTrans;
    public Graphics3D scene_g3d;
    IndexBuffer scene_index_buffer;
    int scene_lastSnd;
    int scene_nCurrentScene;
    long scene_textureMemoryUsage;
    int scene_timer;
    long scene_timerTmp;
    boolean scene_timerUpdate;
    long scene_timerVal;
    long[] scene_timing;
    int[] scene_timingcolor;
    Transform scene_workerTrans;
    String script;
    int selectedColor;
    Appearance shadowAppearance;
    CompositingMode shadowCompmode;
    int sizex;
    int sizey;
    Mesh skyDome;
    int slowCount;
    Car[] sortedCarsList;
    CSoundPlayerMIDP2 soundPlayer;
    Sprite3D sparks_sprite;
    int[] splash_CheatKeyArray;
    int splash_nCheatKey;
    int splash_nState;
    int splash_nTimeInState;
    int[] stockColors;
    Random system_Random;
    CFont system_SoftkeyFont;
    CFont system_SoftkeyFontBackup;
    boolean system_bAppPaused;
    boolean system_bAssetLoading;
    boolean system_bCheat;
    boolean system_bConstantUpdate;
    boolean system_bDemoMode;
    boolean system_bExit;
    int system_bHasMMAPI;
    boolean system_bInitialised;
    boolean system_bReRenderSoftKeys;
    boolean system_bScreenDirty;
    boolean system_bSoundOn;
    boolean system_bSoundPlaying;
    boolean system_bTipsOn;
    boolean system_bUpdateDirty;
    int system_nCanvasHeight;
    int system_nCanvasWidth;
    int system_nClipHeight;
    int system_nClipWidth;
    int system_nContLevel;
    int system_nCouncurentSounds;
    int system_nDirtyHeight;
    int system_nDirtyWidth;
    int system_nFirstSoftkey;
    int system_nKeyCount;
    int system_nLastHighScore;
    long system_nLastTime;
    int system_nLoopCount;
    int system_nSaveDifficulty;
    int system_nSaveHealth;
    int system_nSaveLevel;
    int system_nSaveScore;
    int system_nScoreSlot;
    int system_nSecondSoftkey;
    int system_nSoftkeyHeight;
    int system_nSoftkeyWidth;
    int system_nSoundTypes;
    int system_nThisFrameTime;
    long system_nTimeEnd;
    long system_nTimeStart;
    int system_nVolume;
    String[] system_sSoftkeyArray;
    int system_softkeyBackground;
    int system_softkeyColor;
    int system_xClip;
    int system_xDirty;
    int system_yClip;
    int system_yDirty;
    TextureRef tex_ref;
    int timeInMenu;
    int timeLastKeyPress;
    int tipInitTime;
    Mesh[] trackBarrier1;
    int trackBarrier1Count;
    Mesh[] trackBarrier2;
    int trackBarrier2Count;
    Mesh[] trackBarrier3;
    int trackBarrier3Count;
    Mesh[] trackBarrier4;
    int trackBarrier4Count;
    int trackColTriangle;
    Group trackGroup;
    boolean[] trackIsMesh;
    boolean[] trackIsRendered;
    Mesh[] trackMeshs;
    short trackPVSFrame1;
    short trackPVSFrame2;
    short trackPVSFrame3;
    int trackPVSSegment;
    short[][] track_checkpoints;
    short[][] track_copPoints;
    short[][] track_evasionPoints;
    short track_maxPVSi;
    short[][] track_pvsMask;
    short[][] track_pvsStruct;
    short[][] track_pvsXYZ;
    short[][][] track_splines;
    Car[] traffic;
    Transform trans;
    boolean transitionDoneNextPaint;
    boolean transition_done;
    long tryMusicUntil;
    Vector vObjectList;
    Vector vTextureList;
    VertexBuffer wheelVertes;
    static byte[] game_keyHistory = new byte[8];
    static int g_missionIncID = 0;
    static boolean bAssertionsStarted = false;
    static boolean bAssertionSet = false;
    Image[] asset_ImageArray = new Image[66];
    byte[][] asset_TileMapArray = new byte[1][];
    byte[][] asset_DataBufArray = new byte[15][];
    int asset_PaletteFilter = -1;
    Image[] asset_FlippedImageArray = new Image[66];
    int[] system_HighScoreArray = new int[4];
    int scene_currentMusicTrack = 0;
    int[] scene_musicTracks = {1005, 1008, 1011, 1014, 1002};
    int car_dashboard = 0;
    boolean showFlashEffect = false;
    CCollisionResult colResultCamera = new CCollisionResult(this);
    short[] sin_Array = {0, 402, 803, 1205, 1605, 2005, 2404, 2801, 3196, 3589, 3980, 4369, 4756, 5139, 5519, 5896, 6269, 6639, 7005, 7366, 7723, 8075, 8423, 8765, 9102, 9434, 9759, 10079, 10393, 10701, 11002, 11297, 11585, 11866, 12139, 12406, 12665, 12916, 13159, 13395, 13622, 13842, 14053, 14255, 14449, 14634, 14810, 14978, 15136, 15286, 15426, 15557, 15678, 15790, 15892, 15985, 16069, 16142, 16206, 16260, 16305, 16339, 16364, 16379, 16383, 16379, 16364, 16339, 16305, 16260, 16206, 16142, 16069, 15985, 15892, 15790, 15678, 15557, 15426, 15286, 15136, 14978, 14810, 14634, 14449, 14255, 14053, 13842, 13622, 13395, 13159, 12916, 12665, 12406, 12139, 11866, 11585, 11297, 11002, 10701, 10393, 10079, 9759, 9434, 9102, 8765, 8423, 8075, 7723, 7366, 7005, 6639, 6269, 5896, 5519, 5139, 4756, 4369, 3980, 3589, 3196, 2801, 2404, 2005, 1605, 1205, 803, 402, 0, -402, -803, -1205, -1605, -2005, -2404, -2801, -3196, -3589, -3980, -4369, -4756, -5139, -5519, -5896, -6269, -6639, -7005, -7366, -7723, -8075, -8423, -8765, -9102, -9434, -9759, -10079, -10393, -10701, -11002, -11297, -11585, -11866, -12139, -12406, -12665, -12916, -13159, -13395, -13622, -13842, -14053, -14255, -14449, -14634, -14810, -14978, -15136, -15286, -15426, -15557, -15678, -15790, -15892, -15985, -16069, -16142, -16206, -16260, -16305, -16339, -16364, -16379, -16383, -16379, -16364, -16339, -16305, -16260, -16206, -16142, -16069, -15985, -15892, -15790, -15678, -15557, -15426, -15286, -15136, -14978, -14810, -14634, -14449, -14255, -14053, -13842, -13622, -13395, -13159, -12916, -12665, -12406, -12139, -11866, -11585, -11297, -11002, -10701, -10393, -10079, -9759, -9434, -9102, -8765, -8423, -8075, -7723, -7366, -7005, -6639, -6269, -5896, -5519, -5139, -4756, -4369, -3980, -3589, -3196, -2801, -2404, -2005, -1605, -1205, -803, -402};
    int[] exp_Array = {65535, 61564, 57834, 54330, 51038, 47946, 45041, 42312, 39748, 37340, 35078, 32953, 30956, 29080, 27319, 25663, 24108, 22648, 21276, 19987, 18776, 17638, 16569, 15565, 14622, 13736, 12904, 12122, 11388, 10698, 10050, 9441, 8869, 8331, 7827, 7352, 6907, 6488, 6095, 5726, 5379, 5053, 4747, 4459, 4189, 3935, 3697, 3473, 3262, 3065, 2879, 2704, 2541, 2387, 2242, 2106, 1978, 1859, 1746, 1640, 1541, 1447, 1360, 1277, 1200, 1127, 1059, 995, 934, 878, 824, 774, 728, 683, 642, 603, 566, 532, 500, 470, 441, 414, 389, 366, 343, 323, 303, 285, 267, 251, 236, 222, 208, 195, 184, 172, 162, 152, 143, 134, 126, 118, 111, 104, 98, 92, 86, 81, 76, 72, 67, 63, 59, 56, 52, 49, 46, 43, 41, 38, 36, 34, 31, 30, 28, 26, 24, 23, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 11, 10, 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int game_profilerPos = 0;
    int[] game_profilerColours = new int[30];
    long[][] game_profilerStartTimes = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 30, 32);
    long[][] game_profilerEndTimes = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 30, 32);
    int[] game_profilerTotalTimes = new int[30];
    int game_renderCount = 0;
    int game_loadedWorld = -1;
    String popupString = null;
    int popupImg = -1;
    boolean popupPriority = false;
    boolean splash_bRendered = false;
    byte splash_langSelection = 0;
    final int GAMETEXT_YES = 0;
    final int GAMETEXT_NO = 1;
    final int GAMETEXT_OK = 2;
    final int GAMETEXT_SELECT = 3;
    final int GAMETEXT_BACK = 4;
    final int GAMETEXT_EXIT = 5;
    final int GAMETEXT_CONTINUE = 6;
    final int GAMETEXT_RETRY = 7;
    final int GAMETEXT_PAUSE = 8;
    final int GAMETEXT_RESUME = 9;
    final int GAMETEXT_TOTAL_FINE = 10;
    final int GAMETEXT_MUSIC_VOLUME = 11;
    final int GAMETEXT_PRESSTOSTART = 12;
    final int GAMETEXT_LOCKED = 13;
    final int GAMETEXT_MISSION_PASSED = 14;
    final int GAMETEXT_MISSION_FAILED = 15;
    final int GAMETEXT_DEMO = 16;
    final int GAMETEXT_CASH = 17;
    final int GAMETEXT_REP = 18;
    final int GAMETEXT_RACE_TYPE = 19;
    final int GAMETEXT_LAPS = 20;
    final int GAMETEXT_TRACK = 21;
    final int GAMETEXT_TIMELIMIT = 22;
    final int GAMETEXT_FINE = 23;
    final int GAMETEXT_MISSIONS = 24;
    final int GAMETEXT_COMPLETE = 25;
    final int GAMETEXT_PERCENTAGE = 26;
    final int GAMETEXT_PLAYER = 27;
    final int GAMETEXT_CARS = 28;
    final int GAMETEXT_LOADING = 29;
    final int GAMETEXT_INUSE = 30;
    final int GAMETEXT_INGARAGE = 31;
    final int GAMETEXT_NOT_AVAILABLE = 32;
    final int GAMETEXT_OWNED = 33;
    final int GAMETEXT_INSTALLED = 34;
    final int GAMETEXT_NOT_INSTALLED = 35;
    final int GAMETEXT_NOT_OWNED = 36;
    final int GAMETEXT_PRICE = 37;
    final int GAMETEXT_BANKROLL = 38;
    final int GAMETEXT_TRACK_LENGTH = 39;
    final int GAMETEXT_REPWON = 40;
    final int GAMETEXT_CASHWON = 41;
    final int GAMETEXT_SCORE = 42;
    final int GAMETEXT_TIME = 43;
    final int GAMETEXT_TOP_SPEED = 44;
    final int GAMETEXT_FASTEST_LAP = 45;
    final int GAMETEXT_COPS_CRASHED = 46;
    final int GAMETEXT_STEER_RIGHT = 47;
    final int GAMETEXT_STEER_LEFT = 48;
    final int GAMETEXT_BRAKE = 49;
    final int GAMETEXT_TAP_NITRO = 50;
    final int GAMETEXT_TAP_ACCELERATE = 51;
    final int GAMETEXT_INSTALLPART = 52;
    final int GAMETEXT_BUYPART = 53;
    final int GAMETEXT_SELECTCAR = 54;
    final int GAMETEXT_CAR_LOCKED = 55;
    final int GAMETEXT_CAR_LOCKED_DEMO = 56;
    final int GAMETEXT_CHANGE_LANGUAGE = 57;
    final int GAMETEXT_CHANGE_PROFILE = 58;
    final int GAMETEXT_CLEAR_PROFILE = 59;
    final int GAMETEXT_NEED_REP = 60;
    final int GAMETEXT_NEED_REP_DEMO = 61;
    final int GAMETEXT_NEED_CASH = 62;
    final int GAMETEXT_NEED_CASH_DEMO = 63;
    final int GAMETEXT_NEED_MISSION = 64;
    final int GAMETEXT_NEED_MISSION_DEMO = 65;
    final int GAMETEXT_ALREADY_INSTALLED = 66;
    final int GAMETEXT_DOWNGRADING = 67;
    final int GAMETEXT_EXIT_WARNING = 68;
    final int GAMETEXT_TRACK_DEMOLOCK = 69;
    final int GAMETEXT_CANT_REPEAT = 70;
    final int GAMETEXT_CAR_USED = 71;
    final int GAMETEXT_CAR_MITSU = 72;
    final int GAMETEXT_CAR_CORVET = 73;
    final int GAMETEXT_CAR_SUPRA = 74;
    final int GAMETEXT_CAR_LANCER = 75;
    final int GAMETEXT_CAR_RX8 = 76;
    final int GAMETEXT_CAR_BMW = 77;
    final int GAMETEXT_CAR_COP = 78;
    final int GAMETEXT_CAR_TRAFFIC = 79;
    final int GAMETEXT_TRACK_CITY = 80;
    final int GAMETEXT_TRACK_BEACH = 81;
    final int GAMETEXT_TRACK_CITYA = 82;
    final int GAMETEXT_TRACK_CITYB = 83;
    final int GAMETEXT_TRACK_CITYC = 84;
    final int GAMETEXT_TRACK_BEACHA = 85;
    final int GAMETEXT_TRACK_BEACHB = 86;
    final int GAMETEXT_MENUTITLE_CAREER = 87;
    final int GAMETEXT_MENUTITLE_STATS = 88;
    final int GAMETEXT_MENUTITLE_CUSOMTIZE = 89;
    final int GAMETEXT_MENUTITLE_MAINMENU = 90;
    final int GAMETEXT_MENUTITLE_MISSIONS = 91;
    final int GAMETEXT_MENUTITLE_OPTIONS = 92;
    final int GAMETEXT_MENUTITLE_PROFILES = 93;
    final int GAMETEXT_MENUTITLE_QUICKRACE = 94;
    final int GAMETEXT_MENUTITLE_SELECT_CAR = 95;
    final int GAMETEXT_MENUTITLE_SELECT_TRACK = 96;
    final int GAMETEXT_MENUTITLE_LAYOUT = 97;
    final int GAMETEXT_MENUTITLE_COLOUR1 = 98;
    final int GAMETEXT_MENUTITLE_COLOUR2 = 99;
    final int GAMETEXT_MENUTITLE_COLOUR3 = 100;
    final int GAMETEXT_MENUTITLE_TINT = 101;
    final int GAMETEXT_MENUTITLE_PAINT = 102;
    final int GAMETEXT_MENUTITLE_VINYLS = 103;
    final int GAMETEXT_MENUTITLE_SPOILER = 104;
    final int GAMETEXT_MENUTITLE_RIMS = 105;
    final int GAMETEXT_MENUTITLE_FBUMPER = 106;
    final int GAMETEXT_MENUTITLE_RBUMPER = 107;
    final int GAMETEXT_MENUTITLE_ENGINE = 108;
    final int GAMETEXT_MENUTITLE_TURBO = 109;
    final int GAMETEXT_MENUTITLE_NITRO = 110;
    final int GAMETEXT_MENUTITLE_TRANS = 111;
    final int GAMETEXT_MENUTITLE_TIRES = 112;
    final int GAMETEXT_MENUTITLE_BRAKES = 113;
    final int GAMETEXT_MENUTITLE_FUEL = 114;
    final int GAMETEXT_MENUTITLE_VIS = 115;
    final int GAMETEXT_MENUTITLE_PERF = 116;
    final int GAMETEXT_MENUTITLE_CIRCUIT = 117;
    final int GAMETEXT_MENUTITLE_CHECKPOINT = 118;
    final int GAMETEXT_MENUTITLE_KNOCKOUT = 119;
    final int GAMETEXT_MENUTITLE_SPEEDCAM = 120;
    final int GAMETEXT_MENUTITLE_OUTRUN = 121;
    final int GAMETEXT_MENUTITLE_CHALLENGE = 122;
    final int GAMETEXT_MENUTITLE_GENERAL = 123;
    final int GAMETEXT_MENUTITLE_BLACKLIST = 124;
    final int GAMETEXT_MENUTITLE_CUSTOMIZE = 125;
    final int GAMETEXT_MENUTITLE_SELECTCAR = 126;
    final int GAMETEXT_MENUTITLE_PROFILE1 = 127;
    final int GAMETEXT_MENUTITLE_PROFILE2 = 128;
    final int GAMETEXT_MENUTITLE_PROFILE3 = 129;
    final int GAMETEXT_MENUTITLE_CONTROLS = 130;
    final int GAMETEXT_MENUTITLE_RACETYPE = 131;
    final int GAMETEXT_MENUTITLE_RAPSHEET = 132;
    final int GAMETEXT_MENUTITLE_HUD = 133;
    final int GAMETEXT_MENUTITLE_VOLUME = 134;
    final int GAMETEXT_MENUTITLE_CHANGE_PROFILE = 135;
    final int GAMETEXT_MENUTITLE_CLEAR_PROFILE = 136;
    final int GAMETEXT_MENUTITLE_HELP = 137;
    final int GAMETEXT_MENUTITLE_LANGUAGE = 138;
    final int GAMETEXT_MENUTITLE_SUPPORT = 139;
    final int GAMETEXT_MENUTITLE_EXIT = 140;
    final int GAMETEXT_PART_NONE = 141;
    final int GAMETEXT_PART_STOCK = 142;
    final int GAMETEXT_PART_DYNAMIC = 143;
    final int GAMETEXT_PART_WAVES = 144;
    final int GAMETEXT_PART_SKULL = 145;
    final int GAMETEXT_PART_SLASH = 146;
    final int GAMETEXT_PART_FIRE = 147;
    final int GAMETEXT_PART_BLAZE = 148;
    final int GAMETEXT_PART_STRIPE = 149;
    final int GAMETEXT_PART_COLOUR1 = 150;
    final int GAMETEXT_PART_COLOUR2 = 151;
    final int GAMETEXT_PART_COLOUR3 = 152;
    final int GAMETEXT_PART_COLOUR4 = 153;
    final int GAMETEXT_PART_COLOUR5 = 154;
    final int GAMETEXT_PART_COLOUR6 = 155;
    final int GAMETEXT_PART_COLOUR7 = 156;
    final int GAMETEXT_PART_COLOUR8 = 157;
    final int GAMETEXT_PART_COLOUR9 = 158;
    final int GAMETEXT_PART_COLOUR10 = 159;
    final int GAMETEXT_PART_COLOUR11 = 160;
    final int GAMETEXT_PART_COLOUR12 = 161;
    final int GAMETEXT_PART_COLOUR13 = 162;
    final int GAMETEXT_PART_FLAME1 = 163;
    final int GAMETEXT_PART_FLAME2 = 164;
    final int GAMETEXT_PART_MODERN1 = 165;
    final int GAMETEXT_PART_MODERN2 = 166;
    final int GAMETEXT_PART_STRIPES1 = 167;
    final int GAMETEXT_PART_STRIPES2 = 168;
    final int GAMETEXT_PART_TRIBAL1 = 169;
    final int GAMETEXT_PART_TRIBAL2 = 170;
    final int GAMETEXT_PART_TYPE1 = 171;
    final int GAMETEXT_PART_TYPE2 = 172;
    final int GAMETEXT_PART_TYPE3 = 173;
    final int GAMETEXT_PART_TYPE4 = 174;
    final int GAMETEXT_PART_TYPE5 = 175;
    final int GAMETEXT_PART_TYPE6 = 176;
    final int GAMETEXT_PART_TYPE7 = 177;
    final int GAMETEXT_PART_TYPE8 = 178;
    final int GAMETEXT_PART_PACK1 = 179;
    final int GAMETEXT_PART_PACK2 = 180;
    final int GAMETEXT_PART_PACK3 = 181;
    final int GAMETEXT_NITRO_EMPTY = 182;
    final int GAMETEXT_OPPONENT_KNOCKEDOUT = 183;
    final int GAMETEXT_CHECKPOINT = 184;
    final int GAMETEXT_GO = 185;
    final int GAMETEXT_PAUSED = 186;
    final int GAMETEXT_BUSTED = 187;
    final int GAMETEXT_1ST = 188;
    final int GAMETEXT_2ND = 189;
    final int GAMETEXT_3RD = 190;
    final int GAMETEXT_4TH = 191;
    final int GAMETEXT_TOO_SLOW = 192;
    final int GAMETEXT_CAR_BROKEN = 193;
    final int GAMETEXT_EVADE = 194;
    final int GAMETEXT_BUSTED_IN = 195;
    final int GAMETEXT_TIMESUP = 196;
    final int GAMETEXT_TOOSLOW = 197;
    final int GAMETEXT_CAUGHT = 198;
    final int GAMETEXT_GOTAWAY = 199;
    final int GAMETEXT_RACE_COMPLETE = 200;
    final int GAMETEXT_RECKLESS_DRIVING = 201;
    final int GAMETEXT_ASSULT = 202;
    final int GAMETEXT_SPEEDING = 203;
    final int GAMETEXT_SCRIPT_BOSS1_BLURB = 204;
    final int GAMETEXT_SCRIPT_BOSS1_UNLOCK = 205;
    final int GAMETEXT_SCRIPT_BOSS1_COMPLETE = 206;
    final int GAMETEXT_SCRIPT_BOSS2_BLURB = 207;
    final int GAMETEXT_SCRIPT_BOSS2_UNLOCK = 208;
    final int GAMETEXT_SCRIPT_BOSS2_COMPLETE = 209;
    final int GAMETEXT_SCRIPT_BOSS2_COP = 210;
    final int GAMETEXT_SCRIPT_BOSS3_BLURB = 211;
    final int GAMETEXT_SCRIPT_BOSS3_UNLOCK = 212;
    final int GAMETEXT_SCRIPT_BOSS3_COMPLETE = 213;
    final int GAMETEXT_SCRIPT_BOSS3_COP = 214;
    final int GAMETEXT_SCRIPT_BOSS4_BLURB = 215;
    final int GAMETEXT_SCRIPT_BOSS4_UNLOCK = 216;
    final int GAMETEXT_SCRIPT_BOSS4_COMPLETE = 217;
    final int GAMETEXT_SCRIPT_BOSS4_COP = 218;
    final int GAMETEXT_SCRIPT_BOSS5_BLURB = 219;
    final int GAMETEXT_SCRIPT_BOSS5_UNLOCK = 220;
    final int GAMETEXT_SCRIPT_BOSS5_COMPLETE = 221;
    final int GAMETEXT_SCRIPT_BOSS5_COP = 222;
    final int GAMETEXT_SCRIPT_BOSS6_BLURB = 223;
    final int GAMETEXT_SCRIPT_BOSS6_UNLOCK = 224;
    final int GAMETEXT_SCRIPT_BOSS6_COMPLETE = 225;
    final int GAMETEXT_SCRIPT_BOSS6_COP = 226;
    final int GAMETEXT_SCRIPT_CIRCUIT_1 = 227;
    final int GAMETEXT_SCRIPT_CIRCUIT_2 = 228;
    final int GAMETEXT_SCRIPT_CIRCUIT_3 = 229;
    final int GAMETEXT_SCRIPT_CIRCUIT_4 = 230;
    final int GAMETEXT_SCRIPT_CIRCUIT_5 = 231;
    final int GAMETEXT_SCRIPT_CIRCUIT_6 = 232;
    final int GAMETEXT_SCRIPT_CHECKPOINT_1 = 233;
    final int GAMETEXT_SCRIPT_CHECKPOINT_2 = 234;
    final int GAMETEXT_SCRIPT_CHECKPOINT_3 = 235;
    final int GAMETEXT_SCRIPT_CHECKPOINT_4 = 236;
    final int GAMETEXT_SCRIPT_CHECKPOINT_5 = 237;
    final int GAMETEXT_SCRIPT_CHECKPOINT_6 = 238;
    final int GAMETEXT_SCRIPT_KNOCKOUT_1 = 239;
    final int GAMETEXT_SCRIPT_KNOCKOUT_2 = 240;
    final int GAMETEXT_SCRIPT_KNOCKOUT_3 = 241;
    final int GAMETEXT_SCRIPT_KNOCKOUT_4 = 242;
    final int GAMETEXT_SCRIPT_KNOCKOUT_5 = 243;
    final int GAMETEXT_SCRIPT_KNOCKOUT_6 = 244;
    final int GAMETEXT_SCRIPT_CAMERA_1 = 245;
    final int GAMETEXT_SCRIPT_CAMERA_2 = 246;
    final int GAMETEXT_SCRIPT_CAMERA_3 = 247;
    final int GAMETEXT_SCRIPT_CAMERA_4 = 248;
    final int GAMETEXT_SCRIPT_CAMERA_5 = 249;
    final int GAMETEXT_SCRIPT_CAMERA_6 = 250;
    final int GAMETEXT_SCRIPT_OUTRUN_1 = 251;
    final int GAMETEXT_SCRIPT_OUTRUN_2 = 252;
    final int GAMETEXT_SCRIPT_OUTRUN_3 = 253;
    final int GAMETEXT_SCRIPT_OUTRUN_4 = 254;
    final int GAMETEXT_SCRIPT_OUTRUN_5 = 255;
    final int GAMETEXT_SCRIPT_OUTRUN_6 = 256;
    final int GAMETEXT_TOTAL_LINES = 257;
    int[] g_docsEnglish = {963, 965, 971, 967, 969, 973};
    int[] g_docsChineseSimplified = {989, 991, 997, 993, 995, 999};
    int[] g_docs = this.g_docsEnglish;
    int[] g_HudImgsEnglish = {108, 116, 120, 104, 96, 100, 112};
    int[] g_HudImgsChineseSimplified = {412, 420, 424, 408, 400, 404, 416};
    int[] g_HudImgs = this.g_HudImgsEnglish;
    int[] g_WarningImgs = {610, 628};
    int[] g_MenuImagesEnglish = {604, 634, 640};
    int[] g_MenuImagesSChinese = {622, 936, 942};
    int[] g_MenuImages = this.g_MenuImagesEnglish;
    byte g_nLanguage = 0;
    String[] g_Text = new String[257];
    String[] g_statNamesEnglish = {"SP", "HD", "AC", "RP"};
    String[] g_statNamesSChinese = {"速度", "操纵", "加速", "名声"};
    int[] stats_stock = {0, 0, 0, 0};
    int[] stats_paint = {0, 0, 0, 1};
    int[] stats_windTint = {0, 0, 0, 1};
    int[] stats_vinyl = {0, 0, 0, 2};
    int[] stats_spoiler = {0, 1, 0, 2};
    int[] stats_rims = {0, 0, 0, 2};
    int[] stats_bumpers = {0, 0, 0, 1};
    int[] stats_engine1 = {1, 0, 0, 0};
    int[] stats_turbo1 = {0, 0, 1, 0};
    int[] stats_nitrous1 = {0, 0, 0, 0};
    int[] stats_trans1 = {0, 0, 1, 0};
    int[] stats_tires1 = {0, 1, 0, 0};
    int[] stats_brakes1 = {0, 1, 0, 0};
    int[] stats_fuel1 = {1, 0, 0, 0};
    int[] stats_engine2 = {2, 0, 0, 0};
    int[] stats_turbo2 = {0, 0, 2, 0};
    int[] stats_nitrous2 = {0, 0, 0, 0};
    int[] stats_trans2 = {0, 0, 2, 0};
    int[] stats_tires2 = {0, 2, 0, 0};
    int[] stats_brakes2 = {0, 2, 0, 0};
    int[] stats_fuel2 = {2, 0, 0, 0};
    int[] stats_engine3 = {3, 0, 0, 0};
    int[] stats_turbo3 = {0, 0, 3, 0};
    int[] stats_nitrous3 = {0, 0, 0, 0};
    int[] stats_trans3 = {0, 0, 3, 0};
    int[] stats_tires3 = {0, 3, 0, 0};
    int[] stats_brakes3 = {0, 3, 0, 0};
    int[] stats_fuel3 = {3, 0, 0, 0};
    int[] stats_max = {10, 11, 10, 13};
    NFSMW_CarPart[][] g_carParts = {new NFSMW_CarPart[]{new NFSMW_CarPart(this, 4096, 0, 142, "", -1, 0, this.stats_stock), new NFSMW_CarPart(this, 4096, 1, 143, "paintlayout_01", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 2, 144, "paintlayout_02", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 3, 145, "paintlayout_03", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 4, 146, "paintlayout_04", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 5, 147, "paintlayout_05", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 6, 148, "paintlayout_06", 0, 750, this.stats_paint), new NFSMW_CarPart(this, 4096, 7, 149, "paintlayout_07", 0, 750, this.stats_paint)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 8192, 0, 142, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 8192, 1, 150, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 2, 151, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 3, 152, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 4, 153, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 5, 154, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 6, 155, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 7, 156, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 8, 157, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 9, 158, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 10, 159, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 11, 160, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 12, 161, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 8192, 13, 162, 0, 200, this.stats_paint)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 16384, 0, 142, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 16384, 1, 150, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 2, 151, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 3, 152, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 4, 153, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 5, 154, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 6, 155, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 7, 156, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 8, 157, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 9, 158, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 10, 159, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 11, 160, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 12, 161, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 16384, 13, 162, 0, 200, this.stats_paint)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 32768, 0, 142, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 32768, 1, 150, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 2, 151, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 3, 152, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 4, 153, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 5, 154, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 6, 155, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 7, 156, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 8, 157, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 9, 158, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 10, 159, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 11, 160, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 12, 161, 0, 200, this.stats_paint), new NFSMW_CarPart(this, 32768, 13, 162, 0, 200, this.stats_paint)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 65536, 0, 142, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 65536, 1, 150, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 2, 151, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 3, 152, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 4, 153, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 5, 154, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 6, 155, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 7, 156, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 8, 157, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 9, 158, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 10, 159, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 11, 160, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 12, 161, 0, 1000, this.stats_paint), new NFSMW_CarPart(this, 65536, 13, 162, 0, 1000, this.stats_paint)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 131072, 0, 142, -1, -1, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 131072, 1, 163, 66, 12, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 2, 164, 72, 8, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 3, 165, 84, 40, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 4, 166, 78, 36, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 5, 167, 90, 50, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 6, 168, 18, 46, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 7, 169, 24, 60, 0, 2000, this.stats_vinyl), new NFSMW_CarPart(this, 131072, 8, 170, 30, 56, 0, 2000, this.stats_vinyl)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 262144, 0, 141, "", -1, 0, this.stats_stock), new NFSMW_CarPart(this, 262144, 1, 171, "wing_01", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 2, 172, "wing_02", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 3, 173, "wing_03", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 4, 174, "wing_04", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 5, 175, "wing_05", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 6, 176, "wing_06", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 7, 177, "wing_07", 0, 2000, this.stats_spoiler), new NFSMW_CarPart(this, 262144, 8, 178, "wing_08", 0, 2000, this.stats_spoiler)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 524288, 0, 142, "/rim_01.png", -1, 0, this.stats_stock), new NFSMW_CarPart(this, 524288, 1, 171, "/rim_02.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 2, 172, "/rim_03.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 3, 173, "/rim_04.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 4, 174, "/rim_05.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 5, 175, "/rim_06.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 6, 176, "/rim_07.png", 0, 2500, this.stats_rims), new NFSMW_CarPart(this, 524288, 7, 177, "/rim_08.png", 0, 2500, this.stats_rims)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 1048576, 0, 142, -1, -1, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 1048576, 1, 171, 460, 446, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 2, 172, 456, 442, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 3, 173, 452, 438, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 4, 174, 568, 554, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 5, 175, 564, 550, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 6, 176, 560, 546, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 7, 177, 482, 540, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 1048576, 8, 178, 478, 536, 0, 3000, this.stats_bumpers)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 2097152, 0, 142, -1, -1, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 2097152, 1, 171, 474, 526, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 2, 172, 470, 522, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 3, 173, 466, 518, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 4, 174, 504, 434, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 5, 175, 500, 430, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 6, 176, 496, 514, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 7, 177, 492, 510, 0, 3000, this.stats_bumpers), new NFSMW_CarPart(this, 2097152, 8, 178, 488, 532, 0, 3000, this.stats_bumpers)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 4194304, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 4194304, 1, 179, 0, 2500, this.stats_engine1), new NFSMW_CarPart(this, 4194304, 2, 180, 0, 5000, this.stats_engine2), new NFSMW_CarPart(this, 4194304, 3, 181, 0, 9500, this.stats_engine3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 8388608, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 8388608, 1, 179, 0, 2000, this.stats_turbo1), new NFSMW_CarPart(this, 8388608, 2, 180, 0, 4000, this.stats_turbo2), new NFSMW_CarPart(this, 8388608, 3, 181, 0, 8000, this.stats_turbo3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 16777216, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 16777216, 1, 179, 0, 2500, this.stats_nitrous1), new NFSMW_CarPart(this, 16777216, 2, 180, 0, 5000, this.stats_nitrous2), new NFSMW_CarPart(this, 16777216, 3, 181, 0, 9500, this.stats_nitrous3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 33554432, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 33554432, 1, 179, 0, 2500, this.stats_trans1), new NFSMW_CarPart(this, 33554432, 2, 180, 0, 5000, this.stats_trans2), new NFSMW_CarPart(this, 33554432, 3, 181, 0, 9500, this.stats_trans3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 67108864, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 67108864, 1, 179, 0, 2000, this.stats_tires1), new NFSMW_CarPart(this, 67108864, 2, 180, 0, 4000, this.stats_tires2), new NFSMW_CarPart(this, 67108864, 3, 181, 0, 8000, this.stats_tires3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 134217728, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 134217728, 1, 179, 0, 1000, this.stats_brakes1), new NFSMW_CarPart(this, 134217728, 2, 180, 0, 2000, this.stats_brakes2), new NFSMW_CarPart(this, 134217728, 3, 181, 0, 5000, this.stats_brakes3)}, new NFSMW_CarPart[]{new NFSMW_CarPart(this, 268435456, 0, 141, -1, 0, this.stats_stock), new NFSMW_CarPart(this, 268435456, 1, 179, -1, 2000, this.stats_fuel1), new NFSMW_CarPart(this, 268435456, 2, 180, -1, 4000, this.stats_fuel2), new NFSMW_CarPart(this, 268435456, 3, 181, -1, 8000, this.stats_fuel3)}};
    Image g_carImgHi = Image.createImage(128, 128);
    Image g_carImgLow = Image.createImage(64, 64);
    Image g_carImgTraffic = Image.createImage(64, 32);
    Graphics g_carGfxHi = null;
    Graphics g_carGfxLow = null;
    Graphics g_carGfxTraffic = null;
    byte[][] g_carSetups = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{3, 0, 13, 9, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0}, new byte[]{5, 7, 0, 3, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{4, 6, 3, 0, 0, 0, 3, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0}, new byte[]{2, 6, 0, 13, 2, 0, 7, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 4, 13, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, new byte[]{0, 13, 0, 3, 5, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    byte[][] g_QRcarSetups = {new byte[]{0, 9, 0, 0, 0, 6, 8, 1, 2, 6, 2, 2, 2, 1, 1, 1, 1}, new byte[]{0, 13, 13, 9, 13, 0, 6, 7, 5, 0, 2, 2, 2, 1, 1, 1, 1}, new byte[]{0, 1, 0, 3, 0, 0, 5, 6, 1, 5, 2, 2, 2, 2, 1, 1, 1}, new byte[]{0, 6, 5, 0, 0, 4, 7, 4, 0, 0, 2, 2, 2, 2, 1, 1, 1}, new byte[]{0, 10, 0, 13, 2, 0, 2, 5, 7, 4, 2, 2, 2, 2, 2, 1, 1}, new byte[]{0, 4, 3, 0, 13, 0, 2, 5, 0, 0, 2, 2, 2, 2, 2, 2, 2}};
    NFSMW_CarAppearance[] g_cars = {new NFSMW_CarAppearance(this, 32, 0, 72, "car_mitsu_eclipse", 1041, new int[]{0, 0, 0, 0}, false), new NFSMW_CarAppearance(this, 32, 1, 73, "car_corvette_c6r", 1047, new int[]{1, 1, 0, 0}, false), new NFSMW_CarAppearance(this, 32, 2, 74, "car_toyota_supra", 1037, new int[]{2, 2, 1, 0}, false), new NFSMW_CarAppearance(this, 32, 3, 75, "car_lancer_evoviii", 1045, new int[]{2, 3, 2, 0}, false), new NFSMW_CarAppearance(this, 32, 4, 76, "car_mazda_rx8", 1043, new int[]{3, 3, 4, 0}, false), new NFSMW_CarAppearance(this, 32, 5, 77, "car_bmw_3series", 1049, new int[]{4, 4, 4, 0}, false), null, new NFSMW_CarAppearance(this, 32, 7, 78, "car_police", 1039, new int[]{0, 0, 0, 0}, false), new NFSMW_CarAppearance(this, 32, 8, 79, "traffic_hatch", 1019, new int[]{0, 0, 0, 0}, true), new NFSMW_CarAppearance(this, 32, 9, 79, "traffic_4x4", 1021, new int[]{0, 0, 0, 0}, true), new NFSMW_CarAppearance(this, 32, 10, 79, "traffic_van", 1017, new int[]{0, 0, 0, 0}, true), new NFSMW_CarAppearance(this, 32, 11, 74, "car_toyota_supra", 1037, new int[]{2, 2, 1, 0}, false)};
    String[] g_worlds = {"track_01", "track_02"};
    int[] g_worldsPretty = {81, 80};
    NFSMW_TrackPath[] g_trackPaths = {new NFSMW_TrackPath(this, 0, 0, 1083, 1063, -1, 9), new NFSMW_TrackPath(this, 0, 1, 1081, 1061, -1, 3), null, new NFSMW_TrackPath(this, 0, 3, 1095, 1063, 1077, 255), new NFSMW_TrackPath(this, 0, 3, 1091, 1061, 1075, 255), new NFSMW_TrackPath(this, 0, 3, 1087, 1061, 1073, 255), new NFSMW_TrackPath(this, 1, 0, 1126, 1102, -1, 59), new NFSMW_TrackPath(this, 1, 1, 1124, 1100, -1, 39), new NFSMW_TrackPath(this, 1, 2, 1122, 1098, -1, 106), new NFSMW_TrackPath(this, 1, 3, 1138, 1100, 1118, 255), new NFSMW_TrackPath(this, 1, 3, 1134, 1102, 1116, 255), new NFSMW_TrackPath(this, 1, 3, 1130, 1102, 1114, 255), new NFSMW_TrackPath(this, 0, 3, 1081, 1061, 1079, 255), new NFSMW_TrackPath(this, 1, 3, 1126, 1102, 1120, 255), null};
    NFSMW_Track[] g_tracks = {new NFSMW_Track(this, 136, 0, 82, 586, 6, "1.0"), new NFSMW_Track(this, 136, 1, 83, 592, 7, "1.0"), new NFSMW_Track(this, 136, 2, 84, 598, 8, "0.8"), new NFSMW_Track(this, 136, 3, 85, 574, 0, "1.2"), new NFSMW_Track(this, 136, 4, 86, 580, 1, "1.7")};
    int[] g_missionTypeNames = {117, 118, 119, 120, 121, 122};
    int[][] raceSetups = {new int[]{1, 3, 2, 1}, new int[]{2, 3, 2, 1}, new int[]{3, 3, 2, 1}, new int[]{4, 3, 2, 1}, new int[]{1, 2, 1, 1}, new int[]{2, 3, 1, 1}, new int[]{3, 3, 1, 1}, new int[]{1, 1, 2, 1}, new int[]{2, 1, 2, 1}, new int[]{3, 1, 2, 1}, new int[]{5, 3, 2, 1}, new int[]{1, 2, 2, 1}, new int[]{2, 2, 2, 1}, new int[]{3, 2, 2, 1}};
    int[][] scriptScenes = {new int[]{204, 205, 206}, new int[]{207, 208, 209}, new int[]{-1, -1, 210}, new int[]{211, 212, 213}, new int[]{-1, -1, 214}, new int[]{215, 216, 217}, new int[]{-1, -1, 218}, new int[]{219, 220, 221}, new int[]{-1, -1, 222}, new int[]{223, 224, 225}, new int[]{-1, -1, 226}, new int[]{227, -1, -1}, new int[]{228, -1, -1}, new int[]{229, -1, -1}, new int[]{230, -1, -1}, new int[]{231, -1, -1}, new int[]{232, -1, -1}, new int[]{233, -1, -1}, new int[]{234, -1, -1}, new int[]{235, -1, -1}, new int[]{236, -1, -1}, new int[]{237, -1, -1}, new int[]{238, -1, -1}, new int[]{239, -1, -1}, new int[]{240, -1, -1}, new int[]{241, -1, -1}, new int[]{242, -1, -1}, new int[]{243, -1, -1}, new int[]{244, -1, -1}, new int[]{245, -1, -1}, new int[]{246, -1, -1}, new int[]{247, -1, -1}, new int[]{248, -1, -1}, new int[]{249, -1, -1}, new int[]{250, -1, -1}, new int[]{251, -1, -1}, new int[]{252, -1, -1}, new int[]{253, -1, -1}, new int[]{254, -1, -1}, new int[]{255, -1, -1}, new int[]{256, -1, -1}};

    /* JADX INFO: renamed from: TheGame$1 */
    static class C00001 {
    }

    public class CCollisionResult {
        short nAttribute;
        short nTriangleID;
        private final TheGame this$0;

        /* JADX INFO: renamed from: x */
        int f0x;

        /* JADX INFO: renamed from: y */
        int f1y;

        /* JADX INFO: renamed from: z */
        int f2z;

        public CCollisionResult(TheGame theGame) {
            this.this$0 = theGame;
        }

        void Init() {
            this.nTriangleID = (short) -1;
            this.nAttribute = (short) -1;
            this.f2z = 0;
            this.f1y = 0;
            this.f0x = 0;
        }
    }

    private class CFont {
        Font m_SystemFont;
        boolean m_bShadow;
        int m_blue;
        int m_green;
        int m_nMaxWidth;
        int m_red;
        int m_shadowColor;
        private final TheGame this$0;

        private CFont(TheGame theGame) {
            this.this$0 = theGame;
        }

        CFont(TheGame theGame, C00001 c00001) {
            this(theGame);
        }

        void Construct() {
            this.m_SystemFont = null;
            this.m_red = 0;
            this.m_green = 0;
            this.m_blue = 0;
            this.m_bShadow = false;
            this.m_shadowColor = 0;
            this.m_nMaxWidth = 0;
        }

        void DrawSubstring(String str, int i, int i2, int i3, int i4, int i5) {
            int iGetSubstringWidth = GetSubstringWidth(str, i, i2);
            int iGetHeight = GetHeight();
            if ((i5 & 1) != 0) {
                i3 -= iGetSubstringWidth >> 1;
            } else if ((i5 & 2) != 0) {
                i3 -= iGetSubstringWidth;
            }
            if ((i5 & 4) != 0) {
                i4 -= iGetHeight >> 1;
            } else if ((i5 & 8) != 0) {
                i4 -= iGetHeight;
            } else if ((i5 & 0) != 0) {
            }
            this.this$0.system_UpdateDirty(i3, i4, iGetSubstringWidth, iGetHeight);
            if (this.m_SystemFont != null) {
                TheGame.m_CurrentGraphics.setFont(this.m_SystemFont);
                TheGame.m_CurrentGraphics.setClip(this.this$0.system_xClip, this.this$0.system_yClip, this.this$0.system_nClipWidth, this.this$0.system_nClipHeight);
                if (this.m_bShadow) {
                    TheGame.m_CurrentGraphics.setColor(this.m_shadowColor);
                    Graphics graphics = TheGame.m_CurrentGraphics;
                    Graphics graphics2 = TheGame.m_CurrentGraphics;
                    TheGame.m_CurrentGraphics.drawSubstring(str, i, i2, i3 + 1, i4 + 1, 20);
                }
                TheGame.m_CurrentGraphics.setColor(this.m_red, this.m_green, this.m_blue);
                Graphics graphics3 = TheGame.m_CurrentGraphics;
                Graphics graphics4 = TheGame.m_CurrentGraphics;
                Graphics graphics5 = TheGame.m_CurrentGraphics;
                graphics3.drawSubstring(str, i, i2, i3, i4, 20);
            }
        }

        void DrawSubstringCustom(int i, int i2, String str, int i3, int i4, int i5, int i6) {
            short s = (short) ((this.this$0.asset_DataArray[i + 0] & (-65536)) >> 16);
            short s2 = (short) ((this.this$0.asset_DataArray[i + 0] & 65535) >> 0);
            boolean z = ((short) ((this.this$0.asset_DataArray[i + 1] & (-65536)) >> 16)) != 0;
            short s3 = (short) ((this.this$0.asset_DataArray[i2 + 1] & 65535) >> 0);
            short s4 = (short) ((this.this$0.asset_DataArray[s3 + 0] & (-65536)) >> 16);
            int i7 = ((short) ((this.this$0.asset_DataArray[s3 + 0] & 65535) >> 0)) - ((short) ((this.this$0.asset_DataArray[s3 + 3] & (-65536)) >> 16));
            short s5 = (short) ((this.this$0.asset_DataArray[((short) ((this.this$0.asset_DataArray[s3 + 2] & (-65536)) >> 16)) + 0] & (-65536)) >> 16);
            int i8 = i3 + i4;
            int i9 = i5;
            while (i3 < i8) {
                char cCharAt = str.charAt(i3);
                if (z) {
                    cCharAt = Character.toUpperCase(cCharAt);
                }
                if (cCharAt >= 0 && cCharAt <= 127) {
                    this.this$0.asset_DrawClipped(s5, (i9 - ((cCharAt & 15) * s)) + s4, (i6 - ((cCharAt >> 4) * s2)) + i7, i9, i6, s, s2, false);
                }
                i3++;
                i9 += s;
            }
        }

        void DrawSubstringWrapped(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            int i8;
            int iGetHeight;
            int i9;
            int i10 = i + i2;
            if ((i6 & 12) != 0) {
                int iGetSubstringWrappedHeight = GetSubstringWrappedHeight(str, i, i2, i3, i7);
                if ((i6 & 4) != 0) {
                    i5 -= iGetSubstringWrappedHeight >> 1;
                } else if ((i6 & 8) != 0) {
                    i5 -= iGetSubstringWrappedHeight;
                }
                i8 = (i6 & 3) | 0;
                iGetHeight = i5;
            } else {
                i8 = i6;
                iGetHeight = i5;
            }
            while (true) {
                if (i < i10 && str.charAt(i) == ' ') {
                    i++;
                } else {
                    if (i >= i10) {
                        return;
                    }
                    int iSystem_FindFirst = this.this$0.system_FindFirst(str, i, i10, ' ');
                    while (iSystem_FindFirst < i10 - 1) {
                        int iSystem_FindFirst2 = this.this$0.system_FindFirst(str, iSystem_FindFirst + 1, i10, ' ');
                        if (GetSubstringWidth(str, i, iSystem_FindFirst2 - i) > i3) {
                            break;
                        } else {
                            iSystem_FindFirst = iSystem_FindFirst2;
                        }
                    }
                    while (true) {
                        i9 = iSystem_FindFirst;
                        if (GetSubstringWidth(str, i, i9 - i) <= i3) {
                            break;
                        }
                        iSystem_FindFirst = i9 - 1;
                        TheGame.Assert(iSystem_FindFirst > i, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\cfont_share.hpp", 312);
                    }
                    int i11 = i9;
                    while (i11 >= i && str.charAt(i11 - 1) == ' ') {
                        i11--;
                    }
                    if (i >= i11) {
                        return;
                    }
                    DrawSubstring(str, i, i11 - i, i4, iGetHeight, i8);
                    iGetHeight += GetHeight() + i7;
                    i = i9;
                }
            }
        }

        void Free() {
            this.m_SystemFont = null;
        }

        int GetHeight() {
            if (this.m_SystemFont != null) {
                return this.m_SystemFont.getHeight();
            }
            return -1;
        }

        int GetSubstringWidth(String str, int i, int i2) {
            if (this.m_SystemFont != null) {
                return this.m_SystemFont.substringWidth(str, i, i2);
            }
            return -1;
        }

        int GetSubstringWrappedHeight(String str, int i, int i2, int i3, int i4) {
            int iGetSubstringWidth;
            int i5 = i + i2;
            this.m_nMaxWidth = 0;
            int iGetHeight = 0;
            while (true) {
                if (i < i5 && str.charAt(i) == ' ') {
                    i++;
                } else {
                    if (i >= i5) {
                        return iGetHeight;
                    }
                    int iSystem_FindFirst = this.this$0.system_FindFirst(str, i, i5, ' ');
                    while (iSystem_FindFirst < i5 - 1) {
                        int iSystem_FindFirst2 = this.this$0.system_FindFirst(str, iSystem_FindFirst + 1, i5, ' ');
                        if (GetSubstringWidth(str, i, iSystem_FindFirst2 - i) > i3) {
                            break;
                        }
                        iSystem_FindFirst = iSystem_FindFirst2;
                    }
                    while (true) {
                        iGetSubstringWidth = GetSubstringWidth(str, i, iSystem_FindFirst - i);
                        if (iGetSubstringWidth <= i3) {
                            break;
                        }
                        iSystem_FindFirst--;
                        TheGame.Assert(iSystem_FindFirst > i, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\cfont_share.hpp", 243);
                    }
                    if (this.m_nMaxWidth < iGetSubstringWidth) {
                        this.m_nMaxWidth = iGetSubstringWidth;
                    }
                    iGetHeight = GetHeight() + i4 + iGetHeight;
                    i = iSystem_FindFirst;
                }
            }
        }

        void ResetShadow() {
            this.m_bShadow = false;
        }

        void SetColor(int i) {
            this.m_red = (i >> 16) & 255;
            this.m_green = (i >> 8) & 255;
            this.m_blue = i & 255;
        }

        void SetColor(int i, int i2, int i3) {
            this.m_red = i;
            this.m_green = i2;
            this.m_blue = i3;
        }

        void SetShadow(int i) {
            this.m_bShadow = true;
            this.m_shadowColor = i;
        }

        void SetSystem(Font font) {
            this.m_SystemFont = font;
        }
    }

    public class CGroundCollision {
        CTriangle[] TriangleArray;
        CVertex[] VertexArray;
        int m_nAttributeMask;
        int nScaleShift;
        int nTriangles;
        int nVertices;
        private final TheGame this$0;
        int xOffset;
        int yOffset;
        int zOffset;

        public class CTriangle {
            short nAttribute;
            private final CGroundCollision this$1;
            short[] nVertices = new short[3];
            short[] nAdjacentTriangles = new short[3];

            public CTriangle(CGroundCollision cGroundCollision) {
                this.this$1 = cGroundCollision;
            }
        }

        public class CVertex {
            private final CGroundCollision this$1;

            /* JADX INFO: renamed from: x */
            short f3x;

            /* JADX INFO: renamed from: y */
            short f4y;

            /* JADX INFO: renamed from: z */
            short f5z;

            public CVertex(CGroundCollision cGroundCollision) {
                this.this$1 = cGroundCollision;
            }
        }

        public CGroundCollision(TheGame theGame) {
            this.this$0 = theGame;
        }

        private int ConvertCollisionToWorldX(int i) {
            return (this.nScaleShift >= 0 ? i << this.nScaleShift : i >> (-this.nScaleShift)) + this.xOffset;
        }

        private int ConvertCollisionToWorldY(int i) {
            return (this.nScaleShift >= 0 ? i << this.nScaleShift : i >> (-this.nScaleShift)) + this.yOffset;
        }

        private int ConvertCollisionToWorldZ(int i) {
            return (this.nScaleShift >= 0 ? i << this.nScaleShift : i >> (-this.nScaleShift)) + this.zOffset;
        }

        private int ConvertWorldToCollisionX(int i) {
            int i2 = i - this.xOffset;
            return this.nScaleShift >= 0 ? i2 >> this.nScaleShift : i2 << (-this.nScaleShift);
        }

        private int ConvertWorldToCollisionY(int i) {
            int i2 = i - this.yOffset;
            return this.nScaleShift >= 0 ? i2 >> this.nScaleShift : i2 << (-this.nScaleShift);
        }

        private int ConvertWorldToCollisionZ(int i) {
            int i2 = i - this.zOffset;
            return this.nScaleShift >= 0 ? i2 >> this.nScaleShift : i2 << (-this.nScaleShift);
        }

        private int FindHeight(int i, int i2, int i3) {
            CTriangle cTriangle = this.TriangleArray[i];
            CVertex cVertex = this.VertexArray[cTriangle.nVertices[0] & Short.MAX_VALUE];
            CVertex cVertex2 = this.VertexArray[cTriangle.nVertices[1] & Short.MAX_VALUE];
            CVertex cVertex3 = this.VertexArray[cTriangle.nVertices[2] & Short.MAX_VALUE];
            long j = i2 - (cVertex.f3x << 8);
            long j2 = i3 - (cVertex.f4y << 8);
            long j3 = ((long) (cVertex3.f3x - cVertex2.f3x)) << 8;
            long j4 = ((long) (cVertex3.f4y - cVertex2.f4y)) << 8;
            long j5 = ((long) (cVertex2.f3x - cVertex.f3x)) << 8;
            long j6 = ((long) (cVertex2.f4y - cVertex.f4y)) << 8;
            long j7 = (j3 * j6) - (j4 * j5);
            int i4 = cVertex.f5z << 8;
            if (j7 == 0) {
                return i4;
            }
            return i4 + ((int) ((((((long) (cVertex2.f5z - cVertex.f5z)) << 8) * ((j2 * j3) - (j * j4))) + ((((long) (cVertex3.f5z - cVertex2.f5z)) << 8) * ((j6 * j) - (j5 * j2)))) / j7));
        }

        private void FindTriangle(int i, int i2, CCollisionResult cCollisionResult) {
            int i3;
            CVertex cVertex;
            CVertex cVertex2;
            boolean z;
            cCollisionResult.nTriangleID = (short) -1;
            for (int i4 = 0; i4 < this.nTriangles; i4++) {
                CTriangle cTriangle = this.TriangleArray[i4];
                int i5 = 0;
                while (true) {
                    i3 = i5;
                    if (i3 >= 3) {
                        break;
                    }
                    int i6 = i3 < 2 ? i3 + 1 : 0;
                    if (cTriangle.nVertices[i3] < 0) {
                        cVertex = this.VertexArray[cTriangle.nVertices[i6] & Short.MAX_VALUE];
                        cVertex2 = this.VertexArray[cTriangle.nVertices[i3] & Short.MAX_VALUE];
                        z = true;
                    } else {
                        cVertex = this.VertexArray[cTriangle.nVertices[i3] & Short.MAX_VALUE];
                        cVertex2 = this.VertexArray[cTriangle.nVertices[i6] & Short.MAX_VALUE];
                        z = false;
                    }
                    long j = ((((long) (cVertex.f3x - cVertex2.f3x)) << 8) * (((long) i2) - (((long) cVertex.f4y) << 8))) + ((((long) i) - (((long) cVertex.f3x) << 8)) * (((long) (cVertex2.f4y - cVertex.f4y)) << 8));
                    if (!z) {
                        if (j > 0) {
                            break;
                        } else {
                            i5 = i3 + 1;
                        }
                    } else if (j <= 0) {
                        break;
                    } else {
                        i5 = i3 + 1;
                    }
                }
                if (i3 == 3) {
                    cCollisionResult.nTriangleID = (short) i4;
                    cCollisionResult.nAttribute = cTriangle.nAttribute;
                    cCollisionResult.f0x = ConvertCollisionToWorldX(i);
                    cCollisionResult.f1y = ConvertCollisionToWorldY(i2);
                    cCollisionResult.f2z = ConvertCollisionToWorldZ(FindHeight(i4, i, i2));
                    return;
                }
            }
        }

        private void GetTriangle(int i, CCollisionResult cCollisionResult) {
            CTriangle cTriangle = this.TriangleArray[i];
            CVertex cVertex = this.VertexArray[cTriangle.nVertices[0] & Short.MAX_VALUE];
            cCollisionResult.nTriangleID = (short) i;
            cCollisionResult.nAttribute = cTriangle.nAttribute;
            cCollisionResult.f0x = ConvertCollisionToWorldX(cVertex.f3x << 8);
            cCollisionResult.f1y = ConvertCollisionToWorldY(cVertex.f4y << 8);
            cCollisionResult.f2z = ConvertCollisionToWorldZ(cVertex.f5z << 8);
        }

        void Free() {
            if (this.VertexArray != null) {
                for (int i = 0; i < this.nVertices; i++) {
                    this.VertexArray[i] = null;
                }
            }
            this.VertexArray = null;
            this.nVertices = 0;
            if (this.TriangleArray != null) {
                for (int i2 = 0; i2 < this.nTriangles; i2++) {
                    this.TriangleArray[i2] = null;
                }
            }
            this.TriangleArray = null;
            this.nTriangles = 0;
        }

        void Load(short[] sArr) {
            this.m_nAttributeMask = -1;
            this.xOffset = sArr[0] << 16;
            this.xOffset |= sArr[1] & 65535;
            this.yOffset = sArr[2] << 16;
            this.yOffset = (sArr[3] & 65535) | this.yOffset;
            this.zOffset = sArr[4] << 16;
            this.zOffset = (sArr[5] & 65535) | this.zOffset;
            this.nScaleShift = sArr[6] - 8;
            if (this.nScaleShift >= 0) {
                this.xOffset >>= this.nScaleShift;
                this.xOffset <<= this.nScaleShift;
                this.yOffset >>= this.nScaleShift;
                this.yOffset <<= this.nScaleShift;
                this.zOffset >>= this.nScaleShift;
                this.zOffset <<= this.nScaleShift;
            }
            int i = 8;
            this.nVertices = sArr[7];
            this.VertexArray = new CVertex[this.nVertices];
            for (int i2 = 0; i2 < this.nVertices; i2++) {
                this.VertexArray[i2] = new CVertex(this);
                int i3 = i + 1;
                this.VertexArray[i2].f3x = sArr[i];
                int i4 = i3 + 1;
                this.VertexArray[i2].f4y = sArr[i3];
                i = i4 + 1;
                this.VertexArray[i2].f5z = sArr[i4];
            }
            this.nTriangles = sArr[i];
            this.TriangleArray = new CTriangle[this.nTriangles];
            int i5 = i + 1;
            for (int i6 = 0; i6 < this.nTriangles; i6++) {
                this.TriangleArray[i6] = new CTriangle(this);
                int i7 = i5 + 1;
                this.TriangleArray[i6].nAttribute = sArr[i5];
                int i8 = i7 + 1;
                this.TriangleArray[i6].nVertices[0] = sArr[i7];
                int i9 = i8 + 1;
                this.TriangleArray[i6].nVertices[1] = sArr[i8];
                int i10 = i9 + 1;
                this.TriangleArray[i6].nVertices[2] = sArr[i9];
                int i11 = i10 + 1;
                this.TriangleArray[i6].nAdjacentTriangles[0] = sArr[i10];
                int i12 = i11 + 1;
                this.TriangleArray[i6].nAdjacentTriangles[1] = sArr[i11];
                i5 = i12 + 1;
                this.TriangleArray[i6].nAdjacentTriangles[2] = sArr[i12];
            }
        }

        /* JADX WARN: Code duplicated, block: B:68:0x0297  */
        void TestPointForCollision(int i, int i2, CCollisionResult cCollisionResult) {
            int i3;
            short s;
            int i4;
            CVertex cVertex;
            CVertex cVertex2;
            boolean z;
            int i5;
            boolean z2;
            cCollisionResult.f0x = ConvertWorldToCollisionX(cCollisionResult.f0x);
            cCollisionResult.f1y = ConvertWorldToCollisionY(cCollisionResult.f1y);
            int iConvertWorldToCollisionX = ConvertWorldToCollisionX(i);
            int iConvertWorldToCollisionY = ConvertWorldToCollisionY(i2);
            short s2 = cCollisionResult.nTriangleID;
            int i6 = -1;
            int i7 = 0;
            while (i7 <= 6 && cCollisionResult.nTriangleID != -1) {
                CTriangle cTriangle = this.TriangleArray[cCollisionResult.nTriangleID];
                int i8 = 0;
                while (true) {
                    if (i8 >= 3) {
                        i3 = i8;
                        s = s2;
                        i4 = iConvertWorldToCollisionY;
                        break;
                    }
                    int i9 = i8 < 2 ? i8 + 1 : 0;
                    if (cTriangle.nVertices[i8] < 0) {
                        cVertex = this.VertexArray[cTriangle.nVertices[i9] & Short.MAX_VALUE];
                        cVertex2 = this.VertexArray[cTriangle.nVertices[i8] & Short.MAX_VALUE];
                        z = true;
                    } else {
                        cVertex = this.VertexArray[cTriangle.nVertices[i8] & Short.MAX_VALUE];
                        cVertex2 = this.VertexArray[cTriangle.nVertices[i9] & Short.MAX_VALUE];
                        z = false;
                    }
                    long j = ((((long) iConvertWorldToCollisionX) - (((long) cVertex.f3x) << 8)) * (((long) (cVertex2.f4y - cVertex.f4y)) << 8)) + ((((long) iConvertWorldToCollisionY) - (((long) cVertex.f4y) << 8)) * (((long) (cVertex.f3x - cVertex2.f3x)) << 8));
                    if ((!z || j > 0) && (z || j <= 0)) {
                        i5 = i6;
                    } else {
                        int i10 = iConvertWorldToCollisionY - cCollisionResult.f1y;
                        int i11 = cCollisionResult.f0x - iConvertWorldToCollisionX;
                        long j2 = (((long) ((cVertex.f3x << 8) - cCollisionResult.f0x)) * ((long) i10)) + (((long) ((cVertex.f4y << 8) - cCollisionResult.f1y)) * ((long) i11));
                        long j3 = (((long) i11) * ((long) ((cVertex2.f4y << 8) - cCollisionResult.f1y))) + (((long) ((cVertex2.f3x << 8) - cCollisionResult.f0x)) * ((long) i10));
                        long j4 = ((((long) cCollisionResult.f0x) - (((long) cVertex.f3x) << 8)) * (((long) (cVertex2.f4y - cVertex.f4y)) << 8)) + ((((long) cCollisionResult.f1y) - (((long) cVertex.f4y) << 8)) * (((long) (cVertex.f3x - cVertex2.f3x)) << 8));
                        if (z) {
                            z2 = (j2 <= 0 && j3 > 0) || j4 <= 0;
                        } else {
                            z2 = (j2 > 0 && j3 <= 0) || j4 > 0;
                        }
                        if (z2) {
                            short s3 = cTriangle.nAdjacentTriangles[i8];
                            if (s3 >= 0 && (this.TriangleArray[s3].nAttribute & this.m_nAttributeMask) != 0) {
                                s = cCollisionResult.nTriangleID;
                                cCollisionResult.nTriangleID = s3;
                                i6 = -1;
                                i3 = i8;
                                i4 = iConvertWorldToCollisionY;
                                break;
                            }
                            if (i6 != i8 || s2 != cCollisionResult.nTriangleID) {
                                if (i6 != -1 && s2 == cCollisionResult.nTriangleID) {
                                    int i12 = cCollisionResult.f0x;
                                    i4 = cCollisionResult.f1y;
                                    i3 = 3;
                                    s = s2;
                                    iConvertWorldToCollisionX = i12;
                                    break;
                                }
                                long j5 = ((long) (cVertex2.f3x - cVertex.f3x)) << 8;
                                long j6 = ((long) (cVertex2.f4y - cVertex.f4y)) << 8;
                                long j7 = ((((long) (iConvertWorldToCollisionX - (cVertex.f3x << 8))) * j6) - (((long) (iConvertWorldToCollisionY - (cVertex.f4y << 8))) * j5)) * 5;
                                long j8 = ((j6 * j6) + (j5 * j5)) * 4;
                                iConvertWorldToCollisionX -= (int) ((j6 * j7) / j8);
                                i4 = iConvertWorldToCollisionY + ((int) ((j5 * j7) / j8));
                                i3 = i8;
                                i6 = i8;
                                s = s2;
                                break;
                            }
                            i5 = i8;
                        } else {
                            i5 = i6;
                        }
                    }
                    i8++;
                    i6 = i5;
                }
                if (i3 == 3) {
                    if (cCollisionResult.nTriangleID >= 0) {
                        cCollisionResult.nAttribute = cTriangle.nAttribute;
                        cCollisionResult.f0x = ConvertCollisionToWorldX(iConvertWorldToCollisionX);
                        cCollisionResult.f1y = ConvertCollisionToWorldY(i4);
                        cCollisionResult.f2z = ConvertCollisionToWorldZ(FindHeight(cCollisionResult.nTriangleID, iConvertWorldToCollisionX, i4));
                        return;
                    }
                    return;
                }
                i7++;
                s2 = s;
                iConvertWorldToCollisionY = i4;
            }
            FindTriangle(iConvertWorldToCollisionX, iConvertWorldToCollisionY, cCollisionResult);
        }

        public void UpdateHeight(CCollisionResult cCollisionResult) {
            if (cCollisionResult.nTriangleID != -1) {
                cCollisionResult.f2z = ConvertCollisionToWorldZ(FindHeight(cCollisionResult.nTriangleID, ConvertWorldToCollisionX(cCollisionResult.f0x), ConvertWorldToCollisionY(cCollisionResult.f1y)));
            }
        }
    }

    class CSoundObject {
        static final int NUM_SOUND_TYPES = 6;
        static final int SOUND_TYPE_AMR = 5;
        static final int SOUND_TYPE_MIDI = 3;
        static final int SOUND_TYPE_QCP = 4;
        static final int SOUND_TYPE_TONE = 1;
        static final int SOUND_TYPE_UNK = 0;
        static final int SOUND_TYPE_WAV = 2;
        boolean isPlaying;
        int soundType;
        String soundUrl;
        private final TheGame this$0;
        NDInputStream memstream = null;
        int soundID = -1;
        int refCount = -1;

        CSoundObject(TheGame theGame) {
            this.this$0 = theGame;
        }

        void Dispose() {
            this.memstream = null;
        }

        boolean LoadSound(byte[] bArr, int i) {
            int length = bArr.length;
            this.memstream = null;
            this.memstream = new NDInputStream(this.this$0, bArr);
            this.soundType = i;
            return true;
        }

        boolean LoadSound(byte[] bArr, int i, int i2, int i3) {
            this.memstream = null;
            this.memstream = new NDInputStream(this.this$0, bArr, i, i2);
            this.soundType = i3;
            return true;
        }

        void SetUrl(String str) {
            this.soundUrl = str;
        }
    }

    class CSoundPlayer {
        static final int MAX_SOUNDS = 8;
        CSoundObject CurrentSound;
        int CurrentSoundsPlaying;
        int GlobalVolume;
        CSoundObject NextSound;
        String callbackString;
        String exceptionString;
        int maxSounds;
        private final TheGame this$0;

        CSoundPlayer(TheGame theGame) {
            this.this$0 = theGame;
        }

        boolean Construct() {
            this.CurrentSound = null;
            this.NextSound = null;
            this.callbackString = null;
            this.exceptionString = null;
            this.CurrentSoundsPlaying = 0;
            this.maxSounds = 0;
            return false;
        }

        void Destroy() {
            this.callbackString = null;
            this.exceptionString = null;
        }

        void DisposeSound(CSoundObject cSoundObject) {
        }

        String GetCallbackString() {
            return this.callbackString;
        }

        String GetErrorString() {
            return this.exceptionString;
        }

        boolean IsAnySoundPlaying() {
            return false;
        }

        boolean IsSoundPlaying(CSoundObject cSoundObject) {
            return false;
        }

        void PlayBackgroundMusic(CSoundObject cSoundObject) {
        }

        void PlaySoundImmediate(CSoundObject cSoundObject) {
        }

        void PlaySoundNext(CSoundObject cSoundObject) {
        }

        void PlaySoundNowIfPossible(CSoundObject cSoundObject) {
        }

        void SetVolume(int i) {
            this.GlobalVolume = i;
        }

        void SetVolume(CSoundObject cSoundObject, int i) {
        }

        void StopAllSounds() {
        }

        void StopBackgroundMusic(CSoundObject cSoundObject) {
        }

        void StopCurrentSound() {
        }

        void StopSound(CSoundObject cSoundObject) {
        }
    }

    class CSoundPlayerMIDP2 extends CSoundPlayer implements PlayerListener {
        String[] mimeType;
        SoundCache[] sCache;
        private final TheGame this$0;

        private class SoundCache {
            Player m_theSound;
            CSoundObject object;
            private final CSoundPlayerMIDP2 this$1;

            private SoundCache(CSoundPlayerMIDP2 cSoundPlayerMIDP2) {
                this.this$1 = cSoundPlayerMIDP2;
                this.m_theSound = null;
                this.object = null;
            }

            SoundCache(CSoundPlayerMIDP2 cSoundPlayerMIDP2, C00001 c00001) {
                this(cSoundPlayerMIDP2);
            }
        }

        CSoundPlayerMIDP2(TheGame theGame) {
            super(theGame);
            this.this$0 = theGame;
            this.sCache = new SoundCache[8];
            this.mimeType = new String[6];
        }

        @Override // TheGame.CSoundPlayer
        boolean Construct() {
            super.Construct();
            System.out.println("MIDP2:Construct");
            System.out.flush();
            System.out.println("c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp compiled for ???");
            System.out.flush();
            this.mimeType[1] = null;
            this.mimeType[2] = "audio/x-wav";
            this.mimeType[3] = "audio/midi";
            this.mimeType[4] = null;
            this.mimeType[5] = "audio/amr";
            return false;
        }

        @Override // TheGame.CSoundPlayer
        void Destroy() {
        }

        @Override // TheGame.CSoundPlayer
        void DisposeSound(CSoundObject cSoundObject) {
            for (int i = 0; i < 8; i++) {
                if (this.sCache[i] != null && this.sCache[i].object == cSoundObject && this.sCache[i].m_theSound != null) {
                    try {
                        this.sCache[i].m_theSound.stop();
                    } catch (Exception e) {
                    }
                    this.sCache[i].m_theSound.removePlayerListener(this);
                    this.sCache[i].m_theSound.deallocate();
                    this.sCache[i].m_theSound.close();
                    this.sCache[i] = null;
                    return;
                }
            }
        }

        @Override // TheGame.CSoundPlayer
        boolean IsAnySoundPlaying() {
            for (int i = 0; i < 8; i++) {
                if (this.sCache[i] != null && this.sCache[i].object.isPlaying) {
                    return true;
                }
            }
            return false;
        }

        @Override // TheGame.CSoundPlayer
        boolean IsSoundPlaying(CSoundObject cSoundObject) {
            return cSoundObject.isPlaying;
        }

        @Override // TheGame.CSoundPlayer
        void PlayBackgroundMusic(CSoundObject cSoundObject) {
            PlaySoundNext(cSoundObject, -1, false);
        }

        @Override // TheGame.CSoundPlayer
        void PlaySoundImmediate(CSoundObject cSoundObject) {
            StopAllSounds();
            PlaySoundNext(cSoundObject);
        }

        @Override // TheGame.CSoundPlayer
        void PlaySoundNext(CSoundObject cSoundObject) {
            PlaySoundNext(cSoundObject, 1, false);
        }

        void PlaySoundNext(CSoundObject cSoundObject, int i, boolean z) {
            this.exceptionString = null;
            this.callbackString = null;
            System.out.println(new StringBuffer().append("PSN: want to play sound ").append(cSoundObject).toString());
            System.out.flush();
            for (int i2 = 0; i2 < 8; i2++) {
                try {
                    if (this.sCache[i2] != null && this.sCache[i2].m_theSound != null) {
                        int state = this.sCache[i2].m_theSound.getState();
                        Player player = this.sCache[i2].m_theSound;
                        if (state == 400 && this.sCache[i2].m_theSound.getMediaTime() < this.sCache[i2].m_theSound.getDuration()) {
                            System.out.println("PSN: there is already a sound playing, ignoring this request...");
                            System.out.flush();
                            return;
                        }
                    }
                } catch (IOException e) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 408, e.toString());
                    System.out.println(new StringBuffer().append("IOExc:").append(e.getMessage()).toString());
                    System.out.flush();
                    this.exceptionString = new StringBuffer().append("IOE:").append(e.getMessage()).toString();
                    return;
                } catch (IllegalStateException e2) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 414, e2.toString());
                    System.out.println(new StringBuffer().append("IllStateExc:").append(e2.getMessage()).toString());
                    System.out.flush();
                    this.exceptionString = new StringBuffer().append("ISE:").append(e2.getMessage()).toString();
                    return;
                } catch (Exception e3) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 420, e3.toString());
                    System.out.println(new StringBuffer().append("Exc:").append(e3.getMessage()).toString());
                    System.out.flush();
                    this.exceptionString = new StringBuffer().append("GE:").append(e3.getMessage()).toString();
                    return;
                } catch (MediaException e4) {
                    System.out.println(new StringBuffer().append("MediaExc:").append(e4.getMessage()).toString());
                    System.out.flush();
                    this.exceptionString = new StringBuffer().append("ME:").append(e4.getMessage()).toString();
                    DisposeSound(cSoundObject);
                    return;
                }
            }
            for (int i3 = 0; i3 < 8; i3++) {
                if (this.sCache[i3] != null && this.sCache[i3].object == cSoundObject && this.sCache[i3].m_theSound != null) {
                    int state2 = this.sCache[i3].m_theSound.getState();
                    Player player2 = this.sCache[i3].m_theSound;
                    if (state2 == 400) {
                        System.out.println("PSN: WARNING - SHOULD NOT GET HERE!");
                        System.out.flush();
                        TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 351, "Sound is not started!");
                        return;
                    }
                    System.out.println(new StringBuffer().append("PSN: SETTING LOOP COUNT TO: ").append(i).append(" FOR CACHED SOUND").toString());
                    System.out.flush();
                    this.sCache[i3].m_theSound.setLoopCount(i);
                    if (!z) {
                        this.sCache[i3].m_theSound.setMediaTime(0L);
                        this.sCache[i3].m_theSound.start();
                    }
                    System.out.println(new StringBuffer().append("PSN: Setting cached sound volume:").append(this.GlobalVolume).toString());
                    System.out.flush();
                    this.sCache[i3].m_theSound.getControl("VolumeControl").setLevel(this.GlobalVolume);
                    System.out.println(new StringBuffer().append("PSN: started cached sound ").append(i3).append(" ").append(this.sCache[i3].object).toString());
                    System.out.flush();
                    return;
                }
            }
            System.out.println("PSN: sound is not cached");
            System.out.flush();
            for (int i4 = 0; i4 < 8; i4++) {
                if (this.sCache[i4] == null) {
                    cSoundObject.memstream.reset();
                    this.sCache[i4] = new SoundCache(this, null);
                    this.sCache[i4].object = cSoundObject;
                    this.sCache[i4].m_theSound = Manager.createPlayer(cSoundObject.memstream, this.mimeType[cSoundObject.soundType]);
                    this.sCache[i4].m_theSound.realize();
                    this.sCache[i4].m_theSound.prefetch();
                    this.sCache[i4].m_theSound.addPlayerListener(this);
                    this.sCache[i4].m_theSound.setLoopCount(i);
                    System.out.println(new StringBuffer().append("PSN: SETTING LOOP COUNT TO: ").append(i).append(" FOR NON-CACHED SOUND").toString());
                    System.out.flush();
                    if (!z) {
                        this.sCache[i4].m_theSound.setMediaTime(0L);
                        this.sCache[i4].m_theSound.start();
                    }
                    System.out.println(new StringBuffer().append("PSN: Setting Volume:").append(this.GlobalVolume).toString());
                    System.out.flush();
                    this.sCache[i4].m_theSound.getControl("VolumeControl").setLevel(this.GlobalVolume);
                    System.out.println(new StringBuffer().append("PSN: loaded sound to slot ").append(i4).append(" ").append(this.sCache[i4].object).toString());
                    System.out.flush();
                    return;
                }
            }
            System.out.println("PSN: failed to find an unused cache slot (too many sounds)");
            System.out.flush();
            TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 396, "failed to find an unused cache slot (too many sounds)");
        }

        @Override // TheGame.CSoundPlayer
        void PlaySoundNowIfPossible(CSoundObject cSoundObject) {
            PlaySoundNext(cSoundObject);
        }

        void PrepareSound(CSoundObject cSoundObject, int i) {
            PlaySoundNext(cSoundObject, i, true);
        }

        @Override // TheGame.CSoundPlayer
        void SetVolume(int i) {
            System.out.println(new StringBuffer().append("PSN: Setting Volume to:").append(i).toString());
            System.out.flush();
            this.GlobalVolume = i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 8) {
                    System.out.println(new StringBuffer().append("PSN: Global Volume:").append(this.GlobalVolume).toString());
                    System.out.flush();
                    return;
                }
                if (this.sCache[i3] != null && this.sCache[i3].m_theSound != null) {
                    int state = this.sCache[i3].m_theSound.getState();
                    Player player = this.sCache[i3].m_theSound;
                    if (state == 400) {
                        this.sCache[i3].m_theSound.getControl("VolumeControl").setLevel(this.GlobalVolume);
                    }
                }
                i2 = i3 + 1;
            }
        }

        @Override // TheGame.CSoundPlayer
        void StopAllSounds() {
            for (int i = 0; i < 8; i++) {
                try {
                    if (this.sCache[i] != null && this.sCache[i].m_theSound != null) {
                        int state = this.sCache[i].m_theSound.getState();
                        Player player = this.sCache[i].m_theSound;
                        if (state == 400) {
                            System.out.println(new StringBuffer().append("SAS: stopping sound in slot ").append(i).append("...").toString());
                            System.out.flush();
                            this.sCache[i].m_theSound.stop();
                        } else {
                            continue;
                        }
                    }
                } catch (MediaException e) {
                    this.exceptionString = new StringBuffer().append("ME:").append(e.getMessage()).toString();
                    return;
                }
            }
        }

        @Override // TheGame.CSoundPlayer
        void StopCurrentSound() {
        }

        @Override // TheGame.CSoundPlayer
        void StopSound(CSoundObject cSoundObject) {
            for (int i = 0; i < 8; i++) {
                try {
                    if (this.sCache[i] != null && this.sCache[i].object == cSoundObject && this.sCache[i].m_theSound != null) {
                        this.sCache[i].m_theSound.stop();
                        System.out.println(new StringBuffer().append("  SS: stopped sound in slot ").append(i).toString());
                        System.out.flush();
                        return;
                    }
                } catch (MediaException e) {
                    this.exceptionString = new StringBuffer().append("ME:").append(e.getMessage()).toString();
                    return;
                }
            }
        }

        public void playerUpdate(Player player, String str, Object obj) {
            this.callbackString = str;
            if (str == "started") {
                System.out.println("callback: STARTED");
                System.out.flush();
                for (int i = 0; i < 8; i++) {
                    if (this.sCache[i] != null && this.sCache[i].m_theSound == player) {
                        this.sCache[i].object.isPlaying = true;
                        break;
                    }
                }
            }
            if (str == "stopped") {
                System.out.println("callback: STOPPED");
                System.out.flush();
                for (int i2 = 0; i2 < 8; i2++) {
                    if (this.sCache[i2] != null && this.sCache[i2].m_theSound == player) {
                        this.sCache[i2].object.isPlaying = false;
                        break;
                    }
                }
            }
            if (str == "stoppedAtTime") {
                System.out.println("callback: STOPPED_AT_TIME");
                System.out.flush();
            }
            if (str == "endOfMedia") {
                try {
                    System.out.println("callback: END_OF_MEDIA");
                    System.out.flush();
                } catch (Exception e) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\javasoundmidp2.hpp", 89, e.toString());
                }
            }
            if (str == "durationUpdated") {
            }
            if (str == "deviceUnavailable") {
                System.out.println("callback: DEVICE_UNAVAILABLE");
                System.out.flush();
                try {
                    Thread.sleep(1000L);
                    player.start();
                } catch (Exception e2) {
                }
            }
            if (str == "deviceAvailable") {
                System.out.println("callback: DEVICE_AVAILABLE");
                System.out.flush();
            }
            if (str == "volumeChanged") {
                System.out.println("callback: VOLUME_CHANGED");
                System.out.flush();
            }
            if (str == "sizeChanged") {
            }
            if (str == "error") {
                System.out.println("callback: ERROR");
                System.out.flush();
            }
            if (str == "closed") {
            }
            if (str == "recordStarted") {
            }
            if (str == "recordStopped") {
            }
            if (str == "recordError") {
            }
            if (str == "bufferingStarted") {
            }
            if (str == "bufferingStopped") {
            }
        }
    }

    class Car {
        short[][] aiSpline2;
        boolean bBackOffFromOverTacking;
        public short[][] m_aiSpline;
        public boolean m_bDisabled;
        public boolean m_bGoingBackward;
        public boolean m_bNearCulled;
        public boolean m_bPlayer;
        public boolean m_bReverseTrack;
        public boolean m_bTraffic;
        public int m_camDist;
        public float m_distanceMovedLastFrame;
        public int m_nAccelerateTimer;
        public int m_nAiNode;
        public int m_nAssaultTimer;
        public int m_nAverageSplineMovementSpeed;
        public int m_nBustedness;
        public int m_nCA;
        public int m_nCheckpointTime;
        public int m_nCoolTimer;
        public byte m_nCopNum;
        int m_nCrossAI;
        public int m_nCurCheckpoint;
        public int m_nCurrentHeatRating;
        int m_nCurrentSplineDistance;
        public int m_nDamagedLevel;
        public int m_nHighestRaceSpeed;
        public int m_nID;
        public int m_nLap;
        int m_nLastAverageCount;
        int m_nLastWheelCount;
        public int m_nNitroTimer;
        int m_nOverTackingAngleOffset;
        public int m_nPlayerDist;
        public int m_nPursuitTimer;
        public int m_nRecklessTimer;
        public int m_nSlideOutDisableForCollision;
        public int m_nSortDistance;
        public int m_nSortedPos;
        public int m_nSpeedingScore;
        public int m_nSpeedingTimer;
        public int m_nState;
        public int m_nStateTime;
        public int m_nTimeNotVisable;
        public int m_nTimeSinceSpawn;
        public CCollisionResult m_tempColResult;
        public int m_velocityLastFrame;
        public int m_velocityMax;
        public int m_xAng;
        public int m_xAngVel;
        public int m_xPos;
        public int m_xVel;
        public int m_yAng;
        public int m_yAngVel;
        public int m_yPos;
        public int m_yVel;
        public int m_zAng;
        public int m_zAngVel;
        int m_zLastAveragePos;
        public int m_zPos;
        public int m_zSteeringAng;
        public int m_zVel;
        int nAngOffset1;
        int nAngOffset2;
        int nAngOffset3;
        int nAngleAI;
        int nAngleAIDiff;
        int nCollisionExpand;
        int nCrossAI;
        int nDotAI;
        int nForwardDot;
        int nFrontWheelAngle;
        int nIntersection;
        int nSideDot;
        int nxAI;
        int nyAI;
        private final TheGame this$0;
        int xColPos;
        int xColSizeA;
        int xColSizeB;
        int xCollisionExpandA;
        int xCollisionExpandB;
        int xDistA;
        int xDistB;
        int xForwad;
        int xNormal;
        int xOldVel;
        int xPosAInBSpace;
        int xPosBInASpace;
        int xPosTmp;
        int xRight;
        int xRight2;
        int yColPos;
        int yColSizeA;
        int yColSizeB;
        int yCollisionExpandA;
        int yCollisionExpandB;
        int yDistA;
        int yDistB;
        int yForwad;
        int yNormal;
        int yOldVel;
        int yPosAInBSpace;
        int yPosBInASpace;
        int yPosTmp;
        int yRight;
        int yRight2;
        VertexArray positions = new VertexArray(4, 3, 2);
        VertexArray texCoords = new VertexArray(4, 2, 2);
        VertexBuffer vertexBuffer = new VertexBuffer();
        int[] stripLengths = {4};
        TriangleStripArray indexBuffer = new TriangleStripArray(0, this.stripLengths);
        short[] positionsData = {-128, 128, 0, -128, -128, 0, 128, 128, 0, 128, -128, 0};
        Transform tmpTrans = new Transform();
        Transform scene_workerTrans = new Transform();
        public boolean m_bCheapUpdate = false;
        public boolean m_bUsingSecondarySpline = false;
        public boolean m_bHitPlayer = false;
        public int m_nTimeSinceLastSplineSwap = 0;
        public int m_nNitroCount = 5;
        public float[] rotationArray = new float[16];
        public Transform rotation = new Transform();
        public CCollisionResult[] m_colResult = new CCollisionResult[4];
        int[] zWheelForce = new int[4];
        public int m_nTopSpeed = 15510;
        public int m_nAcceleration = 90;
        public int m_nHandling = 64;
        public int m_nAverageSpeed = this.m_nTopSpeed;
        public int m_nReverseTimer = 0;
        CSpark[] m_carSparks = new CSpark[5];
        public NFSMW_CarAppearance m_ca = null;
        public boolean m_bBreaking = false;
        public boolean m_bReversing = false;

        public class CSpark {
            private final Car this$1;
            int timer;

            /* JADX INFO: renamed from: x */
            float f6x;

            /* JADX INFO: renamed from: y */
            float f7y;

            /* JADX INFO: renamed from: z */
            float f8z;

            public CSpark(Car car) {
                this.this$1 = car;
            }
        }

        public Car(TheGame theGame, int i) {
            this.this$0 = theGame;
            this.m_tempColResult = new CCollisionResult(this.this$0);
            this.m_nID = i;
            theGame.shadowCompmode.setBlending(68);
            theGame.shadowCompmode.setDepthTestEnable(false);
            theGame.shadowCompmode.setDepthWriteEnable(true);
            theGame.shadowAppearance.setPolygonMode(theGame.polygonMode_NoPersp);
            theGame.shadowAppearance.setCompositingMode(theGame.shadowCompmode);
            this.positions.set(0, 4, this.positionsData);
            this.vertexBuffer.setPositions(this.positions, 0.015625f, (float[]) null);
            this.vertexBuffer.setDefaultColor(-14869219);
            for (int i2 = 0; i2 < this.m_carSparks.length; i2++) {
                this.m_carSparks[i2] = new CSpark(this);
            }
        }

        void AIAcceleration(int i) {
            this.m_bBreaking = this.bBackOffFromOverTacking;
            if (this.m_nState == 2 || this.m_nState == 3) {
                if (this.m_nStateTime > 3000) {
                    this.m_nState = 0;
                }
                this.m_bBreaking = true;
            }
            if (this.m_nState == 4 || this.m_nState == 9) {
                this.m_bBreaking = true;
            }
            if (this.m_bReverseTrack) {
                this.m_nPlayerDist = (((-this.this$0.players[0].m_nAiNode) + ((this.this$0.players[0].m_nLap + 1) * this.m_aiSpline.length)) - (-this.m_nAiNode)) - ((this.m_nLap + 1) * this.m_aiSpline.length);
            } else {
                this.m_nPlayerDist = ((this.this$0.players[0].m_nAiNode + (this.this$0.players[0].m_nLap * this.m_aiSpline.length)) - this.m_nAiNode) - (this.m_nLap * this.m_aiSpline.length);
            }
            if (!this.m_bBreaking) {
                AIAcceleration_NotBraking(i);
            }
            if (this.m_bBreaking) {
                AIAcceleration_Brake(i);
            }
            int i2 = ((this.m_xVel * this.xRight) + (this.m_yVel * this.yRight)) >> 14;
            if (i2 <= 0) {
                int i3 = (this.m_nHandling * i) >> 3;
                int i4 = i3 > (-i2) ? -i2 : i3;
                this.m_xVel += (this.xRight * i4) >> 14;
                this.m_yVel = ((i4 * this.yRight) >> 14) + this.m_yVel;
                return;
            }
            int i5 = (this.m_nHandling * i) >> 3;
            if (i5 <= i2) {
                i2 = i5;
            }
            this.m_xVel -= (this.xRight * i2) >> 14;
            this.m_yVel -= (i2 * this.yRight) >> 14;
        }

        void AIAcceleration_Brake(int i) {
            int i2 = this.m_nCopNum != 0 ? 6 : 4;
            if (this.nForwardDot > 0) {
                int i3 = i2 * i;
                if (i3 > this.nForwardDot) {
                    i3 = this.nForwardDot;
                }
                this.m_xVel -= (this.xForwad * i3) >> 14;
                this.m_yVel -= (i3 * this.yForwad) >> 14;
                return;
            }
            if (this.nForwardDot < 0) {
                int i4 = i2 * i;
                if (i4 > (-this.nForwardDot)) {
                    i4 = -this.nForwardDot;
                }
                this.m_xVel += (this.xForwad * i4) >> 14;
                this.m_yVel = ((i4 * this.yForwad) >> 14) + this.m_yVel;
            }
        }

        void AIAcceleration_NotBraking(int i) {
            int i2;
            this.m_nReverseTimer -= i;
            if (this.m_nReverseTimer < -4000) {
                this.m_nReverseTimer = -4000;
                if (this.m_nAverageSpeed < (this.m_nTopSpeed >> 5)) {
                    this.m_nReverseTimer = 1500;
                    if (this.m_nCopNum != 0) {
                        this.m_nReverseTimer += 1500;
                    }
                }
            }
            if (this.m_nReverseTimer > 0 && ((this.m_nCopNum == 0 && !this.m_bTraffic) || this.m_nPlayerDist > 2)) {
                int i3 = (((this.nForwardDot + 15000) * (this.this$0.exp_Array[(-((-i) >> 1)) >> 8] + (((this.this$0.exp_Array[((-((-i) >> 1)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) >> 1)) >> 8]) * ((-((-i) >> 1)) - ((-((-i) >> 1)) & (-256)))) >> 8))) >> 16) - 15000;
                this.m_xVel += (this.xForwad * (i3 - this.nForwardDot)) >> 14;
                this.m_yVel = (((i3 - this.nForwardDot) * this.yForwad) >> 14) + this.m_yVel;
                return;
            }
            if (this.nForwardDot <= -64) {
                this.m_bBreaking = true;
                return;
            }
            int i4 = this.m_nTopSpeed;
            if (this.m_bTraffic) {
                i2 = i4 >> 3;
            } else {
                i2 = i4 + ((this.m_nPlayerDist - 1) * 512);
                if (i2 < this.m_nTopSpeed - (this.m_nTopSpeed >> 3)) {
                    i2 = this.m_nTopSpeed - (this.m_nTopSpeed >> 3);
                } else if (i2 > this.m_nTopSpeed + (this.m_nTopSpeed >> 3)) {
                    i2 = this.m_nTopSpeed + (this.m_nTopSpeed >> 3);
                }
            }
            if (this.m_nCopNum != 0 || this.m_nID == -5) {
                AIAcceleration_NotBraking_Cops(i, i2);
            } else {
                i2 -= (this.m_nID - 1) * (this.m_nTopSpeed >> 3);
            }
            if (this.m_bBreaking || this.nForwardDot * (Math.abs(this.nAngleAIDiff) >> 8) > 358400) {
                this.m_bBreaking = true;
                return;
            }
            int i5 = this.m_nAcceleration;
            int i6 = i2 + (((((((-((-(i * i5)) >> 8)) - ((-((-(i5 * i)) >> 8)) & (-256))) * (this.this$0.exp_Array[((-((-(i * i5)) >> 8)) >> 8) + 1] - this.this$0.exp_Array[(-((-(i * i5)) >> 8)) >> 8])) >> 8) + this.this$0.exp_Array[(-((-(i * i5)) >> 8)) >> 8]) * (this.nForwardDot - i2)) >> 16);
            this.m_xVel += (this.xForwad * (i6 - this.nForwardDot)) >> 14;
            this.m_yVel = (((i6 - this.nForwardDot) * this.yForwad) >> 14) + this.m_yVel;
        }

        void AIAcceleration_NotBraking_Cops(int i, int i2) {
            int i3 = i2 + (this.m_nTopSpeed >> 8);
            int i4 = this.m_nAcceleration + 80;
            if (Math.abs(this.this$0.players[0].m_nAverageSplineMovementSpeed) < 1000 && Math.abs(this.m_nPlayerDist) < 2) {
                this.m_nState = 7;
                if (this.m_velocityLastFrame > this.this$0.players[0].m_velocityLastFrame + 5000) {
                    this.m_bBreaking = true;
                }
            }
            if (this.m_nState == 7) {
                if (Math.abs(this.this$0.players[0].m_nAverageSplineMovementSpeed) > 4000) {
                    this.m_nState = 0;
                    return;
                }
                return;
            }
            if (this.m_nState == 1) {
                if (this.m_nPlayerDist < 8) {
                    if (this.this$0.system_GetRandom() >= 0) {
                        this.m_nState = 2;
                    } else {
                        this.m_nState = 3;
                    }
                    this.m_nStateTime = 0;
                }
                int i5 = (this.m_nTopSpeed >> 1) + (this.m_nTopSpeed >> 2);
                return;
            }
            if (this.m_nPlayerDist < -1 && this.m_nState != 6) {
                this.m_bReverseTrack = this.m_bReverseTrack ? false : true;
                return;
            }
            if (this.m_bReverseTrack) {
                return;
            }
            if (this.m_nState == 6 || this.m_nState == 0 || this.m_nState == 5) {
                int length = this.this$0.players[0].m_nAiNode - this.m_nAiNode;
                if (length < ((-this.m_aiSpline.length) >> 1)) {
                    length += this.m_aiSpline.length;
                } else if (length > (this.m_aiSpline.length >> 1)) {
                    length -= this.m_aiSpline.length;
                }
                int i6 = (length << 8) + ((this.this$0.players[0].m_nCurrentSplineDistance - this.m_nCurrentSplineDistance) >> 6);
                if (i6 > -32) {
                    this.nAngleAIDiff >>= 2;
                }
                if (i6 > 32) {
                    int i7 = i3 + (this.m_nTopSpeed >> 4);
                }
                if (this.m_nState == 6) {
                    this.nAngleAIDiff >>= 2;
                    int i8 = i4 + 120;
                    if (i6 > -250) {
                        this.m_nState = 0;
                        return;
                    } else {
                        if (this.m_velocityLastFrame > this.this$0.players[0].m_velocityLastFrame - 3000) {
                            this.m_bBreaking = true;
                            return;
                        }
                        return;
                    }
                }
                if (this.m_nState != 5) {
                    if (i6 < 1024 && this.m_velocityLastFrame > this.this$0.players[0].m_velocityLastFrame + 2000) {
                        this.m_bBreaking = true;
                    }
                    if (i6 < -120) {
                        this.m_nState = 5;
                        return;
                    }
                    return;
                }
                this.nAngleAIDiff = 0;
                if (i6 > -74) {
                    this.m_nState = 0;
                } else if (Math.abs(this.this$0.players[0].m_nCrossAI - this.m_nCrossAI) < 200 || this.m_velocityLastFrame > this.this$0.players[0].m_velocityLastFrame - 200) {
                    this.m_bBreaking = true;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
        void AIOvertaking(int i) {
            int i2;
            int i3 = 5000;
            int i4 = this.this$0.g_nParam1;
            if (this.m_nSortedPos < this.this$0.sortedCarsList.length - 1) {
                int distanceToClosestCarInFront = getDistanceToClosestCarInFront();
                if (this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_nCopNum != 0 || this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_bTraffic) {
                    if (distanceToClosestCarInFront < 200) {
                        int i5 = this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_nCrossAI - this.m_nCrossAI;
                        int i6 = (this.m_velocityLastFrame - this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_velocityLastFrame > 5000 || this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_velocityLastFrame < 1000) ? 5000 : 3000;
                        if (i5 > 0) {
                            i2 = (-i6) + i5;
                            if (i2 > 0) {
                                i2 = 0;
                            }
                        } else {
                            i2 = i6 + i5;
                            if (i2 < 0) {
                                i2 = 0;
                            }
                        }
                        if (i2 <= 5000) {
                            i3 = i2 < -5000 ? -5000 : i2;
                        }
                        this.m_nOverTackingAngleOffset = i3;
                    } else {
                        i3 = i4;
                    }
                } else if (distanceToClosestCarInFront < 160) {
                    i3 = this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_nCrossAI - this.m_nCrossAI > 0 ? -1100 : 1100;
                    if (distanceToClosestCarInFront < 90) {
                        i3 >>= 1;
                    }
                } else {
                    i3 = i4;
                }
            } else {
                i3 = i4;
            }
            this.this$0.g_nParam1 = i3;
        }

        void AISteering(int i) {
            int i2;
            if (this.m_nLastWheelCount < 2 || this.m_nState == 4) {
                this.m_zAngVel = (this.m_zAngVel * (this.this$0.exp_Array[(-((-i) * 8)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 8)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 8)) >> 8]) * ((-((-i) * 8)) - ((-((-i) * 8)) & (-256)))) >> 8))) >> 16;
                return;
            }
            int i3 = this.m_zAng;
            int i4 = this.nAngleAI;
            if (this.m_nCopNum != 0) {
                if (this.m_nState == 3) {
                    i4 += 16384;
                } else if (this.m_nState == 2) {
                    i4 -= 16384;
                }
            }
            this.m_zAng &= 16777215;
            int i5 = this.nAngleAI - (this.m_zAng >> 8);
            if (i5 > 32768) {
                i4 -= 65536;
            } else if (i5 < -32768) {
                i4 += 65536;
            }
            int iCalcAIMaxTurningAngle = calcAIMaxTurningAngle(i5);
            int i6 = this.nCrossAI << 2;
            if (i6 > iCalcAIMaxTurningAngle) {
                i6 = iCalcAIMaxTurningAngle;
            } else if (i6 < (-iCalcAIMaxTurningAngle)) {
                i6 = -iCalcAIMaxTurningAngle;
            }
            if (this.m_nReverseTimer > 0) {
                i6 = -i6;
            }
            int i7 = i4 - i6;
            if (this.m_nCopNum != 0) {
                this.this$0.g_nParam1 = i7;
                this.this$0.g_nParam2 = i5;
                this.this$0.g_nParam3 = 0;
                CopAISteering(i);
                i7 = this.this$0.g_nParam1;
                int i8 = this.this$0.g_nParam2;
                i2 = this.this$0.g_nParam3;
            } else {
                this.this$0.g_nParam1 = 0;
                AIOvertaking(i);
                i2 = this.this$0.g_nParam1;
            }
            int overTakingOffset = (getOverTakingOffset(i, i2) + i7) - (this.m_zAng >> 8);
            if (overTakingOffset <= iCalcAIMaxTurningAngle) {
                iCalcAIMaxTurningAngle = overTakingOffset < (-iCalcAIMaxTurningAngle) ? -iCalcAIMaxTurningAngle : overTakingOffset;
            }
            if (this.m_nCopNum != 0 && this.m_nState != 8 && Math.abs(this.nSideDot) * 3 > (Math.abs(this.nForwardDot) << 1)) {
                this.m_nState = 8;
                this.m_nStateTime = 0;
            }
            if (this.m_nCopNum == 0 || this.m_nState != 8) {
                this.m_zAngVel -= iCalcAIMaxTurningAngle;
                this.m_zAngVel = (this.m_zAngVel * (this.this$0.exp_Array[(-((-i) * 75)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 75)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 75)) >> 8]) * ((-((-i) * 75)) - ((-((-i) * 75)) & (-256)))) >> 8))) >> 16;
                if (this.m_zAngVel > 0) {
                    this.m_zAngVel -= i * 4;
                    if (this.m_zAngVel < 0) {
                        this.m_zAngVel = 0;
                    }
                } else {
                    this.m_zAngVel += i * 4;
                    if (this.m_zAngVel > 0) {
                        this.m_zAngVel = 0;
                    }
                }
                this.m_zAngVel += iCalcAIMaxTurningAngle;
            } else {
                if (this.m_nStateTime > 2000) {
                    this.m_nState = 0;
                    this.m_nStateTime = 0;
                }
                this.m_zAngVel = (this.m_zAngVel * (this.this$0.exp_Array[(-((-i) * 8)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 8)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 8)) >> 8]) * ((-((-i) * 8)) - ((-((-i) * 8)) & (-256)))) >> 8))) >> 16;
            }
            applyAISlidingForce(i);
        }

        public void AddSparks(int i, int i2, int i3) {
            int i4 = 0;
            int i5 = 268435455;
            int i6 = 0;
            while (true) {
                int i7 = i4;
                if (i6 >= this.m_carSparks.length) {
                    this.m_carSparks[i7].timer = this.this$0.game_Time + 500;
                    this.m_carSparks[i7].f6x = i * 1.5258789E-5f;
                    this.m_carSparks[i7].f8z = i2 * 1.5258789E-5f;
                    this.m_carSparks[i7].f7y = i3 * 1.5258789E-5f;
                    return;
                }
                if (this.m_carSparks[i6].timer < i5) {
                    i5 = this.m_carSparks[i6].timer;
                    i4 = i6;
                } else {
                    i4 = i7;
                }
                i6++;
            }
        }

        public void AdjustCarStats() {
            int i = 0;
            while (i < 4) {
                if (!this.m_bPlayer) {
                    float f = this.this$0.g_race.m_difficulty * (this.this$0.stats_max[i] / 6.0f);
                    if (this.this$0.g_race.m_nMissionID < 2) {
                        this.m_ca.m_modStats[i] = ((int) f) - 1;
                    } else if ((this.this$0.g_race.m_nMissionID > 1 && this.this$0.g_race.m_nMissionID < 5) || this.this$0.g_race.m_nMissionID > 35) {
                        this.m_ca.m_modStats[i] = ((int) f) + 1;
                    } else if (this.this$0.g_race.m_nMissionID == 5) {
                        this.m_ca.m_modStats[i] = this.this$0.stats_max[i];
                    } else if (this.this$0.g_player.m_missionStatus[1] == 0 || this.this$0.g_race.m_nMissionID == 35) {
                        this.m_ca.m_modStats[i] = ((int) f) - 2;
                    } else {
                        this.m_ca.m_modStats[i] = ((int) f) - 1;
                    }
                }
                if (this.m_ca.m_modStats[i] <= 0) {
                    this.m_ca.m_modStats[i] = 1;
                }
                if (this.m_ca.m_modStats[i] > this.this$0.stats_max[i]) {
                    this.m_ca.m_modStats[i] = this.this$0.stats_max[i];
                }
                i++;
            }
            if (this.m_bPlayer) {
                this.m_nCurrentHeatRating = 0;
                if (this.this$0.g_race.m_type == 4 || this.this$0.system_bDemoMode || this.this$0.g_player.m_missionStatus[5] == 1) {
                    this.m_nCurrentHeatRating = 3;
                }
            }
            try {
                if (this.m_ca.m_modStats[0] > this.this$0.stats_max[0] || this.m_ca.m_modStats[2] > this.this$0.stats_max[2] || this.m_ca.m_modStats[1] > this.this$0.stats_max[1]) {
                    throw new Exception();
                }
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 385, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 385, e2.toString());
            }
            float f2 = 1.0f - (this.m_ca.m_modStats[0] / this.this$0.stats_max[0]);
            float f3 = 1.0f - (this.m_ca.m_modStats[2] / this.this$0.stats_max[2]);
            this.m_nHandling = (int) (this.m_nHandling - (((1.0f - (this.m_ca.m_modStats[1] / this.this$0.stats_max[1])) * this.m_nHandling) / 5.0f));
            this.m_nAcceleration = (int) (this.m_nAcceleration - ((f3 * this.m_nAcceleration) / 5.0f));
            this.m_nTopSpeed = (int) (this.m_nTopSpeed - ((f2 * this.m_nTopSpeed) / 5.0f));
            if (this.m_nCopNum != 0) {
                this.m_nTopSpeed = this.this$0.players[0].m_nTopSpeed + 1000;
                this.m_nAcceleration = 170;
                this.m_nHandling = 64;
            }
        }

        void CalcCollisionPositionAndNormal(Car car, int i, int i2) {
            int i3 = this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255]) * ((this.m_zAng >> 8) - ((this.m_zAng >> 8) & (-256)))) >> 8);
            int i4 = this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((this.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.m_zAng >> 8) + 49152) - (((this.m_zAng >> 8) + 49152) & (-256)))) >> 8);
            int i5 = this.this$0.sin_Array[((car.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((car.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((car.m_zAng >> 8) >> 8) & 255]) * ((car.m_zAng >> 8) - ((car.m_zAng >> 8) & (-256)))) >> 8);
            int i6 = this.this$0.sin_Array[(((car.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((car.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((car.m_zAng >> 8) + 49152) >> 8) & 255]) * (((car.m_zAng >> 8) + 49152) - (((car.m_zAng >> 8) + 49152) & (-256)))) >> 8);
            this.xNormal = 0;
            this.yNormal = 1;
            this.xColPos = 0;
            this.yColPos = 0;
            if ((this.xDistB <= this.yDistB || this.xDistB <= this.xDistA || this.xDistB <= this.yDistA) && (this.xDistB > this.yDistB || this.yDistB <= this.xDistA || this.yDistB <= this.yDistA)) {
                if (this.xDistA > this.yDistA) {
                    calcCollisionA1(this, car, i4, i3);
                    return;
                } else {
                    calcCollisionA2(this, car, i4, i3);
                    return;
                }
            }
            if (this.xDistB > this.yDistB) {
                calcCollisionB1(this, car, i6, i5);
            } else {
                calcCollisionB2(this, car, i6, i5);
            }
        }

        void CalcCollisionResponse(Car car, int i, int i2) {
            int i3;
            this.nIntersection -= this.nCollisionExpand;
            int i4 = (-this.nIntersection) - this.nCollisionExpand;
            if (i4 < 0) {
                i4 = 0;
                i3 = 0;
            } else {
                i3 = (i4 * i) >> 2;
            }
            int i5 = this.nIntersection + this.nCollisionExpand;
            int i6 = i5 < 0 ? 0 : (i5 * i2) >> 6;
            int i7 = (((this.m_xVel - car.m_xVel) * this.xNormal) + ((this.m_yVel - car.m_yVel) * this.yNormal)) >> 14;
            int i8 = (((this.xColPos - this.m_xPos) * this.yNormal) - ((this.yColPos - this.m_yPos) * this.xNormal)) >> 14;
            int i9 = (((this.xColPos - car.m_xPos) * this.yNormal) - ((this.yColPos - car.m_yPos) * this.xNormal)) >> 14;
            int i10 = (i7 - ((((((this.m_zAngVel >> 8) * i8) - ((car.m_zAngVel >> 8) * i9)) >> 8) * 1608) >> 16)) - i6;
            if (i10 > 0) {
                addAngularCollisionForce(this, car, i10, i8, i9);
            }
            int i11 = ((((((this.m_xVel - car.m_xVel) * this.xNormal) + ((this.m_yVel - car.m_yVel) * this.yNormal)) >> 14) - ((((((this.m_zAngVel >> 8) * i8) - ((car.m_zAngVel >> 8) * i9)) >> 8) * 1608) >> 16)) - i6) + i3;
            if (i11 > 0) {
                addLinearCollisionForce(this, car, i11, i8, i9);
                if (car.m_velocityLastFrame > 1000) {
                    car.AddSparks(this.xColPos << 8, this.yColPos << 8, this.m_zPos << 8);
                }
                car.DamageCar(i11, this.xNormal, this.yNormal, i4, this);
                DamageCar(i11, -this.xNormal, -this.yNormal, i4, car);
            }
        }

        public void CalculateSuspension(int i, int i2, int i3, int i4, int i5) {
            if (i3 == 4) {
                i5 >>= 2;
                int i6 = this.rotationArray[5] < 0.5f ? -200 : 64;
                if (this.m_nLastAverageCount == 4 && i4 > 0) {
                    int i7 = (((((this.zWheelForce[0] + this.zWheelForce[1]) + this.zWheelForce[2]) + this.zWheelForce[3]) - 10) * i) >> 6;
                    int i8 = ((i5 - this.m_zLastAveragePos) * i2) >> 6;
                    int i9 = i7 + (((((this.m_zVel - i8) * (this.this$0.exp_Array[(-(((-i) * i4) * 15)) >> 8] + (((this.this$0.exp_Array[((-(((-i) * i4) * 15)) >> 8) + 1] - this.this$0.exp_Array[(-(((-i) * i4) * 15)) >> 8]) * ((-(((-i) * i4) * 15)) - ((-(((-i) * i4) * 15)) & (-256)))) >> 8))) >> 16) + i8) - this.m_zVel);
                    if (i9 > 0) {
                        this.m_zVel = i9 + this.m_zVel;
                        int i10 = i8 + 400 + ((i * 1680) >> 10);
                        if (this.m_zVel > i10) {
                            this.m_zVel = i10;
                        }
                    }
                    if (this.m_zPos < i5 - i6) {
                        this.m_zPos = i5 - i6;
                        if (this.m_zVel < i8) {
                            this.m_zVel = i8;
                        }
                    }
                } else if (this.m_zPos < i5 - i6) {
                    this.m_zPos = i5 - i6;
                }
            }
            this.m_nLastAverageCount = i3;
            this.m_zLastAveragePos = i5;
            this.m_nLastWheelCount = i4;
            if (Math.abs(this.m_xAng) > 2097152) {
                this.m_xAngVel -= (((this.zWheelForce[0] - this.zWheelForce[2]) + (this.zWheelForce[1] - this.zWheelForce[3])) * i) >> 3;
                if (Math.abs(this.m_yAng) < 2097152) {
                    this.m_yAngVel -= (((this.zWheelForce[0] - this.zWheelForce[1]) + (this.zWheelForce[2] - this.zWheelForce[3])) * i) >> 2;
                } else {
                    this.m_yAngVel += (((this.zWheelForce[0] - this.zWheelForce[1]) + (this.zWheelForce[2] - this.zWheelForce[3])) * i) >> 2;
                }
            } else {
                this.m_xAngVel += (((this.zWheelForce[0] - this.zWheelForce[2]) + (this.zWheelForce[1] - this.zWheelForce[3])) * i) >> 3;
                if (Math.abs(this.m_yAng) > 2097152) {
                    this.m_yAngVel -= (((this.zWheelForce[0] - this.zWheelForce[1]) + (this.zWheelForce[2] - this.zWheelForce[3])) * i) >> 2;
                } else {
                    this.m_yAngVel += (((this.zWheelForce[0] - this.zWheelForce[1]) + (this.zWheelForce[2] - this.zWheelForce[3])) * i) >> 2;
                }
            }
            if (this.rotationArray[5] > 0.0f) {
                this.m_xAngVel = (this.m_xAngVel * (this.this$0.exp_Array[(-(((-i) * 12) * i4)) >> 8] + (((this.this$0.exp_Array[((-(((-i) * 12) * i4)) >> 8) + 1] - this.this$0.exp_Array[(-(((-i) * 12) * i4)) >> 8]) * ((-(((-i) * 12) * i4)) - ((-(((-i) * 12) * i4)) & (-256)))) >> 8))) >> 16;
                this.m_yAngVel = (this.m_yAngVel * (this.this$0.exp_Array[(-(((-i) * 5) * i4)) >> 8] + (((this.this$0.exp_Array[((-(((-i) * 5) * i4)) >> 8) + 1] - this.this$0.exp_Array[(-(((-i) * 5) * i4)) >> 8]) * ((-(((-i) * 5) * i4)) - ((-(((-i) * 5) * i4)) & (-256)))) >> 8))) >> 16;
            } else {
                this.m_xAngVel = (this.m_xAngVel * (this.this$0.exp_Array[(-(((-i) * 20) * i4)) >> 8] + (((this.this$0.exp_Array[((-(((-i) * 20) * i4)) >> 8) + 1] - this.this$0.exp_Array[(-(((-i) * 20) * i4)) >> 8]) * ((-(((-i) * 20) * i4)) - ((-(((-i) * 20) * i4)) & (-256)))) >> 8))) >> 16;
                this.m_yAngVel = (this.m_yAngVel * (this.this$0.exp_Array[(-(((-i) * 10) * i4)) >> 8] + (((this.this$0.exp_Array[((-(((-i) * 10) * i4)) >> 8) + 1] - this.this$0.exp_Array[(-(((-i) * 10) * i4)) >> 8]) * ((-(((-i) * 10) * i4)) - ((-(((-i) * 10) * i4)) & (-256)))) >> 8))) >> 16;
            }
        }

        public void CalculateTimeDiff() {
            int i;
            if (this.this$0.game_playerPosition == 1) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 1; i4 < this.this$0.g_race.m_numRacers; i4++) {
                    if (this.this$0.players[i4].m_nLap == this.this$0.players[0].m_nLap) {
                        i2++;
                        i3 = i4;
                    }
                }
                if (i2 != 1 || this.this$0.popupTimer >= this.this$0.game_Time) {
                    return;
                }
                this.this$0.game_popupText(constructTimeString(this.this$0.players[0].m_nCheckpointTime - this.this$0.players[i3].m_nCheckpointTime, false), true);
                return;
            }
            boolean z = false;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 1; i7 < this.this$0.g_race.m_numRacers; i7++) {
                if (this.this$0.players[i7].m_nLap >= this.this$0.players[0].m_nLap && (i = this.this$0.players[0].m_nCheckpointTime - this.this$0.players[i7].m_nCheckpointTime) >= i6) {
                    z = true;
                    i5 = i7;
                    i6 = i;
                }
            }
            if (!this.m_bPlayer || i5 <= 0) {
                return;
            }
            this.this$0.game_popupText(constructTimeString(i6, z), true);
        }

        void CollideWith(Car car, int i, int i2) {
            if (this.m_bDisabled || car.m_bDisabled) {
                return;
            }
            if (car.m_nTimeNotVisable <= 2000 || this.m_nTimeNotVisable <= 2000) {
                int i3 = this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255]) * ((this.m_zAng >> 8) - ((this.m_zAng >> 8) & (-256)))) >> 8);
                int i4 = this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((this.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.m_zAng >> 8) + 49152) - (((this.m_zAng >> 8) + 49152) & (-256)))) >> 8);
                int i5 = this.this$0.sin_Array[((car.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((car.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((car.m_zAng >> 8) >> 8) & 255]) * ((car.m_zAng >> 8) - ((car.m_zAng >> 8) & (-256)))) >> 8);
                int i6 = this.this$0.sin_Array[(((car.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((car.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((car.m_zAng >> 8) + 49152) >> 8) & 255]) * (((car.m_zAng >> 8) + 49152) - (((car.m_zAng >> 8) + 49152) & (-256)))) >> 8);
                this.xCollisionExpandA = ((Math.abs(((this.m_xVel - car.m_xVel) * i4) + ((this.m_yVel - car.m_yVel) * i3)) >> 14) * i) >> 10;
                this.yCollisionExpandA = ((Math.abs(((-i3) * (this.m_xVel - car.m_xVel)) + ((this.m_yVel - car.m_yVel) * i4)) >> 14) * i) >> 10;
                this.xColSizeA = this.xCollisionExpandA + 250;
                this.yColSizeA = this.yCollisionExpandA + 540;
                this.xCollisionExpandB = ((Math.abs(((this.m_xVel - car.m_xVel) * i6) + ((this.m_yVel - car.m_yVel) * i5)) >> 14) * i) >> 10;
                this.yCollisionExpandB = ((Math.abs(((-i5) * (this.m_xVel - car.m_xVel)) + ((this.m_yVel - car.m_yVel) * i6)) >> 14) * i) >> 10;
                this.xColSizeB = this.xCollisionExpandB + 250;
                this.yColSizeB = this.yCollisionExpandB + 540;
                this.nAngOffset1 = this.this$0.sin_Array[(((car.m_zAng - this.m_zAng) >> 16) & 63) + 32];
                this.nAngOffset1 = (this.nAngOffset1 * 353) >> 14;
                this.nAngOffset2 = this.this$0.sin_Array[((car.m_zAng - this.m_zAng) >> 16) & 127];
                this.nAngOffset2 = (this.nAngOffset2 * 290) >> 14;
                this.nAngOffset3 = this.this$0.sin_Array[(((car.m_zAng - this.m_zAng) >> 16) + 64) & 127];
                this.nAngOffset3 = (this.nAngOffset3 * 290) >> 14;
                this.xPosTmp = car.m_xPos - this.m_xPos;
                this.yPosTmp = car.m_yPos - this.m_yPos;
                this.xPosBInASpace = (((-this.xPosTmp) * i4) - (this.yPosTmp * i3)) >> 14;
                this.yPosBInASpace = ((i3 * this.xPosTmp) - (i4 * this.yPosTmp)) >> 14;
                this.xPosAInBSpace = ((this.xPosTmp * i6) + (this.yPosTmp * i5)) >> 14;
                this.yPosAInBSpace = (((-this.xPosTmp) * i5) + (this.yPosTmp * i6)) >> 14;
                this.xDistA = ((Math.abs(this.xPosBInASpace) - this.nAngOffset1) - this.nAngOffset2) - 250;
                this.yDistA = ((Math.abs(this.yPosBInASpace) - this.nAngOffset1) - this.nAngOffset3) - 540;
                this.xDistB = ((Math.abs(this.xPosAInBSpace) - this.nAngOffset1) - this.nAngOffset2) - 250;
                this.yDistB = ((Math.abs(this.yPosAInBSpace) - this.nAngOffset1) - this.nAngOffset3) - 540;
                if (this.xDistA - this.xCollisionExpandA >= 0 || this.yDistA - this.yCollisionExpandA >= 0 || this.xDistB - this.xCollisionExpandB >= 0 || this.yDistB - this.yCollisionExpandB >= 0) {
                    return;
                }
                CalcCollisionPositionAndNormal(car, i, i2);
                CalcCollisionResponse(car, i, i2);
                if (this.m_nCopNum != 0 && car.m_bPlayer) {
                    this.m_bHitPlayer = true;
                } else {
                    if (!this.m_bPlayer || car.m_nCopNum == 0) {
                        return;
                    }
                    car.m_bHitPlayer = true;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:51:0x00f7  */
        void CopAISteering(int i) {
            int i2;
            int i3 = 4000;
            int i4 = this.this$0.g_nParam1;
            int i5 = this.this$0.g_nParam2;
            int i6 = this.this$0.g_nParam3;
            if (this.m_nState == 7) {
                this.nAngleAI = (this.this$0.arctan2((-(this.this$0.players[0].m_xPos - this.m_xPos)) << 16, (-(this.this$0.players[0].m_yPos - this.m_yPos)) << 16) & 16777215) >> 8;
                int i7 = this.nAngleAI;
                i5 = this.nAngleAI - (this.m_zAng >> 8);
                if (i5 > 32768) {
                    i7 -= 65536;
                } else if (i5 < -32768) {
                    i7 += 65536;
                }
                this.m_nOverTackingAngleOffset = 0;
                i2 = i6;
                i4 = i7;
            } else if (this.m_bReverseTrack) {
                i2 = i6;
            } else if (this.m_nState == 0 || this.m_nState == 6) {
                int distanceToPlayer = getDistanceToPlayer();
                if (distanceToPlayer < 128) {
                    int i8 = this.this$0.players[0].m_nCrossAI - this.m_nCrossAI > 0 ? -1500 : 1500;
                    i2 = i8;
                    i4 += i8;
                } else if (distanceToPlayer >= -90) {
                    i2 = i6;
                } else if (this.m_nState == 6) {
                    int i9 = (this.this$0.players[0].m_nCrossAI - this.m_nCrossAI) << 1;
                    int i10 = (distanceToPlayer >> 2) + 4000;
                    if (i10 < 0) {
                        i10 = 0;
                    }
                    if (i9 <= i10) {
                        i10 = i9 < (-i10) ? -i10 : i9;
                    }
                    this.m_nOverTackingAngleOffset = i10;
                    i2 = i10;
                    i4 += i10;
                } else {
                    int i11 = this.this$0.players[0].m_nCrossAI - this.m_nCrossAI;
                    if (i11 <= 4000) {
                        i3 = i11 < -4000 ? -4000 : i11;
                    }
                    i2 = i3;
                    i4 += i3;
                }
            } else if (this.m_nState == 5) {
                int i12 = (this.this$0.players[0].m_nCrossAI - this.m_nCrossAI) << 1;
                if (i12 <= 4000) {
                    i3 = i12 < -4000 ? -4000 : i12;
                }
                this.m_nOverTackingAngleOffset = i3;
                i2 = i3;
                i4 += i3;
            } else {
                i2 = i6;
            }
            this.this$0.g_nParam1 = i4;
            this.this$0.g_nParam2 = i5;
            this.this$0.g_nParam3 = i2;
        }

        public void DamageCar(int i, int i2, int i3, int i4, Car car) {
            if (car == this.this$0.players[0] && this.m_nID == -5) {
                this.m_nState = 0;
                if (this.this$0.game_Time <= car.m_nRecklessTimer || this.this$0.game_state != 2) {
                    return;
                }
                if (car.m_nCurrentHeatRating < 3) {
                    car.m_nCurrentHeatRating++;
                }
                this.this$0.game_popupText(this.this$0.g_Text[201], false);
                car.m_nRecklessTimer = this.this$0.game_Time + 10000;
                return;
            }
            if (this.m_nCopNum == 0 || car.m_velocityLastFrame < 1000 || (((car.m_xVel * i2) + (car.m_yVel * i3)) >> 14) < 0 || this.m_nDamagedLevel >= 51200) {
                return;
            }
            if (this.m_nState == 4) {
                this.m_nState = 0;
                return;
            }
            if (car == this.this$0.players[0] && this.this$0.game_Time > car.m_nRecklessTimer && this.this$0.game_state == 2) {
                if (car.m_nCurrentHeatRating < 3) {
                    car.m_nCurrentHeatRating++;
                }
                this.this$0.game_popupText(this.this$0.g_Text[201], false);
                car.m_nRecklessTimer = this.this$0.game_Time + 10000;
            }
            this.m_nDamagedLevel += i;
            if (this.m_nDamagedLevel > 51200) {
                this.m_nState = 4;
                this.m_zVel += 896;
                if (car == this.this$0.players[0] && this.this$0.game_Time > car.m_nAssaultTimer && this.this$0.game_state == 2) {
                    if (car.m_nCurrentHeatRating < 3) {
                        car.m_nCurrentHeatRating++;
                    }
                    this.this$0.game_popupText(this.this$0.g_Text[202], false);
                    car.m_nAssaultTimer = this.this$0.game_Time + 10000;
                }
                int i5 = this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255]) * ((this.m_zAng >> 8) - ((this.m_zAng >> 8) & (-256)))) >> 8);
                int i6 = this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((this.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.m_zAng >> 8) + 49152) - (((this.m_zAng >> 8) + 49152) & (-256)))) >> 8);
                int i7 = (((-i2) * i6) - (i3 * i5)) >> 14;
                int i8 = ((i5 * i2) - (i6 * i3)) >> 14;
                this.m_xAngVel += i8 >> 3;
                this.m_yAngVel -= i7 >> 3;
                if (car.m_velocityLastFrame < 5000 && this.m_velocityLastFrame < 5000) {
                    i4 = 0;
                }
                int i9 = (i4 - 60) * 8;
                if (i9 > 0) {
                    if (i9 > 2500) {
                        i9 = 2500;
                    }
                    this.m_xAngVel = ((i8 >> 7) * i9) + this.m_xAngVel;
                    this.m_yAngVel -= (i7 >> 6) * i9;
                    if (i9 > 1400) {
                        i9 = 1400;
                    }
                    this.m_zVel = i9 + this.m_zVel;
                }
                this.this$0.g_race.m_nCopsSmashed++;
            }
        }

        public void DeInitialize() {
            for (int i = 0; i < this.m_carSparks.length; i++) {
                this.m_carSparks[i] = null;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                this.m_colResult[i2] = null;
            }
            this.m_ca = null;
        }

        public int FindClosedAISpline() {
            int i = 1073741824;
            int length = this.m_aiSpline.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int iApproximateMagnitude = this.this$0.ApproximateMagnitude(this.m_xPos - (this.m_aiSpline[i2][0] << 4), this.m_yPos - (this.m_aiSpline[i2][1] << 4));
                if (i > iApproximateMagnitude) {
                    i3 = i2;
                } else {
                    iApproximateMagnitude = i;
                }
                i2++;
                i = iApproximateMagnitude;
            }
            return i3;
        }

        public int GetMPH() {
            return ((((this.this$0.players[0].m_velocityLastFrame * 1000) >> 2) >> 8) * 572) >> 16;
        }

        public void HandleHeatRating() {
            if (this.this$0.g_roadsideCop != null && !this.this$0.g_roadsideCop.m_bDisabled) {
                int i = this.this$0.g_roadsideCop.m_xPos - this.m_xPos;
                int i2 = this.this$0.g_roadsideCop.m_yPos - this.m_yPos;
                if ((Math.abs(i) + Math.abs(i2)) - (Math.min(Math.abs(i), Math.abs(i2)) >> 1) < 7680) {
                    if (this.m_bPlayer && GetMPH() > this.this$0.g_race.m_nSpeedLimit && this.this$0.game_Time > this.m_nSpeedingTimer && this.this$0.game_state == 2) {
                        if (this.m_nCurrentHeatRating < 3) {
                            this.m_nCurrentHeatRating++;
                        }
                        this.this$0.game_popupText(this.this$0.g_Text[203], false);
                        this.m_nSpeedingTimer = this.this$0.game_Time + 30000;
                        this.this$0.g_roadsideCop.m_nState = 0;
                    }
                    if (this.m_nCurrentHeatRating > 1) {
                        this.this$0.g_roadsideCop.m_nState = 0;
                    }
                }
            }
            int i3 = (this.this$0.track_evasionPoints[this.this$0.game_closestEvasionPickup][0] << 4) - this.m_xPos;
            int i4 = (this.this$0.track_evasionPoints[this.this$0.game_closestEvasionPickup][1] << 4) - this.m_yPos;
            if ((Math.abs(i3) + Math.abs(i4)) - (Math.min(Math.abs(i3), Math.abs(i4)) >> 1) >= 2048 || !this.m_bPlayer || this.this$0.game_Time <= this.m_nCoolTimer || this.this$0.game_state != 2 || this.m_nCurrentHeatRating <= 0) {
                return;
            }
            this.this$0.showFlashEffect = true;
            this.m_nCurrentHeatRating--;
            this.m_nCoolTimer = this.this$0.game_Time + 3000;
        }

        public void Init() {
            this.m_nTimeNotVisable = 0;
            this.m_nCurCheckpoint = 0;
            this.m_nCheckpointTime = 0;
            this.m_nAiNode = 0;
            this.m_nLap = 0;
            this.m_velocityMax = 0;
            this.m_velocityLastFrame = 0;
            this.m_nSpeedingScore = 0;
            this.m_nPlayerDist = 0;
            this.m_nHighestRaceSpeed = 0;
            this.m_bDisabled = false;
            this.m_nCurrentHeatRating = 0;
            this.m_nCoolTimer = 0;
            this.m_nSpeedingTimer = 0;
            this.m_nAssaultTimer = 0;
            this.m_nRecklessTimer = 0;
            this.m_bBreaking = false;
            this.m_bReversing = false;
            this.m_nReverseTimer = 0;
            this.m_bReverseTrack = false;
            this.m_bGoingBackward = false;
            this.m_bCheapUpdate = false;
            this.m_bUsingSecondarySpline = false;
            this.m_nTimeSinceLastSplineSwap = 0;
            this.m_distanceMovedLastFrame = 0.0f;
            this.m_nSlideOutDisableForCollision = 0;
            this.m_nAverageSpeed = this.m_nTopSpeed;
            this.m_nAverageSplineMovementSpeed = 0;
            this.m_nTimeSinceSpawn = 0;
            this.m_bHitPlayer = false;
            this.m_nBustedness = 0;
            this.m_nDamagedLevel = 0;
            this.m_nCurrentSplineDistance = 0;
            this.m_nCrossAI = 0;
            this.m_nOverTackingAngleOffset = 0;
            this.m_nState = 0;
            this.m_nStateTime = 0;
            this.m_zVel = 0;
            this.m_yVel = 0;
            this.m_xVel = 0;
            this.m_nTopSpeed = 15510;
            this.m_nAcceleration = 90;
            this.m_nHandling = 64;
            for (int i = 0; i < this.m_carSparks.length; i++) {
                if (this.m_carSparks[i] == null) {
                    this.m_carSparks[i] = new CSpark(this);
                }
                this.m_carSparks[i].timer = 0;
            }
        }

        public void InitCollision() {
            if (this.m_colResult[0] == null) {
                this.m_colResult[0] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[1] == null) {
                this.m_colResult[1] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[2] == null) {
                this.m_colResult[2] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[3] == null) {
                this.m_colResult[3] = new CCollisionResult(this.this$0);
            }
            this.m_colResult[0].Init();
            this.m_colResult[1].Init();
            this.m_colResult[2].Init();
            this.m_colResult[3].Init();
            this.m_nAiNode = FindClosedAISpline();
            this.m_zAng = ((this.m_aiSpline[this.m_nAiNode][2] & 65535) + 16384) << 8;
        }

        public void InitCollisionToSplinePos(int i) {
            if (this.m_colResult[0] == null) {
                this.m_colResult[0] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[1] == null) {
                this.m_colResult[1] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[2] == null) {
                this.m_colResult[2] = new CCollisionResult(this.this$0);
            }
            if (this.m_colResult[3] == null) {
                this.m_colResult[3] = new CCollisionResult(this.this$0);
            }
            this.m_colResult[0].nAttribute = (short) 0;
            this.m_colResult[0].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[0].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[0].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[1].nAttribute = (short) 0;
            this.m_colResult[1].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[1].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[1].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[2].nAttribute = (short) 0;
            this.m_colResult[2].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[2].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[2].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[3].nAttribute = (short) 0;
            this.m_colResult[3].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[3].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[3].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.this$0.groundCollision.UpdateHeight(this.m_colResult[0]);
            this.m_colResult[1].f2z = this.m_colResult[0].f2z;
            this.m_colResult[2].f2z = this.m_colResult[0].f2z;
            this.m_colResult[3].f2z = this.m_colResult[0].f2z;
            this.m_zPos = this.m_colResult[0].f2z >> 8;
            this.m_zLastAveragePos = this.m_zPos;
            this.m_nLastWheelCount = 0;
            this.m_xAng = 0;
            this.m_yAng = 0;
            this.m_xAngVel = 0;
            this.m_yAngVel = 0;
            this.m_zAngVel = 0;
            this.m_xVel = 0;
            this.m_yVel = 0;
            this.m_zVel = 0;
            this.m_nAverageSplineMovementSpeed = 0;
            UpdatePhysics(100, 655);
            UpdateTrackCollision(100, 655);
            this.m_xAngVel = 0;
            this.m_yAngVel = 0;
            this.m_zAngVel = 0;
            this.m_xVel = 0;
            this.m_yVel = 0;
            this.m_zVel = 0;
            this.m_zLastAveragePos = this.m_zPos;
            UpdatePhysics(100, 655);
            UpdateTrackCollision(100, 655);
            this.m_xAngVel = 0;
            this.m_yAngVel = 0;
            this.m_zAngVel = 0;
            this.m_xVel = 0;
            this.m_yVel = 0;
            this.m_zVel = 0;
        }

        public void InitCollisionToSplinePosWhileMoving(int i) {
            this.m_colResult[0].nAttribute = (short) 0;
            this.m_colResult[0].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[0].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[0].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[1].nAttribute = (short) 0;
            this.m_colResult[1].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[1].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[1].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[2].nAttribute = (short) 0;
            this.m_colResult[2].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[2].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[2].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.m_colResult[3].nAttribute = (short) 0;
            this.m_colResult[3].nTriangleID = this.m_aiSpline[i][3];
            this.m_colResult[3].f0x = this.m_aiSpline[i][0] << 12;
            this.m_colResult[3].f1y = (-this.m_aiSpline[i][1]) << 12;
            this.this$0.groundCollision.UpdateHeight(this.m_colResult[0]);
            this.m_colResult[1].f2z = this.m_colResult[0].f2z;
            this.m_colResult[2].f2z = this.m_colResult[0].f2z;
            this.m_colResult[3].f2z = this.m_colResult[0].f2z;
            this.m_zVel = 0;
            this.m_zPos = this.m_colResult[0].f2z >> 8;
            this.m_zLastAveragePos = this.m_zPos;
            this.m_nLastWheelCount = 0;
        }

        void InitPhysicsVariables() {
            this.xOldVel = this.m_xVel;
            this.yOldVel = this.m_yVel;
            this.xForwad = -(this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255]) * ((this.m_zAng >> 8) - ((this.m_zAng >> 8) & (-256)))) >> 8));
            this.yForwad = this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((this.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.m_zAng >> 8) + 49152) - (((this.m_zAng >> 8) + 49152) & (-256)))) >> 8);
            this.xRight2 = this.yForwad;
            this.yRight2 = -this.xForwad;
            this.nForwardDot = ((this.m_xVel * this.xForwad) + (this.m_yVel * this.yForwad)) >> 14;
            this.nSideDot = ((this.m_xVel * this.xRight2) + (this.m_yVel * this.yRight2)) >> 14;
            this.nFrontWheelAngle = (this.m_zAng + (this.m_zSteeringAng * 8)) >> 8;
            this.xRight = this.this$0.sin_Array[((this.nFrontWheelAngle + 49152) >> 8) & 255] + (((this.this$0.sin_Array[(((this.nFrontWheelAngle + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.nFrontWheelAngle + 49152) >> 8) & 255]) * ((this.nFrontWheelAngle + 49152) - ((this.nFrontWheelAngle + 49152) & (-256)))) >> 8);
            this.yRight = this.this$0.sin_Array[(this.nFrontWheelAngle >> 8) & 255] + (((this.this$0.sin_Array[((this.nFrontWheelAngle >> 8) + 1) & 255] - this.this$0.sin_Array[(this.nFrontWheelAngle >> 8) & 255]) * (this.nFrontWheelAngle - (this.nFrontWheelAngle & (-256)))) >> 8);
            this.bBackOffFromOverTacking = false;
        }

        void PlayerAcceleration(int i) {
            this.m_bBreaking = false;
            this.m_bReversing = false;
            if ((this.this$0.game_nKeyFlags & 16) != 0) {
                this.m_nAccelerateTimer = -1024;
                this.m_bBreaking = true;
            } else if ((this.this$0.game_nKeyFlags & 2) != 0) {
                this.m_nAccelerateTimer = 2500;
            } else if ((this.this$0.game_nKeyFlags & 4) != 0) {
                this.m_nAccelerateTimer = -1024;
                this.m_bBreaking = true;
            } else if ((this.this$0.game_nKeyFlags & 1) != 0) {
                this.m_nAccelerateTimer = 250000;
            } else if ((this.this$0.game_nKeyFlags & 6144) != 0) {
                if (this.this$0.g_race.m_type == 4) {
                    this.this$0.game_popupText(this.this$0.g_Text[182], false);
                } else if (this.m_nNitroCount > 0 && this.m_nNitroTimer <= 0) {
                    this.m_nNitroTimer = 2500;
                    this.m_nNitroCount--;
                }
            } else if (this.m_nAccelerateTimer >= 0) {
                this.m_nAccelerateTimer -= i;
                if (this.m_nAccelerateTimer < 0) {
                    this.m_nAccelerateTimer = 0;
                }
            } else {
                this.m_nAccelerateTimer += i;
                if (this.m_nAccelerateTimer >= 0) {
                    this.m_nAccelerateTimer = 0;
                }
            }
            if (this.m_nNitroTimer > 0) {
                this.m_nNitroTimer -= i;
                if (this.m_nNitroTimer < 0) {
                    this.m_nNitroTimer = 0;
                }
            }
            if (this.m_nAccelerateTimer > 0 || this.m_nNitroTimer > 0) {
                if (this.nForwardDot > -16) {
                    int i2 = this.m_nAcceleration;
                    if (this.m_nNitroTimer > 0) {
                        i2 += 100;
                    }
                    int i3 = (((((((-((-(i * i2)) >> 8)) - ((-((-(i2 * i)) >> 8)) & (-256))) * (this.this$0.exp_Array[((-((-(i * i2)) >> 8)) >> 8) + 1] - this.this$0.exp_Array[(-((-(i * i2)) >> 8)) >> 8])) >> 8) + this.this$0.exp_Array[(-((-(i * i2)) >> 8)) >> 8]) * (this.nForwardDot - this.m_nTopSpeed)) >> 16) + this.m_nTopSpeed;
                    this.m_xVel += (this.xForwad * (i3 - this.nForwardDot)) >> 14;
                    this.m_yVel = (((i3 - this.nForwardDot) * this.yForwad) >> 14) + this.m_yVel;
                } else {
                    int i4 = i * 4;
                    if (i4 > (-this.nForwardDot)) {
                        i4 = -this.nForwardDot;
                    }
                    this.m_xVel += (this.xForwad * i4) >> 14;
                    this.m_yVel = ((i4 * this.yForwad) >> 14) + this.m_yVel;
                    this.m_bBreaking = true;
                }
            } else if (this.m_bBreaking && this.nForwardDot < 64) {
                int i5 = (((this.nForwardDot + 15000) * (this.this$0.exp_Array[(-((-i) >> 1)) >> 8] + (((this.this$0.exp_Array[((-((-i) >> 1)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) >> 1)) >> 8]) * ((-((-i) >> 1)) - ((-((-i) >> 1)) & (-256)))) >> 8))) >> 16) - 15000;
                this.m_xVel += (this.xForwad * (i5 - this.nForwardDot)) >> 14;
                this.m_yVel = (((i5 - this.nForwardDot) * this.yForwad) >> 14) + this.m_yVel;
                this.m_bReversing = true;
                this.m_bBreaking = false;
            } else if (this.nForwardDot > 0) {
                int i6 = ((i * 4) * (-this.m_nAccelerateTimer)) >> 10;
                if (i6 > this.nForwardDot) {
                    i6 = this.nForwardDot;
                }
                this.m_xVel -= (this.xForwad * i6) >> 14;
                this.m_yVel -= (i6 * this.yForwad) >> 14;
            } else if (this.nForwardDot < 0) {
                int i7 = ((i * 4) * (-this.m_nAccelerateTimer)) >> 10;
                if (i7 > (-this.nForwardDot)) {
                    i7 = -this.nForwardDot;
                }
                this.m_xVel += (this.xForwad * i7) >> 14;
                this.m_yVel = ((i7 * this.yForwad) >> 14) + this.m_yVel;
            }
            int i8 = ((this.m_xVel * this.xRight) + (this.m_yVel * this.yRight)) >> 14;
            if (i8 <= 0) {
                int i9 = (this.m_nHandling * i) >> 3;
                int i10 = i9 > (-i8) ? -i8 : i9;
                this.m_xVel += (this.xRight * i10) >> 14;
                this.m_yVel = ((i10 * this.yRight) >> 14) + this.m_yVel;
                return;
            }
            int i11 = (this.m_nHandling * i) >> 3;
            if (i11 <= i8) {
                i8 = i11;
            }
            this.m_xVel -= (this.xRight * i8) >> 14;
            this.m_yVel -= (i8 * this.yRight) >> 14;
        }

        void PlayerSteering(int i) {
            if (this.m_nLastWheelCount < 2) {
                this.m_zAngVel = (this.m_zAngVel * (this.this$0.exp_Array[(-((-i) * 8)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 8)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 8)) >> 8]) * ((-((-i) * 8)) - ((-((-i) * 8)) & (-256)))) >> 8))) >> 16;
                return;
            }
            int i2 = this.m_nAccelerateTimer <= 0 ? 20 + ((((-this.m_nAccelerateTimer) >> 4) * 12) >> 6) : 20;
            int iCalcPlayerMaxTurningAngle = calcPlayerMaxTurningAngle();
            if ((this.this$0.game_nKeyFlags & 96) != 0) {
                if (this.m_zAngVel < 0) {
                    iCalcPlayerMaxTurningAngle -= this.m_zAngVel * 2;
                }
                if (iCalcPlayerMaxTurningAngle > 16384) {
                    iCalcPlayerMaxTurningAngle = 16384;
                }
                this.m_zSteeringAng -= iCalcPlayerMaxTurningAngle;
                this.m_zSteeringAng = (this.m_zSteeringAng * (this.this$0.exp_Array[(-((-i) * i2)) >> 8] + (((this.this$0.exp_Array[((-((-i) * i2)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * i2)) >> 8]) * ((-((-i) * i2)) - ((-((-i) * i2)) & (-256)))) >> 8))) >> 16;
                this.m_zSteeringAng += iCalcPlayerMaxTurningAngle;
            }
            if ((this.this$0.game_nKeyFlags & 384) != 0) {
                if (this.m_zAngVel > 0) {
                    iCalcPlayerMaxTurningAngle += this.m_zAngVel * 2;
                }
                int i3 = iCalcPlayerMaxTurningAngle <= 16384 ? iCalcPlayerMaxTurningAngle : 16384;
                this.m_zSteeringAng += i3;
                this.m_zSteeringAng = ((((((-((-i) * i2)) - ((-(i2 * (-i))) & (-256))) * (this.this$0.exp_Array[((-((-i) * i2)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * i2)) >> 8])) >> 8) + this.this$0.exp_Array[(-((-i) * i2)) >> 8]) * this.m_zSteeringAng) >> 16;
                this.m_zSteeringAng -= i3;
            }
            if ((this.this$0.game_nKeyFlags & 480) == 0) {
                this.m_zSteeringAng = (this.m_zSteeringAng * (this.this$0.exp_Array[(-((-i) * 24)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 24)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 24)) >> 8]) * ((-((-i) * 24)) - ((-((-i) * 24)) & (-256)))) >> 8))) >> 24;
            }
            this.m_zAngVel -= this.m_zSteeringAng;
            this.m_zAngVel = (this.m_zAngVel * (this.this$0.exp_Array[(-((-i) * 75)) >> 8] + (((this.this$0.exp_Array[((-((-i) * 75)) >> 8) + 1] - this.this$0.exp_Array[(-((-i) * 75)) >> 8]) * ((-((-i) * 75)) - ((-((-i) * 75)) & (-256)))) >> 8))) >> 16;
            if (this.m_zAngVel > 0) {
                this.m_zAngVel -= i * 4;
                if (this.m_zAngVel < 0) {
                    this.m_zAngVel = 0;
                }
            } else {
                this.m_zAngVel += i * 4;
                if (this.m_zAngVel > 0) {
                    this.m_zAngVel = 0;
                }
            }
            this.m_zAngVel += this.m_zSteeringAng;
            applyPlayerSlidingForce(i);
        }

        public void RealizeNewTransform(int i, int i2) {
            this.m_camDist = Math.abs(this.m_xPos - this.this$0.game_posX) + Math.abs(this.m_yPos - this.this$0.game_posY) + Math.abs(this.m_zPos - this.this$0.game_posZ);
            this.m_xAng += this.m_xAngVel * i;
            this.m_yAng += this.m_yAngVel * i;
            this.m_zAng += this.m_zAngVel * i;
            this.rotation.setIdentity();
            this.rotation.postTranslate(this.m_xPos * 0.00390625f, this.m_zPos * 0.00390625f, this.m_yPos * 0.00390625f);
            this.rotation.postRotate(this.m_zAng * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
            this.rotation.postRotate(this.m_xAng * 2.1457672E-5f, 1.0f, 0.0f, 0.0f);
            this.rotation.postRotate(this.m_yAng * 2.1457672E-5f, 0.0f, 0.0f, 1.0f);
            if (this.m_nDamagedLevel >= 51200) {
                this.m_xAng += 8388608;
                this.m_xAng &= 16777215;
                this.m_xAng -= 8388608;
                this.m_yAng += 8388608;
                this.m_yAng &= 16777215;
                this.m_yAng -= 8388608;
                return;
            }
            if (this.m_xAng > 2097152) {
                this.m_xAng = 2097152;
            } else if (this.m_xAng < -2097152) {
                this.m_xAng = -2097152;
            }
            if (this.m_yAng > 2097152) {
                this.m_yAng = 2097152;
            } else if (this.m_yAng < -2097152) {
                this.m_yAng = -2097152;
            }
        }

        public void SetAppearance(NFSMW_CarAppearance nFSMW_CarAppearance, int i, boolean z) {
            if (z) {
                this.m_ca = new NFSMW_CarAppearance(this.this$0, nFSMW_CarAppearance);
            } else {
                this.m_ca = nFSMW_CarAppearance;
            }
            this.m_nCA = i;
            AdjustCarStats();
        }

        public void UpdatePhysics(int i, int i2) {
            InitPhysicsVariables();
            if (this.m_bDisabled) {
                this.m_nSortDistance = Integer.MAX_VALUE;
                return;
            }
            this.m_nStateTime += i;
            this.m_nTimeNotVisable += i;
            this.m_nTimeSinceSpawn += i;
            this.m_ca.m_wheelAngle += this.nForwardDot;
            if (this.m_velocityMax < this.nForwardDot) {
                this.m_velocityMax = this.nForwardDot;
            }
            this.m_velocityLastFrame = this.nForwardDot;
            this.m_distanceMovedLastFrame = (-(this.nForwardDot * i)) / 8388608.0f;
            if (GetMPH() > this.m_nHighestRaceSpeed) {
                this.m_nHighestRaceSpeed = GetMPH();
            }
            this.m_nAverageSpeed = ((this.m_nAverageSpeed * 224) + (this.nForwardDot * 32)) >> 8;
            UpdatePhysics_RaceSpecifics(i, i2);
            UpdatePositionOnAiSpline(i);
            UpdatePhysics_SortCarsOnSpline();
            UpdatePhysics_CarsSplineDirection();
            if (this.m_bPlayer) {
                PlayerSteering(i);
            } else {
                AISteering(i);
            }
            if (this.m_nLastWheelCount >= 2) {
                if (this.m_bPlayer) {
                    PlayerAcceleration(i);
                } else {
                    AIAcceleration(i);
                }
            }
            UpdatePhysics_Other();
            this.m_nSlideOutDisableForCollision -= i;
            if (this.m_nSlideOutDisableForCollision < 0) {
                this.m_nSlideOutDisableForCollision = 0;
            }
        }

        void UpdatePhysics_CarsSplineDirection() {
            if (this.m_bGoingBackward) {
                this.nxAI = -this.nxAI;
                this.nyAI = -this.nyAI;
                this.nCrossAI = -this.nCrossAI;
                this.nAngleAI += 32768;
                this.m_nCrossAI = -this.m_nCrossAI;
                this.m_nAverageSplineMovementSpeed = (this.m_nAverageSplineMovementSpeed * 200) + ((((this.m_xVel * this.nxAI) + (this.m_yVel * this.nyAI)) >> 10) * 56);
                this.m_nAverageSplineMovementSpeed >>= 8;
                if (this.m_nAverageSplineMovementSpeed > 64) {
                    this.m_bGoingBackward = false;
                }
            } else {
                this.m_nAverageSplineMovementSpeed = (this.m_nAverageSplineMovementSpeed * 200) + ((((this.m_xVel * this.nxAI) + (this.m_yVel * this.nyAI)) >> 10) * 56);
                this.m_nAverageSplineMovementSpeed >>= 8;
                if (this.m_nAverageSplineMovementSpeed < -64) {
                    this.m_bGoingBackward = true;
                }
            }
            if (this.m_bReverseTrack) {
                this.nxAI = -this.nxAI;
                this.nyAI = -this.nyAI;
                this.nCrossAI = -this.nCrossAI;
                this.nAngleAI += 32768;
            }
            this.nAngleAI &= 65535;
        }

        void UpdatePhysics_Other() {
            int i = this.m_xVel - this.xOldVel;
            int i2 = this.m_yVel - this.yOldVel;
            this.m_xAngVel = ((((this.xForwad * i) + (this.yForwad * i2)) >> 14) << 1) + this.m_xAngVel;
            this.m_yAngVel -= (((i * this.xRight) + (i2 * this.yRight)) >> 14) >> 1;
            this.m_ca.m_lightAngle = this.m_zAng & 16777215;
        }

        void UpdatePhysics_RaceSpecifics(int i, int i2) {
            if (this.this$0.g_race.m_type == 1) {
                if (this.m_nCurCheckpoint < this.this$0.track_checkpoints.length) {
                    int i3 = (this.this$0.track_checkpoints[this.m_nCurCheckpoint][0] << 4) - this.m_xPos;
                    int i4 = (this.this$0.track_checkpoints[this.m_nCurCheckpoint][1] << 4) - this.m_yPos;
                    if ((Math.abs(i3) + Math.abs(i4)) - (Math.min(Math.abs(i3), Math.abs(i4)) >> 1) < 6400) {
                        this.m_nCurCheckpoint++;
                        this.m_nCheckpointTime = this.this$0.game_Time;
                        if (!this.m_bPlayer || this.m_nCurCheckpoint >= this.this$0.track_checkpoints.length) {
                            return;
                        }
                        this.this$0.game_popupText(this.this$0.g_Text[184], false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.m_bPlayer && (this.this$0.g_race.m_type == 0 || this.this$0.g_race.m_type == 2)) {
                HandleHeatRating();
                return;
            }
            if (this.this$0.g_race.m_type != 3) {
                if (this.this$0.g_race.m_type == 4 && this.m_bPlayer && this.this$0.game_state != 5) {
                    int i5 = 10000;
                    for (int i6 = 1; i6 < this.this$0.g_race.m_numRacers; i6++) {
                        if (this.this$0.players[i6].m_nPlayerDist < i5) {
                            i5 = this.this$0.players[i6].m_nPlayerDist;
                        }
                    }
                    if (i5 > this.this$0.g_missions[this.this$0.g_race.m_nMissionID].m_nreqScore) {
                        this.this$0.game_EndRace();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.m_nCurCheckpoint < this.this$0.track_checkpoints.length) {
                int i7 = (this.this$0.track_checkpoints[this.m_nCurCheckpoint][0] << 4) - this.m_xPos;
                int i8 = (this.this$0.track_checkpoints[this.m_nCurCheckpoint][1] << 4) - this.m_yPos;
                if ((Math.abs(i7) + Math.abs(i8)) - (Math.min(Math.abs(i7), Math.abs(i8)) >> 1) < 6400) {
                    this.m_nCurCheckpoint++;
                    this.m_nCheckpointTime = this.this$0.game_Time;
                    if (this.m_bPlayer) {
                        this.this$0.showFlashEffect = true;
                        if (GetMPH() <= this.this$0.g_race.m_nSpeedLimit) {
                            if (this.m_nCurCheckpoint < this.this$0.track_checkpoints.length) {
                                this.this$0.game_popupText(this.this$0.g_Text[192], false);
                            }
                        } else {
                            this.m_nSpeedingScore += GetMPH() - this.this$0.g_missions[this.this$0.g_race.m_nMissionID].m_nreqChkpSpeed;
                            if (this.m_nCurCheckpoint < this.this$0.track_checkpoints.length) {
                                this.this$0.game_popupText(new StringBuffer().append("").append(GetMPH() - this.this$0.g_missions[this.this$0.g_race.m_nMissionID].m_nreqChkpSpeed).toString(), false);
                            }
                        }
                    }
                }
            }
        }

        void UpdatePhysics_SortCarsOnSpline() {
            if (this.m_bTraffic) {
                setTrafficSortDistance();
            } else {
                this.m_nSortDistance = this.m_nAiNode - this.this$0.players[0].m_nAiNode;
            }
            if (this.m_nSortDistance > (this.m_aiSpline.length >> 1)) {
                this.m_nSortDistance -= this.m_aiSpline.length;
            } else if (this.m_nSortDistance < ((-this.m_aiSpline.length) >> 1)) {
                this.m_nSortDistance += this.m_aiSpline.length;
            }
        }

        void UpdatePlayerTrackCollision(int i) {
            int i2;
            if (this.m_bPlayer) {
                int i3 = -(this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_zAng >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_zAng >> 8) >> 8) & 255]) * ((this.m_zAng >> 8) - ((this.m_zAng >> 8) & (-256)))) >> 8));
                int i4 = (((this.this$0.sin_Array[((((this.m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.m_zAng >> 8) + 49152) - (((this.m_zAng >> 8) + 49152) & (-256)))) >> 8) + this.this$0.sin_Array[(((this.m_zAng >> 8) + 49152) >> 8) & 255];
                int i5 = -i3;
                this.m_tempColResult.f0x = this.m_colResult[0].f0x;
                this.m_tempColResult.f1y = this.m_colResult[0].f1y;
                this.m_tempColResult.f2z = this.m_colResult[0].f2z;
                this.m_tempColResult.nTriangleID = this.m_colResult[0].nTriangleID;
                this.this$0.groundCollision.TestPointForCollision(this.m_colResult[1].f0x, this.m_colResult[1].f1y, this.m_tempColResult);
                if (this.m_tempColResult.f0x == this.m_colResult[1].f0x && this.m_tempColResult.f1y == this.m_colResult[1].f1y) {
                    i2 = 0;
                } else {
                    this.m_xVel -= ((i3 * 10) * i) >> 14;
                    this.m_yVel -= ((i4 * 10) * i) >> 14;
                    i2 = 1;
                }
                this.m_tempColResult.f0x = this.m_colResult[2].f0x;
                this.m_tempColResult.f1y = this.m_colResult[2].f1y;
                this.m_tempColResult.f2z = this.m_colResult[2].f2z;
                this.m_tempColResult.nTriangleID = this.m_colResult[2].nTriangleID;
                this.this$0.groundCollision.TestPointForCollision(this.m_colResult[3].f0x, this.m_colResult[3].f1y, this.m_tempColResult);
                if (this.m_tempColResult.f0x != this.m_colResult[3].f0x || this.m_tempColResult.f1y != this.m_colResult[3].f1y) {
                    this.m_xVel = (((i3 * 10) * i) >> 14) + this.m_xVel;
                    this.m_yVel += ((i4 * 10) * i) >> 14;
                    i2 |= 2;
                }
                this.m_tempColResult.f0x = this.m_colResult[0].f0x;
                this.m_tempColResult.f1y = this.m_colResult[0].f1y;
                this.m_tempColResult.f2z = this.m_colResult[0].f2z;
                this.m_tempColResult.nTriangleID = this.m_colResult[0].nTriangleID;
                this.this$0.groundCollision.TestPointForCollision(this.m_colResult[2].f0x, this.m_colResult[2].f1y, this.m_tempColResult);
                if (this.m_tempColResult.f0x != this.m_colResult[2].f0x || this.m_tempColResult.f1y != this.m_colResult[2].f1y) {
                    this.m_xVel += ((i4 * 10) * i) >> 14;
                    this.m_yVel += ((i5 * 10) * i) >> 14;
                    i2 |= 4;
                }
                this.m_tempColResult.f0x = this.m_colResult[1].f0x;
                this.m_tempColResult.f1y = this.m_colResult[1].f1y;
                this.m_tempColResult.f2z = this.m_colResult[1].f2z;
                this.m_tempColResult.nTriangleID = this.m_colResult[1].nTriangleID;
                this.this$0.groundCollision.TestPointForCollision(this.m_colResult[3].f0x, this.m_colResult[3].f1y, this.m_tempColResult);
                if (this.m_tempColResult.f0x != this.m_colResult[3].f0x || this.m_tempColResult.f1y != this.m_colResult[3].f1y) {
                    this.m_xVel -= ((i4 * 10) * i) >> 14;
                    this.m_yVel -= ((i5 * 10) * i) >> 14;
                    i2 |= 8;
                }
                if (i2 == 0) {
                    this.this$0.g_nTimePlayerStuck = 0;
                    return;
                }
                this.this$0.g_nTimePlayerStuck += i;
                if (this.this$0.g_nTimePlayerStuck > 4000) {
                    this.m_xPos = this.m_aiSpline[this.m_nAiNode][0] << 4;
                    this.m_yPos = (-this.m_aiSpline[this.m_nAiNode][1]) << 4;
                    InitCollisionToSplinePos(this.m_nAiNode);
                }
            }
        }

        void UpdatePositionOnAiSpline(int i) {
            if (this.m_bGoingBackward) {
                UpdatePositionOnAiSpline_backwards(i);
            } else {
                UpdatePositionOnAiSpline_Forwards(i);
            }
            this.nAngleAI += 16384;
        }

        void UpdatePositionOnAiSpline_Forwards(int i) {
            int i2;
            int i3;
            int i4;
            int i5 = 0;
            while (true) {
                i2 = this.m_nAiNode + 1;
                if (i2 >= this.m_aiSpline.length) {
                    i2 = 0;
                }
                i3 = this.m_xPos - (this.m_aiSpline[i2][0] << 4);
                i4 = this.m_yPos - (this.m_aiSpline[i2][1] << 4);
                this.nAngleAI = this.m_aiSpline[this.m_nAiNode][2] & 65535;
                this.nyAI = (-this.this$0.sin_Array[((-this.nAngleAI) >> 8) & 255]) >> 4;
                this.nxAI = this.this$0.sin_Array[(((-this.nAngleAI) >> 8) + 192) & 255] >> 4;
                this.nDotAI = (this.nxAI * i3) + (this.nyAI * i4);
                if (this.nDotAI < 0 || i5 > 0) {
                    break;
                }
                i5++;
                this.m_nAiNode = i2;
                if (i2 == 0 && this.this$0.game_state == 2) {
                    UpdatePositionOnAiSpline_Forwards_NextSplinePoint();
                }
            }
            this.nCrossAI = ((this.nyAI * i3) - (this.nxAI * i4)) >> 10;
            this.m_nCrossAI = this.nCrossAI;
            UpdatePositionOnAiSpline_Forwards_SplineSwapping(i);
            int i6 = ((this.m_xPos - (this.m_aiSpline[this.m_nAiNode][0] << 4)) * this.nxAI) + ((this.m_yPos - (this.m_aiSpline[this.m_nAiNode][1] << 4)) * this.nyAI);
            this.m_nCurrentSplineDistance = (i6 << 4) / (((-this.nDotAI) + i6) >> 10);
            if (this.m_bPlayer) {
                setPlayerTargetAngle(this.m_nAiNode, true);
            } else {
                UpdatePositionOnAiSpline_Forwards_LookAhead(this.aiSpline2, i6, i2);
            }
            this.aiSpline2 = (short[][]) null;
        }

        void UpdatePositionOnAiSpline_Forwards_LookAhead(short[][] sArr, int i, int i2) {
            int i3 = (this.nForwardDot * 200) >> 8;
            int i4 = this.nForwardDot >> 12;
            int i5 = i3 - (i4 << 12);
            if (i4 < 0) {
                i4 = 0;
                i5 = 0;
            }
            int i6 = this.m_nAiNode + i4;
            int i7 = this.m_nAiNode + 1 + i4;
            int length = i6 >= this.m_aiSpline.length ? i6 - this.m_aiSpline.length : i6;
            int length2 = i7 >= this.m_aiSpline.length ? i7 - this.m_aiSpline.length : i7;
            this.nAngleAI = sArr[length][2] & 65535;
            int i8 = sArr[length2][2] & 65535;
            if (i8 - this.nAngleAI > 32768) {
                i8 -= 65536;
            }
            if (i8 - this.nAngleAI < -32768) {
                i8 += 65536;
            }
            this.nAngleAI = (((i8 - this.nAngleAI) * (((((((-this.nDotAI) + i) * i5) >> 12) + i) << 4) / (((-this.nDotAI) + i) >> 10))) >> 14) + this.nAngleAI;
            int length3 = i2 + 5;
            if (length3 >= this.m_aiSpline.length) {
                length3 -= this.m_aiSpline.length;
            }
            this.nAngleAIDiff = ((sArr[this.m_nAiNode][2] & 65535) - (sArr[length3][2] & 65535)) & 65535;
            if (this.nAngleAIDiff > 32768) {
                this.nAngleAIDiff -= 65536;
            } else if (this.nAngleAIDiff < -32768) {
                this.nAngleAIDiff += 65536;
            }
        }

        void UpdatePositionOnAiSpline_Forwards_NextSplinePoint() {
            if (this.m_nCopNum != 0 || this.m_nID < 0) {
                return;
            }
            this.m_nLap++;
            if (this.this$0.g_race.m_type != 1 && this.this$0.g_race.m_type != 3) {
                this.m_nCheckpointTime = this.this$0.game_Time;
            }
            if (this.m_bPlayer) {
                this.this$0.g_race.m_nLastLapTime = (this.this$0.game_Time - 5000) - this.this$0.g_race.m_nLastLapTime;
                if (this.this$0.g_race.m_nFastestLapTime > this.this$0.g_race.m_nLastLapTime || this.this$0.g_race.m_nFastestLapTime == 0) {
                    this.this$0.g_race.m_nFastestLapTime = this.this$0.g_race.m_nLastLapTime;
                }
            }
            if (this.this$0.g_race.m_type != 2) {
                if (this.this$0.g_race.m_numRacers <= 1 || this.m_nLap >= this.this$0.g_race.m_laps) {
                    return;
                }
                CalculateTimeDiff();
                return;
            }
            int i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < this.this$0.g_race.m_numRacers; i3++) {
                if (!this.this$0.players[i3].m_bDisabled && this.this$0.players[i3].m_nID != this.m_nID && this.this$0.players[i3].m_nLap < this.m_nLap) {
                    i2++;
                    i = this.this$0.players[i3].m_nID;
                }
            }
            if (i2 == 1) {
                if (this.this$0.players[i].m_bPlayer) {
                    this.this$0.game_EndRace();
                } else {
                    this.this$0.players[i].m_bDisabled = true;
                    this.this$0.game_popupText(this.this$0.g_Text[183], false);
                }
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.this$0.g_race.m_numRacers; i5++) {
                if (!this.this$0.players[i5].m_bDisabled) {
                    i4++;
                }
            }
            if (i4 == 1) {
                this.this$0.game_EndRace();
            }
        }

        void UpdatePositionOnAiSpline_Forwards_SplineSwapping(int i) {
            int i2;
            if (this.m_aiSpline != this.this$0.track_splines[0]) {
                this.aiSpline2 = this.m_aiSpline;
                return;
            }
            this.aiSpline2 = this.this$0.track_splines[1];
            short s = this.aiSpline2[this.m_nAiNode][2];
            int i3 = (((this.m_xPos - (this.aiSpline2[this.m_nAiNode][0] << 4)) * ((-this.this$0.sin_Array[((-s) >> 8) & 255]) >> 4)) - ((this.this$0.sin_Array[(((-s) >> 8) + 192) & 255] >> 4) * (this.m_yPos - (this.aiSpline2[this.m_nAiNode][1] << 4)))) >> 10;
            this.m_nTimeSinceLastSplineSwap += i;
            if (Math.abs(this.nCrossAI - i3) < 100) {
                i2 = this.m_nTimeSinceLastSplineSwap <= 2000 ? 300 : 100;
                if (this.m_nTimeSinceLastSplineSwap > 4000) {
                    i2 = 0;
                }
            } else {
                i2 = 300;
            }
            if (this.m_bUsingSecondarySpline) {
                if (Math.abs(this.nCrossAI) >= Math.abs(i3) - i2) {
                    this.aiSpline2 = this.this$0.track_splines[1];
                    this.nCrossAI = i3;
                    return;
                } else {
                    this.m_bUsingSecondarySpline = false;
                    this.aiSpline2 = this.this$0.track_splines[0];
                    this.m_nTimeSinceLastSplineSwap = 0;
                    return;
                }
            }
            if (Math.abs(i3) >= Math.abs(this.nCrossAI) - i2) {
                this.aiSpline2 = this.this$0.track_splines[0];
                return;
            }
            this.m_bUsingSecondarySpline = true;
            this.aiSpline2 = this.this$0.track_splines[1];
            this.m_nTimeSinceLastSplineSwap = 0;
            this.nCrossAI = i3;
        }

        void UpdatePositionOnAiSpline_backwards(int i) {
            int length;
            int i2;
            int i3;
            int i4 = 0;
            while (true) {
                length = this.m_nAiNode - 1;
                if (length <= 0) {
                    length = this.m_aiSpline.length - 1;
                }
                i2 = this.m_xPos - (this.m_aiSpline[length][0] << 4);
                i3 = this.m_yPos - (this.m_aiSpline[length][1] << 4);
                this.nAngleAI = (this.m_aiSpline[length][2] + Short.MIN_VALUE) & 65535;
                this.nyAI = (-this.this$0.sin_Array[((-this.nAngleAI) >> 8) & 255]) >> 4;
                this.nxAI = this.this$0.sin_Array[(((-this.nAngleAI) >> 8) + 192) & 255] >> 4;
                this.nDotAI = (this.nxAI * i2) + (this.nyAI * i3);
                if (this.nDotAI < 0 || i4 > 0) {
                    break;
                }
                i4++;
                this.m_nAiNode = length;
                if (length == this.m_aiSpline.length - 1) {
                    this.m_nLap--;
                }
            }
            this.nCrossAI = ((this.nyAI * i2) - (this.nxAI * i3)) >> 10;
            this.m_nCrossAI = this.nCrossAI;
            int i5 = ((this.m_xPos - (this.m_aiSpline[this.m_nAiNode][0] << 4)) * this.nxAI) + ((this.m_yPos - (this.m_aiSpline[this.m_nAiNode][1] << 4)) * this.nyAI);
            this.m_nCurrentSplineDistance = (i5 << 4) / (((-this.nDotAI) + i5) >> 10);
            if (this.m_bPlayer) {
                setPlayerTargetAngle(length, false);
            } else {
                setAITargetAngle(i5, length);
            }
        }

        public void UpdateTrackCollision(int i, int i2) {
            boolean z;
            if (this.m_bDisabled) {
                return;
            }
            int i3 = this.m_xVel;
            int i4 = this.m_yVel;
            if (this.m_nTimeNotVisable > 3000) {
                trackCollision_doCheapUpdate(i);
                return;
            }
            if (this.m_bCheapUpdate) {
                this.m_bCheapUpdate = false;
                z = true;
            } else {
                z = false;
            }
            this.m_zVel -= (i * 3584) >> 10;
            this.m_zPos += (this.m_zVel * i) >> 10;
            this.rotation.get(this.rotationArray);
            int i5 = (int) (this.rotationArray[8] * 65536.0f);
            int i6 = (int) ((-this.rotationArray[10]) * 65536.0f);
            int i7 = -((int) (this.rotationArray[6] * 65536.0f));
            int i8 = (int) (this.rotationArray[0] * 65536.0f);
            int i9 = (int) ((-this.rotationArray[2]) * 65536.0f);
            int i10 = (int) (this.rotationArray[4] * 65536.0f);
            int i11 = this.rotationArray[5] < 0.0f ? ((int) (this.rotationArray[5] * (-350.0f))) + 70 : 70;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = this.m_xPos + ((this.m_xVel * i) >> 10);
            int i19 = 0;
            int i20 = this.m_yPos + ((this.m_yVel * i) >> 10);
            while (i19 < 4) {
                this.this$0.g_nParam1 = i12;
                this.this$0.g_nParam2 = i13;
                this.this$0.g_nParam3 = i14;
                trackCollision_setWheelPositions(i19, i11, i5, i6, i7, i8, i9, i10);
                i12 = this.this$0.g_nParam1;
                i13 = this.this$0.g_nParam2;
                i14 = this.this$0.g_nParam3;
                this.zWheelForce[i19] = 0;
                int i21 = i18 + i12;
                int i22 = i20 + i13;
                this.this$0.groundCollision.TestPointForCollision(i21 << 8, (-i22) << 8, this.m_colResult[i19]);
                if (this.m_colResult[i19].nTriangleID != -1) {
                    int i23 = this.m_colResult[i19].f2z >> 8;
                    if (i14 < i23) {
                        i16++;
                        if ((this.m_colResult[i19].nAttribute & 57344) != 0) {
                            i23 += 40;
                        }
                        this.zWheelForce[i19] = i23 - i14;
                        if ((this.m_colResult[i19].nAttribute & 0) != 0) {
                            int[] iArr = this.zWheelForce;
                            iArr[i19] = iArr[i19] + (((this.this$0.sin_Array[(((((this.m_xPos + this.m_yPos) * 1000) + 67108864) >> 8) >> 8) & 255] + (((this.this$0.sin_Array[((((((this.m_xPos + this.m_yPos) * 1000) + 67108864) >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[(((((this.m_xPos + this.m_yPos) * 1000) + 67108864) >> 8) >> 8) & 255]) * (((((this.m_xPos + this.m_yPos) * 1000) + 67108864) >> 8) - (((((this.m_xPos + this.m_yPos) * 1000) + 67108864) >> 8) & (-256)))) >> 8)) * 64) >> 14);
                        }
                    }
                    i17++;
                    i15 += i23;
                    int i24 = (i21 << 8) - this.m_colResult[i19].f0x;
                    int i25 = (i22 << 8) + this.m_colResult[i19].f1y;
                    int i26 = ((i24 >> 6) * i2) >> 8;
                    int i27 = ((i25 >> 6) * i2) >> 8;
                    this.m_xVel -= i26;
                    this.m_yVel -= i27;
                    if ((i26 != 0 || i27 != 0) && this.m_velocityLastFrame > 1000) {
                        AddSparks(this.m_colResult[i19].f0x, -this.m_colResult[i19].f1y, this.m_zPos << 8);
                    }
                    trackCollision_AddAngularForce(i24, i25, i12, i13);
                }
                i18 = this.m_xPos + ((this.m_xVel * i) >> 10);
                i20 = ((this.m_yVel * i) >> 10) + this.m_yPos;
                i19++;
                i17 = i17;
            }
            this.m_xPos = i18;
            this.m_yPos = i20;
            if (z) {
                this.m_xVel = i3;
                this.m_yVel = i4;
            }
            CalculateSuspension(i, i2, i17, i16, i15);
            this.rotation.setIdentity();
            this.rotation.postTranslate(this.m_xPos * 0.00390625f, this.m_zPos * 0.00390625f, this.m_yPos * 0.00390625f);
            this.rotation.postRotate(this.m_zAng * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
            this.rotation.postRotate(this.m_xAng * 2.1457672E-5f, 1.0f, 0.0f, 0.0f);
            this.rotation.postRotate(this.m_yAng * 2.1457672E-5f, 0.0f, 0.0f, 1.0f);
            UpdatePlayerTrackCollision(i);
        }

        void addAngularCollisionForce(Car car, Car car2, int i, int i2, int i3) {
            if (car.m_nCopNum == 0) {
                car.m_nSlideOutDisableForCollision = 1024;
            }
            if (car2.m_nCopNum == 0) {
                car2.m_nSlideOutDisableForCollision = 1024;
            }
            if (car2.m_bPlayer && car.m_nCopNum != 0) {
                car.m_zAngVel += (((i2 * i) >> 8) * 3) >> 2;
                car2.m_zAngVel -= (((i3 * i) >> 8) * 1) >> 2;
            } else if (!car.m_bPlayer || car2.m_nCopNum == 0) {
                car.m_zAngVel += (i2 * i) >> 8;
                car2.m_zAngVel -= (i3 * i) >> 8;
            } else {
                car.m_zAngVel += (((i2 * i) >> 8) * 1) >> 2;
                car2.m_zAngVel -= (((i3 * i) >> 8) * 3) >> 2;
            }
        }

        void addLinearCollisionForce(Car car, Car car2, int i, int i2, int i3) {
            if (car.m_nCopNum == 0) {
                car.m_nSlideOutDisableForCollision = 1024;
            }
            if (car2.m_nCopNum == 0) {
                car2.m_nSlideOutDisableForCollision = 1024;
            }
            if (car2.m_bPlayer && car.m_nCopNum != 0) {
                car.m_xVel -= (((this.xNormal * i) >> 15) * 3) >> 2;
                car.m_yVel -= (((this.yNormal * i) >> 15) * 3) >> 2;
                car2.m_xVel += ((this.xNormal * i) >> 15) >> 2;
                car2.m_yVel += ((this.yNormal * i) >> 15) >> 2;
                return;
            }
            if (!car.m_bPlayer || car2.m_nCopNum == 0) {
                car.m_xVel -= (this.xNormal * i) >> 15;
                car.m_yVel -= (this.yNormal * i) >> 15;
                car2.m_xVel += (this.xNormal * i) >> 15;
                car2.m_yVel += (this.yNormal * i) >> 15;
                return;
            }
            car.m_xVel -= ((this.xNormal * i) >> 15) >> 2;
            car.m_yVel -= ((this.yNormal * i) >> 15) >> 2;
            car2.m_xVel += (((this.xNormal * i) >> 15) * 3) >> 2;
            car2.m_yVel += (((this.yNormal * i) >> 15) * 3) >> 2;
        }

        void applyAISlidingForce(int i) {
            int i2 = 16384;
            int i3 = (this.nSideDot * 80) >> 8;
            if (i3 <= 16384) {
                i2 = i3 < -16384 ? -16384 : i3;
            }
            this.m_zAngVel -= ((((i2 * (1024 - this.m_nSlideOutDisableForCollision)) >> 10) * i) * 25) >> 11;
        }

        void applyPlayerSlidingForce(int i) {
            int i2 = 16384;
            int i3 = (this.nSideDot * 80) >> 8;
            if (i3 <= 16384) {
                i2 = i3 < -16384 ? -16384 : i3;
            }
            this.m_zAngVel -= ((((i2 * (1024 - this.m_nSlideOutDisableForCollision)) >> 10) * i) * 25) >> 11;
        }

        int calcAIMaxTurningAngle(int i) {
            int iAbs = (1104000 - (Math.abs(this.nForwardDot) * 44)) >> 8;
            if (iAbs > 16384) {
                iAbs = 16384;
            }
            if (this.m_bBreaking) {
                iAbs += iAbs >> 9;
            }
            if (iAbs > 16384) {
                iAbs = 16384;
            }
            if (this.m_nCopNum != 0 && Math.abs(i) > 32768 && (iAbs = iAbs * 3) > 16384) {
                iAbs = 16384;
            }
            int iAbs2 = Math.abs(this.nForwardDot >> 2);
            if (iAbs2 > 256) {
                iAbs2 = 256;
            }
            return (iAbs * iAbs2) >> 8;
        }

        void calcCollisionA1(Car car, Car car2, int i, int i2) {
            int i3 = this.xCollisionExpandA + this.nAngOffset1 + this.nAngOffset2;
            int i4 = (this.this$0.sin_Array[(((car2.m_zAng - car.m_zAng) >> 16) & 127) + 64] * 290) >> 14;
            if (this.xPosBInASpace < 0) {
                i3 = -i3;
                i4 = -i4;
                this.xNormal = i;
                this.yNormal = i2;
            } else {
                this.xNormal = -i;
                this.yNormal = -i2;
            }
            this.xColPos = car2.m_xPos + (((i * i3) - (i2 * i4)) >> 14);
            this.yColPos = (((i4 * i) + (i3 * i2)) >> 14) + car2.m_yPos;
            this.nIntersection = this.xDistA;
            this.nCollisionExpand = this.xCollisionExpandA;
        }

        void calcCollisionA2(Car car, Car car2, int i, int i2) {
            int i3 = this.yCollisionExpandA + this.nAngOffset1 + this.nAngOffset3;
            int i4 = (this.this$0.sin_Array[((((car.m_zAng - car2.m_zAng) >> 16) + 64) & 127) + 64] * 290) >> 14;
            if (this.yPosBInASpace < 0) {
                i3 = -i3;
                i4 = -i4;
                this.xNormal = -i2;
                this.yNormal = i;
            } else {
                this.xNormal = i2;
                this.yNormal = -i;
            }
            this.xColPos = car2.m_xPos + (((i * i4) - (i2 * i3)) >> 14);
            this.yColPos = (((i4 * i2) + (i3 * i)) >> 14) + car2.m_yPos;
            this.nIntersection = this.yDistA;
            this.nCollisionExpand = this.yCollisionExpandA;
        }

        void calcCollisionB1(Car car, Car car2, int i, int i2) {
            int i3 = this.xCollisionExpandB + this.nAngOffset1 + this.nAngOffset2;
            int i4 = (this.this$0.sin_Array[(((car.m_zAng - car2.m_zAng) >> 16) & 127) + 64] * 290) >> 14;
            if (this.xPosAInBSpace < 0) {
                i3 = -i3;
                i4 = -i4;
                this.xNormal = i;
                this.yNormal = i2;
            } else {
                this.xNormal = -i;
                this.yNormal = -i2;
            }
            this.xNormal = -this.xNormal;
            this.yNormal = -this.yNormal;
            this.xColPos = car.m_xPos + (((i * i3) - (i2 * i4)) >> 14);
            this.yColPos = (((i4 * i) + (i3 * i2)) >> 14) + car.m_yPos;
            this.nIntersection = this.xDistB;
            this.nCollisionExpand = this.xCollisionExpandB;
        }

        void calcCollisionB2(Car car, Car car2, int i, int i2) {
            int i3 = this.yCollisionExpandB + this.nAngOffset1 + this.nAngOffset3;
            int i4 = (this.this$0.sin_Array[((((car2.m_zAng - car.m_zAng) >> 16) + 64) & 127) + 64] * 290) >> 14;
            if (this.yPosAInBSpace < 0) {
                i3 = -i3;
                i4 = -i4;
                this.xNormal = -i2;
                this.yNormal = i;
            } else {
                this.xNormal = i2;
                this.yNormal = -i;
            }
            this.xNormal = -this.xNormal;
            this.yNormal = -this.yNormal;
            this.xColPos = car.m_xPos + (((i * i4) - (i2 * i3)) >> 14);
            this.yColPos = (((i4 * i2) + (i3 * i)) >> 14) + car.m_yPos;
            this.nIntersection = this.yDistB;
            this.nCollisionExpand = this.yCollisionExpandB;
        }

        int calcPlayerMaxTurningAngle() {
            int i = 256;
            int iAbs = (((1104000 - (Math.abs(this.nForwardDot) * 44)) >> 8) * this.m_nHandling) >> 6;
            if (iAbs > 16384) {
                iAbs = 16384;
            }
            int i2 = this.nForwardDot >> 2;
            if (i2 <= 256) {
                i = i2 < -256 ? -256 : i2;
            }
            int i3 = (iAbs * i) >> 8;
            if (this.m_nAccelerateTimer > 0 || (i3 = i3 + ((((-this.m_nAccelerateTimer) >> 4) * i3) >> 7)) <= 16384) {
                return i3;
            }
            return 16384;
        }

        public String constructTimeString(int i, boolean z) {
            String string = z ? "-" : "+";
            int iAbs = Math.abs(i);
            int i2 = (iAbs / 1000) % 60;
            int i3 = iAbs / 60000;
            int i4 = iAbs - ((60000 * i3) + (i2 * 1000));
            if (i3 < 10) {
                string = new StringBuffer().append(string).append("0").toString();
            }
            String string2 = new StringBuffer().append(string).append(i3).append(":").toString();
            if (i2 < 10) {
                string2 = new StringBuffer().append(string2).append("0").toString();
            }
            String string3 = new StringBuffer().append(string2).append(i2).append(":").toString();
            if (i4 < 10) {
                string3 = new StringBuffer().append(string3).append("0").toString();
            }
            return new StringBuffer().append(string3).append(i4).toString();
        }

        int getDistanceToClosestCarInFront() {
            int length = this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_nAiNode - this.m_nAiNode;
            if (length < 0) {
                length += this.m_aiSpline.length;
            }
            return (length << 8) + ((this.this$0.sortedCarsList[this.m_nSortedPos + 1].m_nCurrentSplineDistance - this.m_nCurrentSplineDistance) >> 6);
        }

        int getDistanceToPlayer() {
            int length = this.this$0.players[0].m_nAiNode - this.m_nAiNode;
            if (length < ((-this.m_aiSpline.length) >> 1)) {
                length += this.m_aiSpline.length;
            } else if (length > (this.m_aiSpline.length >> 1)) {
                length -= this.m_aiSpline.length;
            }
            return (length << 8) + ((this.this$0.players[0].m_nCurrentSplineDistance - this.m_nCurrentSplineDistance) >> 6);
        }

        int getOverTakingOffset(int i, int i2) {
            if (this.m_nOverTackingAngleOffset < i2) {
                this.m_nOverTackingAngleOffset += i << 1;
                if (this.m_nOverTackingAngleOffset > i2) {
                    this.m_nOverTackingAngleOffset = i2;
                }
            } else if (this.m_nOverTackingAngleOffset > i2) {
                this.m_nOverTackingAngleOffset -= i << 1;
                if (this.m_nOverTackingAngleOffset < i2) {
                    this.m_nOverTackingAngleOffset = i2;
                }
            }
            return this.m_nOverTackingAngleOffset;
        }

        public void playEngineSound() {
        }

        public void render() {
            if (this.m_bDisabled || this.m_camDist >= 15000 || this.m_bNearCulled) {
                return;
            }
            this.m_nTimeNotVisable = 0;
            if (this.m_bCheapUpdate) {
                InitCollisionToSplinePosWhileMoving(this.m_nAiNode);
                this.rotation.setIdentity();
                this.rotation.postTranslate(this.m_xPos * 0.00390625f, this.m_zPos * 0.00390625f, this.m_yPos * 0.00390625f);
                this.rotation.postRotate(this.m_zAng * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
                this.rotation.postRotate(this.m_xAng * 2.1457672E-5f, 1.0f, 0.0f, 0.0f);
                this.rotation.postRotate(this.m_yAng * 2.1457672E-5f, 0.0f, 0.0f, 1.0f);
            }
            this.m_ca.m_carMesh.setTransform(this.rotation);
            this.m_ca.render(this.rotation, this, this.m_camDist < 5000, this.m_bBreaking, this.m_bReversing);
        }

        public void renderAlpha() {
            if (this.m_bDisabled || this.m_camDist >= 15000 || this.m_bNearCulled) {
                return;
            }
            for (int i = 0; i < this.m_carSparks.length; i++) {
                if (this.m_carSparks[i].timer > this.this$0.game_Time) {
                    float f = (4.0f - ((this.m_carSparks[i].timer - this.this$0.game_Time) / 125.0f)) / 2.0f;
                    this.tmpTrans.setIdentity();
                    this.tmpTrans.postTranslate(this.m_carSparks[i].f6x, this.m_carSparks[i].f7y, this.m_carSparks[i].f8z);
                    this.tmpTrans.postScale(f, f, f);
                    this.this$0.scene_g3d.render(this.this$0.sparks_sprite, this.tmpTrans);
                }
            }
            this.m_ca.renderAlpha(this.rotation, this);
        }

        public void renderShadow() {
            if (this.m_bDisabled) {
                return;
            }
            this.m_bNearCulled = ((-(this.this$0.sin_Array[((this.this$0.game_cameraAngZ >> 8) >> 8) & 255] + (((this.this$0.sin_Array[(((this.this$0.game_cameraAngZ >> 8) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.this$0.game_cameraAngZ >> 8) >> 8) & 255]) * ((this.this$0.game_cameraAngZ >> 8) - ((this.this$0.game_cameraAngZ >> 8) & (-256)))) >> 8))) * (this.m_xPos - this.this$0.game_posX)) + ((this.this$0.sin_Array[(((this.this$0.game_cameraAngZ >> 8) + 49152) >> 8) & 255] + (((this.this$0.sin_Array[((((this.this$0.game_cameraAngZ >> 8) + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[(((this.this$0.game_cameraAngZ >> 8) + 49152) >> 8) & 255]) * (((this.this$0.game_cameraAngZ >> 8) + 49152) - (((this.this$0.game_cameraAngZ >> 8) + 49152) & (-256)))) >> 8)) * (this.m_yPos - this.this$0.game_posY)) < -25165824;
            if (this.m_camDist >= 8000 || this.m_bNearCulled) {
                return;
            }
            this.positionsData[0] = (short) (this.m_colResult[0].f0x >> 10);
            this.positionsData[1] = (short) ((this.m_colResult[0].f2z >> 10) + 4);
            this.positionsData[2] = (short) ((-this.m_colResult[0].f1y) >> 10);
            this.positionsData[3] = (short) (this.m_colResult[1].f0x >> 10);
            this.positionsData[4] = (short) ((this.m_colResult[1].f2z >> 10) + 4);
            this.positionsData[5] = (short) ((-this.m_colResult[1].f1y) >> 10);
            this.positionsData[6] = (short) (this.m_colResult[2].f0x >> 10);
            this.positionsData[7] = (short) ((this.m_colResult[2].f2z >> 10) + 4);
            this.positionsData[8] = (short) ((-this.m_colResult[2].f1y) >> 10);
            this.positionsData[9] = (short) (this.m_colResult[3].f0x >> 10);
            this.positionsData[10] = (short) ((this.m_colResult[3].f2z >> 10) + 4);
            this.positionsData[11] = (short) ((-this.m_colResult[3].f1y) >> 10);
            this.positions.set(0, 4, this.positionsData);
            this.this$0.scene_g3d.render(this.vertexBuffer, this.indexBuffer, this.this$0.shadowAppearance, (Transform) null);
        }

        void setAITargetAngle(int i, int i2) {
            int i3 = (this.nForwardDot * 200) >> 8;
            int i4 = this.nForwardDot >> 12;
            int i5 = i3 - (i4 << 12);
            if (i4 < 0) {
                i4 = 0;
                i5 = 0;
            }
            int length = (this.m_nAiNode - 1) - i4;
            int length2 = (this.m_nAiNode - 2) - i4;
            if (length < 0) {
                length += this.m_aiSpline.length;
            }
            if (length2 < 0) {
                length2 += this.m_aiSpline.length;
            }
            this.nAngleAI = (this.m_aiSpline[length][2] + Short.MIN_VALUE) & 65535;
            int i6 = (this.m_aiSpline[length2][2] + Short.MIN_VALUE) & 65535;
            if (i6 - this.nAngleAI > 32768) {
                i6 -= 65536;
            }
            if (i6 - this.nAngleAI < -32768) {
                i6 += 65536;
            }
            this.nAngleAI = (((i6 - this.nAngleAI) * (((((i5 * ((-this.nDotAI) + i)) >> 12) + i) << 4) / (((-this.nDotAI) + i) >> 10))) >> 14) + this.nAngleAI;
            int length3 = i2 - 5;
            if (length3 < 0) {
                length3 += this.m_aiSpline.length;
            }
            this.nAngleAIDiff = ((this.m_aiSpline[this.m_nAiNode][2] & 65535) - (this.m_aiSpline[length3][2] & 65535)) & 65535;
            if (this.nAngleAIDiff > 32768) {
                this.nAngleAIDiff -= 65536;
            } else if (this.nAngleAIDiff < -32768) {
                this.nAngleAIDiff += 65536;
            }
        }

        void setPlayerTargetAngle(int i, boolean z) {
            if (z) {
                this.nAngleAI = this.m_aiSpline[i][2] & 65535;
            } else {
                this.nAngleAI = (this.m_aiSpline[i][2] + Short.MIN_VALUE) & 65535;
            }
            int length = i + 7;
            if (length >= this.m_aiSpline.length) {
                length -= this.m_aiSpline.length;
            }
            this.this$0.game_xArrowPos = this.m_aiSpline[length][0] << 4;
            this.this$0.game_yArrowPos = this.m_aiSpline[length][1] << 4;
        }

        void setTrafficSortDistance() {
            short s = this.m_aiSpline[this.m_nAiNode][4];
            int i = s;
            if (s < 0) {
                i = (-s) - 1;
            }
            this.m_nSortDistance = i - this.this$0.players[0].m_nAiNode;
            short s2 = this.this$0.track_splines[0][i][2];
            this.m_nCrossAI = (((this.m_xPos - (this.this$0.track_splines[0][i][0] << 4)) * ((-this.this$0.sin_Array[((-s2) >> 8) & 255]) >> 4)) - ((this.m_yPos - (this.this$0.track_splines[0][i][1] << 4)) * (this.this$0.sin_Array[(((-s2) >> 8) + 192) & 255] >> 4))) >> 10;
            this.m_nCurrentSplineDistance = 0;
        }

        void trackCollision_AddAngularForce(int i, int i2, int i3, int i4) {
            int i5 = (((i2 >> 8) * i3) - ((i >> 8) * i4)) >> 6;
            if (i5 > 0) {
                this.m_nSlideOutDisableForCollision = 1024;
                if (this.m_nLastWheelCount < 0 || this.m_zAngVel >= i5) {
                    return;
                }
                this.m_zAngVel = i5;
                return;
            }
            if (i5 < 0) {
                this.m_nSlideOutDisableForCollision = 1024;
                if (this.m_nLastWheelCount < 0 || this.m_zAngVel <= i5) {
                    return;
                }
                this.m_zAngVel = i5;
            }
        }

        void trackCollision_doCheapUpdate(int i) {
            this.m_bCheapUpdate = true;
            this.m_zVel = 0;
            this.m_xPos += (this.m_xVel * i) >> 10;
            this.m_yPos += (this.m_yVel * i) >> 10;
            this.m_nLastAverageCount = 0;
            this.m_zLastAveragePos = 0;
            this.m_nLastWheelCount = 4;
            this.m_xAngVel = 0;
            this.m_yAngVel = 0;
            this.m_xAng = 0;
            this.m_yAng = 0;
            this.rotation.setIdentity();
            this.rotation.postTranslate(this.m_xPos * 0.00390625f, this.m_zPos * 0.00390625f, this.m_yPos * 0.00390625f);
            this.rotation.postRotate(this.m_zAng * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
            this.rotation.postRotate(this.m_xAng * 2.1457672E-5f, 1.0f, 0.0f, 0.0f);
            this.rotation.postRotate(this.m_yAng * 2.1457672E-5f, 0.0f, 0.0f, 1.0f);
        }

        void trackCollision_setWheelPositions(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            int i11;
            int i12 = this.this$0.g_nParam1;
            int i13 = this.this$0.g_nParam2;
            int i14 = this.this$0.g_nParam3;
            switch (i) {
                case 0:
                    i9 = ((i3 * 580) + (i6 * 210)) >> 16;
                    i10 = ((i4 * 580) + (i7 * 210)) >> 16;
                    i11 = ((i5 * 580) + (i8 * 210)) >> 16;
                    break;
                case 1:
                    i9 = ((i3 * 580) + (i6 * (-210))) >> 16;
                    i10 = ((i4 * 580) + (i7 * (-210))) >> 16;
                    i11 = ((i5 * 580) + (i8 * (-210))) >> 16;
                    break;
                case 2:
                    i9 = ((i3 * (-580)) + (i6 * 210)) >> 16;
                    i10 = ((i4 * (-580)) + (i7 * 210)) >> 16;
                    i11 = ((i5 * (-580)) + (i8 * 210)) >> 16;
                    break;
                default:
                    i9 = ((i3 * (-580)) + (i6 * (-210))) >> 16;
                    i10 = ((i4 * (-580)) + (i7 * (-210))) >> 16;
                    i11 = ((i5 * (-580)) + (i8 * (-210))) >> 16;
                    break;
            }
            int i15 = i11 + (this.m_zPos - i2);
            this.this$0.g_nParam1 = i9;
            this.this$0.g_nParam2 = i10;
            this.this$0.g_nParam3 = i15;
        }
    }

    class MenuFriendly {
        public int m_cmd;
        public int m_icon;
        public int m_title;
        public int m_type;
        private final TheGame this$0;

        public MenuFriendly(TheGame theGame, int i, int i2, int i3, int i4) {
            this.this$0 = theGame;
            this.m_title = i;
            this.m_type = i2;
            this.m_cmd = i3;
            this.m_icon = i4;
        }
    }

    class MintMesh {
        Mesh m_mesh;
        String m_meshName;
        String m_textureName;
        private final TheGame this$0;

        MintMesh(TheGame theGame) {
            this.this$0 = theGame;
        }
    }

    class NDInputStream extends InputStream {
        public int buffersize;
        public int current;
        byte[] internal;
        public int stid;
        private final TheGame this$0;
        public int total;

        public NDInputStream(TheGame theGame, byte[] bArr) {
            this.this$0 = theGame;
            this.total = bArr.length;
            this.internal = new byte[this.total];
            System.arraycopy(bArr, 0, this.internal, 0, this.total);
            this.stid = -1;
            this.current = 0;
        }

        public NDInputStream(TheGame theGame, byte[] bArr, int i, int i2) {
            this.this$0 = theGame;
            this.internal = new byte[i2];
            System.arraycopy(bArr, i, this.internal, 0, i2);
            this.stid = -1;
            this.current = 0;
        }

        @Override // java.io.InputStream
        public int available() {
            int i = this.total - this.current;
            if (i <= 0) {
                return 0;
            }
            return i;
        }

        public void copy(byte[] bArr) {
            this.total = bArr.length;
            System.arraycopy(bArr, 0, this.internal, 0, this.total);
            this.current = 0;
        }

        public void copy(byte[] bArr, int i, int i2) {
            System.arraycopy(bArr, i, this.internal, 0, i2);
            this.current = 0;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.current >= this.total) {
                return -1;
            }
            byte b = this.internal[this.current];
            this.current++;
            return b;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            this.buffersize = bArr.length;
            if (this.current >= this.total) {
                return -1;
            }
            int i3 = this.current;
            int i4 = this.current + i2;
            if (i4 > this.total) {
                i4 = this.total;
            }
            System.arraycopy(this.internal, i3, bArr, i, i4 - i3);
            this.current = i4;
            return i4 - i3;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.current = 0;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            return 0L;
        }
    }

    class NFSMW_CarAppearance extends MenuFriendly {
        public boolean m_bUseingLowLOD;
        public int[] m_baseStats;
        float[][] m_carLightPos;
        public Mesh m_carMesh;
        float[] m_carSpoilerPos;
        float[][] m_carStreakPos;
        float[][] m_carStreakPosOffset;
        float[][] m_carWheelPos;
        public Image2D m_img2D;
        public Image m_imgClean;
        public boolean m_isTrafficCar;
        public int m_lightAngle;
        public int[] m_modStats;
        public String m_modelName;
        public byte[] m_parts;
        public int m_pointsID;
        public Mesh m_reflectionMesh;
        public boolean m_refreshSpoiler;
        public boolean m_refreshTexture;
        public boolean m_refreshWheels;
        public Mesh m_spoilerMesh;
        public Appearance m_streakAppearance;
        public TriangleStripArray m_streakIndexBuffer;
        public Mesh m_streakMesh;
        public Appearance m_streakNitroAppearance;
        public Texture2D m_streakNitroTexture;
        public Texture2D m_streakTexture;
        public VertexBuffer m_streakVertices;
        public Texture2D m_texture;
        public int m_wheelAngle;
        public Mesh m_wheelMesh;
        int[] m_yStreakTranslation;
        int m_zStreakAngle;
        private final TheGame this$0;
        Transform tmpTrans;

        public NFSMW_CarAppearance(TheGame theGame, int i, int i2, int i3, String str, int i4, int[] iArr, boolean z) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_yStreakTranslation = new int[2];
            this.tmpTrans = new Transform();
            this.m_parts = new byte[17];
            this.m_baseStats = new int[4];
            this.m_modStats = new int[4];
            this.m_carWheelPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 4, 4);
            this.m_carLightPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 4, 3);
            this.m_carSpoilerPos = new float[3];
            this.m_carStreakPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 3);
            this.m_carStreakPosOffset = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 2);
            this.m_modelName = str;
            this.m_pointsID = i4;
            for (int i5 = 0; i5 < 17; i5++) {
                this.m_parts[i5] = 0;
            }
            for (int i6 = 0; i6 < 4; i6++) {
                int[] iArr2 = this.m_modStats;
                int[] iArr3 = this.m_baseStats;
                int i7 = iArr[i6];
                iArr3[i6] = i7;
                iArr2[i6] = i7;
            }
            this.m_wheelMesh = null;
            this.m_reflectionMesh = null;
            this.m_carMesh = null;
            this.m_imgClean = null;
            this.m_isTrafficCar = z;
            if (theGame.g_carGfxHi == null) {
                theGame.g_carGfxHi = theGame.g_carImgHi.getGraphics();
            }
            if (theGame.g_carGfxLow == null) {
                theGame.g_carGfxLow = theGame.g_carImgLow.getGraphics();
            }
            if (theGame.g_carGfxTraffic == null) {
                theGame.g_carGfxTraffic = theGame.g_carImgTraffic.getGraphics();
            }
        }

        public NFSMW_CarAppearance(TheGame theGame, NFSMW_CarAppearance nFSMW_CarAppearance) {
            super(theGame, nFSMW_CarAppearance.m_title, nFSMW_CarAppearance.m_type, nFSMW_CarAppearance.m_cmd, nFSMW_CarAppearance.m_icon);
            this.this$0 = theGame;
            this.m_yStreakTranslation = new int[2];
            this.tmpTrans = new Transform();
            this.m_parts = new byte[17];
            this.m_baseStats = new int[4];
            this.m_modStats = new int[4];
            this.m_carWheelPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 4, 4);
            this.m_carLightPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 4, 3);
            this.m_carSpoilerPos = new float[3];
            this.m_carStreakPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 3);
            this.m_carStreakPosOffset = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 2);
            copy(nFSMW_CarAppearance);
        }

        void ApplyBumpers(Graphics graphics) {
            if (this.m_parts[8] != 0) {
                try {
                    Graphics graphics2 = TheGame.m_CurrentGraphics;
                    TheGame.m_CurrentGraphics = graphics;
                    this.this$0.g_carParts[8][this.m_parts[8]].drawPartImg(this.m_bUseingLowLOD);
                    graphics.setClip(0, 0, this.this$0.g_carImgHi.getWidth(), this.this$0.g_carImgHi.getHeight());
                    TheGame.m_CurrentGraphics = graphics2;
                } catch (Error e) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1368, e.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1368, e2.toString());
                }
            }
            if (this.m_parts[9] != 0) {
                try {
                    Graphics graphics3 = TheGame.m_CurrentGraphics;
                    TheGame.m_CurrentGraphics = graphics;
                    this.this$0.g_carParts[9][this.m_parts[9]].drawPartImg(this.m_bUseingLowLOD);
                    graphics.setClip(0, 0, this.this$0.g_carImgHi.getWidth(), this.this$0.g_carImgHi.getHeight());
                    TheGame.m_CurrentGraphics = graphics3;
                } catch (Error e3) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1385, e3.toString());
                } catch (Exception e4) {
                    e4.printStackTrace();
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1385, e4.toString());
                }
            }
        }

        void ApplyVinyl(Graphics graphics) {
            if (this.m_parts[5] == 0) {
                return;
            }
            try {
                Graphics graphics2 = TheGame.m_CurrentGraphics;
                TheGame.m_CurrentGraphics = graphics;
                this.this$0.g_carParts[5][this.m_parts[5]].drawPartImg(this.m_bUseingLowLOD);
                graphics.setClip(0, 0, this.this$0.g_carImgHi.getWidth(), this.this$0.g_carImgHi.getHeight());
                TheGame.m_CurrentGraphics = graphics2;
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1349, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1349, e2.toString());
            }
        }

        int HSLtoRGB(int i, int i2, int i3) {
            int iHue_2_RGB;
            int iHue_2_RGB2;
            int iHue_2_RGB3;
            if (i2 == 0) {
                iHue_2_RGB3 = i3;
                iHue_2_RGB2 = i3;
                iHue_2_RGB = i3;
            } else {
                int i4 = i3 < 128 ? ((i2 + 255) * i3) >> 8 : (i3 + i2) - ((i2 * i3) >> 8);
                int i5 = (i3 * 2) - i4;
                iHue_2_RGB = Hue_2_RGB(i5, i4, i + 85);
                iHue_2_RGB2 = Hue_2_RGB(i5, i4, i);
                iHue_2_RGB3 = Hue_2_RGB(i5, i4, i - 85);
            }
            return iHue_2_RGB3 | (iHue_2_RGB2 << 8) | (iHue_2_RGB << 16);
        }

        int Hue_2_RGB(int i, int i2, int i3) {
            int i4 = i3 < 0 ? i3 + 256 : i3;
            if (i4 > 256) {
                i4 -= 256;
            }
            if (i4 * 6 < 256) {
                return i + ((i4 * ((i2 - i) * 6)) >> 8);
            }
            if (i4 * 2 < 256) {
                return i2;
            }
            if (i4 * 3 < 512) {
                return i + ((((170 - i4) * (i2 - i)) * 6) >> 8);
            }
            return i;
        }

        void PaintCar(int[] iArr, int[] iArr2, boolean z) {
            char c;
            int length = iArr.length;
            byte b = this.m_parts[1];
            byte b2 = this.m_parts[2];
            byte b3 = this.m_parts[3];
            String str = this.this$0.g_carParts[0][this.m_parts[0]].m_partName;
            int[] iArr3 = null;
            if (!z && str.length() > 0) {
                Image imageScene_LoadTexImage = this.this$0.scene_LoadTexImage(new StringBuffer().append("/").append(str).append(".png").toString());
                if (imageScene_LoadTexImage == null) {
                    return;
                }
                iArr3 = new int[imageScene_LoadTexImage.getWidth() * imageScene_LoadTexImage.getHeight()];
                imageScene_LoadTexImage.getRGB(iArr3, 0, imageScene_LoadTexImage.getWidth(), 0, 0, imageScene_LoadTexImage.getWidth(), imageScene_LoadTexImage.getHeight());
            }
            int[] iArr4 = new int[3];
            int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 3);
            int[] iArr6 = new int[3];
            RGBtoHSL(iArr4, (16711680 & iArr2[0]) >> 16, (65280 & iArr2[0]) >> 8, iArr2[0] & 255);
            RGBtoHSL(iArr5[0], (16711680 & this.this$0.stockColors[b]) >> 16, (65280 & this.this$0.stockColors[b]) >> 8, this.this$0.stockColors[b] & 255);
            RGBtoHSL(iArr5[1], (16711680 & this.this$0.stockColors[b2]) >> 16, (65280 & this.this$0.stockColors[b2]) >> 8, this.this$0.stockColors[b2] & 255);
            RGBtoHSL(iArr5[2], (16711680 & this.this$0.stockColors[b3]) >> 16, (65280 & this.this$0.stockColors[b3]) >> 8, this.this$0.stockColors[b3] & 255);
            int[] iArr7 = {(iArr5[0][1] + 255) - iArr4[1], (iArr5[1][1] + 255) - iArr4[1], (iArr5[2][1] + 255) - iArr4[1]};
            int[] iArr8 = {(iArr5[0][2] + 255) - iArr4[2], (iArr5[1][2] + 255) - iArr4[2], (iArr5[2][2] + 255) - iArr4[2]};
            char c2 = 0;
            int i = this.m_bUseingLowLOD ? 2 : 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = (16711680 & iArr[i2]) >> 16;
                int i4 = (65280 & iArr[i2]) >> 8;
                int i5 = iArr[i2] & 255;
                int i6 = (16711680 & iArr2[i2]) >> 16;
                int i7 = (65280 & iArr2[i2]) >> 8;
                int i8 = iArr2[i2] & 255;
                if (iArr3 != null) {
                    int i9 = iArr3[i2 * i] & 16777215;
                    if (i9 == 16777215) {
                        c = 0;
                    } else {
                        c = i9 == 0 ? (char) 2 : (char) 1;
                    }
                } else {
                    c = c2;
                }
                if (i7 > i6 * 2) {
                    RGBtoHSL(iArr6, i6, i7, i8);
                    int i10 = (iArr6[1] * iArr7[c]) >> 8;
                    if (i10 > 255) {
                        i10 = 255;
                    }
                    int i11 = (iArr6[2] * iArr8[c]) >> 8;
                    if (i11 > 255) {
                        i11 = 255;
                    }
                    iArr[i2] = HSLtoRGB(iArr5[c][0], i10, i11) | (-16777216);
                }
                i2++;
                c2 = c;
            }
        }

        void RGBtoHSL(int[] iArr, int i, int i2, int i3) {
            int i4;
            int i5;
            int iMin = Math.min(i, Math.min(i2, i3));
            int iMax = Math.max(i, Math.max(i2, i3));
            int i6 = iMax - iMin;
            int i7 = (iMax + iMin) / 2;
            if (i6 == 0) {
                i4 = 0;
                i5 = 0;
            } else {
                i4 = i7 < 128 ? (i6 << 8) / (iMin + iMax) : (i6 << 8) / ((512 - iMax) - iMin);
                int i8 = ((((iMax - i) >> 3) + (i6 >> 1)) << 8) / i6;
                int i9 = ((((iMax - i2) >> 3) + (i6 >> 1)) << 8) / i6;
                int i10 = ((((iMax - i3) >> 3) + (i6 >> 1)) << 8) / i6;
                if (i == iMax) {
                    i5 = i10 - i9;
                } else if (i2 == iMax) {
                    i5 = (i8 + 85) - i10;
                } else {
                    i5 = i3 == iMax ? (i9 + 170) - i8 : 0;
                }
                if (i5 < 0) {
                    i5 += 256;
                }
                if (i5 > 256) {
                    i5 -= 256;
                }
            }
            iArr[0] = i5;
            iArr[1] = i4;
            iArr[2] = i7;
        }

        void TintWindows(int[] iArr, int[] iArr2) {
            int[] iArr3;
            int[] iArr4 = null;
            if (0 == 0) {
                Image imageScene_LoadTexImage = this.this$0.scene_LoadTexImage("/window_tint.png");
                int[] iArr5 = new int[imageScene_LoadTexImage.getWidth() * imageScene_LoadTexImage.getHeight()];
                imageScene_LoadTexImage.getRGB(iArr5, 0, imageScene_LoadTexImage.getWidth(), 0, 0, imageScene_LoadTexImage.getWidth(), imageScene_LoadTexImage.getHeight());
                iArr4 = iArr5;
            }
            if (0 == 0) {
                Image imageScene_LoadTexImage2 = this.this$0.scene_LoadTexImage("/window_tint_lod.png");
                iArr3 = new int[imageScene_LoadTexImage2.getWidth() * imageScene_LoadTexImage2.getHeight()];
                imageScene_LoadTexImage2.getRGB(iArr3, 0, imageScene_LoadTexImage2.getWidth(), 0, 0, imageScene_LoadTexImage2.getWidth(), imageScene_LoadTexImage2.getHeight());
            } else {
                iArr3 = null;
            }
            if (this.m_parts[4] == 0) {
                return;
            }
            if (!this.m_bUseingLowLOD) {
                iArr3 = iArr4;
            }
            int length = iArr.length;
            int i = this.this$0.stockColors[this.m_parts[4]];
            int i2 = (16711680 & i) >> 16;
            int i3 = (65280 & i) >> 8;
            int i4 = i & 255;
            for (int i5 = 0; i5 < length; i5++) {
                if ((16777215 & iArr3[i5]) == 0) {
                    int i6 = (16711680 & iArr[i5]) >> 16;
                    int i7 = (65280 & iArr[i5]) >> 8;
                    int i8 = iArr[i5] & 255;
                    int i9 = (16711680 & iArr2[i5]) >> 16;
                    int i10 = (65280 & iArr2[i5]) >> 8;
                    int i11 = iArr2[i5] & 255;
                    if (i10 < (i9 << 1)) {
                        int i12 = (i9 * i2) >> 7;
                        int i13 = (i10 * i3) >> 7;
                        int i14 = (i11 * i4) >> 7;
                        if (i12 > 255) {
                            i12 = 255;
                        }
                        if (i13 > 255) {
                            i13 = 255;
                        }
                        if (i14 > 255) {
                            i14 = 255;
                        }
                        iArr[i5] = (i14 & 255) | ((i13 << 8) & 65280) | ((i12 << 16) & 16711680) | (-16777216);
                    }
                }
            }
        }

        void calcStats() {
            for (int i = 0; i < 4; i++) {
                this.m_modStats[i] = this.m_baseStats[i];
                for (int i2 = 0; i2 < 17; i2++) {
                    int[] iArr = this.m_modStats;
                    iArr[i] = iArr[i] + this.this$0.g_carParts[i2][this.m_parts[i2]].m_stats[i];
                }
                if (this.m_modStats[i] < 0) {
                    this.m_modStats[i] = 0;
                } else if (this.m_modStats[i] > this.this$0.stats_max[i]) {
                    this.m_modStats[i] = this.this$0.stats_max[i];
                }
            }
        }

        public void constructCar(boolean z) {
            Image image;
            try {
                if (this.m_carMesh == null || this.m_bUseingLowLOD != z || z) {
                    while (this.this$0.scene_BuildCar(this, z, this.m_isTrafficCar)) {
                    }
                    this.m_refreshTexture = true;
                    this.m_refreshWheels = true;
                    this.m_refreshSpoiler = true;
                    this.m_bUseingLowLOD = z;
                }
                if (this.m_refreshTexture && this.m_carMesh != null) {
                    int i = this.m_bUseingLowLOD ? 2 : 1;
                    if (this.m_bUseingLowLOD) {
                        int[] iArr = new int[this.m_imgClean.getWidth() * this.m_imgClean.getHeight()];
                        this.m_imgClean.getRGB(iArr, 0, this.m_imgClean.getWidth(), 0, 0, this.m_imgClean.getWidth(), this.m_imgClean.getHeight());
                        int width = this.this$0.g_carImgLow.getWidth() * this.this$0.g_carImgLow.getHeight();
                        int[] iArr2 = new int[width];
                        for (int i2 = 0; i2 < this.this$0.g_carImgLow.getWidth(); i2++) {
                            for (int i3 = 0; i3 < this.this$0.g_carImgLow.getHeight(); i3++) {
                                iArr2[(this.this$0.g_carImgLow.getWidth() * i3) + i2] = iArr[(this.m_imgClean.getWidth() * i3 * i) + (i2 * i)];
                            }
                        }
                        int[] iArr3 = new int[width];
                        System.arraycopy(iArr2, 0, iArr3, 0, width);
                        TintWindows(iArr2, iArr3);
                        PaintCar(iArr2, iArr3, this.m_isTrafficCar);
                        this.this$0.g_carGfxLow.drawRGB(iArr2, 0, this.this$0.g_carImgLow.getWidth(), 0, 0, this.this$0.g_carImgLow.getWidth(), this.this$0.g_carImgLow.getHeight(), true);
                        ApplyVinyl(this.this$0.g_carGfxLow);
                        image = this.this$0.g_carImgLow;
                    } else {
                        this.this$0.g_carGfxHi.setClip(0, 0, this.m_imgClean.getWidth(), this.m_imgClean.getHeight());
                        this.this$0.g_carGfxHi.drawImage(this.m_imgClean, 0, 0, 20);
                        this.this$0.g_carGfxHi.setClip(0, 0, this.m_imgClean.getWidth(), this.m_imgClean.getHeight());
                        if (!this.m_isTrafficCar) {
                            ApplyBumpers(this.this$0.g_carGfxHi);
                        }
                        int width2 = this.m_imgClean.getWidth() * this.m_imgClean.getHeight();
                        int[] iArr4 = new int[width2];
                        this.this$0.g_carImgHi.getRGB(iArr4, 0, this.m_imgClean.getWidth(), 0, 0, this.m_imgClean.getWidth(), this.m_imgClean.getHeight());
                        int[] iArr5 = new int[width2];
                        System.arraycopy(iArr4, 0, iArr5, 0, width2);
                        if (this.m_isTrafficCar) {
                            PaintCar(iArr4, iArr5, this.m_isTrafficCar);
                            this.this$0.g_carGfxTraffic.drawRGB(iArr4, 0, this.this$0.g_carImgTraffic.getWidth(), 0, 0, this.this$0.g_carImgTraffic.getWidth(), this.this$0.g_carImgTraffic.getHeight(), true);
                            image = this.this$0.g_carImgTraffic;
                        } else {
                            TintWindows(iArr4, iArr5);
                            PaintCar(iArr4, iArr5, this.m_isTrafficCar);
                            this.this$0.g_carGfxHi.drawRGB(iArr4, 0, this.this$0.g_carImgHi.getWidth(), 0, 0, this.this$0.g_carImgHi.getWidth(), this.this$0.g_carImgHi.getHeight(), true);
                            ApplyVinyl(this.this$0.g_carGfxHi);
                            image = this.this$0.g_carImgHi;
                        }
                    }
                    this.m_img2D = new Image2D(99, image);
                    if (this.m_img2D == null) {
                        System.out.println("FAILED TO CREATE IMG");
                        return;
                    }
                    this.m_texture = new Texture2D(this.m_img2D);
                    if (this.m_texture == null) {
                        System.out.println("FAILED TO CREATE TEXTURE");
                        return;
                    }
                    this.m_img2D = null;
                    this.m_texture.setFiltering(208, 210);
                    this.m_texture.setWrapping(241, 241);
                    this.m_texture.setBlending(228);
                    Appearance appearance = this.m_carMesh.getAppearance(0);
                    appearance.setTexture(0, this.m_texture);
                    appearance.setCompositingMode(this.this$0.compositingMode_ZWRITEREAD);
                    this.m_refreshTexture = false;
                    if (this.m_bUseingLowLOD) {
                        this.m_imgClean = null;
                    }
                }
                if (this.m_isTrafficCar) {
                    return;
                }
                if (this.m_refreshWheels && this.m_wheelMesh != null) {
                    String str = this.this$0.g_carParts[7][this.m_parts[7]].m_partName;
                    Texture2D texture2DScene_FindTexture = this.this$0.scene_FindTexture(str);
                    if (texture2DScene_FindTexture == null) {
                        texture2DScene_FindTexture = this.this$0.scene_CreateTexture(str, this.this$0.scene_LoadTexImage(str), true, true);
                    }
                    this.m_wheelMesh.getAppearance(0).setTexture(0, texture2DScene_FindTexture);
                }
                if (this.m_refreshSpoiler && this.m_carMesh != null) {
                    byte b = this.m_parts[6];
                    if (b == 0) {
                        this.m_spoilerMesh = null;
                    } else {
                        while (this.this$0.scene_OpenModel(this.this$0.g_carParts[6][b].m_partName, 4, true)) {
                        }
                        this.m_spoilerMesh = this.this$0.scene_FindMintMesh(this.this$0.g_carParts[6][b].m_partName)[0].m_mesh.duplicate();
                        Appearance appearance2 = this.m_carMesh.getAppearance(0);
                        Appearance appearanceDuplicate = this.m_spoilerMesh.getAppearance(0).duplicate();
                        appearanceDuplicate.setTexture(0, appearance2.getTexture(0));
                        if (appearanceDuplicate.getPolygonMode() == null) {
                            appearanceDuplicate.setPolygonMode(this.this$0.polygonMode_NoPersp);
                        }
                        PolygonMode polygonModeDuplicate = appearanceDuplicate.getPolygonMode().duplicate();
                        polygonModeDuplicate.setCulling(162);
                        appearanceDuplicate.setPolygonMode(polygonModeDuplicate);
                        this.m_spoilerMesh.setAppearance(0, appearanceDuplicate);
                    }
                }
                this.m_carStreakPosOffset[0] = new float[2];
                this.m_carStreakPosOffset[1] = new float[2];
                this.m_yStreakTranslation[0] = 0;
                this.m_yStreakTranslation[1] = 32768;
                calcStats();
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 948, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 948, e2.toString());
            }
        }

        public void copy(NFSMW_CarAppearance nFSMW_CarAppearance) {
            for (int i = 0; i < 17; i++) {
                this.m_parts[i] = nFSMW_CarAppearance.m_parts[i];
            }
            this.m_modelName = nFSMW_CarAppearance.m_modelName;
            this.m_pointsID = nFSMW_CarAppearance.m_pointsID;
            this.m_refreshSpoiler = true;
            this.m_refreshWheels = true;
            this.m_refreshTexture = true;
            if (nFSMW_CarAppearance.m_carMesh != null) {
                this.m_carMesh = nFSMW_CarAppearance.m_carMesh.duplicate();
            } else {
                this.m_carMesh = null;
            }
            if (nFSMW_CarAppearance.m_reflectionMesh != null) {
                this.m_reflectionMesh = nFSMW_CarAppearance.m_reflectionMesh.duplicate();
            } else {
                this.m_reflectionMesh = null;
            }
            if (nFSMW_CarAppearance.m_wheelMesh != null) {
                this.m_wheelMesh = nFSMW_CarAppearance.m_wheelMesh.duplicate();
            } else {
                this.m_wheelMesh = null;
            }
            if (nFSMW_CarAppearance.m_spoilerMesh != null) {
                this.m_spoilerMesh = nFSMW_CarAppearance.m_spoilerMesh.duplicate();
            } else {
                this.m_spoilerMesh = null;
            }
            if (nFSMW_CarAppearance.m_imgClean != null) {
                this.m_imgClean = Image.createImage(nFSMW_CarAppearance.m_imgClean);
            } else {
                this.m_imgClean = null;
            }
            this.m_bUseingLowLOD = nFSMW_CarAppearance.m_bUseingLowLOD;
            for (int i2 = 0; i2 < 4; i2++) {
                this.m_baseStats[i2] = nFSMW_CarAppearance.m_baseStats[i2];
            }
            for (int i3 = 0; i3 < 4; i3++) {
                this.m_modStats[i3] = nFSMW_CarAppearance.m_modStats[i3];
            }
            this.m_lightAngle = nFSMW_CarAppearance.m_lightAngle;
            this.m_wheelAngle = nFSMW_CarAppearance.m_wheelAngle;
            this.m_carWheelPos = nFSMW_CarAppearance.m_carWheelPos;
            this.m_carLightPos = nFSMW_CarAppearance.m_carLightPos;
            this.m_carSpoilerPos = nFSMW_CarAppearance.m_carSpoilerPos;
            this.m_carStreakPos = nFSMW_CarAppearance.m_carStreakPos;
            this.m_streakVertices = nFSMW_CarAppearance.m_streakVertices;
            this.m_streakIndexBuffer = nFSMW_CarAppearance.m_streakIndexBuffer;
            this.m_streakTexture = nFSMW_CarAppearance.m_streakTexture;
            this.m_streakAppearance = nFSMW_CarAppearance.m_streakAppearance;
            this.m_streakNitroAppearance = nFSMW_CarAppearance.m_streakNitroAppearance;
            this.m_streakNitroTexture = nFSMW_CarAppearance.m_streakNitroTexture;
            this.m_carStreakPosOffset = nFSMW_CarAppearance.m_carStreakPosOffset;
        }

        void free() {
            this.this$0.scene_FreeMintMesh(this.m_modelName);
            this.m_carMesh = null;
            this.m_reflectionMesh = null;
            this.m_wheelMesh = null;
            this.m_streakMesh = null;
            this.m_streakTexture = null;
            this.m_streakNitroTexture = null;
            this.m_streakVertices = null;
            this.m_streakAppearance = null;
            this.m_streakNitroAppearance = null;
            this.m_streakIndexBuffer = null;
            this.m_carStreakPosOffset[0] = null;
            this.m_carStreakPosOffset[1] = null;
            this.m_spoilerMesh = null;
            this.m_imgClean = null;
            this.m_img2D = null;
            this.m_texture = null;
            this.m_bUseingLowLOD = false;
        }

        public boolean isPartInstalled(int i, byte b) {
            return this.m_parts[i] == b;
        }

        public void randomize(int i) {
            for (int i2 = 0; i2 < 17; i2++) {
                if (i2 != 0) {
                    while (true) {
                        this.m_parts[i2] = (byte) Math.abs((this.this$0.system_GetRandom() >> 15) & 127);
                        byte[] bArr = this.m_parts;
                        bArr[i2] = (byte) (bArr[i2] % this.this$0.g_carParts[i2].length);
                        if (i2 != 1) {
                            if (i2 == 5 && this.this$0.system_GetRandom() < 0) {
                                this.m_parts[i2] = 0;
                                break;
                            } else {
                                break;
                                break;
                            }
                        }
                        if (!this.m_isTrafficCar || (this.m_parts[i2] != 0 && this.m_parts[i2] != 12 && this.m_parts[i2] != 13)) {
                            for (int i3 = 0; i3 < i; i3++) {
                                if (this.this$0.players[i3].m_ca.m_parts[i2] == this.m_parts[i2]) {
                                }
                            }
                            break;
                        }
                    }
                    if (this.m_parts[i2] < 0 || this.m_parts[i2] >= this.this$0.g_carParts[i2].length) {
                        System.err.println(new StringBuffer().append("***********   WRONG ").append((int) this.m_parts[i2]).toString());
                    }
                } else {
                    this.m_parts[i2] = 0;
                }
            }
            this.m_refreshWheels = true;
            this.m_refreshTexture = true;
            this.m_refreshSpoiler = true;
        }

        public final boolean render(Transform transform, Car car, boolean z, boolean z2, boolean z3) {
            try {
                if (this.m_carMesh == null) {
                    return false;
                }
                try {
                    this.this$0.scene_g3d.render(this.m_carMesh, transform);
                } catch (Error e) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1053, e.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1053, e2.toString());
                }
                if (!z || this.m_isTrafficCar) {
                    return true;
                }
                int i = this.this$0.game_cameraAngZ & 16777215;
                int i2 = this.m_lightAngle;
                int i3 = this.m_lightAngle - (this.this$0.game_cameraAngZ & 16777215);
                int i4 = i3 > 8388608 ? i3 - 16777216 : i3 < -8388608 ? i3 + 16777216 : i3;
                float fAbs = Math.abs(i4) * 2.1457672E-5f;
                boolean z4 = true;
                boolean z5 = true;
                if ((car != null && car.m_bPlayer) || (this.this$0.scene_nCurrentScene & 4096) != 0) {
                    if (fAbs > -10.0f && fAbs < 10.0f) {
                        z4 = false;
                    } else if (i4 >= 0) {
                        z5 = false;
                    }
                }
                if (z4 && this.m_wheelMesh != null) {
                    if ((car == null || !car.m_bPlayer) && (this.this$0.scene_nCurrentScene & 4096) == 0) {
                        for (int i5 = 0; i5 < 4; i5++) {
                            renderWheel(transform, i5, this.tmpTrans);
                        }
                    } else if (z5) {
                        renderWheel(transform, 1, this.tmpTrans);
                        renderWheel(transform, 3, this.tmpTrans);
                    } else {
                        renderWheel(transform, 0, this.tmpTrans);
                        renderWheel(transform, 2, this.tmpTrans);
                    }
                }
                if (this.m_spoilerMesh != null) {
                    this.tmpTrans.set(transform);
                    this.tmpTrans.postTranslate(this.m_carSpoilerPos[0], this.m_carSpoilerPos[1], this.m_carSpoilerPos[2]);
                    this.this$0.scene_g3d.render(this.m_spoilerMesh, this.tmpTrans);
                }
                if (car != null && car.m_nCopNum != 0) {
                    return true;
                }
                if (this.m_streakVertices != null && car != null && this.m_carStreakPos[0] != null && car.GetMPH() > 60) {
                    int i6 = car.m_velocityLastFrame - 5000;
                    if (car.m_nNitroTimer > 0) {
                        i6 += (2500 - car.m_nNitroTimer) * 2;
                    }
                    if (i6 > 0) {
                        float f = i6 * 2.0E-4f;
                        if (this.m_zStreakAngle - this.m_lightAngle > 8388608) {
                            this.m_zStreakAngle -= 16777216;
                        } else if (this.m_zStreakAngle - this.m_lightAngle < -8388608) {
                            this.m_zStreakAngle += 16777216;
                        }
                        this.m_zStreakAngle -= this.m_lightAngle;
                        this.m_zStreakAngle = ((this.m_zStreakAngle >> 4) * ((this.this$0.exp_Array[3] + (((this.this$0.exp_Array[4] - this.this$0.exp_Array[3]) * 32) >> 8)) >> 4)) >> 8;
                        this.m_zStreakAngle += this.m_lightAngle;
                        Appearance appearance = this.m_streakAppearance;
                        if (car.m_nNitroTimer > 0) {
                            appearance = this.m_streakNitroAppearance;
                        }
                        for (int i7 = 0; i7 < 2; i7++) {
                            this.tmpTrans.set(transform);
                            this.tmpTrans.postTranslate(this.m_carStreakPos[i7][0] + this.m_carStreakPosOffset[i7][0], this.m_carStreakPos[i7][1] + this.m_carStreakPosOffset[i7][1], this.m_carStreakPos[i7][2] - 2.0f);
                            this.tmpTrans.postRotate((this.m_zStreakAngle - this.m_lightAngle) * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
                            this.tmpTrans.postRotate(-(car.m_xAng * 2.1457672E-5f), 1.0f, 0.0f, 0.0f);
                            this.tmpTrans.postScale(f, 1.0f, f);
                            if (this.this$0.game_state != 3) {
                                int[] iArr = this.m_yStreakTranslation;
                                iArr[i7] = iArr[i7] + (((car.m_velocityLastFrame * 20) * 85) >> 12);
                                if (this.m_yStreakTranslation[i7] > 65535) {
                                    this.m_carStreakPosOffset[i7][0] = (this.this$0.system_GetRandom() >> 24) / 512.0f;
                                    this.m_carStreakPosOffset[i7][1] = (this.this$0.system_GetRandom() >> 24) / 512.0f;
                                }
                                int[] iArr2 = this.m_yStreakTranslation;
                                iArr2[i7] = iArr2[i7] & 65535;
                            }
                            appearance.getTexture(0).setTranslation(0.0f, this.m_yStreakTranslation[i7] * (-7.6293945E-6f), 0.0f);
                            appearance.getTexture(0).translate(0.0f, (-car.m_velocityLastFrame) * 4 * 1.0172526E-4f, 0.0f);
                            this.m_streakVertices.setDefaultColor(((((this.this$0.sin_Array[((this.m_yStreakTranslation[i7] + 49152) >> 8) & 255] + (((this.this$0.sin_Array[(((this.m_yStreakTranslation[i7] + 49152) >> 8) + 1) & 255] - this.this$0.sin_Array[((this.m_yStreakTranslation[i7] + 49152) >> 8) & 255]) * ((this.m_yStreakTranslation[i7] + 49152) - ((this.m_yStreakTranslation[i7] + 49152) & (-256)))) >> 8)) >> 7) + 128) << 24) | 16777215);
                            this.this$0.scene_g3d.render(this.m_streakVertices, this.m_streakIndexBuffer, appearance, this.tmpTrans);
                        }
                    }
                }
                if (fAbs < 90.0f) {
                    float f2 = 0.5f * ((60.0f - fAbs) / 60.0f);
                    if (this.this$0.brakelights != null && f2 > 0.0f && z2) {
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[2][0], this.m_carLightPos[2][1], this.m_carLightPos[2][2]);
                        this.tmpTrans.postScale(f2, f2, f2);
                        this.this$0.scene_g3d.render(this.this$0.brakelights, this.tmpTrans);
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[3][0], this.m_carLightPos[3][1], this.m_carLightPos[3][2]);
                        this.tmpTrans.postScale(f2, f2, f2);
                        this.this$0.scene_g3d.render(this.this$0.brakelights, this.tmpTrans);
                    }
                } else if ((this.this$0.scene_nCurrentScene & 4096) == 4096) {
                    float f3 = 0.5f * ((80.0f - (180.0f - fAbs)) / 80.0f);
                    if (this.this$0.headlights != null && f3 > 0.0f) {
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[0][0], this.m_carLightPos[0][1], this.m_carLightPos[0][2]);
                        this.tmpTrans.postScale(f3, f3, f3);
                        this.this$0.scene_g3d.render(this.this$0.headlights, this.tmpTrans);
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[1][0], this.m_carLightPos[1][1], this.m_carLightPos[1][2]);
                        this.tmpTrans.postScale(f3, f3, f3);
                        this.this$0.scene_g3d.render(this.this$0.headlights, this.tmpTrans);
                    }
                }
                return true;
            } catch (Error e3) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1232, e3.toString());
            } catch (Exception e4) {
                e4.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 1232, e4.toString());
            }
        }

        public final boolean renderAlpha(Transform transform, Car car) {
            if (car != null && car.m_ca.m_cmd == 7 && this.this$0.brakelights != null && this.this$0.policelights != null && this.this$0.fire_sprites[0] != null) {
                int iAbs = (Math.abs(car.m_nID) + 1) * 100;
                if (car.m_nDamagedLevel < 38400 || car.m_nCopNum == 0) {
                    boolean z = (((this.this$0.scene_timer + iAbs) >> 7) & 2) == 2;
                    if (this.this$0.game_state == 3) {
                        z = true;
                    }
                    if (z) {
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[2][0], this.m_carLightPos[2][1], this.m_carLightPos[2][2]);
                        this.this$0.scene_g3d.render(this.this$0.policelights, this.tmpTrans);
                    }
                    boolean z2 = this.this$0.game_state == 3 || ((((this.this$0.scene_timer + iAbs) >> 7) + 1) & 2) == 2;
                    if (z2) {
                        this.tmpTrans.set(transform);
                        this.tmpTrans.postTranslate(this.m_carLightPos[3][0], this.m_carLightPos[3][1], this.m_carLightPos[3][2]);
                        this.this$0.scene_g3d.render(this.this$0.brakelights, this.tmpTrans);
                    }
                } else if (car.m_nCopNum > 0) {
                    float f = (car.m_nDamagedLevel - 38400) * 1.953125E-4f;
                    if (f > 2.5f) {
                        f = 2.5f;
                    }
                    this.tmpTrans.set(transform);
                    this.tmpTrans.postTranslate(this.m_carSpoilerPos[0], this.m_carSpoilerPos[1] + (f / 3.0f), this.m_carSpoilerPos[2]);
                    this.tmpTrans.postScale(f, f, f);
                    int i = ((this.this$0.game_Time + iAbs) >> 7) % 3;
                    if (i == 0) {
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[0], this.tmpTrans);
                        this.tmpTrans.postTranslate((this.this$0.game_Time & 15) / 256.0f, 0.0f, 0.0f);
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[1], this.tmpTrans);
                    } else if (i == 1) {
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[1], this.tmpTrans);
                        this.tmpTrans.postTranslate((this.this$0.game_Time & 15) / 256.0f, 0.0f, 0.0f);
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[2], this.tmpTrans);
                    } else if (i == 2) {
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[2], this.tmpTrans);
                        this.tmpTrans.postTranslate((this.this$0.game_Time & 15) / 256.0f, 0.0f, 0.0f);
                        this.this$0.scene_g3d.render(this.this$0.fire_sprites[0], this.tmpTrans);
                    }
                }
            }
            if (this.this$0.showFlashEffect && this.this$0.flash_effect_sprite != null) {
                this.this$0.showFlashEffect = false;
                this.tmpTrans.set(transform);
                this.tmpTrans.postTranslate(0.0f, 2.0f, -5.0f);
                this.tmpTrans.postScale(100.0f, 100.0f, 100.0f);
                this.this$0.scene_g3d.render(this.this$0.flash_effect_sprite, this.tmpTrans);
            }
            return true;
        }

        public void renderWheel(Transform transform, int i, Transform transform2) {
            transform2.set(transform);
            transform2.postTranslate(this.m_carWheelPos[i][0], this.m_carWheelPos[i][1], this.m_carWheelPos[i][2]);
            transform2.postRotate((-this.m_wheelAngle) >> 5, 1.0f, 0.0f, 0.0f);
            if (this.m_carWheelPos[i][0] > 0.0f) {
                transform2.postRotate(180.0f, 0.0f, 1.0f, 0.0f);
            }
            this.this$0.scene_g3d.render(this.m_wheelMesh, transform2);
        }

        public void setPart(int i, byte b) {
            if (this.m_parts[i] != b) {
                setRefresh(i);
                this.m_parts[i] = b;
            }
        }

        public void setParts(byte[] bArr) {
            for (int i = 0; i < 17; i++) {
                if (this.m_parts[i] != bArr[i]) {
                    setRefresh(i);
                    this.m_parts[i] = bArr[i];
                }
            }
        }

        void setRefresh(int i) {
            if (i == 7) {
                this.m_refreshWheels = true;
            } else if (i == 6) {
                this.m_refreshSpoiler = true;
            } else if (i < 10) {
                this.m_refreshTexture = true;
            }
        }

        public void testPart(int i, byte b) {
            setRefresh(i);
            byte b2 = this.m_parts[i];
            this.m_parts[i] = b;
            constructCar(false);
            this.m_parts[i] = b2;
            setRefresh(i);
        }
    }

    class NFSMW_CarPart extends MenuFriendly {
        public boolean m_bLoaded;
        public int m_cost;
        Mesh m_mesh;
        public String m_partName;
        public int m_partVisualID;
        public int m_partVisualID_LOD;
        public int m_repRequired;
        public int[] m_stats;
        private final TheGame this$0;

        public NFSMW_CarPart(TheGame theGame, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_stats = new int[4];
            this.m_icon = getPartIcon(i);
            for (int i8 = 0; i8 < 4; i8++) {
                this.m_stats[i8] = iArr[i8];
            }
            this.m_partName = null;
            this.m_partVisualID = i4;
            this.m_partVisualID_LOD = i5;
            this.m_repRequired = i6;
            this.m_cost = i7;
            this.m_bLoaded = false;
        }

        public NFSMW_CarPart(TheGame theGame, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_stats = new int[4];
            this.m_icon = getPartIcon(i);
            for (int i6 = 0; i6 < 4; i6++) {
                this.m_stats[i6] = iArr[i6];
            }
            this.m_partName = null;
            this.m_partVisualID_LOD = -1;
            this.m_partVisualID = -1;
            this.m_repRequired = i4;
            this.m_cost = i5;
            this.m_bLoaded = false;
        }

        public NFSMW_CarPart(TheGame theGame, int i, int i2, int i3, String str, int i4, int i5, int[] iArr) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_stats = new int[4];
            this.m_icon = getPartIcon(i);
            for (int i6 = 0; i6 < 4; i6++) {
                this.m_stats[i6] = iArr[i6];
            }
            this.m_partName = str;
            this.m_partVisualID_LOD = -1;
            this.m_partVisualID = -1;
            this.m_repRequired = i4;
            this.m_cost = i5;
            this.m_bLoaded = false;
        }

        public void drawPartImg(boolean z) throws Exception {
            int i = z ? this.m_partVisualID_LOD : this.m_partVisualID;
            if (i == -1) {
                return;
            }
            this.this$0.asset_LoadImage(i, false);
            this.this$0.asset_DrawImage(i, 0, 0);
            this.this$0.asset_FreeImage(i);
        }

        public int getPartIcon(int i) {
            switch (i) {
                case 4096:
                case 8192:
                case 16384:
                case 32768:
                    return 866;
                case 65536:
                    return 846;
                case 131072:
                    return 850;
                case 262144:
                    return 854;
                case 524288:
                    return 858;
                case 1048576:
                    return 870;
                case 2097152:
                    return 862;
                case 4194304:
                    return 836;
                case 8388608:
                    return 816;
                case 16777216:
                    return 828;
                case 33554432:
                    return 820;
                case 67108864:
                    return 824;
                case 134217728:
                    return 840;
                case 268435456:
                    return 832;
                default:
                    return 858;
            }
        }
    }

    class NFSMW_Menu {
        public int m_backgroundStyle;
        public int m_itemCount;
        public NFSMW_MenuItem[] m_items;
        public boolean m_loaded;
        public NFSMW_Menu m_parent;
        public int m_selected;
        public int m_title;
        private final TheGame this$0;

        public NFSMW_Menu(TheGame theGame, int i, MenuFriendly[] menuFriendlyArr, int i2) {
            this.this$0 = theGame;
            this.m_items = null;
            this.m_selected = 0;
            this.m_parent = null;
            this.m_backgroundStyle = i2;
            this.m_itemCount = menuFriendlyArr.length;
            this.m_title = i;
            this.m_loaded = false;
            for (int i3 = 0; i3 < this.m_itemCount; i3++) {
                if (menuFriendlyArr[i3] == null) {
                    this.m_itemCount = i3;
                    break;
                }
            }
            this.m_items = new NFSMW_MenuItem[this.m_itemCount];
            for (int i4 = 0; i4 < this.m_itemCount; i4++) {
                this.m_items[i4] = new NFSMW_MenuItem(theGame, menuFriendlyArr[i4]);
            }
        }

        public NFSMW_Menu(TheGame theGame, int i, MenuFriendly[] menuFriendlyArr, int i2, int i3, int i4) {
            this.this$0 = theGame;
            this.m_items = null;
            this.m_selected = 0;
            this.m_parent = null;
            this.m_backgroundStyle = i4;
            this.m_itemCount = menuFriendlyArr.length;
            this.m_title = i;
            this.m_loaded = false;
            this.m_items = new NFSMW_MenuItem[i3];
            this.m_itemCount = this.m_items.length;
            int i5 = i3 + i2;
            for (int i6 = i2; i6 < i5; i6++) {
                this.m_items[i6 - i2] = new NFSMW_MenuItem(theGame, menuFriendlyArr[i6]);
            }
        }

        public NFSMW_Menu(TheGame theGame, int i, NFSMW_MenuItem[] nFSMW_MenuItemArr, int i2) {
            this.this$0 = theGame;
            this.m_items = null;
            this.m_selected = 0;
            this.m_parent = null;
            this.m_backgroundStyle = i2;
            this.m_items = nFSMW_MenuItemArr;
            this.m_itemCount = this.m_items.length;
            this.m_title = i;
            this.m_loaded = false;
            for (int i3 = 0; i3 < this.m_itemCount; i3++) {
                if (this.m_items[i3].m_subMenu != null) {
                    this.m_items[i3].m_subMenu.m_parent = this;
                }
            }
        }

        public void freeIcons(boolean z) {
            if (this.m_items == null || !this.m_loaded) {
                return;
            }
            for (int i = 0; i < this.m_items.length; i++) {
                if (this.m_items[i] != null) {
                    try {
                        this.this$0.asset_FreeImage(this.m_items[i].m_icon);
                    } catch (Error e) {
                        TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu.h", 211, e.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu.h", 211, e2.toString());
                    }
                    if (z && this.m_items[i].m_subMenu != null) {
                        this.m_items[i].m_subMenu.freeIcons(z);
                    }
                }
            }
            this.m_loaded = false;
        }

        public void loadIcons(boolean z) {
            if (this.m_items == null || this.m_loaded) {
                return;
            }
            for (int i = 0; i < this.m_items.length; i++) {
                if (this.m_items[i] != null) {
                    try {
                        this.this$0.asset_LoadImage(this.m_items[i].m_icon, false);
                    } catch (Error e) {
                        TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu.h", 186, e.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu.h", 186, e2.toString());
                    }
                    if (z && this.m_items[i].m_subMenu != null) {
                        this.m_items[i].m_subMenu.loadIcons(z);
                    }
                }
            }
            this.m_loaded = true;
        }

        public void sortCareerMenu() {
        }
    }

    class NFSMW_MenuItem {
        public int m_cmd;
        public int m_icon;
        public NFSMW_Menu m_subMenu;
        public int m_text;
        public int m_type;
        private final TheGame this$0;

        public NFSMW_MenuItem(TheGame theGame, int i, int i2, int i3, int i4, NFSMW_Menu nFSMW_Menu) {
            this.this$0 = theGame;
            this.m_text = i;
            this.m_icon = i2;
            this.m_type = i3;
            this.m_cmd = i4;
            this.m_subMenu = nFSMW_Menu;
        }

        public NFSMW_MenuItem(TheGame theGame, MenuFriendly menuFriendly) {
            this.this$0 = theGame;
            this.m_text = menuFriendly.m_title;
            this.m_type = menuFriendly.m_type;
            this.m_cmd = menuFriendly.m_cmd;
            this.m_icon = menuFriendly.m_icon;
            this.m_subMenu = null;
        }
    }

    class NFSMW_Mission extends MenuFriendly {
        int m_cashWon;
        int m_nLaps;
        int m_nTimeLimit;
        int m_nreqChkpSpeed;
        int m_nreqScore;
        int m_raceSetup;
        int m_raceType;
        int m_repWon;
        int m_reqMission;
        int m_reqRep;
        int m_script;
        int m_trackPath;
        private final TheGame this$0;

        public NFSMW_Mission(TheGame theGame, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_raceSetup = 0;
            this.m_icon = getMissionIcon(i6);
            init(i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
        }

        public int getMissionIcon(int i) {
            switch (i) {
                case 0:
                    return 802;
                case 1:
                    return 806;
                case 2:
                    return 798;
                case 3:
                    return 810;
                case 4:
                    return 794;
                default:
                    return 858;
            }
        }

        public void init(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.m_raceType = i3;
            this.m_trackPath = i4;
            this.m_nLaps = i5;
            this.m_nTimeLimit = i9;
            this.m_nreqScore = i10;
            this.m_nreqChkpSpeed = i11;
            this.m_reqRep = i;
            this.m_reqMission = i2;
            this.m_cashWon = i7;
            this.m_repWon = i8;
            this.m_raceSetup = i6;
            this.m_nreqScore = i10;
            this.m_script = i12;
        }
    }

    class NFSMW_Profile {
        public int m_carRep;
        public int m_cash;
        public byte m_currentCar;
        public byte m_equipedCar;
        public byte[] m_missionStatus;
        public int m_nCopsCrashed;
        public byte[][] m_partStatus;
        public byte m_profileNum;
        public int m_rep;
        private final TheGame this$0;
        public byte[][] m_carSetups = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 6, 17);
        public int[] m_LapTimes = new int[5];

        NFSMW_Profile(TheGame theGame) {
            this.this$0 = theGame;
            this.m_missionStatus = new byte[this.this$0.g_missions.length];
            this.m_partStatus = new byte[this.this$0.g_carParts.length][];
            Init();
            getLastOpenProfile();
            loadRecords();
        }

        private void setInitialCarSetups() {
            for (int i = 0; i < 6; i++) {
                for (int i2 = 0; i2 < 17; i2++) {
                    this.m_carSetups[i][i2] = this.this$0.g_carSetups[i][i2];
                }
            }
        }

        public void Init() {
            this.m_rep = 0;
            this.m_cash = 0;
            this.m_carRep = 0;
            this.m_equipedCar = (byte) 5;
            this.m_currentCar = (byte) 5;
            this.m_nCopsCrashed = 0;
            for (int i = 0; i < 6; i++) {
                for (int i2 = 0; i2 < 17; i2++) {
                    this.m_carSetups[i][i2] = 0;
                }
            }
            for (int i3 = 0; i3 < this.m_LapTimes.length; i3++) {
                this.m_LapTimes[i3] = 0;
            }
            for (int i4 = 0; i4 < this.m_missionStatus.length; i4++) {
                this.m_missionStatus[i4] = 0;
            }
            for (int i5 = 0; i5 < this.m_partStatus.length; i5++) {
                this.m_partStatus[i5] = new byte[this.this$0.g_carParts[i5].length];
                this.m_partStatus[i5][0] = 1;
                for (int i6 = 1; i6 < this.m_partStatus[i5].length; i6++) {
                    this.m_partStatus[i5][i6] = 0;
                }
            }
            TheGame.g_missionIncID = 0;
        }

        public int byteArrayToInt(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 >= 4) {
                    return i4;
                }
                i2 = ((bArr[i3 + i] & 255) << ((3 - i3) * 8)) + i4;
                i3++;
            }
        }

        public void changeCurrentProfile(byte b) {
            try {
                byte[] bArr = new byte[2];
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("currentProfile", false);
                RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
                while (recordEnumerationEnumerateRecords.hasNextElement()) {
                    int iNextRecordId = recordEnumerationEnumerateRecords.nextRecordId();
                    byte[] record = recordStoreOpenRecordStore.getRecord(iNextRecordId);
                    if (record[0] == 0) {
                        record[0] = 0;
                        record[1] = b;
                        recordStoreOpenRecordStore.setRecord(iNextRecordId, record, 0, 2);
                        this.m_profileNum = b;
                    }
                }
                recordEnumerationEnumerateRecords.destroy();
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2950, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2950, e2.toString());
            }
        }

        public void clearAllProfiles() {
            try {
                RecordStore.deleteRecordStore("currentProfile");
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2965, e.toString());
            } catch (RecordStoreNotFoundException e2) {
            } catch (Exception e3) {
                e3.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2965, e3.toString());
            }
            getLastOpenProfile();
            byte b = this.m_profileNum;
            for (byte b2 = 0; b2 < 3; b2 = (byte) (b2 + 1)) {
                this.m_profileNum = b2;
                clearProfile();
            }
            this.m_profileNum = b;
            changeCurrentProfile(this.m_profileNum);
        }

        public void clearProfile() {
            try {
                RecordStore.deleteRecordStore(new StringBuffer().append("NFSMW_profile").append((int) this.m_profileNum).toString());
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2994, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2994, e2.toString());
            } catch (RecordStoreNotFoundException e3) {
            }
            Init();
            setInitialCarSetups();
        }

        public void createProfile() {
            boolean z = true;
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("currentProfile", true);
                if (recordStoreOpenRecordStore.getNumRecords() <= 0 || recordStoreOpenRecordStore.getNumRecords() == 2) {
                    z = false;
                } else {
                    RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
                    while (recordEnumerationEnumerateRecords.hasNextElement()) {
                        recordStoreOpenRecordStore.deleteRecord(recordEnumerationEnumerateRecords.nextRecordId());
                    }
                    recordEnumerationEnumerateRecords.destroy();
                }
                try {
                    if (recordStoreOpenRecordStore.getNumRecords() == 0) {
                        this.m_profileNum = (byte) 0;
                        byte[] bArr = {0, this.m_profileNum};
                        recordStoreOpenRecordStore.addRecord(bArr, 0, 2);
                        bArr[0] = 1;
                        bArr[1] = 13;
                        recordStoreOpenRecordStore.addRecord(bArr, 0, 2);
                    }
                    recordStoreOpenRecordStore.closeRecordStore();
                } catch (Error e) {
                    e = e;
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2497, e.toString());
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2497, e.toString());
                }
            } catch (Error e3) {
                e = e3;
                z = false;
            } catch (Exception e4) {
                e = e4;
                z = false;
            }
            if (z) {
                clearAllProfiles();
            }
        }

        public void createRecords(boolean z) {
            int i = 1;
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(new StringBuffer().append("NFSMW_profile").append((int) this.m_profileNum).toString(), true);
                if (recordStoreOpenRecordStore.getNumRecords() != 7) {
                    if (recordStoreOpenRecordStore.getNumRecords() > 0) {
                        RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
                        while (recordEnumerationEnumerateRecords.hasNextElement()) {
                            recordStoreOpenRecordStore.deleteRecord(recordEnumerationEnumerateRecords.nextRecordId());
                        }
                        recordEnumerationEnumerateRecords.destroy();
                    }
                    if (z) {
                        Init();
                        setInitialCarSetups();
                    }
                    int length = 1;
                    for (int i2 = 0; i2 < this.m_partStatus.length; i2++) {
                        length += this.m_partStatus[i2].length;
                    }
                    byte[] bArr = new byte[length];
                    bArr[0] = 0;
                    bArr[1] = this.m_equipedCar;
                    recordStoreOpenRecordStore.addRecord(bArr, 0, 2);
                    bArr[0] = 6;
                    bArr[1] = (byte) (this.m_nCopsCrashed >> 24);
                    bArr[2] = (byte) (this.m_nCopsCrashed >> 16);
                    bArr[3] = (byte) (this.m_nCopsCrashed >> 8);
                    bArr[4] = (byte) this.m_nCopsCrashed;
                    recordStoreOpenRecordStore.addRecord(bArr, 0, 5);
                    bArr[0] = 1;
                    for (int i3 = 0; i3 < 6; i3++) {
                        for (int i4 = 0; i4 < 17; i4++) {
                            bArr[(i3 * 17) + i4 + 1] = this.m_carSetups[i3][i4];
                        }
                    }
                    recordStoreOpenRecordStore.addRecord(bArr, 0, bArr.length);
                    bArr[0] = 2;
                    for (int i5 = 0; i5 < this.m_missionStatus.length; i5++) {
                        bArr[i5 + 1] = this.m_missionStatus[i5];
                    }
                    recordStoreOpenRecordStore.addRecord(bArr, 0, this.m_missionStatus.length + 1);
                    bArr[0] = 3;
                    for (int i6 = 0; i6 < this.m_partStatus.length; i6++) {
                        int i7 = 0;
                        while (i7 < this.m_partStatus[i6].length) {
                            bArr[i] = this.m_partStatus[i6][i7];
                            i7++;
                            i++;
                        }
                    }
                    recordStoreOpenRecordStore.addRecord(bArr, 0, i);
                    bArr[0] = 4;
                    byte[] bArrIntToByteArray = intToByteArray(this.m_cash);
                    for (int i8 = 0; i8 < 4; i8++) {
                        bArr[i8 + 1] = bArrIntToByteArray[i8];
                    }
                    byte[] bArrIntToByteArray2 = intToByteArray(this.m_rep);
                    for (int i9 = 0; i9 < 4; i9++) {
                        bArr[i9 + 5] = bArrIntToByteArray2[i9];
                    }
                    recordStoreOpenRecordStore.addRecord(bArr, 0, 9);
                    bArr[0] = 5;
                    for (int i10 = 0; i10 < 5; i10++) {
                        byte[] bArrIntToByteArray3 = intToByteArray(this.m_LapTimes[i10]);
                        for (int i11 = 0; i11 < 4; i11++) {
                            bArr[(i10 * 4) + 1 + i11] = bArrIntToByteArray3[i11];
                        }
                    }
                    recordStoreOpenRecordStore.addRecord(bArr, 0, (this.m_LapTimes.length * 4) + 1);
                }
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2679, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2679, e2.toString());
            }
        }

        public int decodeBytes(byte[] bArr, int i) {
            int i2 = i << 2;
            return (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
        }

        public void encodeBytes(byte[] bArr, int i, int i2) {
            int i3 = i2 << 2;
            bArr[i3] = (byte) (i >> 24);
            bArr[i3 + 1] = (byte) (i >> 16);
            bArr[i3 + 2] = (byte) (i >> 8);
            bArr[i3 + 3] = (byte) i;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0043  */
        /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
        public void getLastOpenProfile() {
            boolean z;
            createProfile();
            try {
                byte[] bArr = new byte[2];
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("currentProfile", false);
                RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
                z = false;
                while (recordEnumerationEnumerateRecords.hasNextElement()) {
                    try {
                        int iNextRecordId = recordEnumerationEnumerateRecords.nextRecordId();
                        byte[] record = recordStoreOpenRecordStore.getRecord(iNextRecordId);
                        if (record[0] == 0) {
                            this.m_profileNum = record[1];
                        } else if (record[0] != 1) {
                            System.out.println(new StringBuffer().append("Unknown profile data: ").append(iNextRecordId).toString());
                        } else if (record[1] != 13) {
                            try {
                                record[0] = 1;
                                record[1] = 13;
                                recordStoreOpenRecordStore.setRecord(iNextRecordId, record, 0, 2);
                                z = true;
                            } catch (Error e) {
                                e = e;
                                z = true;
                                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2547, e.toString());
                                if (z) {
                                    clearAllProfiles();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z = true;
                                e.printStackTrace();
                                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2547, e.toString());
                                if (z) {
                                    clearAllProfiles();
                                }
                            }
                        } else {
                            continue;
                        }
                    } catch (Error e3) {
                        e = e3;
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                recordEnumerationEnumerateRecords.destroy();
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Error e5) {
                e = e5;
                z = false;
            } catch (Exception e6) {
                e = e6;
                z = false;
            }
            if (z) {
                clearAllProfiles();
            }
        }

        public int getTotalRep() {
            return this.m_carRep + this.m_rep;
        }

        public byte[] intToByteArray(int i) {
            byte[] bArr = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2] = (byte) ((i >> (((bArr.length - 1) - i2) * 8)) & 255);
            }
            return bArr;
        }

        public void loadRecords() {
            if (this.this$0.system_bDemoMode) {
                return;
            }
            createRecords(true);
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(new StringBuffer().append("NFSMW_profile").append((int) this.m_profileNum).toString(), false);
                int length = 1;
                for (int i = 0; i < this.m_partStatus.length; i++) {
                    length += this.m_partStatus[i].length;
                }
                byte[] bArr = new byte[length];
                RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
                while (recordEnumerationEnumerateRecords.hasNextElement()) {
                    byte[] record = recordStoreOpenRecordStore.getRecord(recordEnumerationEnumerateRecords.nextRecordId());
                    byte b = record[0];
                    switch (b) {
                        case 0:
                            byte b2 = record[1];
                            this.m_equipedCar = b2;
                            this.m_currentCar = b2;
                            break;
                        case 1:
                            for (int i2 = 0; i2 < 6; i2++) {
                                for (int i3 = 0; i3 < 17; i3++) {
                                    this.m_carSetups[i2][i3] = record[(i2 * 17) + i3 + 1];
                                }
                            }
                            break;
                        case 2:
                            for (int i4 = 0; i4 < this.m_missionStatus.length; i4++) {
                                this.m_missionStatus[i4] = record[i4 + 1];
                            }
                            break;
                        case 3:
                            int i5 = 1;
                            for (int i6 = 0; i6 < this.m_partStatus.length; i6++) {
                                int i7 = 0;
                                while (i7 < this.m_partStatus[i6].length) {
                                    this.m_partStatus[i6][i7] = record[i5];
                                    i7++;
                                    i5++;
                                }
                            }
                            break;
                        case 4:
                            this.m_cash = byteArrayToInt(record, 1);
                            this.m_rep = byteArrayToInt(record, 5);
                            break;
                        case 5:
                            for (int i8 = 0; i8 < 5; i8++) {
                                this.m_LapTimes[i8] = byteArrayToInt(record, (i8 * 4) + 1);
                            }
                            break;
                        case 6:
                            this.m_nCopsCrashed = (record[1] << 24) | ((record[2] & 255) << 16) | ((record[3] & 255) << 8) | (record[4] & 255);
                            break;
                        default:
                            System.out.println(new StringBuffer().append("ERROR: unknown record ID ").append((int) b).toString());
                            break;
                    }
                }
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2783, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2783, e2.toString());
            }
        }

        public void saveRecords() {
            if (this.this$0.system_bDemoMode) {
                return;
            }
            try {
                RecordStore.deleteRecordStore(new StringBuffer().append("NFSMW_profile").append((int) this.m_profileNum).toString());
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2801, e.toString());
            } catch (RecordStoreNotFoundException e2) {
            } catch (Exception e3) {
                e3.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2801, e3.toString());
            }
            createRecords(false);
        }
    }

    class NFSMW_Race {
        public String m_LapTimeString;
        public boolean m_bMission;
        public boolean m_bMissionPassed;
        public boolean m_bNewMission;
        public int m_laps;
        public int m_nCopsSmashed;
        public int m_nFastestLapTime;
        public int m_nLastLapTime;
        public int m_nMissionID;
        public int m_nMissionUnlocked;
        public int m_nSpeedLimit;
        public int m_nTimeLimit;
        public int m_nTopSpeed;
        public int m_quickraceID;
        public String m_timeString;
        public int m_trackPath;
        public int m_type;
        private final TheGame this$0;
        public int m_difficulty = 0;
        public int m_numRacers = 3;
        public int m_numCops = 2;
        public int m_numTraffic = 1;

        NFSMW_Race(TheGame theGame) {
            this.this$0 = theGame;
        }
    }

    class NFSMW_Track extends MenuFriendly {
        public int m_previewImg;
        public boolean m_previewLoaded;
        public String m_trackLength;
        public int m_trackPath;
        private final TheGame this$0;

        public NFSMW_Track(TheGame theGame, int i, int i2, int i3, int i4, int i5, String str) {
            super(theGame, i3, i, i2, 858);
            this.this$0 = theGame;
            this.m_previewImg = i4;
            this.m_trackPath = i5;
            this.m_previewLoaded = false;
            this.m_trackLength = str;
        }

        public void createTrackPreview() {
            if (this.m_previewLoaded) {
                return;
            }
            try {
                this.this$0.asset_LoadImage(this.m_previewImg, false);
                this.m_previewLoaded = true;
            } catch (Error e) {
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2005, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2005, e2.toString());
            }
        }

        public void freeTrackPreview() {
            if (this.m_previewLoaded) {
                try {
                    this.this$0.asset_FreeImage(this.m_previewImg);
                    this.m_previewLoaded = false;
                } catch (Error e) {
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2017, e.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TheGame.AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\player_profile.h", 2017, e2.toString());
                }
            }
        }
    }

    class NFSMW_TrackPath {
        public int m_AISpline;
        public int m_checkpoints;
        public int m_nTrack;
        public int m_nTrackFlags;
        public int m_nWorld;
        public int m_trafficSpline;
        private final TheGame this$0;

        public NFSMW_TrackPath(TheGame theGame, int i, int i2, int i3, int i4, int i5, int i6) {
            this.this$0 = theGame;
            this.m_AISpline = i3;
            this.m_trafficSpline = i4;
            this.m_checkpoints = i5;
            this.m_nWorld = i;
            this.m_nTrack = i2;
            this.m_nTrackFlags = i6;
        }
    }

    class ObjectRef {
        public String m_name;
        public MintMesh[] m_object;
        private final TheGame this$0;

        public ObjectRef(TheGame theGame, String str, MintMesh[] mintMeshArr) {
            this.this$0 = theGame;
            this.m_name = str;
            this.m_object = mintMeshArr;
        }
    }

    class TextureRef {
        public boolean m_alpha;
        public String m_name;
        public Texture2D m_texture;
        private final TheGame this$0;

        public TextureRef(TheGame theGame, String str, Texture2D texture2D, boolean z) {
            this.this$0 = theGame;
            this.m_name = str;
            this.m_texture = texture2D;
            this.m_alpha = z;
        }
    }

    public TheGame(AppMain appMain) {
        int i = g_missionIncID;
        g_missionIncID = i + 1;
        int i2 = g_missionIncID;
        g_missionIncID = i2 + 1;
        int i3 = g_missionIncID;
        g_missionIncID = i3 + 1;
        int i4 = g_missionIncID;
        g_missionIncID = i4 + 1;
        int i5 = g_missionIncID;
        g_missionIncID = i5 + 1;
        int i6 = g_missionIncID;
        g_missionIncID = i6 + 1;
        int i7 = g_missionIncID;
        g_missionIncID = i7 + 1;
        int i8 = g_missionIncID;
        g_missionIncID = i8 + 1;
        int i9 = g_missionIncID;
        g_missionIncID = i9 + 1;
        int i10 = g_missionIncID;
        g_missionIncID = i10 + 1;
        int i11 = g_missionIncID;
        g_missionIncID = i11 + 1;
        int i12 = g_missionIncID;
        g_missionIncID = i12 + 1;
        int i13 = g_missionIncID;
        g_missionIncID = i13 + 1;
        int i14 = g_missionIncID;
        g_missionIncID = i14 + 1;
        int i15 = g_missionIncID;
        g_missionIncID = i15 + 1;
        int i16 = g_missionIncID;
        g_missionIncID = i16 + 1;
        int i17 = g_missionIncID;
        g_missionIncID = i17 + 1;
        int i18 = g_missionIncID;
        g_missionIncID = i18 + 1;
        int i19 = g_missionIncID;
        g_missionIncID = i19 + 1;
        int i20 = g_missionIncID;
        g_missionIncID = i20 + 1;
        int i21 = g_missionIncID;
        g_missionIncID = i21 + 1;
        int i22 = g_missionIncID;
        g_missionIncID = i22 + 1;
        int i23 = g_missionIncID;
        g_missionIncID = i23 + 1;
        int i24 = g_missionIncID;
        g_missionIncID = i24 + 1;
        int i25 = g_missionIncID;
        g_missionIncID = i25 + 1;
        int i26 = g_missionIncID;
        g_missionIncID = i26 + 1;
        int i27 = g_missionIncID;
        g_missionIncID = i27 + 1;
        int i28 = g_missionIncID;
        g_missionIncID = i28 + 1;
        int i29 = g_missionIncID;
        g_missionIncID = i29 + 1;
        int i30 = g_missionIncID;
        g_missionIncID = i30 + 1;
        int i31 = g_missionIncID;
        g_missionIncID = i31 + 1;
        int i32 = g_missionIncID;
        g_missionIncID = i32 + 1;
        int i33 = g_missionIncID;
        g_missionIncID = i33 + 1;
        int i34 = g_missionIncID;
        g_missionIncID = i34 + 1;
        int i35 = g_missionIncID;
        g_missionIncID = i35 + 1;
        int i36 = g_missionIncID;
        g_missionIncID = i36 + 1;
        int i37 = g_missionIncID;
        g_missionIncID = i37 + 1;
        int i38 = g_missionIncID;
        g_missionIncID = i38 + 1;
        int i39 = g_missionIncID;
        g_missionIncID = i39 + 1;
        int i40 = g_missionIncID;
        g_missionIncID = i40 + 1;
        int i41 = g_missionIncID;
        g_missionIncID = i41 + 1;
        this.g_missions = new NFSMW_Mission[]{new NFSMW_Mission(this, 72, i, 122, 70, -1, 0, 1, 2, 0, 0, 0, 0, 0, 60, 0), new NFSMW_Mission(this, 72, i2, 122, 150, 0, 0, 6, 5, 1, 0, 30, 0, 0, 60, 1), new NFSMW_Mission(this, 72, i3, 122, 350, 1, 1, 3, 0, 2, 0, 40, 0, 0, 50, 3), new NFSMW_Mission(this, 72, i4, 122, 550, 2, 0, 7, 3, 2, 0, 60, 0, 0, 50, 5), new NFSMW_Mission(this, 72, i5, 122, 800, 3, 0, 8, 5, 3, 0, 80, 0, 0, 40, 7), new NFSMW_Mission(this, 72, i6, 122, 1100, 4, 0, 1, 5, 3, 0, 100, 0, 0, 40, 9), new NFSMW_Mission(this, 72, i7, 117, 0, -1, 0, 0, 2, 0, 1000, 15, 0, 0, 60, 11), new NFSMW_Mission(this, 72, i8, 117, 0, -1, 0, 7, 3, 0, 2000, 20, 0, 0, 60, 12), new NFSMW_Mission(this, 72, i9, 117, 0, 0, 0, 6, 3, 1, 3000, 25, 0, 0, 50, 13), new NFSMW_Mission(this, 72, i10, 117, 0, 0, 0, 1, 4, 2, 3500, 30, 0, 0, 50, 14), new NFSMW_Mission(this, 72, i11, 117, 0, 3, 0, 8, 4, 3, 4000, 35, 0, 0, 40, 15), new NFSMW_Mission(this, 72, i12, 117, 0, 3, 0, 7, 5, 10, 4500, 40, 0, 0, 40, 16), new NFSMW_Mission(this, 72, i13, 118, 0, -1, 1, 9, 0, 0, 1000, 15, 0, 0, 60, 17), new NFSMW_Mission(this, 72, i14, 118, 0, -1, 1, 3, 0, 0, 2000, 20, 0, 0, 60, 18), new NFSMW_Mission(this, 72, i15, 118, 0, 1, 1, 10, 0, 1, 3000, 25, 0, 0, 50, 19), new NFSMW_Mission(this, 72, i16, 118, 0, 1, 1, 4, 0, 2, 3500, 30, 0, 0, 50, 20), new NFSMW_Mission(this, 72, i17, 118, 0, 2, 1, 11, 0, 3, 4000, 35, 0, 0, 40, 21), new NFSMW_Mission(this, 72, i18, 118, 0, 2, 1, 5, 0, 10, 4500, 40, 0, 0, 40, 22), new NFSMW_Mission(this, 72, i19, 119, 0, 0, 2, 0, 2, 0, 1000, 15, 0, 0, 60, 23), new NFSMW_Mission(this, 72, i20, 119, 0, 0, 2, 7, 2, 0, 2000, 20, 0, 0, 60, 24), new NFSMW_Mission(this, 72, i21, 119, 0, 1, 2, 1, 2, 1, 3000, 25, 0, 0, 50, 25), new NFSMW_Mission(this, 72, i22, 119, 0, 1, 2, 6, 2, 2, 3500, 30, 0, 0, 50, 26), new NFSMW_Mission(this, 72, i23, 119, 0, 3, 2, 8, 2, 3, 4000, 35, 0, 0, 40, 27), new NFSMW_Mission(this, 72, i24, 119, 0, 3, 2, 1, 2, 10, 4500, 40, 0, 0, 0, 28), new NFSMW_Mission(this, 72, i25, 120, 0, 0, 3, 12, 1, 7, 1000, 15, 90000, 210, 40, 29), new NFSMW_Mission(this, 72, i26, 120, 0, 0, 3, 13, 1, 7, 2000, 20, 90000, 190, 40, 30), new NFSMW_Mission(this, 72, i27, 120, 0, 1, 3, 12, 1, 8, 3000, 25, 70000, 210, 50, 31), new NFSMW_Mission(this, 72, i28, 120, 0, 1, 3, 13, 1, 8, 3500, 30, 70000, 200, 50, 32), new NFSMW_Mission(this, 72, i29, 120, 0, 2, 3, 12, 1, 9, 4000, 35, 70000, 215, 60, 33), new NFSMW_Mission(this, 72, i30, 120, 0, 2, 3, 13, 1, 9, 4500, 40, 70000, 185, 60, 34), new NFSMW_Mission(this, 72, i31, 121, 0, 2, 4, 1, 1, 4, 0, 15, 110000, 12, 0, 35), new NFSMW_Mission(this, 72, i32, 121, 0, 2, 4, 6, 1, 4, 0, 20, 110000, 12, 0, 36), new NFSMW_Mission(this, 72, i33, 121, 0, 3, 4, 0, 1, 5, 0, 25, 90000, 12, 0, 37), new NFSMW_Mission(this, 72, i34, 121, 0, 3, 4, 8, 1, 5, 0, 30, 90000, 15, 0, 38), new NFSMW_Mission(this, 72, i35, 121, 0, 4, 4, 1, 1, 6, 0, 35, 80000, 17, 0, 39), new NFSMW_Mission(this, 72, i36, 121, 0, 4, 4, 8, 1, 6, 0, 40, 80000, 15, 0, 40), new NFSMW_Mission(this, 72, i37, 122, 0, 1, 4, 1, 2, 3, 1000, 15, 100000, 5, 0, 2), new NFSMW_Mission(this, 72, i38, 122, 0, 1, 4, 6, 3, 3, 2000, 20, 100000, 8, 0, 4), new NFSMW_Mission(this, 72, i39, 122, 0, 2, 4, 0, 3, 4, 3000, 25, 80000, 10, 0, 6), new NFSMW_Mission(this, 72, i40, 122, 0, 2, 4, 8, 4, 4, 4000, 30, 80000, 17, 0, 8), new NFSMW_Mission(this, 72, i41, 122, 0, 3, 4, 1, 4, 5, 6000, 35, 70000, 20, 0, 10)};
        this.g_player = new NFSMW_Profile(this);
        this.g_race = new NFSMW_Race(this);
        this.menuTrackSelect = new NFSMW_Menu(this, 96, this.g_tracks, 3);
        this.menuCarSelect = new NFSMW_Menu(this, 95, this.g_cars, 1);
        this.menuQRCarSelect = new NFSMW_Menu(this, 95, this.g_cars, 1);
        this.menuCarPaintLayout = new NFSMW_Menu(this, 125, this.g_carParts[0], 1);
        this.menuCarPaintSelect1 = new NFSMW_Menu(this, 125, this.g_carParts[1], 1);
        this.menuCarPaintSelect2 = new NFSMW_Menu(this, 125, this.g_carParts[2], 1);
        this.menuCarPaintSelect3 = new NFSMW_Menu(this, 125, this.g_carParts[3], 1);
        this.menuCarWindTintSelect = new NFSMW_Menu(this, 125, this.g_carParts[4], 1);
        this.menuCarVinylSelect = new NFSMW_Menu(this, 125, this.g_carParts[5], 1);
        this.menuCarSpoilerSelect = new NFSMW_Menu(this, 125, this.g_carParts[6], 2);
        this.menuCarRimsSelect = new NFSMW_Menu(this, 125, this.g_carParts[7], 2);
        this.menuCarFrontBmprsSelect = new NFSMW_Menu(this, 125, this.g_carParts[8], 2);
        this.menuCarRearBmprsSelect = new NFSMW_Menu(this, 125, this.g_carParts[9], 2);
        this.menuCarPaintItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 97, 866, 2, 0, this.menuCarPaintLayout), new NFSMW_MenuItem(this, 98, 866, 2, 0, this.menuCarPaintSelect1), new NFSMW_MenuItem(this, 99, 866, 2, 0, this.menuCarPaintSelect2), new NFSMW_MenuItem(this, 100, 866, 2, 0, this.menuCarPaintSelect3), new NFSMW_MenuItem(this, 101, 846, 2, 0, this.menuCarWindTintSelect)};
        this.menuCarPaint = new NFSMW_Menu(this, 125, this.menuCarPaintItems, 1);
        this.menuCustomizeVisItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 102, 866, 2, 0, this.menuCarPaint), new NFSMW_MenuItem(this, 103, 850, 2, 0, this.menuCarVinylSelect), new NFSMW_MenuItem(this, 104, 854, 2, 0, this.menuCarSpoilerSelect), new NFSMW_MenuItem(this, 105, 858, 2, 0, this.menuCarRimsSelect), new NFSMW_MenuItem(this, 106, 870, 2, 0, this.menuCarFrontBmprsSelect), new NFSMW_MenuItem(this, 107, 862, 2, 0, this.menuCarRearBmprsSelect)};
        this.menuCustomizeVis = new NFSMW_Menu(this, 125, this.menuCustomizeVisItems, 1);
        this.menuCarEngineSelect = new NFSMW_Menu(this, 125, this.g_carParts[10], 1);
        this.menuCarTurboSelect = new NFSMW_Menu(this, 125, this.g_carParts[11], 1);
        this.menuCarNitrousSelect = new NFSMW_Menu(this, 125, this.g_carParts[12], 1);
        this.menuCarTransmissionSelect = new NFSMW_Menu(this, 125, this.g_carParts[13], 1);
        this.menuCarTireSelect = new NFSMW_Menu(this, 125, this.g_carParts[14], 1);
        this.menuCarBrakesSelect = new NFSMW_Menu(this, 125, this.g_carParts[15], 1);
        this.menuCarFuelSelect = new NFSMW_Menu(this, 125, this.g_carParts[16], 1);
        this.menuCustomizePerfItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 108, 836, 2, 0, this.menuCarEngineSelect), new NFSMW_MenuItem(this, 109, 816, 2, 0, this.menuCarTurboSelect), new NFSMW_MenuItem(this, 110, 828, 2, 0, this.menuCarNitrousSelect), new NFSMW_MenuItem(this, 111, 820, 2, 0, this.menuCarTransmissionSelect), new NFSMW_MenuItem(this, 112, 824, 2, 0, this.menuCarTireSelect), new NFSMW_MenuItem(this, 113, 840, 2, 0, this.menuCarBrakesSelect), new NFSMW_MenuItem(this, 114, 832, 2, 0, this.menuCarFuelSelect)};
        this.menuCustomizePerf = new NFSMW_Menu(this, 125, this.menuCustomizePerfItems, 1);
        this.menuCustomizeItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 115, 906, 2, 0, this.menuCustomizeVis), new NFSMW_MenuItem(this, 116, 910, 2, 0, this.menuCustomizePerf)};
        this.menuCustomize = new NFSMW_Menu(this, 125, this.menuCustomizeItems, 1);
        this.menuMissionCircuits = new NFSMW_Menu(this, 91, this.g_missions, 6, 6, 4);
        this.menuMissionCheckpoints = new NFSMW_Menu(this, 91, this.g_missions, 12, 6, 4);
        this.menuMissionKnockout = new NFSMW_Menu(this, 91, this.g_missions, 18, 6, 4);
        this.menuMissionSpeedCam = new NFSMW_Menu(this, 91, this.g_missions, 24, 6, 4);
        this.menuMissionOutrun = new NFSMW_Menu(this, 91, this.g_missions, 30, 6, 4);
        this.menuMissionChallenge = new NFSMW_Menu(this, 91, this.g_missions, 0, 6, 4);
        this.menuMissionTypeItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 117, 802, 2, 0, this.menuMissionCircuits), new NFSMW_MenuItem(this, 118, 806, 2, 0, this.menuMissionCheckpoints), new NFSMW_MenuItem(this, 119, 798, 2, 0, this.menuMissionKnockout), new NFSMW_MenuItem(this, 120, 810, 2, 0, this.menuMissionSpeedCam), new NFSMW_MenuItem(this, 121, 794, 2, 0, this.menuMissionOutrun), new NFSMW_MenuItem(this, 122, 750, 2, 0, this.menuMissionChallenge)};
        this.menuMissionTypes = new NFSMW_Menu(this, 91, this.menuMissionTypeItems, 1);
        this.menuCareerStatItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 123, 758, 0, 0, null), new NFSMW_MenuItem(this, 124, 758, 0, 1, null)};
        this.menuCareerStats = new NFSMW_Menu(this, 88, this.menuCareerStatItems, 6);
        this.menuCareerItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 91, 750, 2, 0, this.menuMissionTypes), new NFSMW_MenuItem(this, 125, 754, 2, 0, this.menuCustomize), new NFSMW_MenuItem(this, 126, 746, 2, 0, this.menuCarSelect), new NFSMW_MenuItem(this, 132, 758, 2, 0, this.menuCareerStats)};
        this.menuCareer = new NFSMW_Menu(this, 87, this.menuCareerItems, 1);
        this.menuProfileItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 127, 892, 4, 0, null), new NFSMW_MenuItem(this, 128, 888, 4, 1, null), new NFSMW_MenuItem(this, 129, 884, 4, 2, null)};
        this.menuProfile = new NFSMW_Menu(this, 93, this.menuProfileItems, 0);
        this.menuHelpItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 130, 896, 256, 0, null), new NFSMW_MenuItem(this, 131, 750, 256, 1, null), new NFSMW_MenuItem(this, 133, 746, 256, 2, null)};
        this.menuHelp = new NFSMW_Menu(this, 137, this.menuHelpItems, 0);
        this.menuOptionsItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 134, 876, 1024, 0, null), new NFSMW_MenuItem(this, 135, 900, 2, 0, this.menuProfile), new NFSMW_MenuItem(this, 136, 900, 4, 0, null), new NFSMW_MenuItem(this, 138, 758, 2048, 0, null)};
        this.menuOptions = new NFSMW_Menu(this, 92, this.menuOptionsItems, 0);
        this.menuRootItems = new NFSMW_MenuItem[]{new NFSMW_MenuItem(this, 94, 650, 2, 0, this.menuQRCarSelect), new NFSMW_MenuItem(this, 87, 662, 2, 0, this.menuCareer), new NFSMW_MenuItem(this, 92, 654, 2, 0, this.menuOptions), new NFSMW_MenuItem(this, 137, 896, 2, 0, this.menuHelp), new NFSMW_MenuItem(this, 139, 880, 512, 1, null), new NFSMW_MenuItem(this, 140, 658, 1, 0, null)};
        this.menuRoot = new NFSMW_Menu(this, 90, this.menuRootItems, 0);
        this.menu_tmpCarStatData = new int[4];
        this.menu_Group = new Group();
        this.menu_IsPaused = false;
        this.menu_SplashPause = false;
        this.scene_timing = new long[50];
        this.scene_timingcolor = new int[50];
        this.trackPVSFrame1 = (short) 0;
        this.trackPVSFrame2 = (short) 0;
        this.trackPVSFrame3 = (short) 0;
        this.trackColTriangle = 0;
        this.trackPVSSegment = 0;
        this.cameraScopeMask = 0;
        this.numTrackItems = 0;
        this.trackMeshs = new Mesh[400];
        this.trackIsMesh = new boolean[400];
        this.trackIsRendered = new boolean[400];
        this.trackBarrier1 = new Mesh[20];
        this.trackBarrier1Count = 0;
        this.trackBarrier2 = new Mesh[20];
        this.trackBarrier2Count = 0;
        this.trackBarrier3 = new Mesh[20];
        this.trackBarrier3Count = 0;
        this.trackBarrier4 = new Mesh[20];
        this.trackBarrier4Count = 0;
        this.scene_lastSnd = -1;
        this.track_splines = new short[3][][];
        this.numPlayers = 0;
        this.game_playerPosition = 1;
        this.players = new Car[3];
        this.cops = new Car[2];
        this.traffic = new Car[1];
        this.g_roadsideCop = null;
        this.scene_cameraTrans = new Transform();
        this.headlights = null;
        this.brakelights = null;
        this.policelights = null;
        this.fire_sprites = new Sprite3D[4];
        this.sparks_sprite = null;
        this.flash_effect_sprite = null;
        this.wheelVertes = null;
        this.vTextureList = new Vector();
        this.vObjectList = new Vector();
        this.crc_table = new long[256];
        this.crc_table_computed = 0;
        this.system_Random = new Random(System.currentTimeMillis());
        this.system_sSoftkeyArray = new String[]{"OK", "SELECT", "NEXT", "OPTIONS", "EXIT", "BACK", "PAUSE", "DONE", "CANCEL"};
        this.system_nFirstSoftkey = 0;
        this.system_nSecondSoftkey = 0;
        this.asset_SoundArray = new CSoundObject[10];
        this.Player = new CSoundPlayerMIDP2[1];
        this.stockColors = new int[]{16777215, 1546498, 740097, 132761, 2134711, 8324610, 13769216, 13284864, 10184192, 10045442, 7275138, 10027638, 10921638, 328965};
        this.hudMPHImages = new short[]{320, 316, 312, 308, 304, 300, 296, 292, 288, 284};
        this.hudLGImages = new short[]{274, 270, 266, 262, 258, 254, 250, 246, 242, 238};
        this.hudSMImages = new short[]{366, 362, 358, 354, 350, 346, 342, 338, 334, 330};
        this.gearImgsOn = new int[]{162, 166, 190, 186, 182, 178, 174, 170};
        this.cheatPosition = 0;
        this.cheatCode = new int[]{49, 51, 52, 55, 57, 35, 42};
        this.trans = new Transform();
        this.shadowAppearance = new Appearance();
        this.shadowCompmode = new CompositingMode();
        this.g_nTimePlayerStuck = 0;
        this.slowCount = 0;
        this.g_nLastRoadSideCopIndex = -1;
        this.scene_workerTrans = new Transform();
        this.lastTacko = 32768;
        this.lastBustedness = 0;
        this.aiPathCollision = new CCollisionResult(this);
        this.m_bPaintHourglass = false;
        this.m_bWait = false;
        this.m_bKeyUnhang = false;
        m_Midlet = appMain;
        Assert(isDoubleBuffered(), "c:\\mobiledevelopment\\nfsmw_cn\\ndplatformjava\\thegamej2me.hpp", 172);
        this.system_bAssetLoading = false;
    }

    public static void Assert(int i, String str, int i2) {
        if (i == 0) {
            ReportError("Assert", new StringBuffer().append(str).append(" line=").append(i2).append("\n ").toString());
            ReportError("Assert", str.concat(Integer.toString(i2)));
        }
    }

    public static void Assert(boolean z, String str, int i) {
        if (z) {
            return;
        }
        ReportError("Assert", new StringBuffer().append(str).append(" line=").append(i).append("\n ").toString());
    }

    public static void AssertExtra(int i, String str, int i2, String str2) {
        if (i == 0) {
            ReportError("Assert", new StringBuffer().append(str).append(" line=").append(i2).append("\n ").append(str2).toString());
        }
    }

    public static void AssertExtra(boolean z, String str, int i, String str2) {
        if (z) {
            return;
        }
        ReportError("Assert", new StringBuffer().append(str).append(" line=").append(i).append("\n ").append(str2).toString());
    }

    public static void ReportError(String str, String str2) {
        if (!bAssertionsStarted) {
            System.out.println(str.concat(str2));
        } else {
            if (bAssertionSet) {
                return;
            }
            Display.getDisplay(m_Midlet).setCurrent(new TextBox(str, str2.concat(" free mem = ").concat(Long.toString(Runtime.getRuntime().freeMemory())), 1000, 131072));
            bAssertionSet = true;
        }
    }

    private void system_CalculateSoftkeySizes() {
        int iGetHeight = this.system_SoftkeyFont.GetHeight() - 4;
        int i = 0;
        int i2 = 0;
        while (i < 9) {
            int iGetSubstringWidth = this.system_SoftkeyFont.GetSubstringWidth(this.system_sSoftkeyArray[i], 0, this.system_sSoftkeyArray[i].length());
            if (iGetSubstringWidth <= i2) {
                iGetSubstringWidth = i2;
            }
            i++;
            i2 = iGetSubstringWidth;
        }
        this.system_nSoftkeyWidth = (iGetHeight >> 1) + i2;
        this.system_nSoftkeyHeight = ((iGetHeight + 7) >> 3) + iGetHeight;
    }

    public int ApproximateMagnitude(int i, int i2) {
        int i3;
        int i4;
        int i5 = i < 0 ? -i : i;
        int i6 = i2 < 0 ? -i2 : i2;
        if (i5 < i6) {
            i3 = i6;
            i4 = i5;
        } else {
            i3 = i5;
            i4 = i6;
        }
        int i7 = (i3 * 1007) + (i4 * 441);
        if (i3 < (i4 << 4)) {
            i7 -= i3 * 40;
        }
        return (i7 + 512) >> 10;
    }

    void ClearGameOver(int i) throws Exception {
        this.gameOver_stage = 0;
        scene_Transition(i);
    }

    void DrawCarStats() {
        this.font_text.SetColor(16777215);
        if (this.menuCurrent != this.menuQRCarSelect) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    break;
                }
                this.menu_tmpCarStatData[i2] = this.g_cars[this.g_player.m_currentCar].m_baseStats[i2];
                for (int i3 = 0; i3 < 17; i3++) {
                    int[] iArr = this.menu_tmpCarStatData;
                    iArr[i2] = iArr[i2] + this.g_carParts[i3][this.g_cars[this.g_player.m_currentCar].m_parts[i3]].m_stats[i2];
                }
                if (this.menu_tmpCarStatData[i2] < 0) {
                    this.menu_tmpCarStatData[i2] = 0;
                }
                if (this.menu_tmpCarStatData[i2] > this.stats_max[i2]) {
                    this.menu_tmpCarStatData[i2] = this.stats_max[i2];
                }
                i = i2 + 1;
            }
        } else {
            this.menu_tmpCarStatData = this.g_cars[this.g_player.m_currentCar].m_modStats;
        }
        int i4 = 0;
        int i5 = this.g_nLanguage == 0 ? 25 : 30;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 4) {
                return;
            }
            int i8 = this.menu_tmpCarStatData[i7];
            int i9 = this.g_cars[this.g_player.m_currentCar].m_modStats[i7];
            int i10 = this.stats_max[i7];
            this.font_text.DrawSubstring(this.g_statNames[i7], 0, this.g_statNames[i7].length(), i5 - 10, i4, 1);
            if (this.g_nLanguage == 0) {
                system_FillRect(i5 + 2, i4 + 5, 50, 3, 8355711);
            } else {
                system_FillRect(i5 + 10, i4 + 5, 50, 3, 8355711);
            }
            int i11 = (int) ((i8 / i10) * 50.0f);
            if (this.g_nLanguage == 0) {
                system_FillRect(i5 + 2, i4 + 5, i11, 3, 16776960);
            } else {
                system_FillRect(i5 + 10, i4 + 5, i11, 3, 16776960);
            }
            int i12 = i5 + i11;
            int i13 = i9 - i8;
            int i14 = (int) ((i13 / i10) * 50.0f);
            int i15 = 16744192;
            if (i13 < 0) {
                i12 += i14;
                i15 = 16711680;
            }
            if (i12 < i5) {
                i12 = i5;
            }
            system_FillRect(i12, i4 + 5, Math.abs(i14), 3, i15);
            i4 += 16;
            i6 = i7 + 1;
        }
    }

    synchronized void End() {
        try {
            system_End();
            this.system_nTimeEnd = System.currentTimeMillis();
        } catch (Exception e) {
        }
    }

    void LoadLanguage(byte b) {
        this.g_nLanguage = b;
        int i = 1052;
        if (b == 0) {
            i = 1052;
            this.g_docs = this.g_docsEnglish;
            this.g_HudImgs = this.g_HudImgsEnglish;
            this.g_statNames = this.g_statNamesEnglish;
            this.g_MenuImages = this.g_MenuImagesEnglish;
        } else if (b == 1) {
            i = 1058;
            this.g_docs = this.g_docsChineseSimplified;
            this.g_HudImgs = this.g_HudImgsChineseSimplified;
            this.g_statNames = this.g_statNamesSChinese;
            this.g_MenuImages = this.g_MenuImagesSChinese;
        } else {
            this.g_nLanguage = (byte) 0;
            this.g_docs = this.g_docsEnglish;
            this.g_HudImgs = this.g_HudImgsEnglish;
            this.g_statNames = this.g_statNamesEnglish;
        }
        if (this.g_nLanguage == 0) {
            this.font_text.SetSystem(Font.getFont(64, 0, 8));
            this.font_text.SetColor(255, 255, 255);
            this.font_headings.SetSystem(Font.getFont(64, 0, 8));
            this.font_headings.SetColor(255, 255, 255);
            this.font_ingame.SetSystem(Font.getFont(64, 0, 8));
            this.font_ingame.SetColor(255, 255, 255);
        } else {
            this.font_text.SetSystem(Font.getFont(64, 0, 0));
            this.font_text.SetColor(255, 255, 255);
            this.font_headings.SetSystem(Font.getFont(64, 0, 0));
            this.font_headings.SetColor(255, 255, 255);
            this.font_ingame.SetSystem(Font.getFont(64, 0, 0));
            this.font_ingame.SetColor(255, 255, 255);
        }
        try {
            asset_LoadData(i);
            short s = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
            int i2 = (this.asset_DataArray[i + 0] & (-1)) >> 0;
            short s2 = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
            this.map_dataPointer = i2;
            String string = "";
            this.map_dataPointer++;
            this.map_dataPointer++;
            int i3 = 0;
            while (this.map_dataPointer < s2) {
                String string2 = new StringBuffer().append("").append((char) ((this.asset_DataBufArray[s][this.map_dataPointer + 1] & 255) + ((this.asset_DataBufArray[s][this.map_dataPointer + 0] & 255) << 8))).toString();
                if (string2.charAt(0) != '\n') {
                    if (string2.charAt(0) == '\r') {
                        this.g_Text[i3] = string;
                        string = "";
                        i3++;
                    } else if (string2.charAt(0) != '\\') {
                        string = new StringBuffer().append(string).append(string2).toString();
                    } else if (new StringBuffer().append("").append((char) this.asset_DataBufArray[s][this.map_dataPointer + 1]).toString().charAt(0) == 'n') {
                        string = new StringBuffer().append(string).append('\n').toString();
                        this.map_dataPointer++;
                    } else {
                        string = new StringBuffer().append(string).append('\\').toString();
                    }
                }
                this.map_dataPointer++;
                this.map_dataPointer++;
            }
            asset_FreeData(i);
            if (this.system_bDemoMode) {
                this.g_Text[55] = this.g_Text[56];
                this.g_Text[60] = this.g_Text[61];
                this.g_Text[62] = this.g_Text[63];
                this.g_Text[64] = this.g_Text[65];
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\gametext.hpp", 397, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\gametext.hpp", 397, e2.toString());
        }
    }

    void RefreshCarPaint(int i) {
        if (this.menuCurrent != null) {
            NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
            int i2 = nFSMW_MenuItem.m_type;
            if ((536866816 & i2) != 0) {
                int iMenuCmdToPart = menuCmdToPart(i2);
                if (this.menu_updateCarPaint) {
                    this.menu_paintCarTimer += i;
                    if (this.menu_paintCarTimer > 700) {
                        byte b = this.g_cars[this.g_player.m_currentCar].m_parts[1];
                        byte b2 = this.g_cars[this.g_player.m_currentCar].m_parts[2];
                        byte b3 = this.g_cars[this.g_player.m_currentCar].m_parts[3];
                        if (iMenuCmdToPart == 0) {
                            this.g_cars[this.g_player.m_currentCar].m_parts[1] = 0;
                            this.g_cars[this.g_player.m_currentCar].m_parts[2] = 4;
                            this.g_cars[this.g_player.m_currentCar].m_parts[3] = 13;
                        }
                        this.g_cars[this.g_player.m_currentCar].testPart(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd);
                        this.g_cars[this.g_player.m_currentCar].m_parts[1] = b;
                        this.g_cars[this.g_player.m_currentCar].m_parts[2] = b2;
                        this.g_cars[this.g_player.m_currentCar].m_parts[3] = b3;
                        this.menu_updateCarPaint = false;
                        this.menu_paintCarTimer = 0;
                    }
                }
            }
        }
    }

    synchronized void Start() throws Exception {
        this.system_bAssetLoading = true;
        system_Start();
        this.system_bAssetLoading = false;
        this.system_nLoopCount = 0;
        this.system_nTimeStart = System.currentTimeMillis();
    }

    int arctan2(int i, int i2) {
        int i3 = 0;
        if ((i2 >> 16) == 0) {
            if ((i >> 16) == 0) {
                return 0;
            }
            return i < 0 ? -4194304 : 4194304;
        }
        int i4 = i < 0 ? -i : i;
        if (i2 >= 0) {
            if (((i2 + i4) >> 16) != 0) {
                i3 = 2097152 - ((((i2 - i4) / ((i4 + i2) >> 16)) >> 8) * 8192);
            }
        } else if (((i4 - i2) >> 16) != 0) {
            i3 = 6291456 - ((((i2 + i4) / ((i4 - i2) >> 16)) >> 8) * 8192);
        }
        return i < 0 ? -i3 : i3;
    }

    void asset_BlitTile(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        m_CurrentGraphics.setClip(i2, i3, i5 - i4, i7 - i6);
        m_CurrentGraphics.drawImage(this.asset_ImageArray[this.asset_nTileImageID], i2 - ((((i & 63) & 7) << 4) + i4), i3 - ((((i & 63) >> 3) << 4) + i6), 20);
    }

    synchronized void asset_ChangeVolume(int i) {
        this.Player[this.ActivePlayer].SetVolume((i * 100) / 5);
    }

    int asset_CreateImage(String str, int i, boolean z) {
        int iIndexOf = str.indexOf(".png");
        if (iIndexOf <= 0) {
            AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1033, new StringBuffer().append("CreateImage: Invalid image name: ").append(str).toString());
            return -1;
        }
        String string = new StringBuffer().append(new StringBuffer().append(str.substring(0, iIndexOf)).append("_png").toString()).append(str).toString();
        if (this.asset_PaletteFilter == -1) {
            try {
                if (z) {
                    this.asset_FlippedImageArray[i] = Image.createImage(string);
                } else {
                    this.asset_ImageArray[i] = Image.createImage(string);
                }
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1071, str.concat(e.toString()));
            } catch (Exception e2) {
                AssertExtra(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1064, str.concat(e2.toString()));
            }
        } else {
            this.nPngDataSize = 0;
            if (this.pngImageDataArray != null) {
                System.gc();
                this.pngImageDataArray = null;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(string));
                int i2 = 0;
                while (true) {
                    int i3 = dataInputStream.read();
                    if (i3 == -1) {
                        break;
                    }
                    if (this.nPngDataSize < 4) {
                        i2 = (i2 << 8) + i3;
                        if (this.nPngDataSize == 3 && i2 != -1991225785) {
                            this.nPngDataSize = i2;
                            break;
                        }
                    }
                    this.nPngDataSize++;
                }
                dataInputStream.close();
                DataInputStream dataInputStream2 = new DataInputStream(getClass().getResourceAsStream(string));
                this.pngImageDataArray = new byte[this.nPngDataSize];
                dataInputStream2.readFully(this.pngImageDataArray);
                dataInputStream2.close();
                this.pngImageDataArray[0] = -119;
                this.pngImageDataArray[1] = 80;
                this.pngImageDataArray[2] = 78;
                this.pngImageDataArray[3] = 71;
                int[] iArr = new int[2];
                asset_FindChunk(1347179589, iArr);
                asset_FilterPalette(this.pngImageDataArray, iArr[0] + 4, iArr[1] - 4);
                crc(this.pngImageDataArray, iArr[1], iArr[0]);
                if (z) {
                    try {
                        this.asset_FlippedImageArray[i] = Image.createImage(this.pngImageDataArray, 0, this.nPngDataSize);
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1174);
                    } catch (IllegalArgumentException e4) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1179);
                    } catch (NullPointerException e5) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1184);
                    }
                } else {
                    try {
                        this.asset_ImageArray[i] = Image.createImage(this.pngImageDataArray, 0, this.nPngDataSize);
                    } catch (ArrayIndexOutOfBoundsException e6) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1200);
                    } catch (IllegalArgumentException e7) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1205);
                    } catch (NullPointerException e8) {
                        Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1210);
                    }
                }
                this.pngImageDataArray = null;
            } catch (Error e9) {
                Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1137);
                this.pngImageDataArray = null;
                return -1;
            } catch (Exception e10) {
                Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1130);
                this.pngImageDataArray = null;
                return -1;
            }
        }
        return 0;
    }

    void asset_DrawClipped(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        if (i4 < this.system_xClip) {
            i6 -= this.system_xClip - i4;
            i4 = this.system_xClip;
        }
        if (i4 + i6 > this.system_xClip + this.system_nClipWidth) {
            i6 = (this.system_xClip + this.system_nClipWidth) - i4;
        }
        if (i5 < this.system_yClip) {
            i7 -= this.system_yClip - i5;
            i5 = this.system_yClip;
        }
        if (i5 + i7 > this.system_yClip + this.system_nClipHeight) {
            i7 = (this.system_yClip + this.system_nClipHeight) - i5;
        }
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        system_UpdateDirty(i4, i5, i6, i7);
        m_CurrentGraphics.setClip(i4, i5, i6, i7);
        if (this.asset_ImageArray[i] != null) {
            if (z && this.asset_FlippedImageArray[i] == null) {
                return;
            }
            if (!z) {
                m_CurrentGraphics.drawImage(this.asset_ImageArray[i], i2, i3, 20);
            } else {
                Assert(this.asset_FlippedImageArray[i] != null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_share.hpp", 319);
                m_CurrentGraphics.drawImage(this.asset_FlippedImageArray[i], i2, i3, 20);
            }
        }
    }

    void asset_DrawFrame(int i, int i2, int i3) {
        asset_DrawFrame(i, i2, i3, -1);
    }

    void asset_DrawFrame(int i, int i2, int i3, int i4) {
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s3 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i5 = 0; i5 < s3; i5++) {
            if (i5 != i4) {
                int iAsset_GetArrayElement = asset_GetArrayElement(s2, i5);
                asset_DrawImage(asset_GetArrayElement(s, i5), ((short) ((this.asset_DataArray[iAsset_GetArrayElement + 0] & (-65536)) >> 16)) + i2, ((short) ((this.asset_DataArray[iAsset_GetArrayElement + 0] & 65535) >> 0)) + i3);
            }
        }
    }

    void asset_DrawFrameFlipped(int i, int i2, int i3) {
        asset_DrawFrameFlipped(i, i2, i3, -1);
    }

    void asset_DrawFrameFlipped(int i, int i2, int i3, int i4) {
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s3 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i5 = 0; i5 < s3; i5++) {
            if (i5 != i4) {
                int iAsset_GetArrayElement = asset_GetArrayElement(s2, i5);
                asset_DrawImageFlipped(asset_GetArrayElement(s, i5), i2 - ((short) ((this.asset_DataArray[iAsset_GetArrayElement + 0] & (-65536)) >> 16)), ((short) ((this.asset_DataArray[iAsset_GetArrayElement + 0] & 65535) >> 0)) + i3);
            }
        }
    }

    void asset_DrawImage(int i, int i2, int i3) {
        int i4 = i2 + ((short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16));
        int i5 = i3 + ((short) ((this.asset_DataArray[i + 0] & 65535) >> 0));
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s3 = (short) ((this.asset_DataArray[i + 2] & 65535) >> 0);
        short s4 = (short) ((this.asset_DataArray[i + 3] & (-65536)) >> 16);
        asset_DrawClipped((short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 2] & (-65536)) >> 16)) + 0] & (-65536)) >> 16), i4 - s3, i5 - s4, i4, i5, s, s2, false);
    }

    void asset_DrawImageFlipped(int i, int i2, int i3) {
        int i4 = i2 - ((short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16));
        int i5 = i3 + ((short) ((this.asset_DataArray[i + 0] & 65535) >> 0));
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s3 = (short) ((this.asset_DataArray[i + 2] & 65535) >> 0);
        short s4 = (short) ((this.asset_DataArray[i + 3] & (-65536)) >> 16);
        short s5 = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 2] & (-65536)) >> 16)) + 0] & (-65536)) >> 16);
        asset_DrawClipped(s5, (s3 + i4) - this.asset_ImageArray[s5].getWidth(), i5 - s4, i4 - s, i5, s, s2, true);
    }

    void asset_DrawTileMap(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        byte b;
        byte b2;
        byte b3;
        int i8 = 0;
        int i9 = ((short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16)) << 4;
        int i10 = ((short) ((this.asset_DataArray[i + 0] & 65535) >> 0)) << 4;
        int i11 = i2 + i9;
        int i12 = i3 + i10;
        int i13 = this.system_xClip;
        int i14 = this.system_yClip;
        int i15 = this.system_nClipWidth + this.system_xClip;
        int i16 = this.system_yClip + this.system_nClipHeight;
        if (i11 <= i13 || i2 >= i15 || i12 <= i14 || i3 >= i16) {
            return;
        }
        if (i2 < i13) {
            i8 = 0 + (i13 - i2);
        } else {
            i13 = i2;
        }
        if (i11 > i15) {
            i9 += i15 - i11;
            i11 = i15;
        }
        if (i3 < i14) {
            i4 = 0 + (i14 - i3);
        } else {
            i14 = i3;
            i4 = 0;
        }
        if (i12 > i16) {
            i5 = (i16 - i12) + i10;
        } else {
            i16 = i12;
            i5 = i10;
        }
        if (i9 <= i8 || i5 <= i4) {
            return;
        }
        system_UpdateDirty(i13, i14, i11 - i13, i16 - i14);
        int i17 = i8 >> 4;
        int i18 = i4 >> 4;
        int i19 = i9 >> 4;
        int i20 = i5 >> 4;
        int i21 = i8 & 15;
        int i22 = i4 & 15;
        int i23 = i9 & 15;
        int i24 = i5 & 15;
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        this.asset_nTileImageID = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
        byte[] bArr = this.asset_TileMapArray[(byte) ((this.asset_DataArray[i + 1] & (-16777216)) >> 24)];
        Assert(bArr != null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_share.hpp", 870);
        int i25 = i17 + (i18 * s);
        int i26 = i20 == i18 ? i24 : 16;
        byte b4 = bArr[i25];
        if (b4 != -1) {
            asset_BlitTile(b4, i13, i14, i21, i19 == i17 ? i23 : 16, i22, i26);
        }
        int i27 = i13 + (16 - i21);
        int i28 = 1;
        while (i28 < i19 - i17) {
            byte b5 = bArr[i25 + i28];
            if (b5 != -1) {
                asset_BlitTile(b5, i27, i14, 0, 16, i22, i26);
            }
            i27 += 16;
            i28++;
        }
        if (i23 != 0 && i19 != i17 && (b3 = bArr[i28 + i25]) != -1) {
            asset_BlitTile(b3, i27, i14, 0, i23, i22, i26);
        }
        int i29 = i14 + (16 - i22);
        int i30 = i25 + s;
        int i31 = i18 + 1;
        while (true) {
            i6 = i30;
            int i32 = i31;
            if (i32 >= i20) {
                break;
            }
            byte b6 = bArr[i6];
            if (b6 != -1) {
                asset_BlitTile(b6, i13, i29, i21, i19 == i17 ? i23 : 16, 0, 16);
            }
            int i33 = i13 + (16 - i21);
            Image image = this.asset_ImageArray[this.asset_nTileImageID];
            int i34 = (i19 - i17) + i6;
            for (int i35 = i6 + 1; i35 < i34; i35++) {
                byte b7 = bArr[i35];
                if (b7 != -1) {
                    m_CurrentGraphics.setClip(i33, i29, 16, 16);
                    m_CurrentGraphics.drawImage(image, i33 - ((b7 & 7) << 4), i29 - ((b7 >> 3) << 4), 20);
                    i33 += 16;
                }
            }
            int i36 = i19 - i17;
            if (i23 != 0 && i19 != i17 && (b2 = bArr[i36 + i6]) != -1) {
                asset_BlitTile(b2, i33, i29, 0, i23, 0, 16);
            }
            i29 += 16;
            i30 = i6 + s;
            i31 = i32 + 1;
        }
        if (i24 == 0 || i20 == i18) {
            return;
        }
        byte b8 = bArr[i6];
        if (b8 != -1) {
            asset_BlitTile(b8, i13, i29, i21, i19 == i17 ? i23 : 16, 0, i24);
        }
        int i37 = i13 + (16 - i21);
        int i38 = 1;
        while (true) {
            i7 = i38;
            if (i7 >= i19 - i17) {
                break;
            }
            byte b9 = bArr[i6 + i7];
            if (b9 != -1) {
                asset_BlitTile(b9, i37, i29, 0, 16, 0, i24);
            }
            i37 += 16;
            i38 = i7 + 1;
        }
        if (i23 == 0 || i19 == i17 || (b = bArr[i6 + i7]) == -1) {
            return;
        }
        asset_BlitTile(b, i37, i29, 0, i23, 0, i24);
    }

    void asset_FilterPalette(byte[] bArr, int i, int i2) {
        switch (this.asset_PaletteFilter) {
            case 1:
                for (int i3 = i; i3 < i + i2; i3 += 3) {
                    int i4 = bArr[i3 + 0] & 255;
                    if (i4 < 0) {
                        i4 += 255;
                    }
                    int i5 = bArr[i3 + 1] & 255;
                    if (i5 < 0) {
                        i5 += 255;
                    }
                    int i6 = bArr[i3 + 2] & 255;
                    if (i6 < 0) {
                        i6 += 255;
                    }
                    if (i4 == i5 && i4 == i6 && i5 == i6) {
                        int i7 = (this.asset_PaletteFilterParams[0] >> 16) & 255;
                        int i8 = (this.asset_PaletteFilterParams[0] >> 8) & 255;
                        int i9 = this.asset_PaletteFilterParams[0] & 255;
                        bArr[i3 + 0] = (byte) ((i7 * i4) >> 8);
                        bArr[i3 + 1] = (byte) ((i8 * i4) >> 8);
                        bArr[i3 + 2] = (byte) ((i4 * i9) >> 8);
                    }
                }
                break;
            case 2:
                try {
                    asset_LoadData(this.asset_PaletteFilterParams[0]);
                    short s = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[this.asset_PaletteFilterParams[0] + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
                    int i10 = (this.asset_DataArray[this.asset_PaletteFilterParams[0] + 0] & (-1)) >> 0;
                    short s2 = (short) ((this.asset_DataArray[this.asset_PaletteFilterParams[0] + 1] & (-65536)) >> 16);
                    for (int i11 = i; i11 < i + i2; i11 += 3) {
                        int i12 = 268435455;
                        int i13 = bArr[i11 + 0] & 255;
                        int i14 = bArr[i11 + 1] & 255;
                        int i15 = bArr[i11 + 2] & 255;
                        int i16 = i10;
                        while (i16 < (s2 >> 1) + i10) {
                            int i17 = this.asset_DataBufArray[s][i16 + 0] & 255;
                            int i18 = this.asset_DataBufArray[s][i16 + 1] & 255;
                            int i19 = this.asset_DataBufArray[s][i16 + 2] & 255;
                            int i20 = ((i13 - i17) * (i13 - i17)) + ((i14 - i18) * (i14 - i18)) + ((i15 - i19) * (i15 - i19));
                            if (i20 < i12) {
                                int i21 = this.asset_DataBufArray[s][(s2 >> 1) + i16 + 0] & 255;
                                int i22 = this.asset_DataBufArray[s][(s2 >> 1) + i16 + 1] & 255;
                                int i23 = this.asset_DataBufArray[s][(s2 >> 1) + i16 + 2] & 255;
                                bArr[i11 + 0] = (byte) i21;
                                bArr[i11 + 1] = (byte) i22;
                                bArr[i11 + 2] = (byte) i23;
                            } else {
                                i20 = i12;
                            }
                            i16 += 3;
                            i12 = i20;
                        }
                    }
                    asset_FreeData(this.asset_PaletteFilterParams[0]);
                } catch (Exception e) {
                    Assert(0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_share.hpp", 1475);
                    return;
                }
                break;
        }
    }

    boolean asset_FindChunk(int i, int[] iArr) {
        for (int i2 = 0; i2 < this.nPngDataSize; i2++) {
            if (this.pngImageDataArray[i2] == (i >> 24) && this.pngImageDataArray[i2 + 1] == ((i >> 16) & 255) && this.pngImageDataArray[i2 + 2] == ((i >> 8) & 255) && this.pngImageDataArray[i2 + 3] == (i & 255)) {
                iArr[1] = ((this.pngImageDataArray[i2 - 4] & 255) << 24) + ((this.pngImageDataArray[i2 - 3] & 255) << 16) + ((this.pngImageDataArray[i2 - 2] & 255) << 8) + ((this.pngImageDataArray[i2 - 1] & 255) << 0) + 4;
                iArr[0] = i2;
                return true;
            }
        }
        return false;
    }

    int asset_FindSound(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (this.asset_SoundArray[i2] != null && this.asset_SoundArray[i2].soundID == i) {
                return i2;
            }
        }
        return -1;
    }

    void asset_FreeAnim(int i) {
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_FreeFrame(asset_GetArrayElement(s, i2));
        }
    }

    void asset_FreeCombinedData(int i) {
        short s = (short) ((this.asset_DataArray[i + 0] & 65535) >> 0);
        Assert(s != 0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1539);
        int i2 = s - 1;
        if (i2 == 0) {
            short s2 = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
            Assert(this.asset_DataBufArray[s2] != null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1544);
            this.asset_DataBufArray[s2] = null;
            System.gc();
        }
        this.asset_DataArray[i + 0] = (i2 << 0) | (this.asset_DataArray[i + 0] & (-65536));
    }

    void asset_FreeCombinedImage(int i) {
        short s = (short) ((this.asset_DataArray[i + 0] & 65535) >> 0);
        short s2 = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        int i2 = s - 1;
        if (i2 == 0) {
            if (this.asset_ImageArray[s2] == null) {
            }
            Assert(this.asset_ImageArray[s2] != null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1448);
            this.asset_ImageArray[s2] = null;
        }
        this.asset_DataArray[i + 0] = (this.asset_DataArray[i + 0] & (-65536)) | ((i2 >= 0 ? i2 : 0) << 0);
    }

    void asset_FreeData() {
        this.asset_DataArray = null;
    }

    void asset_FreeData(int i) {
        asset_FreeCombinedData((short) ((this.asset_DataArray[i + 1] & 65535) >> 0));
    }

    void asset_FreeDocument(int i) {
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_FreeData(asset_GetArrayElement(s, i2));
        }
    }

    void asset_FreeFixedFont(int i) {
        short s = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_FreeFixedFontColor(asset_GetArrayElement(s, i2));
        }
    }

    void asset_FreeFixedFontColor(int i) {
        asset_FreeImage((short) ((this.asset_DataArray[i + 1] & 65535) >> 0));
    }

    void asset_FreeFrame(int i) {
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_FreeImage(asset_GetArrayElement(s, i2));
        }
    }

    void asset_FreeImage(int i) {
        asset_FreeCombinedImage((short) ((this.asset_DataArray[i + 2] & (-65536)) >> 16));
    }

    synchronized void asset_FreeSound(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (this.asset_SoundArray[i2] != null && this.asset_SoundArray[i2].soundID == i) {
                CSoundObject cSoundObject = this.asset_SoundArray[i2];
                int i3 = cSoundObject.refCount - 1;
                cSoundObject.refCount = i3;
                if (i3 != 0) {
                    break;
                }
                this.Player[this.ActivePlayer].DisposeSound(this.asset_SoundArray[i2]);
                this.asset_SoundArray[i2].Dispose();
                this.asset_SoundArray[i2].soundID = -1;
                this.asset_SoundArray[i2] = null;
                break;
            }
        }
    }

    void asset_FreeSoundEngine() {
        for (int i = 0; i < 1; i++) {
            this.Player[i].Destroy();
            this.Player[i] = null;
        }
    }

    void asset_FreeTileMap(int i) {
        asset_FreeCombinedImage((short) ((this.asset_DataArray[i + 1] & 65535) >> 0));
        byte b = (byte) ((this.asset_DataArray[i + 1] & 16711680) >> 16);
        Assert(b != 0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1742);
        int i2 = b - 1;
        if (i2 == 0) {
            byte b2 = (byte) ((this.asset_DataArray[i + 1] & (-16777216)) >> 24);
            Assert(this.asset_TileMapArray[b2] != null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1747);
            this.asset_TileMapArray[b2] = null;
        }
        this.asset_DataArray[i + 1] = (this.asset_DataArray[i + 1] & (-16711681)) | ((i2 >= 0 ? i2 : 0) << 16);
    }

    int asset_GetArrayElement(int i, int i2) {
        int i3 = i2 + 1;
        int i4 = (i3 >> 1) + i;
        return (i3 & 1) != 0 ? this.asset_DataArray[i4] & 65535 : (this.asset_DataArray[i4] >> 16) & 65535;
    }

    void asset_InitSoundEngine() throws Exception {
        System.out.println("Init Snd engine\n");
        System.out.flush();
        this.ActivePlayer = 0;
        for (int i = 0; i < 1; i++) {
            this.Player[i] = new CSoundPlayerMIDP2(this);
            this.Player[i].Construct();
        }
    }

    synchronized boolean asset_IsAnySoundPlaying() {
        return !this.system_bSoundOn ? false : this.Player[this.ActivePlayer].IsAnySoundPlaying();
    }

    synchronized boolean asset_IsSoundPlaying(int i) {
        int iAsset_FindSound;
        boolean z = false;
        synchronized (this) {
            if (this.system_bSoundOn && -1 != (iAsset_FindSound = asset_FindSound(i)) && this.Player[this.ActivePlayer].IsSoundPlaying(this.asset_SoundArray[iAsset_FindSound])) {
                z = true;
            }
        }
        return z;
    }

    void asset_LoadAnim(int i, boolean z) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_LoadFrame(asset_GetArrayElement(s, i2), z);
        }
    }

    void asset_LoadCombinedData(int i) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 0] & 65535) >> 0);
        Assert(s >= 0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1487);
        int i2 = s + 1;
        if (s == 0) {
            short s2 = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
            Assert(this.asset_DataBufArray[s2] == null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1496);
            DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(Integer.toString(s2)).append("_dat/").append(Integer.toString(s2)).append(".dat").toString()));
            this.asset_DataBufArray[s2] = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(this.asset_DataBufArray[s2]);
            dataInputStream.close();
        }
        this.asset_DataArray[i + 0] = (i2 << 0) | (this.asset_DataArray[i + 0] & (-65536));
    }

    void asset_LoadCombinedImage(int i, boolean z) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 0] & 65535) >> 0);
        short s2 = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s3 = (short) ((this.asset_DataArray[(i + 0) + 1] & 65535) >> 0);
        Assert(s >= 0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1265);
        int i2 = s + 1;
        if (s == 0) {
            asset_CreateImage(new StringBuffer().append("/").append(Integer.toString(s3)).append(".png").toString(), s2, false);
            if (z) {
                asset_CreateImage(new StringBuffer().append("/f/").append(Integer.toString(s3)).append(".png").toString(), s2, true);
            }
        }
        this.asset_DataArray[i + 0] = (i2 << 0) | (this.asset_DataArray[i + 0] & (-65536));
        if (((short) ((this.asset_DataArray[i + 0] & 65535) >> 0)) < 0) {
        }
    }

    void asset_LoadData() throws Exception {
        DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream("data_bin/data.bin"));
        int i = dataInputStream.readInt();
        this.asset_DataArray = new int[i >> 2];
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        int i2 = i >> 2;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 << 2;
            this.asset_DataArray[i3] = (bArr[i4 + 3] & 255) | (bArr[i4] << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
        }
        dataInputStream.close();
    }

    void asset_LoadData(int i) throws Exception {
        asset_LoadCombinedData((short) ((this.asset_DataArray[i + 1] & 65535) >> 0));
    }

    void asset_LoadDocument(int i) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_LoadData(asset_GetArrayElement(s, i2));
        }
    }

    void asset_LoadFixedFont(int i) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 1] & 65535) >> 0);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_LoadFixedFontColor(asset_GetArrayElement(s, i2));
        }
    }

    void asset_LoadFixedFontColor(int i) throws Exception {
        asset_LoadImage((short) ((this.asset_DataArray[i + 1] & 65535) >> 0), false);
    }

    void asset_LoadFrame(int i, boolean z) throws Exception {
        short s = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i2 = 0; i2 < s2; i2++) {
            asset_LoadImage(asset_GetArrayElement(s, i2), z);
        }
    }

    void asset_LoadImage(int i, boolean z) throws Exception {
        asset_LoadCombinedImage((short) ((this.asset_DataArray[i + 2] & (-65536)) >> 16), z);
    }

    void asset_LoadSound(int i, int i2) throws Exception {
        if (i < 0) {
            return;
        }
        for (int i3 = 0; i3 < 10; i3++) {
            if (this.asset_SoundArray[i3] != null && this.asset_SoundArray[i3].soundID == i) {
                this.asset_SoundArray[i3].refCount++;
                return;
            }
        }
        asset_LoadData(i);
        short s = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
        int i4 = (this.asset_DataArray[i + 0] & (-1)) >> 0;
        int i5 = (short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16);
        if (i5 < 0) {
            i5 += 65536;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (this.asset_SoundArray[i6] == null) {
                this.asset_SoundArray[i6] = new CSoundObject(this);
                this.asset_SoundArray[i6].soundID = (short) i;
                this.asset_SoundArray[i6].refCount = 1;
                byte[] bArr = new byte[i5];
                for (int i7 = 0; i7 < i5; i7++) {
                    bArr[i7] = this.asset_DataBufArray[s][i7 + i4];
                }
                if (i > 999 && i <= 999) {
                    this.asset_SoundArray[i6].LoadSound(bArr, 2);
                } else if (i > 999 && i <= 1014) {
                    this.asset_SoundArray[i6].LoadSound(bArr, 3);
                } else if (i > 1014 && i <= 1014) {
                    this.asset_SoundArray[i6].LoadSound(bArr, 1);
                } else if (i > 1014 && i <= 1014) {
                    this.asset_SoundArray[i6].LoadSound(bArr, 4);
                } else if (i > 1014 && i <= 1014) {
                    this.asset_SoundArray[i6].LoadSound(bArr, 5);
                }
                this.Player[this.ActivePlayer].PrepareSound(this.asset_SoundArray[i6], i2);
                asset_FreeData(i);
                return;
            }
        }
    }

    void asset_LoadTileMap(int i) throws Exception {
        int i2;
        byte b = (byte) ((this.asset_DataArray[i + 1] & 16711680) >> 16);
        Assert(b >= 0, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1655);
        if (b == 0) {
            byte b2 = (byte) ((this.asset_DataArray[i + 1] & (-16777216)) >> 24);
            Assert(this.asset_TileMapArray[b2] == null, "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1666);
            DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(Integer.toString(b2)).append("_map/").append(Integer.toString(b2)).append(".map").toString()));
            int i3 = dataInputStream.readInt();
            this.asset_TileMapArray[b2] = new byte[i3];
            dataInputStream.readFully(this.asset_TileMapArray[b2]);
            dataInputStream.close();
            Assert(i3 == ((short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16)) * ((short) ((this.asset_DataArray[i + 0] & 65535) >> 0)), "c:\\mobiledevelopment\\ndplatform\\ndsrc\\asset_java.hpp", 1700);
            asset_LoadCombinedImage((short) ((this.asset_DataArray[i + 1] & 65535) >> 0), false);
            i2 = b + 1;
        } else {
            i2 = b;
        }
        this.asset_DataArray[i + 1] = (i2 << 16) | (this.asset_DataArray[i + 1] & (-16711681));
    }

    synchronized void asset_PlaySFX(int i) {
    }

    synchronized void asset_PlaySoundImmediate(int i) {
        int iAsset_FindSound;
        if (this.system_bSoundOn && -1 != (iAsset_FindSound = asset_FindSound(i))) {
            this.Player[this.ActivePlayer].PlaySoundImmediate(this.asset_SoundArray[iAsset_FindSound]);
        }
    }

    synchronized void asset_PlaySoundNowIfPossible(int i) {
        int iAsset_FindSound;
        if (this.system_bSoundOn && -1 != (iAsset_FindSound = asset_FindSound(i))) {
            this.Player[this.ActivePlayer].PlayBackgroundMusic(this.asset_SoundArray[iAsset_FindSound]);
        }
    }

    void asset_ReplaceChildImage(int i, int i2, int i3) {
        short s = (short) ((this.asset_DataArray[i + 0] & (-65536)) >> 16);
        short s2 = (short) ((this.asset_DataArray[s + 0] & (-65536)) >> 16);
        for (int i4 = 0; i4 < s2; i4++) {
            int iAsset_GetArrayElement = asset_GetArrayElement(s, i4);
            short s3 = (short) ((this.asset_DataArray[iAsset_GetArrayElement + 1] & (-65536)) >> 16);
            short s4 = (short) ((this.asset_DataArray[s3 + 0] & (-65536)) >> 16);
            for (int i5 = 0; i5 < s4; i5++) {
                if (asset_GetArrayElement(s3, i5) == i2) {
                    asset_SetArrayElement(s3, i5, i3);
                }
            }
        }
    }

    void asset_SetActivePlayer(int i) {
        this.ActivePlayer = i;
    }

    void asset_SetArrayElement(int i, int i2, int i3) {
        int i4 = i2 + 1;
        int i5 = (i4 >> 1) + i;
        if ((i4 & 1) != 0) {
            this.asset_DataArray[i5] = (this.asset_DataArray[i5] & (-65536)) | (i3 & 65535);
        } else {
            this.asset_DataArray[i5] = (this.asset_DataArray[i5] & 65535) | (i3 << 16);
        }
    }

    void asset_SetPaletteFilter(int i, int i2) {
        asset_SetPaletteFilter(i, new int[]{i2});
    }

    void asset_SetPaletteFilter(int i, int[] iArr) {
        this.asset_PaletteFilter = i;
        this.asset_PaletteFilterParams = iArr;
    }

    void asset_StopSound(int i) {
        if (-1 == i) {
            for (int i2 = 0; i2 < 1; i2++) {
                this.Player[i2].StopAllSounds();
            }
            return;
        }
        int iAsset_FindSound = asset_FindSound(i);
        if (iAsset_FindSound != -1) {
            this.Player[this.ActivePlayer].StopSound(this.asset_SoundArray[iAsset_FindSound]);
        }
    }

    void binFree(int i) {
        asset_FreeData(i);
    }

    short binGetShort(int i) {
        int i2 = this.asset_DataBufArray[i][this.map_dataPointer];
        int i3 = this.asset_DataBufArray[i][this.map_dataPointer + 1];
        if (i2 < 0) {
            i2 += 256;
        }
        if (i3 < 0) {
            i3 += 256;
        }
        this.map_dataPointer += 2;
        return (short) (((i3 & 255) << 8) | (i2 & 255));
    }

    int binLoad(int i) {
        try {
            asset_LoadData(i);
            short s = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
            int i2 = (this.asset_DataArray[i + 0] & (-1)) >> 0;
            this.map_dataPointer = i2;
            return s;
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4830, e.toString());
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4830, e2.toString());
            return -1;
        }
    }

    void clearSavedLang() {
        try {
            RecordStore.deleteRecordStore("currentLanguage");
        } catch (Exception e) {
        }
    }

    boolean crc(byte[] bArr, int i, int i2) {
        long jUpdate_crc = update_crc(4294967295L, bArr, i, i2) ^ 4294967295L;
        bArr[i2 + i + 0] = (byte) ((jUpdate_crc >> 24) & 255);
        bArr[i2 + i + 1] = (byte) ((jUpdate_crc >> 16) & 255);
        bArr[i2 + i + 2] = (byte) ((jUpdate_crc >> 8) & 255);
        bArr[i2 + i + 3] = (byte) ((jUpdate_crc >> 0) & 255);
        return true;
    }

    void createTimeString() {
        int i = this.game_Time - 5000;
        if (i < 0) {
            i = 0;
        }
        int i2 = (i / 1000) % 60;
        int i3 = i / 60000;
        this.g_race.m_timeString = new StringBuffer().append("").append(new StringBuffer().append(i3 < 10 ? "0" : "").append(i3).toString()).append(":").append(new StringBuffer().append(i2 < 10 ? "0" : "").append(i2).toString()).toString();
        int i4 = this.g_race.m_nFastestLapTime;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = (i4 / 1000) % 60;
        int i6 = i4 / 60000;
        this.g_race.m_LapTimeString = new StringBuffer().append("").append(new StringBuffer().append(i6 < 10 ? "0" : "").append(i6).toString()).append(":").append(new StringBuffer().append(i5 < 10 ? "0" : "").append(i5).toString()).toString();
        if (!this.g_race.m_bMission && this.g_race.m_nFastestLapTime > 0 && (this.g_player.m_LapTimes[this.g_race.m_quickraceID] > this.g_race.m_nFastestLapTime || this.g_player.m_LapTimes[this.g_race.m_quickraceID] == 0)) {
            this.g_player.m_LapTimes[this.g_race.m_quickraceID] = this.g_race.m_nFastestLapTime;
        }
        this.g_race.m_nTopSpeed = this.players[0].m_nHighestRaceSpeed * 2;
        this.g_race.m_nTopSpeed = (this.g_race.m_nTopSpeed * 2) >> 1;
    }

    void drawBG() {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 2106908);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect(0, 0, this.system_nCanvasWidth, 18, 0);
        system_FillRect(0, 18, 91, 37, 0);
        asset_DrawImage(740, 91, 18);
        asset_DrawImage(736, 0, 55);
        asset_DrawImage(732, 0, 83);
    }

    void drawSoftKey(int i, int i2) {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        this.font_text.SetColor(16777215);
        int i3 = this.system_nCanvasHeight - 20;
        if (this.g_nLanguage == 0) {
            i3++;
        }
        if (i2 == 0) {
            asset_DrawImage(948, 0, this.system_nCanvasHeight - 18);
            this.font_text.DrawSubstring(this.g_Text[i], 0, this.g_Text[i].length(), 45, i3, 1);
        } else {
            asset_DrawImage(948, this.system_nCanvasWidth - 90, this.system_nCanvasHeight - 18);
            this.font_text.DrawSubstring(this.g_Text[i], 0, this.g_Text[i].length(), this.system_nCanvasWidth - 45, i3, 1);
        }
    }

    void game_CheckControl() throws Exception {
        if ((this.game_nKeyFlags & 512) != 0) {
            this.trackPVSSegment++;
            if (this.trackPVSSegment > 99) {
                this.trackPVSSegment = 99;
                return;
            }
            return;
        }
        if ((this.game_nKeyFlags & 1024) != 0) {
            this.trackPVSSegment--;
            if (this.trackPVSSegment < 0) {
                this.trackPVSSegment = 0;
            }
        }
    }

    void game_ClearKeyHistory() {
        this.game_nKeyFlags = 0;
    }

    void game_ClearLevelLoading() throws Exception {
        game_clearPopupText();
        asset_FreeImage(788);
        asset_FreeImage(922);
        asset_FreeImage(930);
        asset_FreeImage(926);
        this.game_isLoading = false;
        game_UpdateCamera(100);
    }

    void game_Construct() throws Exception {
        this.game_posZ = 768;
        this.game_posX = 6400;
        this.game_posY = 6400;
        this.game_cameraAngZ = 0;
        this.camera = new Camera();
        this.camera.setPerspective(80.0f, 1.0f, 0.5f, 1000.0f);
        this.game_loadState = 0;
        this.game_isLoading = false;
        for (int i = 0; i < 50; i++) {
            this.scene_timing[i] = -1;
        }
    }

    void game_CreateBuffer() {
        this.game_imageMapBuffer = Image.createImage(this.system_nCanvasWidth, this.system_nCanvasHeight);
        this.game_gMapBuffer = this.game_imageMapBuffer.getGraphics();
    }

    void game_Destroy() {
        game_LevelCleanup(true);
    }

    void game_DrawDownIcon(int i, int i2) {
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setColor(255, 174, 64);
        m_CurrentGraphics.drawLine(i - 2, i2, i + 2, i2);
        m_CurrentGraphics.drawLine(i - 2, i2, i, i2 + 3);
        m_CurrentGraphics.drawLine(i + 2, i2, i, i2 + 3);
        m_CurrentGraphics.drawLine(i, i2 + 1, i, i2 + 2);
    }

    void game_DrawGameBackground(boolean z) {
    }

    void game_DrawHUD() {
        boolean z = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.game_TimeUpdate > 1000) {
            game_DrawHUDMain();
            this.game_TimeUpdate = jCurrentTimeMillis;
            z = true;
        }
        if ((this.frameCount & 1) == 0 || z) {
            game_DrawHUDMainEx();
        }
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        if (this.game_Time < 6000) {
            switch (5 - (this.game_Time / 1000)) {
                case 0:
                    this.font_ingame.DrawSubstring(this.g_Text[185], 0, this.g_Text[185].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1);
                    break;
                case 1:
                    this.font_ingame.DrawSubstring("1", 0, "1".length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1);
                    break;
                case 2:
                    this.font_ingame.DrawSubstring("2", 0, "2".length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1);
                    break;
                case 3:
                    this.font_ingame.DrawSubstring("3", 0, "3".length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1);
                    break;
            }
            return;
        }
        if (this.popupTimer <= this.game_Time || this.game_state != 2) {
            if (this.popupTimer > 0) {
                game_clearPopupText();
            }
        } else if (this.popupString != null) {
            system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
            this.font_ingame.SetColor(255, 255, 255);
            this.font_ingame.DrawSubstringWrapped(this.popupString, 0, this.popupString.length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1, 0);
        } else if (this.popupImg == -1) {
            this.popupTimer = this.game_Time - 1;
        } else {
            system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
            asset_DrawImage(this.popupImg, (this.system_nCanvasWidth >> 1) - 68, (this.system_nCanvasHeight >> 1) - 20);
        }
    }

    void game_DrawHUDMain() {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        asset_DrawImage(138, 0, 0);
        asset_DrawImage(134, 89, 0);
        if (this.g_race.m_type == 1) {
            asset_DrawImage(this.g_HudImgs[1], 27, 30);
        } else if (this.g_race.m_type == 3) {
            asset_DrawImage(this.g_HudImgs[2], 27, 30);
        } else {
            asset_DrawImage(this.g_HudImgs[0], 27, 30);
        }
        asset_DrawImage(this.g_HudImgs[6], 4, 43);
        for (int i = 0; i < this.players[0].m_nCurrentHeatRating; i++) {
            asset_DrawImage(232, (i * 12) + 35, 43);
        }
        int iAbs = this.players[0].m_velocityLastFrame < 0 ? 0 : this.players[0].m_velocityLastFrame < 100 ? 1 : Math.abs(this.players[0].m_velocityLastFrame >> 11) + 2;
        if (iAbs >= this.gearImgsOn.length) {
            iAbs = this.gearImgsOn.length - 1;
        }
        this.game_currentGear = iAbs;
        asset_DrawImage(this.gearImgsOn[iAbs], (iAbs * 8) + 90, 58);
        int i2 = (this.g_race.m_type == 3 || this.g_race.m_type == 4) ? this.game_Time < 5000 ? this.g_race.m_nTimeLimit : this.g_race.m_nTimeLimit - (this.game_Time - 5000) : this.game_Time - 5000;
        if (i2 < 0) {
            i2 = 0;
        }
        game_DrawNumber(this.hudLGImages, i2 / 60000, 42, 6, 2, 12);
        game_DrawNumber(this.hudLGImages, (i2 / 1000) % 60, 72, 6, 2, 12);
        if (this.game_state == 2) {
            int i3 = 1;
            if (this.g_race.m_type == 1) {
                for (int i4 = 1; i4 < this.g_race.m_numRacers; i4++) {
                    if (this.players[i4].m_nCurCheckpoint > this.players[0].m_nCurCheckpoint || (this.players[i4].m_nCurCheckpoint == this.players[0].m_nCurCheckpoint && this.players[i4].m_nCheckpointTime < this.players[0].m_nCheckpointTime)) {
                        i3++;
                    }
                }
            } else {
                for (int i5 = 1; i5 < this.g_race.m_numRacers; i5++) {
                    if (this.players[i5].m_nPlayerDist < 0) {
                        i3++;
                    } else if (this.players[i5].m_nPlayerDist == 0 && this.g_race.m_type != 4 && this.players[0].m_nCurrentSplineDistance < this.players[i5].m_nCurrentSplineDistance) {
                        i3++;
                    }
                }
            }
            this.game_playerPosition = i3;
        }
        if (this.g_race.m_type == 2) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.g_race.m_numRacers; i7++) {
                if (!this.players[i7].m_bDisabled) {
                    i6++;
                }
            }
            game_DrawNumber(this.hudLGImages, i6, 7, 27, 1, 12);
            game_DrawNumber(this.hudLGImages, this.game_playerPosition, 7, 7, 1, 12);
        } else if (this.g_race.m_type == 4) {
            game_DrawNumber(this.hudLGImages, 1, 7, 27, 1, 12);
            game_DrawNumber(this.hudLGImages, 1, 7, 7, 1, 12);
        } else {
            game_DrawNumber(this.hudLGImages, this.g_race.m_numRacers, 7, 27, 1, 12);
            game_DrawNumber(this.hudLGImages, this.game_playerPosition, 7, 7, 1, 12);
        }
        if (this.g_race.m_type == 4) {
            asset_DrawImage(326, 51, 20);
            asset_DrawImage(326, 37, 20);
        } else if (this.g_race.m_type == 0 || this.g_race.m_type == 2) {
            int i8 = this.players[0].m_nLap < 1 ? 1 : this.players[0].m_nLap >= this.g_race.m_laps ? this.g_race.m_laps : this.players[0].m_nLap + 1;
            game_DrawNumber(this.hudSMImages, this.g_race.m_laps, 77, 30, 1, 8);
            game_DrawNumber(this.hudSMImages, i8, 57, 30, 1, 8);
        } else if (this.g_race.m_type == 1 || this.g_race.m_type == 3) {
            game_DrawNumber(this.hudSMImages, this.track_checkpoints.length, 77, 30, 1, 8);
            game_DrawNumber(this.hudSMImages, this.players[0].m_nCurCheckpoint, 57, 30, 1, 8);
        }
        if (this.players[0].m_nNitroCount == 0) {
            asset_DrawImage(this.g_HudImgs[5], 4, 56);
        } else {
            asset_DrawImage(this.g_HudImgs[3], 4, 56);
        }
        game_DrawNumber(this.hudSMImages, this.players[0].m_nNitroCount, 74, 57, 1, 8);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect(0, this.system_nCanvasHeight - 18, this.system_nCanvasWidth, 18, 0);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        if (this.game_state == 2) {
            if (this.g_race.m_type == 3) {
                this.font_text.DrawSubstring(this.g_Text[10], 0, this.g_Text[10].length(), 94, this.system_nCanvasHeight - 20, 0);
                this.font_ingame.DrawSubstring(new StringBuffer().append("").append(this.players[0].m_nSpeedingScore).toString(), 0, new StringBuffer().append("").append(this.players[0].m_nSpeedingScore).toString().length(), this.system_nCanvasWidth - 1, this.system_nCanvasHeight - 16, 2);
            } else if (this.g_race.m_type == 4) {
                int i9 = 10000;
                for (int i10 = 1; i10 < this.g_race.m_numRacers; i10++) {
                    if (this.players[i10].m_nPlayerDist < i9) {
                        i9 = this.players[i10].m_nPlayerDist;
                    }
                }
                int i11 = ((this.g_missions[this.g_race.m_nMissionID].m_nreqScore - i9) * 55) / this.g_missions[this.g_race.m_nMissionID].m_nreqScore;
                if (i11 <= 0 || this.game_state == 5) {
                    i11 = 0;
                } else if (i11 > 55) {
                    i11 = 55;
                }
                int i12 = ((i11 << 1) + this.lastBustedness) / 3;
                this.lastBustedness = i12;
                this.font_text.DrawSubstring(this.g_Text[187], 0, this.g_Text[187].length(), 94, this.system_nCanvasHeight - 20, 0);
                system_SetClip((this.system_nCanvasWidth - i12) - 2, this.system_nCanvasHeight - 9, i12, 3);
                asset_DrawImage(204, 104, this.system_nCanvasHeight - 9);
                asset_DrawImage(204, 154, this.system_nCanvasHeight - 9);
            }
            drawSoftKey(8, 0);
        }
    }

    void game_DrawHUDMainEx() {
        int i = (-(this.sin_Array[((this.game_tachometer_vel + 10000) >> 8) & 255] + (((this.sin_Array[(((this.game_tachometer_vel + 10000) >> 8) + 1) & 255] - this.sin_Array[((this.game_tachometer_vel + 10000) >> 8) & 255]) * ((this.game_tachometer_vel + 10000) - ((this.game_tachometer_vel + 10000) & (-256)))) >> 8))) << 1;
        int i2 = (-(this.sin_Array[(((this.game_tachometer_vel + 10000) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.game_tachometer_vel + 10000) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.game_tachometer_vel + 10000) + 49152) >> 8) & 255]) * (((this.game_tachometer_vel + 10000) + 49152) - (((this.game_tachometer_vel + 10000) + 49152) & (-256)))) >> 8))) << 1;
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        asset_DrawImage(130, 157, 0);
        asset_DrawImage(126, 180, 0);
        asset_DrawImage(278, 157, 7);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setColor(16775581);
        m_CurrentGraphics.drawLine(202, 40, (i >> 10) + 202, (i2 >> 10) + 40);
        game_DrawNumber(this.hudMPHImages, ((this.players[0].GetMPH() * 2) * 2) >> 1, 132, 16, 3, 20);
        if (this.players[0].m_nNitroTimer <= 0) {
            asset_DrawImage(this.g_HudImgs[3], 4, 56);
        } else if (((this.scene_timer >> 8) & 1) == 1 || this.game_state == 3) {
            asset_DrawImage(this.g_HudImgs[4], 4, 56);
        } else {
            asset_DrawImage(this.g_HudImgs[5], 4, 56);
        }
    }

    void game_DrawNextIcon(int i, int i2) {
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setColor(255, 174, 64);
        m_CurrentGraphics.drawLine(i, i2, i, i2);
        m_CurrentGraphics.drawLine(i, i2 + 1, i + 1, i2 + 1);
        m_CurrentGraphics.drawLine(i, i2 + 2, i + 2, i2 + 2);
        m_CurrentGraphics.drawLine(i, i2 + 3, i + 1, i2 + 3);
        m_CurrentGraphics.drawLine(i, i2 + 4, i, i2 + 4);
    }

    void game_DrawNumber(short[] sArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i4;
        int i7 = i2;
        while (i > 0) {
            asset_DrawImage(sArr[i % 10], i7, i3);
            i6--;
            i /= 10;
            i7 -= i5;
        }
        while (i6 > 0) {
            asset_DrawImage(sArr[0], i7, i3);
            i6--;
            i7 -= i5;
        }
    }

    void game_DrawPrevIcon(int i, int i2) {
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setColor(255, 174, 64);
        m_CurrentGraphics.drawLine(i + 2, i2, i + 2, i2);
        m_CurrentGraphics.drawLine(i + 1, i2 + 1, i + 2, i2 + 1);
        m_CurrentGraphics.drawLine(i, i2 + 2, i + 2, i2 + 2);
        m_CurrentGraphics.drawLine(i + 1, i2 + 3, i + 2, i2 + 3);
        m_CurrentGraphics.drawLine(i + 2, i2 + 4, i + 2, i2 + 4);
    }

    void game_DrawUpIcon(int i, int i2) {
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setColor(255, 174, 64);
        m_CurrentGraphics.drawLine(i - 2, i2, i + 2, i2);
        m_CurrentGraphics.drawLine(i - 2, i2, i, i2 - 3);
        m_CurrentGraphics.drawLine(i + 2, i2, i, i2 - 3);
        m_CurrentGraphics.drawLine(i, i2 - 1, i, i2 - 2);
    }

    void game_End() {
        if (this.trackMeshs != null && this.trackIsMesh != null) {
            for (int i = 0; i < this.trackMeshs.length; i++) {
                this.trackMeshs[i] = null;
                this.trackIsMesh[i] = false;
            }
        }
        if (this.trackBarrier1 != null) {
            for (int i2 = 0; i2 < 20; i2++) {
                this.trackBarrier1[i2] = null;
                this.trackBarrier2[i2] = null;
                this.trackBarrier3[i2] = null;
                this.trackBarrier4[i2] = null;
            }
        }
        if (this.track_splines != null) {
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.track_splines[i3] != null) {
                    for (int i4 = 0; i4 < this.track_splines[i3].length; i4++) {
                        for (int i5 = 0; i5 < this.track_splines[i3][i4].length; i5++) {
                            this.track_splines[i3][i4][i5] = 0;
                        }
                        this.track_splines[i3][i4] = null;
                    }
                    this.track_splines[i3] = (short[][]) null;
                }
            }
        }
        this.numTrackItems = 0;
        scene_FreeTextures();
        scene_FreeAllMintMesh();
        if (this.g_cars != null) {
            for (int i6 = 0; i6 < this.g_cars.length; i6++) {
                if (this.g_cars[i6] != null) {
                    this.g_cars[i6].free();
                }
            }
        }
        if (this.allCarsList != null) {
            for (int i7 = 0; i7 < this.allCarsList.length; i7++) {
                if (this.allCarsList[i7] != null) {
                    this.allCarsList[i7].DeInitialize();
                    this.allCarsList[i7] = null;
                }
            }
            this.allCarsList = null;
        }
        if (this.sortedCarsList != null) {
            for (int i8 = 0; i8 < this.sortedCarsList.length; i8++) {
                if (this.sortedCarsList[i8] != null) {
                    this.sortedCarsList[i8].DeInitialize();
                    this.sortedCarsList[i8] = null;
                }
            }
            this.sortedCarsList = null;
        }
        if (this.groundCollision != null) {
            this.groundCollision.Free();
        }
        if (this.track_pvsStruct != null) {
            for (int i9 = 0; i9 < this.track_pvsStruct.length; i9++) {
                for (int i10 = 0; i10 < this.track_pvsStruct[i9].length; i10++) {
                    this.track_pvsStruct[i9][i10] = 0;
                }
                this.track_pvsStruct[i9] = null;
            }
            this.track_pvsStruct = (short[][]) null;
        }
        if (this.track_pvsMask != null) {
            for (int i11 = 0; i11 < this.track_pvsMask.length; i11++) {
                for (int i12 = 0; i12 < this.track_pvsMask[i11].length; i12++) {
                    this.track_pvsMask[i11][i12] = 0;
                }
                this.track_pvsMask[i11] = null;
            }
            this.track_pvsMask = (short[][]) null;
        }
        if (this.track_pvsXYZ != null) {
            for (int i13 = 0; i13 < this.track_pvsXYZ.length; i13++) {
                for (int i14 = 0; i14 < this.track_pvsXYZ[i13].length; i14++) {
                    this.track_pvsXYZ[i13][i14] = 0;
                }
                this.track_pvsXYZ[i13] = null;
            }
            this.track_pvsXYZ = (short[][]) null;
        }
        if (this.track_evasionPoints != null) {
            for (int i15 = 0; i15 < this.track_evasionPoints.length; i15++) {
                this.track_evasionPoints[i15] = null;
            }
            this.track_evasionPoints = (short[][]) null;
        }
        if (this.track_checkpoints != null) {
            for (int i16 = 0; i16 < this.track_checkpoints.length; i16++) {
                this.track_checkpoints[i16] = null;
            }
            this.track_checkpoints = (short[][]) null;
        }
        if (this.track_copPoints != null) {
            for (int i17 = 0; i17 < this.track_copPoints.length; i17++) {
                this.track_copPoints[i17] = null;
            }
            this.track_copPoints = (short[][]) null;
        }
        if (this.g_roadsideCop != null) {
            this.g_roadsideCop.DeInitialize();
            this.g_roadsideCop = null;
        }
        if (this.fire_sprites != null) {
            for (int i18 = 0; i18 < 4; i18++) {
                if (this.fire_sprites[i18] != null) {
                    this.fire_sprites[i18] = null;
                }
            }
        }
        this.scene_UI_indicator = null;
        this.scene_UI_arrow = null;
        this.scene_UI_evasion_ind = null;
        this.flash_effect_sprite = null;
        asset_FreeImage(138);
        asset_FreeImage(134);
        asset_FreeImage(130);
        asset_FreeImage(278);
        asset_FreeImage(126);
        asset_FreeImage(394);
        asset_FreeImage(394);
        asset_FreeImage(232);
        if (this.g_HudImgs != null) {
            for (int i19 = 0; i19 < this.g_HudImgs.length; i19++) {
                asset_FreeImage(this.g_HudImgs[i19]);
            }
        }
        if (this.hudMPHImages != null) {
            for (int i20 = 0; i20 < this.hudMPHImages.length; i20++) {
                asset_FreeImage(this.hudMPHImages[i20]);
            }
        }
        if (this.hudLGImages != null) {
            for (int i21 = 0; i21 < this.hudLGImages.length; i21++) {
                asset_FreeImage(this.hudLGImages[i21]);
            }
        }
        if (this.hudSMImages != null) {
            for (int i22 = 0; i22 < this.hudSMImages.length; i22++) {
                asset_FreeImage(this.hudSMImages[i22]);
            }
        }
        if (this.gearImgsOn != null) {
            for (int i23 = 0; i23 < this.gearImgsOn.length; i23++) {
                asset_FreeImage(this.gearImgsOn[i23]);
            }
        }
        game_FreeBuffer();
        game_StartMusic(true);
        System.gc();
    }

    void game_EndOfLevel(boolean z) throws Exception {
        game_FreeAnimationResource();
        game_LevelCleanup(true);
        System.gc();
    }

    void game_EndRace() {
        if (this.players[0].m_bPlayer) {
            this.players[0].m_zAng -= 8388608;
            this.players[0].m_zAng &= 16777215;
            this.players[0].m_zAng += 8388608;
            if (this.g_race.m_nMissionID != 0 && (this.g_race.m_type != 4 || this.game_playerPosition == 1)) {
                this.players[0].m_bPlayer = false;
            }
        }
        if (this.game_state != 5) {
            game_InitState(5);
        }
    }

    void game_FreeAnimationResource() throws Exception {
        if (this.game_animationsLoaded) {
            this.game_animationsLoaded = false;
        }
    }

    void game_FreeBuffer() {
        m_CurrentGraphics = null;
        this.game_gMapBuffer = null;
        this.game_imageMapBuffer = null;
    }

    int game_GetByteAsInteger(int i) {
        System.out.print(new StringBuffer().append((int) this.asset_DataBufArray[i][this.map_dataPointer]).append(", ").toString());
        byte[] bArr = this.asset_DataBufArray[i];
        int i2 = this.map_dataPointer;
        this.map_dataPointer = i2 + 1;
        int i3 = bArr[i2];
        if (i3 < 0) {
            i3 += 256;
        }
        return i3 & 255;
    }

    int game_GetInteger(int i) {
        return game_GetByteAsInteger(i) + (game_GetByteAsInteger(i) << 8) + (game_GetByteAsInteger(i) << 16) + (game_GetByteAsInteger(i) << 24);
    }

    int game_GetKeyFlag(int i, int i2) {
        if (i < 48 || i > 57) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 6) {
                return 4;
            }
            if (i2 == 2) {
                return 32;
            }
            if (i2 == 5) {
                return 128;
            }
            if (i2 == 8) {
                return 2048;
            }
            return i == 35 ? 4096 : 0;
        }
        if (i == 50) {
            return 2;
        }
        if (i == 56) {
            return 16;
        }
        if (i == 52) {
            return 64;
        }
        if (i == 54) {
            return 256;
        }
        if (i == 57) {
            return 512;
        }
        return i == 51 ? 1024 : 0;
    }

    short game_GetShort(int i) {
        return (short) (((short) game_GetByteAsInteger(i)) + (game_GetByteAsInteger(i) << 8));
    }

    String game_GetString(int i) {
        int iGame_GetByteAsInteger = game_GetByteAsInteger(i);
        byte[] bArr = new byte[iGame_GetByteAsInteger];
        for (int i2 = 0; i2 < iGame_GetByteAsInteger; i2++) {
            bArr[i2] = this.asset_DataBufArray[i][this.map_dataPointer + i2];
        }
        String str = new String(bArr, 0, iGame_GetByteAsInteger);
        this.map_dataPointer += iGame_GetByteAsInteger;
        return str;
    }

    void game_InitState(int i) {
        this.game_waitForInit = true;
        this.game_state = (byte) i;
        try {
            if (i == 2) {
                game_InitStatePlay();
            } else if (i == 3) {
                game_InitStatePaused();
            } else if (i == 4) {
                game_InitStateLevelLoading(false);
            } else if (i == 5 || i == 6 || this.game_state == 7) {
                game_InitStateGameOver();
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_share.hpp", 633, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_share.hpp", 633, e2.toString());
        }
        this.game_waitForInit = false;
    }

    void game_InitStateGameOver() throws Exception {
        if (this.gameover_pause) {
            this.scene_timer = 0;
            this.game_nKeyFlags = 0;
            return;
        }
        this.scene_timer = 0;
        this.gameOver_stage = 0;
        this.game_nKeyFlags = 0;
        this.players[0].m_nAccelerateTimer = 0;
        this.players[0].m_nNitroTimer = 0;
        createTimeString();
        this.g_race.m_bNewMission = false;
        this.g_race.m_bMissionPassed = false;
        this.g_race.m_nMissionUnlocked = -1;
        this.g_player.m_nCopsCrashed += this.g_race.m_nCopsSmashed;
        if (this.game_state == 6 || this.game_state == 7) {
            this.game_playerPosition = this.g_race.m_numRacers;
        }
        if (this.g_race.m_bMission && this.game_state != 6 && this.game_state != 7) {
            if (this.g_race.m_nMissionID == 0) {
                this.g_race.m_bMissionPassed = true;
            } else if (this.g_race.m_type == 3) {
                if (this.game_Time < this.g_race.m_nTimeLimit + 5000 && this.players[0].m_nSpeedingScore >= this.g_missions[this.g_race.m_nMissionID].m_nreqScore) {
                    this.g_race.m_bMissionPassed = true;
                }
            } else if (this.g_race.m_type == 4) {
                int i = 10000;
                for (int i2 = 1; i2 < this.g_race.m_numRacers; i2++) {
                    if (this.players[i2].m_nPlayerDist < i) {
                        i = this.players[i2].m_nPlayerDist;
                    }
                }
                if (this.game_playerPosition == 1 && i > this.g_missions[this.g_race.m_nMissionID].m_nreqScore) {
                    this.g_race.m_bMissionPassed = true;
                }
            } else if (this.game_playerPosition == 1) {
                this.g_race.m_bMissionPassed = true;
            }
        }
        if (this.g_race.m_bMissionPassed && this.g_player.m_missionStatus[this.g_race.m_nMissionID] == 0) {
            int i3 = this.g_missions[this.g_race.m_nMissionID].m_repWon;
            int i4 = this.g_missions[this.g_race.m_nMissionID].m_cashWon;
            for (int i5 = 0; i5 < 6; i5++) {
                if (this.g_player.getTotalRep() < this.g_missions[i5].m_reqRep) {
                    if (this.g_player.getTotalRep() + i3 >= this.g_missions[i5].m_reqRep && (this.g_missions[i5].m_reqMission == -1 || this.g_player.m_missionStatus[this.g_missions[i5].m_reqMission] == 1)) {
                        this.g_race.m_nMissionUnlocked = i5;
                        break;
                    } else {
                        break;
                        break;
                    }
                }
            }
            this.g_race.m_bNewMission = true;
            if (this.g_race.m_nMissionID > 5 || this.g_race.m_nMissionID == 0) {
                NFSMW_Profile nFSMW_Profile = this.g_player;
                nFSMW_Profile.m_rep = i3 + nFSMW_Profile.m_rep;
                this.g_player.m_cash += i4;
                this.g_player.m_missionStatus[this.g_race.m_nMissionID] = 1;
                if (this.g_race.m_nMissionID > 35) {
                    int i6 = this.g_race.m_nMissionID - 35;
                    this.g_player.m_rep += this.g_missions[i6].m_repWon;
                    this.g_player.m_cash += this.g_missions[i6].m_cashWon;
                    this.g_player.m_missionStatus[i6] = 1;
                }
            }
        }
        if (this.game_state == 7) {
            this.scene_timer = 0;
            this.gameOver_stage = 1;
        }
    }

    void game_InitStateLevelLoading(boolean z) throws Exception {
        this.game_loadState = 0;
        this.game_nKeyFlags = 0;
        this.game_isLoading = true;
        this.game_reloading = z;
        this.gameover_pause = false;
        this.game_numSpawnedCops = 0;
        asset_LoadImage(788, false);
        asset_LoadImage(922, false);
        asset_LoadImage(930, false);
        asset_LoadImage(926, false);
        m_CurrentGraphics = this.game_gMapBuffer;
        game_RenderLevelLoading();
        this.system_bScreenDirty = false;
        this.loading_timeTotal = 0L;
        this.loading_previousTime = System.currentTimeMillis();
        transition_Start();
    }

    void game_InitStatePaused() throws Exception {
        this.game_nKeyFlags = 0;
        this.scene_timer = 0;
        this.paused_hourglass = false;
        this.paused_action = 0;
        asset_ChangeVolume(0);
        game_StopMusic();
    }

    void game_InitStatePlay() throws Exception {
        this.game_nKeyPressed = (byte) 0;
        this.game_nLastKeyTap = (byte) 0;
        this.game_nKeyFlags = 0;
        this.game_seed = (int) System.currentTimeMillis();
        system_SeedRandom(this.game_seed);
        game_LoadAnimationResource();
        this.system_bScreenDirty = false;
        this.system_bReRenderSoftKeys = false;
        this.game_score = this.level_start_score;
        this.game_TimeUpdate = this.game_Time - 1000;
        this.frameCount = 0;
        this.game_tachometer_vel = 0;
        transition_Start();
    }

    void game_KeyPressed(int i, int i2) throws Exception {
        if (this.game_waitForInit) {
            return;
        }
        if (this.game_state == 2) {
            game_KeyPressedPlay(i, i2);
        }
        if (this.game_state == 3) {
            game_KeyPressedPaused(i, i2);
        }
        if (this.game_state == 5 || this.game_state == 6 || this.game_state == 7) {
            game_KeyPressedGameOver(i, i2);
        }
    }

    void game_KeyPressedGameOver(int i, int i2) throws Exception {
        if (this.scene_timer < 500) {
            return;
        }
        if (this.scene_timer < 10000 && this.system_bDemoMode && this.gameOver_stage == 1) {
            return;
        }
        if (this.gameOver_stage == 0) {
            if (i == -6 || i2 == 8 || i == 53) {
                this.scene_timer = 0;
                this.gameOver_stage++;
                if (this.g_race.m_bMissionPassed && this.g_race.m_nMissionID == 0) {
                    NFSMW_Profile nFSMW_Profile = this.g_player;
                    this.g_player.m_equipedCar = (byte) 0;
                    nFSMW_Profile.m_currentCar = (byte) 0;
                    this.g_cars[this.g_player.m_equipedCar].free();
                    this.g_cars[this.g_player.m_equipedCar].setParts(this.g_player.m_carSetups[this.g_player.m_equipedCar]);
                    NFSMW_CarAppearance nFSMW_CarAppearance = this.g_cars[this.menu_car];
                    NFSMW_CarAppearance nFSMW_CarAppearance2 = this.g_cars[this.menu_car];
                    this.g_cars[this.menu_car].m_refreshSpoiler = true;
                    nFSMW_CarAppearance2.m_refreshWheels = true;
                    nFSMW_CarAppearance.m_refreshTexture = true;
                    menu_refreshCar(this.g_player.m_currentCar);
                }
                this.g_player.saveRecords();
                return;
            }
            return;
        }
        if (this.gameOver_stage != 1) {
            if (this.gameOver_stage == 2) {
                if (getNextScriptPage()) {
                    return;
                }
                int i3 = this.scriptScenes[this.g_missions[this.g_race.m_nMissionID].m_script][2];
                if (i3 == -1) {
                    ClearGameOver(4097);
                    return;
                }
                this.script = this.g_Text[i3];
                this.currentPage = "";
                getNextScriptPage();
                this.scene_timer = 2000;
                this.gameOver_stage++;
                return;
            }
            if (getNextScriptPage()) {
                return;
            }
            if (this.g_race.m_nMissionID <= 0 || this.g_race.m_nMissionID >= 6) {
                if (this.g_race.m_nMissionID == 40) {
                    ClearGameOver(4098);
                    return;
                } else {
                    ClearGameOver(4097);
                    return;
                }
            }
            NFSMW_Mission nFSMW_Mission = this.g_missions[this.g_race.m_nMissionID + 35];
            this.g_race.m_type = nFSMW_Mission.m_raceType;
            this.g_race.m_laps = nFSMW_Mission.m_nLaps;
            this.g_race.m_trackPath = nFSMW_Mission.m_trackPath;
            this.g_race.m_nTimeLimit = nFSMW_Mission.m_nTimeLimit;
            this.g_race.m_numRacers = this.raceSetups[nFSMW_Mission.m_raceSetup][1];
            this.g_race.m_numCops = this.raceSetups[nFSMW_Mission.m_raceSetup][2];
            this.g_race.m_numTraffic = this.raceSetups[nFSMW_Mission.m_raceSetup][3];
            this.g_race.m_bMission = true;
            this.g_race.m_nMissionID += 35;
            this.g_race.m_difficulty = (this.g_race.m_nMissionID % 6) + 1;
            ClearGameOver(8192);
            return;
        }
        if (i == -6 || i2 == 8 || i == 53) {
            if (!this.g_race.m_bMission) {
                ClearGameOver(4097);
                return;
            }
            int i4 = this.scriptScenes[this.g_missions[this.g_race.m_nMissionID].m_script][2];
            if (!this.g_race.m_bMissionPassed || (i4 == -1 && this.g_race.m_nMissionUnlocked <= -1)) {
                ClearGameOver(4097);
                return;
            }
            this.scene_timer = 0;
            this.gameOver_stage++;
            if (this.g_race.m_nMissionUnlocked == -1) {
                this.gameOver_stage++;
                this.script = this.g_Text[i4];
                this.currentPage = "";
                getNextScriptPage();
                return;
            }
            this.script = this.g_Text[this.scriptScenes[this.g_missions[this.g_race.m_nMissionUnlocked].m_script][1]];
            this.currentPage = "";
            getNextScriptPage();
            return;
        }
        if (i != -7 || this.g_race.m_bMissionPassed) {
            return;
        }
        this.g_race.m_bMissionPassed = false;
        this.g_race.m_timeString = "";
        this.g_race.m_LapTimeString = "";
        this.g_race.m_nFastestLapTime = 0;
        this.g_race.m_nLastLapTime = 0;
        this.g_race.m_nTopSpeed = 0;
        this.g_race.m_nCopsSmashed = 0;
        this.game_state = (byte) 4;
        this.game_Time = 0;
        this.game_cameraAngZ = 0;
        this.players[0].m_zAng = 0;
        this.players[0].m_nLap = 0;
        this.players[0].m_nCurCheckpoint = 0;
        this.players[0].m_bPlayer = true;
        this.game_camlagX = 0;
        this.game_camlagY = 0;
        this.game_playerPosition = 1;
        this.game_closestEvasionPickup = 0;
        game_clearPopupText();
        this.game_posX = this.track_splines[0][0][0] << 4;
        this.game_posY = this.track_splines[0][0][1] << 4;
        this.game_posZ = 0;
        this.game_angZ = 7864320;
        if (this.g_roadsideCop != null && (this.g_race.m_type == 0 || this.g_race.m_type == 2)) {
            this.g_roadsideCop.Init();
            this.g_roadsideCop.m_aiSpline = this.track_splines[0];
            this.g_roadsideCop.m_nCopNum = (byte) 4;
        }
        for (int i5 = 0; i5 < this.g_race.m_numRacers; i5++) {
            this.players[i5].Init();
            this.players[i5].m_aiSpline = this.track_splines[0];
        }
        for (int i6 = 0; i6 < this.g_race.m_numCops; i6++) {
            this.cops[i6].Init();
            this.cops[i6].m_bDisabled = true;
            this.cops[i6].m_aiSpline = this.track_splines[0];
        }
        for (int i7 = 0; i7 < this.g_race.m_numTraffic; i7++) {
            this.traffic[i7].Init();
        }
        this.game_waitForInit = true;
        try {
            game_InitStateLevelLoading(true);
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_gameover_share.hpp", 160, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_gameover_share.hpp", 160, e2.toString());
        }
        this.game_waitForInit = false;
    }

    void game_KeyPressedPaused(int i, int i2) throws Exception {
        if (this.scene_timer < 500) {
            return;
        }
        if (i == -7) {
            this.paused_action = 1;
        } else if (i == -6 || i2 == 8 || i == 53) {
            this.paused_action = 2;
        }
    }

    void game_KeyPressedPlay(int i, int i2) throws Exception {
        if (i == -6) {
            game_Pause();
        } else {
            this.game_nKeyFlags |= game_GetKeyFlag(i, i2);
        }
    }

    void game_KeyReleased(int i, int i2) {
        if (!this.game_waitForInit && this.game_state == 2) {
            game_KeyReleasedPlay(i, i2);
        }
    }

    void game_KeyReleasedPlay(int i, int i2) {
        for (int i3 = 0; i3 < 7; i3++) {
            game_keyHistory[i3] = game_keyHistory[i3 + 1];
        }
        game_keyHistory[7] = this.game_nKeyPressed;
        if (game_keyHistory[0] != 4 || game_keyHistory[1] != 1 || game_keyHistory[2] != 5 || game_keyHistory[3] != 7 || game_keyHistory[4] != 3 || game_keyHistory[5] != 2 || game_keyHistory[6] != 8 || game_keyHistory[7] == 4) {
        }
        this.game_nKeyFlags &= game_GetKeyFlag(i, i2) ^ (-1);
    }

    void game_LevelCleanup(boolean z) {
    }

    void game_LoadAnimationResource() throws Exception {
        this.game_animationsLoaded = true;
    }

    boolean game_LoadLevel() throws Exception {
        int iAbs;
        boolean z;
        String str = this.g_worlds[this.g_trackPaths[this.g_race.m_trackPath].m_nWorld];
        if (str == "") {
            str = "track_02";
        }
        switch (this.game_loadState) {
            case 0:
                scene_LoadTrackSplines(this.g_race.m_trackPath);
                this.game_loadState++;
                break;
            case 1:
                this.track_copPoints = (short[][]) null;
                this.track_evasionPoints = (short[][]) null;
                this.track_checkpoints = (short[][]) null;
                if (this.g_trackPaths[this.g_race.m_trackPath].m_checkpoints >= 0) {
                    this.track_checkpoints = loadPointSet(this.g_trackPaths[this.g_race.m_trackPath].m_checkpoints);
                }
                if (this.g_race.m_type == 0 || this.g_race.m_type == 2) {
                    if (this.g_trackPaths[this.g_race.m_trackPath].m_nWorld == 0) {
                        this.track_copPoints = loadPointSet(1071);
                        this.track_evasionPoints = loadPointSet(1065);
                    } else {
                        this.track_copPoints = loadPointSet(1112);
                        this.track_evasionPoints = loadPointSet(1104);
                    }
                }
                this.game_loadState++;
                break;
            case 2:
                this.game_posX = this.track_splines[0][0][0] << 4;
                this.game_posY = this.track_splines[0][0][1] << 4;
                this.game_posZ = 0;
                this.game_angZ = 7864320;
                this.game_loadState++;
                break;
            case 3:
                this.g_race.m_nCopsSmashed = 0;
                this.numRoadsideCops = 0;
                if (this.g_race.m_type == 0 || this.g_race.m_type == 2) {
                    this.g_roadsideCop = new Car(this, -5);
                    this.g_roadsideCop.Init();
                    this.g_roadsideCop.SetAppearance(this.g_cars[7], 7, false);
                    this.g_roadsideCop.m_ca.constructCar(true);
                    this.g_roadsideCop.m_bDisabled = true;
                    this.numRoadsideCops = 1;
                }
                this.game_loadState++;
                break;
            case 4:
                this.sortedCarsList = new Car[this.g_race.m_numRacers + this.g_race.m_numCops + this.g_race.m_numTraffic + this.numRoadsideCops];
                this.allCarsList = new Car[this.g_race.m_numRacers + this.g_race.m_numCops + this.g_race.m_numTraffic + this.numRoadsideCops];
                for (int i = 0; i < this.g_race.m_numRacers; i++) {
                    this.sortedCarsList[i] = this.players[i];
                }
                for (int i2 = 0; i2 < this.g_race.m_numCops; i2++) {
                    this.sortedCarsList[this.g_race.m_numRacers + i2] = this.cops[i2];
                }
                for (int i3 = 0; i3 < this.g_race.m_numTraffic; i3++) {
                    this.sortedCarsList[this.g_race.m_numRacers + i3 + this.g_race.m_numCops] = this.traffic[i3];
                }
                for (int i4 = 0; i4 < this.g_race.m_numRacers; i4++) {
                    this.allCarsList[i4] = this.players[i4];
                }
                for (int i5 = 0; i5 < this.g_race.m_numCops; i5++) {
                    this.allCarsList[this.g_race.m_numRacers + i5] = this.cops[i5];
                }
                for (int i6 = 0; i6 < this.g_race.m_numTraffic; i6++) {
                    this.allCarsList[this.g_race.m_numRacers + i6 + this.g_race.m_numCops] = this.traffic[i6];
                }
                if (this.numRoadsideCops != 0) {
                    this.sortedCarsList[this.g_race.m_numRacers + this.g_race.m_numCops + this.g_race.m_numTraffic] = this.g_roadsideCop;
                    this.allCarsList[this.g_race.m_numRacers + this.g_race.m_numCops + this.g_race.m_numTraffic] = this.g_roadsideCop;
                }
                for (int i7 = 0; i7 < this.g_cars.length; i7++) {
                    if (this.g_cars[i7] != null && i7 != this.g_player.m_currentCar) {
                        this.g_cars[i7].free();
                    }
                }
                this.game_loadState++;
                this.loadingCar = 0;
                break;
            case 5:
                this.players[this.loadingCar].Init();
                if (this.loadingCar == 0) {
                    this.players[this.loadingCar].SetAppearance(this.g_cars[this.g_player.m_currentCar], this.g_player.m_currentCar, true);
                    if (this.g_player.m_missionStatus[5] == 1) {
                        this.players[this.loadingCar].m_nCurrentHeatRating = 3;
                    }
                } else if (this.g_race.m_type == 4) {
                    this.players[this.loadingCar].SetAppearance(this.g_cars[7], 7, false);
                } else if (this.loadingCar != 1 || !this.g_race.m_bMission || this.g_race.m_nMissionID >= 6) {
                    do {
                        iAbs = Math.abs(system_GetRandom() % 6);
                        int i8 = 0;
                        while (true) {
                            if (i8 >= this.loadingCar) {
                                z = true;
                            } else if (this.players[i8].m_nCA == iAbs) {
                                z = false;
                            } else {
                                i8++;
                            }
                        }
                    } while (!z);
                    this.players[this.loadingCar].SetAppearance(this.g_cars[iAbs], iAbs, false);
                    this.players[this.loadingCar].m_ca.randomize(this.loadingCar);
                } else if (this.g_race.m_nMissionID == 0) {
                    this.players[this.loadingCar].SetAppearance(this.g_cars[this.g_race.m_nMissionID], this.g_race.m_nMissionID, false);
                    this.players[this.loadingCar].m_ca.setParts(this.g_carSetups[6]);
                } else {
                    this.players[this.loadingCar].SetAppearance(this.g_cars[this.g_race.m_nMissionID], this.g_race.m_nMissionID, false);
                    this.players[this.loadingCar].m_ca.setParts(this.g_carSetups[this.g_race.m_nMissionID]);
                }
                this.players[this.loadingCar].m_ca.constructCar(this.loadingCar != 0);
                if (this.g_race.m_type == 4) {
                    this.players[this.loadingCar].m_aiSpline = this.track_splines[0];
                } else {
                    this.players[this.loadingCar].m_aiSpline = this.track_splines[0];
                }
                this.loadingCar++;
                if (this.loadingCar >= this.g_race.m_numRacers) {
                    if (this.numRoadsideCops != 0) {
                        this.g_roadsideCop.m_aiSpline = this.players[0].m_aiSpline;
                    }
                    this.game_loadState++;
                    this.loadingCar = 0;
                }
                break;
            case 6:
                this.cops[this.loadingCar].Init();
                this.cops[this.loadingCar].m_nCopNum = (byte) (this.loadingCar + 1);
                this.cops[this.loadingCar].SetAppearance(this.g_cars[7], 7, false);
                this.cops[this.loadingCar].m_ca.constructCar(true);
                this.cops[this.loadingCar].m_aiSpline = this.track_splines[0];
                this.cops[this.loadingCar].m_bDisabled = true;
                this.loadingCar++;
                if (this.loadingCar >= this.g_race.m_numCops) {
                    this.game_loadState++;
                    this.loadingCar = 0;
                }
                break;
            case 7:
                int iAbs2 = (Math.abs(system_GetRandom() >> 5) % 3) + 8;
                this.traffic[this.loadingCar].Init();
                this.traffic[this.loadingCar].SetAppearance(this.g_cars[iAbs2], iAbs2, false);
                this.traffic[this.loadingCar].m_ca.randomize(0);
                this.traffic[this.loadingCar].m_ca.constructCar(false);
                this.traffic[this.loadingCar].m_bTraffic = true;
                this.traffic[this.loadingCar].m_aiSpline = this.track_splines[2];
                this.traffic[this.loadingCar].m_nTopSpeed = 5000;
                this.loadingCar++;
                if (this.loadingCar >= this.traffic.length) {
                    this.game_loadState++;
                    this.loadingCar = 0;
                }
                break;
            case 8:
                for (int i9 = 0; i9 < this.g_race.m_numRacers; i9++) {
                    this.players[i9].m_xPos = this.game_posX;
                    this.players[i9].m_yPos = this.game_posY;
                    this.players[i9].m_zPos = -100000;
                }
                if (this.g_race.m_type == 4) {
                    this.players[0].m_nNitroCount = 0;
                } else {
                    this.players[0].m_nNitroCount = this.players[0].m_ca.m_parts[12] * 2;
                }
                this.cops[0].m_xPos = this.game_posX - 500;
                this.cops[0].m_yPos = this.game_posY + 6000;
                this.cops[0].m_zPos = -100000;
                this.cops[1].m_xPos = this.game_posX;
                this.cops[1].m_yPos = this.game_posY + 6000;
                this.cops[1].m_zPos = -100000;
                this.game_loadState++;
                break;
            case 9:
                scene_BuildTrack(str);
                this.game_loadState++;
                break;
            case 10:
                System.gc();
                this.game_loadedWorld = this.g_trackPaths[this.g_race.m_trackPath].m_nWorld;
                this.game_trackFirstRender = true;
                this.game_loadState++;
                break;
            case 11:
                scene_LoadPVS(str);
                if (this.groundCollision == null) {
                    this.groundCollision = new CGroundCollision(this);
                } else {
                    this.groundCollision.Free();
                }
                DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(str).append("_fmc/").append(str).append(".fmc").toString()));
                int iAvailable = dataInputStream.available();
                byte[] bArr = new byte[iAvailable];
                dataInputStream.readFully(bArr);
                int i10 = iAvailable >> 1;
                short[] sArr = new short[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    sArr[i11] = (short) ((bArr[i11 << 1] & 255) | ((bArr[(i11 << 1) + 1] & 255) << 8));
                }
                dataInputStream.close();
                this.groundCollision.Load(sArr);
                this.groundCollision.m_nAttributeMask = this.g_trackPaths[this.g_race.m_trackPath].m_nTrackFlags;
                this.game_loadState++;
                break;
            case 12:
                game_clearPopupText();
                if (this.scene_UI_arrow == null) {
                    while (scene_OpenModel("arrow", 4, true)) {
                    }
                    MintMesh[] mintMeshArrScene_FindMintMesh = scene_FindMintMesh("arrow");
                    Appearance appearance = mintMeshArrScene_FindMintMesh[0].m_mesh.getAppearance(0);
                    this.scene_UI_arrow = mintMeshArrScene_FindMintMesh[0].m_mesh;
                    this.scene_UI_arrow.setAppearance(0, appearance);
                    Appearance appearance2 = this.scene_UI_arrow.getAppearance(0);
                    appearance2.setPolygonMode(this.polygonMode_NoPersp);
                    CompositingMode compositingMode = new CompositingMode();
                    compositingMode.setDepthTestEnable(false);
                    compositingMode.setDepthWriteEnable(false);
                    appearance2.setCompositingMode(compositingMode);
                }
                if (this.scene_UI_indicator == null) {
                    try {
                        if (this.g_race.m_type == 3) {
                            while (scene_OpenModel("camera", 4, true)) {
                            }
                            this.scene_UI_indicator = scene_FindMintMesh("camera")[0].m_mesh;
                        } else {
                            while (scene_OpenModel("indicator", 4, true)) {
                            }
                            this.scene_UI_indicator = scene_FindMintMesh("indicator")[0].m_mesh;
                        }
                        Appearance appearance3 = this.scene_UI_indicator.getAppearance(0);
                        appearance3.setPolygonMode(this.polygonMode_NoPersp);
                        appearance3.setCompositingMode(this.compositingMode_ZWRITEREAD);
                    } catch (Error e) {
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_levelloading_share.hpp", 598, e.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_levelloading_share.hpp", 598, e2.toString());
                    }
                }
                if ((this.g_race.m_type == 0 || this.g_race.m_type == 2) && this.scene_UI_evasion_ind == null) {
                    do {
                        try {
                        } catch (Error e3) {
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_levelloading_share.hpp", 619, e3.toString());
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_levelloading_share.hpp", 619, e4.toString());
                        }
                    } while (scene_OpenModel("evasion", 4, true));
                    this.scene_UI_evasion_ind = scene_FindMintMesh("evasion")[0].m_mesh;
                    Appearance appearance4 = this.scene_UI_evasion_ind.getAppearance(0);
                    appearance4.setPolygonMode(this.polygonMode_NoPersp);
                    appearance4.setCompositingMode(this.compositingMode_ZWRITEREAD);
                }
                this.game_loadState++;
                break;
            case 13:
                scene_InitTrackSplines();
                for (int i12 = 0; i12 < this.g_race.m_numRacers; i12++) {
                    this.players[i12].InitCollision();
                }
                for (int i13 = 0; i13 < this.g_race.m_numTraffic; i13++) {
                    int length = ((i13 + 1) * this.traffic[i13].m_aiSpline.length) / 5;
                    this.traffic[i13].m_xPos = this.traffic[i13].m_aiSpline[length][0] << 4;
                    this.traffic[i13].m_yPos = this.traffic[i13].m_aiSpline[length][1] << 4;
                    this.traffic[i13].m_zAng = this.traffic[i13].m_aiSpline[length][2] << 8;
                    this.traffic[i13].InitCollisionToSplinePos(length);
                    this.traffic[i13].m_nAiNode = this.traffic[i13].FindClosedAISpline();
                }
                int i14 = -(this.sin_Array[((this.players[0].m_zAng >> 8) >> 8) & 255] + (((this.sin_Array[(((this.players[0].m_zAng >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.players[0].m_zAng >> 8) >> 8) & 255]) * ((this.players[0].m_zAng >> 8) - ((this.players[0].m_zAng >> 8) & (-256)))) >> 8));
                int i15 = this.sin_Array[(((this.players[0].m_zAng >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.players[0].m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.players[0].m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.players[0].m_zAng >> 8) + 49152) - (((this.players[0].m_zAng >> 8) + 49152) & (-256)))) >> 8);
                int i16 = this.players[0].m_zAng + 4194304;
                int i17 = -(this.sin_Array[((i16 >> 8) >> 8) & 255] + (((this.sin_Array[(((i16 >> 8) >> 8) + 1) & 255] - this.sin_Array[((i16 >> 8) >> 8) & 255]) * ((i16 >> 8) - ((i16 >> 8) & (-256)))) >> 8));
                int i18 = this.sin_Array[(((i16 >> 8) + 49152) >> 8) & 255] + (((((i16 >> 8) + 49152) - (((i16 >> 8) + 49152) & (-256))) * (this.sin_Array[((((i16 >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((i16 >> 8) + 49152) >> 8) & 255])) >> 8);
                if (this.g_race.m_type != 4) {
                    boolean z2 = false;
                    for (int i19 = 0; i19 < this.g_race.m_numRacers; i19++) {
                        this.players[i19].m_xPos = ((((i19 * 1000) + 1) * i14) >> 14) + this.game_posX;
                        this.players[i19].m_yPos = ((((i19 * 1000) + 1) * i15) >> 14) + this.game_posY;
                        int i20 = z2 ? 400 : -400;
                        this.players[i19].m_xPos += (i17 * i20) >> 14;
                        Car car = this.players[i19];
                        car.m_yPos = ((i20 * i18) >> 14) + car.m_yPos;
                        z2 = !z2;
                    }
                } else {
                    int i21 = this.g_race.m_numRacers - 1;
                    boolean z3 = false;
                    int i22 = 0;
                    while (i22 < this.g_race.m_numRacers) {
                        this.players[i22].m_xPos = ((((i21 * 1500) + 1) * i14) >> 14) + this.game_posX;
                        this.players[i22].m_yPos = ((((i21 * 1500) + 1) * i15) >> 14) + this.game_posY;
                        int i23 = z3 ? 400 : -400;
                        this.players[i22].m_xPos += (i17 * i23) >> 14;
                        Car car2 = this.players[i22];
                        car2.m_yPos = ((i23 * i18) >> 14) + car2.m_yPos;
                        z3 = !z3;
                        i22++;
                        i21--;
                    }
                }
                for (int i24 = 0; i24 < 2; i24++) {
                    this.players[0].m_bPlayer = true;
                    for (int i25 = 0; i25 < this.g_race.m_numRacers; i25++) {
                        this.players[i25].UpdatePhysics(50, 1310);
                    }
                    for (int i26 = 0; i26 < this.g_race.m_numRacers; i26++) {
                        this.players[i26].m_xVel = 0;
                        this.players[i26].m_yVel = 0;
                        this.players[i26].m_zVel = 0;
                    }
                    for (int i27 = 1; i27 < this.g_race.m_numRacers; i27++) {
                        this.players[0].CollideWith(this.players[i27], 50, 1310);
                    }
                    for (int i28 = 0; i28 < this.g_race.m_numRacers; i28++) {
                        this.players[i28].UpdateTrackCollision(50, 1310);
                    }
                }
                if (this.g_roadsideCop != null) {
                    this.g_roadsideCop.InitCollision();
                }
                this.game_loadState++;
                break;
            case 14:
                this.game_loadState++;
                break;
            case 15:
                if (this.system_bDemoMode) {
                    this.g_race.m_laps = 1;
                }
                this.game_currentGear = 1;
                System.gc();
                return true;
        }
        return false;
    }

    void game_LoadMission(int i) throws Exception {
        asset_LoadData(i);
        short s = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
        int i2 = (this.asset_DataArray[i + 0] & (-1)) >> 0;
        this.map_dataPointer = i2;
        game_GetString(s);
        game_GetString(s);
        game_GetByteAsInteger(s);
        game_GetString(s);
        game_GetString(s);
        game_GetByteAsInteger(s);
        game_GetByteAsInteger(s);
        int iGame_GetByteAsInteger = game_GetByteAsInteger(s);
        for (int i3 = 0; i3 < iGame_GetByteAsInteger; i3++) {
            game_GetInteger(s);
            game_GetInteger(s);
            game_GetInteger(s);
        }
        game_GetByteAsInteger(s);
        int iGame_GetByteAsInteger2 = game_GetByteAsInteger(s);
        for (int i4 = 0; i4 < iGame_GetByteAsInteger2; i4++) {
            game_GetInteger(s);
        }
        int iGame_GetByteAsInteger3 = game_GetByteAsInteger(s);
        for (int i5 = 0; i5 < iGame_GetByteAsInteger3; i5++) {
            game_GetInteger(s);
            game_GetInteger(s);
            game_GetInteger(s);
        }
        game_GetString(s);
        game_GetByteAsInteger(s);
        game_GetInteger(s);
        game_GetInteger(s);
        game_GetInteger(s);
        game_GetByteAsInteger(s);
        game_GetByteAsInteger(s);
        game_GetString(s);
        game_GetByteAsInteger(s);
        asset_FreeData(i);
    }

    int game_MyRandom() {
        this.game_random_state = ((this.game_random_state * 1103515245) + 12345) & 2147483647L;
        return Math.abs((int) ((this.game_random_state >> 11) & 255));
    }

    void game_MyRandomSeed(long j) {
        this.game_random_state = 4294967295L & j;
    }

    void game_Pause() throws Exception {
        if (this.game_state != 3) {
            this.game_state_before_pause = this.game_state;
        }
        game_InitState(3);
    }

    void game_PointerPressed(int i, int i2) throws Exception {
    }

    void game_PointerReleased(int i, int i2) throws Exception {
    }

    int game_ReadInt(byte[] bArr) {
        int i = (bArr[this.map_dataPointer] << 24) | ((bArr[this.map_dataPointer + 1] & 255) << 16) | ((bArr[this.map_dataPointer + 2] & 255) << 8) | (bArr[this.map_dataPointer + 3] & 255);
        this.map_dataPointer += 4;
        return i;
    }

    boolean game_ReloadLevel() throws Exception {
        switch (this.game_loadState) {
            case 0:
                this.game_posX = this.track_splines[0][0][0] << 4;
                this.game_posY = this.track_splines[0][0][1] << 4;
                this.game_posZ = 0;
                this.game_angZ = 7864320;
                if (this.g_player.m_missionStatus[5] == 1) {
                    this.players[0].m_nCurrentHeatRating = 3;
                }
                for (int i = 0; i < this.g_race.m_numRacers; i++) {
                    this.players[i].m_nAiNode = 0;
                    this.players[i].m_xPos = this.game_posX;
                    this.players[i].m_yPos = this.game_posY;
                    this.players[i].m_zPos = -100000;
                    this.players[i].AdjustCarStats();
                }
                if (this.g_race.m_type == 4) {
                    this.players[0].m_nNitroCount = 0;
                } else {
                    this.players[0].m_nNitroCount = this.players[0].m_ca.m_parts[12] * 2;
                }
                this.cops[0].m_xPos = this.game_posX - 500;
                this.cops[0].m_yPos = this.game_posY + 6000;
                this.cops[0].m_zPos = -100000;
                this.cops[1].m_xPos = this.game_posX;
                this.cops[1].m_yPos = this.game_posY + 6000;
                this.cops[1].m_zPos = -100000;
                this.game_loadState++;
                break;
            case 1:
                game_clearPopupText();
                for (int i2 = 0; i2 < this.g_race.m_numRacers; i2++) {
                    this.players[i2].InitCollision();
                }
                for (int i3 = 0; i3 < this.g_race.m_numTraffic; i3++) {
                    int length = ((i3 + 1) * this.traffic[i3].m_aiSpline.length) / 5;
                    this.traffic[i3].m_xPos = this.traffic[i3].m_aiSpline[length][0] << 4;
                    this.traffic[i3].m_yPos = this.traffic[i3].m_aiSpline[length][1] << 4;
                    this.traffic[i3].m_zAng = this.traffic[i3].m_aiSpline[length][2] << 8;
                    this.traffic[i3].InitCollisionToSplinePos(length);
                    this.traffic[i3].m_nAiNode = this.traffic[i3].FindClosedAISpline();
                }
                int i4 = -(this.sin_Array[((this.players[0].m_zAng >> 8) >> 8) & 255] + (((this.sin_Array[(((this.players[0].m_zAng >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.players[0].m_zAng >> 8) >> 8) & 255]) * ((this.players[0].m_zAng >> 8) - ((this.players[0].m_zAng >> 8) & (-256)))) >> 8));
                int i5 = this.sin_Array[(((this.players[0].m_zAng >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.players[0].m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.players[0].m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.players[0].m_zAng >> 8) + 49152) - (((this.players[0].m_zAng >> 8) + 49152) & (-256)))) >> 8);
                int i6 = this.players[0].m_zAng + 4194304;
                int i7 = -(this.sin_Array[((i6 >> 8) >> 8) & 255] + (((this.sin_Array[(((i6 >> 8) >> 8) + 1) & 255] - this.sin_Array[((i6 >> 8) >> 8) & 255]) * ((i6 >> 8) - ((i6 >> 8) & (-256)))) >> 8));
                int i8 = this.sin_Array[(((i6 >> 8) + 49152) >> 8) & 255] + (((((i6 >> 8) + 49152) - (((i6 >> 8) + 49152) & (-256))) * (this.sin_Array[((((i6 >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((i6 >> 8) + 49152) >> 8) & 255])) >> 8);
                if (this.g_race.m_type != 4) {
                    boolean z = false;
                    for (int i9 = 0; i9 < this.g_race.m_numRacers; i9++) {
                        this.players[i9].m_xPos = ((((i9 * 1000) + 1) * i4) >> 14) + this.game_posX;
                        this.players[i9].m_yPos = ((((i9 * 1000) + 1) * i5) >> 14) + this.game_posY;
                        int i10 = z ? 400 : -400;
                        this.players[i9].m_xPos += (i7 * i10) >> 14;
                        Car car = this.players[i9];
                        car.m_yPos = ((i10 * i8) >> 14) + car.m_yPos;
                        z = !z;
                    }
                } else {
                    int i11 = this.g_race.m_numRacers - 1;
                    int i12 = 0;
                    boolean z2 = false;
                    while (i12 < this.g_race.m_numRacers) {
                        this.players[i12].m_xPos = ((((i11 * 1500) + 1) * i4) >> 14) + this.game_posX;
                        this.players[i12].m_yPos = ((((i11 * 1500) + 1) * i5) >> 14) + this.game_posY;
                        int i13 = z2 ? 400 : -400;
                        this.players[i12].m_xPos += (i7 * i13) >> 14;
                        Car car2 = this.players[i12];
                        car2.m_yPos = ((i13 * i8) >> 14) + car2.m_yPos;
                        z2 = !z2;
                        i12++;
                        i11--;
                    }
                }
                for (int i14 = 0; i14 < 2; i14++) {
                    this.players[0].m_bPlayer = true;
                    for (int i15 = 0; i15 < this.g_race.m_numRacers; i15++) {
                        this.players[i15].UpdatePhysics(50, 1310);
                    }
                    for (int i16 = 0; i16 < this.g_race.m_numRacers; i16++) {
                        this.players[i16].m_xVel = 0;
                        this.players[i16].m_yVel = 0;
                        this.players[i16].m_zVel = 0;
                    }
                    for (int i17 = 1; i17 < this.g_race.m_numRacers; i17++) {
                        this.players[0].CollideWith(this.players[i17], 50, 1310);
                    }
                    for (int i18 = 0; i18 < this.g_race.m_numRacers; i18++) {
                        this.players[i18].UpdateTrackCollision(50, 1310);
                    }
                }
                this.game_loadState++;
                break;
            case 2:
                this.game_currentGear = 1;
                System.gc();
                return true;
        }
        return false;
    }

    void game_Render() {
        if (this.game_waitForInit) {
            return;
        }
        if (this.game_state == 2) {
            game_RenderPlay();
        } else if (this.game_state == 3) {
            game_RenderPaused();
        } else if (this.game_state == 4) {
            game_RenderLevelLoading();
        } else if (this.game_state == 5 || this.game_state == 7 || this.game_state == 6) {
            game_RenderGameOver();
        }
        game_RenderHUD();
    }

    void game_RenderGameOver() {
        char c;
        char c2;
        if (this.g_race.m_bMission && this.g_race.m_nMissionID == 0) {
            this.game_playerPosition = this.g_race.m_numRacers;
        }
        if (this.game_playerPosition == 1) {
            c = 188;
        } else if (this.game_playerPosition == 2) {
            c = 189;
        } else {
            c = this.game_playerPosition == 3 ? (char) 190 : (char) 191;
        }
        if (this.gameOver_stage == 0) {
            game_RenderPlay();
            this.font_ingame.SetColor(255, 255, 255);
            system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
            m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
            if (this.game_state == 6) {
                c2 = 187;
            } else if (this.g_race.m_type == 3) {
                if (this.g_race.m_bMissionPassed) {
                    c2 = 200;
                } else {
                    c2 = this.game_Time > this.g_race.m_nTimeLimit + 5000 ? (char) 196 : (char) 197;
                }
            } else if (this.g_race.m_type != 4) {
                if (this.game_state != 7) {
                    this.font_ingame.DrawSubstring(this.g_Text[c], 0, this.g_Text[c].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10, 1);
                }
                c2 = 200;
            } else if (this.g_race.m_bMissionPassed) {
                c2 = 199;
            } else {
                c2 = this.game_Time >= this.g_race.m_nTimeLimit + 5000 ? (char) 196 : (char) 198;
            }
            this.font_ingame.DrawSubstringWrapped(this.g_Text[c2], 0, this.g_Text[c2].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 10 + 16, 1, 0);
            drawSoftKey(6, 0);
            return;
        }
        if (this.gameOver_stage != 1) {
            try {
                drawBG();
                asset_DrawImage(394, 0, 0);
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_gameover_share.hpp", 470, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_gameover_share.hpp", 470, e2.toString());
            }
            this.font_text.SetColor(255, 255, 255);
            this.font_text.DrawSubstringWrapped(this.currentPage, 0, this.currentPage.length(), this.system_nCanvasWidth - 16, 8, 104, 0, 0);
            drawSoftKey(6, 0);
            return;
        }
        drawBG();
        this.font_text.SetColor(255, 255, 255);
        if (this.system_bDemoMode) {
            this.font_headings.DrawSubstringWrapped(this.g_Text[200], 0, this.g_Text[200].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
            this.font_text.DrawSubstringWrapped(this.g_Text[16], 0, this.g_Text[16].length(), this.system_nCanvasWidth - 40, this.system_nCanvasWidth / 2, 80, 1, 0);
            if (this.scene_timer > 10000) {
                drawSoftKey(6, 0);
                if (this.g_race.m_bMissionPassed) {
                    return;
                }
                drawSoftKey(7, 1);
                return;
            }
            return;
        }
        if (this.game_state != 7) {
            if (this.g_race.m_bMission) {
                if (!this.g_race.m_bMissionPassed || this.g_race.m_nMissionID == 0) {
                    this.font_headings.DrawSubstringWrapped(this.g_Text[15], 0, this.g_Text[15].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
                } else {
                    this.font_headings.DrawSubstringWrapped(this.g_Text[14], 0, this.g_Text[14].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
                }
            } else if (this.game_state == 6) {
                this.font_headings.DrawSubstringWrapped(this.g_Text[15], 0, this.g_Text[15].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
            } else {
                this.font_headings.DrawSubstringWrapped(this.g_Text[200], 0, this.g_Text[200].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
            }
            if (this.g_race.m_type != 3 && this.g_race.m_type != 4 && this.game_state != 6) {
                this.font_ingame.DrawSubstring(this.g_Text[c], 0, this.g_Text[c].length(), this.system_nCanvasWidth >> 1, 65, 1);
            }
        } else {
            this.font_headings.DrawSubstringWrapped(this.g_Text[15], 0, this.g_Text[15].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 15, 1, 0);
        }
        int i = 95;
        if (this.g_race.m_bMission) {
            if (this.g_race.m_bMissionPassed && this.g_race.m_bNewMission) {
                int i2 = this.g_missions[this.g_race.m_nMissionID].m_repWon;
                int i3 = this.g_missions[this.g_race.m_nMissionID].m_cashWon;
                this.font_text.DrawSubstring(this.g_Text[40], 0, this.g_Text[40].length(), 20, 95, 0);
                this.font_text.DrawSubstring(new StringBuffer().append("").append(i2).toString(), 0, new StringBuffer().append("").append(i2).toString().length(), 220, 95, 2);
                this.font_text.DrawSubstring(this.g_Text[41], 0, this.g_Text[41].length(), 20, 113, 0);
                this.font_text.DrawSubstring(new StringBuffer().append("").append(i3).toString(), 0, new StringBuffer().append("").append(i3).toString().length(), 220, 113, 2);
                i = 131;
            } else {
                i = 131;
            }
        }
        if (this.g_race.m_type == 3) {
            i += 18;
            this.font_text.DrawSubstring(this.g_Text[42], 0, this.g_Text[42].length(), 20, i, 0);
            this.font_text.DrawSubstring(new StringBuffer().append("").append(this.players[0].m_nSpeedingScore).toString(), 0, new StringBuffer().append("").append(this.players[0].m_nSpeedingScore).toString().length(), 220, i, 2);
        }
        int i4 = i + 18;
        this.font_text.DrawSubstring(this.g_Text[43], 0, this.g_Text[43].length(), 20, i4, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_race.m_timeString).toString(), 0, new StringBuffer().append("").append(this.g_race.m_timeString).toString().length(), 220, i4, 2);
        int i5 = i4 + 18;
        this.font_text.DrawSubstring(this.g_Text[44], 0, this.g_Text[44].length(), 20, i5, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_race.m_nTopSpeed).append("KM/H").toString(), 0, new StringBuffer().append("").append(this.g_race.m_nTopSpeed).append("KM/H").toString().length(), 220, i5, 2);
        int i6 = i5 + 18;
        this.font_text.DrawSubstring(this.g_Text[46], 0, this.g_Text[46].length(), 20, i6, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_race.m_nCopsSmashed).toString(), 0, new StringBuffer().append("").append(this.g_race.m_nCopsSmashed).toString().length(), 220, i6, 2);
        if (this.g_race.m_laps > 1) {
            int i7 = i6 + 18;
            this.font_text.DrawSubstring(this.g_Text[45], 0, this.g_Text[45].length(), 20, i7, 0);
            this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_race.m_LapTimeString).toString(), 0, new StringBuffer().append("").append(this.g_race.m_LapTimeString).toString().length(), 220, i7, 2);
        }
        drawSoftKey(6, 0);
        if (this.g_race.m_bMissionPassed) {
            return;
        }
        drawSoftKey(7, 1);
    }

    void game_RenderHUD() {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 30) {
                break;
            }
            this.game_profilerTotalTimes[i2] = 0;
            for (int i3 = 0; i3 < 32; i3++) {
                int[] iArr = this.game_profilerTotalTimes;
                iArr[i2] = (int) (((long) iArr[i2]) + (this.game_profilerEndTimes[i2][i3] - this.game_profilerStartTimes[i2][i3]));
            }
            this.game_profilerColours[i2] = 8421504;
            i = i2 + 1;
        }
        this.game_profilerPos++;
        if (this.game_profilerPos > 31) {
            this.game_profilerPos = 0;
        }
    }

    void game_RenderLevelLoading() {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
        asset_DrawImage(788, 0, 14);
        this.font_text.SetColor(255, 255, 255);
        this.font_text.DrawSubstringWrapped(this.g_Text[48], 0, this.g_Text[48].length(), 70, 5, 172, 8, 0);
        this.font_text.DrawSubstringWrapped(this.g_Text[47], 0, this.g_Text[47].length(), 70, this.system_nCanvasWidth - 5, 172, 10, 0);
        this.font_text.DrawSubstringWrapped(this.g_Text[49], 0, this.g_Text[49].length(), 70, this.system_nCanvasWidth >> 1, 240, 1, 0);
        this.font_text.DrawSubstringWrapped(this.g_Text[51], 0, this.g_Text[51].length(), 100, this.system_nCanvasWidth >> 1, 120, 9, 0);
        this.font_text.DrawSubstringWrapped(this.g_Text[50], 0, this.g_Text[50].length(), 70, this.system_nCanvasWidth - 5, 208, 2, 0);
        asset_DrawImage(922, 0, this.system_nCanvasHeight - 22);
        if (((this.scene_timer >> 8) & 1) == 1) {
            asset_DrawImage(930, this.system_nCanvasWidth - 66, this.system_nCanvasHeight - 28);
        } else {
            asset_DrawImage(926, this.system_nCanvasWidth - 66, this.system_nCanvasHeight - 28);
        }
        this.font_ingame.DrawSubstring(this.g_Text[29], 0, this.g_Text[29].length(), 8, this.system_nCanvasHeight - 20, 0);
        system_FillRect(0, 290, this.game_reloading ? (this.system_nCanvasWidth / 2) * this.game_loadState : (this.system_nCanvasWidth / 14) * this.game_loadState, 10, 16777215);
    }

    void game_RenderPaused() {
        game_RenderPlay();
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect((this.system_nCanvasWidth >> 1) - 60, (this.system_nCanvasHeight >> 1) - 15, 120, 30, 0);
        this.font_ingame.SetColor(255, 255, 255);
        this.font_ingame.DrawSubstring(this.g_Text[186], 0, this.g_Text[186].length(), this.system_nCanvasWidth >> 1, this.system_nCanvasHeight >> 1, 5);
        drawSoftKey(5, 1);
        drawSoftKey(9, 0);
        if (this.paused_action == 0) {
            this.paused_hourglass = false;
        } else {
            asset_DrawImage(2, (this.system_nCanvasWidth >> 1) - 8, (this.system_nCanvasHeight >> 1) - 12);
            this.paused_hourglass = true;
        }
    }

    void game_RenderPlay() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        this.game_profilerStartTimes[2][this.game_profilerPos] = System.currentTimeMillis();
        if (this.game_playingStateHadUpdate) {
            game_SetCamera();
            m_CurrentGraphics.setClip(0, 84, this.system_nCanvasWidth, (this.system_nCanvasHeight - 84) - 18);
            try {
                this.background.setColorClearEnable(false);
                this.background.setDepthClearEnable(true);
                this.scene_g3d.bindTarget(m_CurrentGraphics, true, 0);
                this.game_profilerEndTimes[2][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[2][this.game_profilerPos] - this.game_profilerStartTimes[2][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:2,").append(this.game_profilerEndTimes[2][this.game_profilerPos] - this.game_profilerStartTimes[2][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[3][this.game_profilerPos] = System.currentTimeMillis();
                this.scene_g3d.clear(this.background);
                this.scene_g3d.setCamera(this.camera, this.scene_cameraTrans);
                this.game_profilerEndTimes[3][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[3][this.game_profilerPos] - this.game_profilerStartTimes[3][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:3,").append(this.game_profilerEndTimes[3][this.game_profilerPos] - this.game_profilerStartTimes[3][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[4][this.game_profilerPos] = System.currentTimeMillis();
                if (this.skyDome != null) {
                    this.scene_g3d.render(this.skyDome, (Transform) null);
                }
                this.game_profilerEndTimes[4][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[4][this.game_profilerPos] - this.game_profilerStartTimes[4][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:4,").append(this.game_profilerEndTimes[4][this.game_profilerPos] - this.game_profilerStartTimes[4][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[5][this.game_profilerPos] = System.currentTimeMillis();
                for (int i5 = 0; i5 < this.trackMeshs.length; i5++) {
                    this.trackIsRendered[i5] = false;
                }
                for (int i6 = this.track_maxPVSi; i6 > -1; i6--) {
                    short s = this.track_pvsStruct[this.trackPVSFrame1][i6];
                    short s2 = this.track_pvsMask[this.trackPVSFrame1][i6];
                    if (s > -1 && (s2 & this.cameraScopeMask) > 0 && this.trackIsMesh[s]) {
                        this.trackIsRendered[s] = true;
                        this.scene_g3d.render(this.trackMeshs[s], (Transform) null);
                    }
                }
                for (int i7 = this.track_maxPVSi; i7 > -1; i7--) {
                    short s3 = this.track_pvsStruct[this.trackPVSFrame2][i7];
                    short s4 = this.track_pvsMask[this.trackPVSFrame2][i7];
                    if (s3 > -1 && (s4 & this.cameraScopeMask) > 0 && this.trackIsMesh[s3] && !this.trackIsRendered[s3]) {
                        this.trackIsRendered[s3] = true;
                        this.scene_g3d.render(this.trackMeshs[s3], (Transform) null);
                    }
                }
                for (int i8 = this.track_maxPVSi; i8 > -1; i8--) {
                    short s5 = this.track_pvsStruct[this.trackPVSFrame3][i8];
                    short s6 = this.track_pvsMask[this.trackPVSFrame3][i8];
                    if (s5 > -1 && (s6 & this.cameraScopeMask) > 0 && this.trackIsMesh[s5] && !this.trackIsRendered[s5]) {
                        this.trackIsRendered[s5] = true;
                        this.scene_g3d.render(this.trackMeshs[s5], (Transform) null);
                    }
                }
                for (int i9 = 0; i9 < 20; i9++) {
                    switch (this.g_trackPaths[this.g_race.m_trackPath].m_nTrack) {
                        case 0:
                            if (this.trackBarrier1[i9] != null) {
                                this.scene_g3d.render(this.trackBarrier1[i9], (Transform) null);
                            }
                            break;
                        case 1:
                            if (this.trackBarrier2[i9] != null) {
                                this.scene_g3d.render(this.trackBarrier2[i9], (Transform) null);
                            }
                            break;
                        case 2:
                            if (this.trackBarrier3[i9] != null) {
                                this.scene_g3d.render(this.trackBarrier3[i9], (Transform) null);
                            }
                            break;
                        case 3:
                            if (this.trackBarrier4[i9] != null) {
                                this.scene_g3d.render(this.trackBarrier4[i9], (Transform) null);
                            }
                            break;
                    }
                }
                this.game_profilerEndTimes[5][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[5][this.game_profilerPos] - this.game_profilerStartTimes[5][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:5,").append(this.game_profilerEndTimes[5][this.game_profilerPos] - this.game_profilerStartTimes[5][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[6][this.game_profilerPos] = System.currentTimeMillis();
                for (int i10 = 0; i10 < this.g_race.m_numRacers; i10++) {
                    this.players[i10].renderShadow();
                }
                for (int i11 = 0; i11 < this.g_race.m_numCops; i11++) {
                    this.cops[i11].renderShadow();
                }
                this.game_profilerEndTimes[6][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[6][this.game_profilerPos] - this.game_profilerStartTimes[6][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:6,").append(this.game_profilerEndTimes[6][this.game_profilerPos] - this.game_profilerStartTimes[6][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[7][this.game_profilerPos] = System.currentTimeMillis();
                if (this.players[0].m_bGoingBackward) {
                    for (int i12 = 0; i12 < this.sortedCarsList.length; i12++) {
                        this.sortedCarsList[i12].render();
                    }
                } else {
                    for (int length = this.sortedCarsList.length - 1; length > -1; length--) {
                        this.sortedCarsList[length].render();
                    }
                }
                this.game_profilerEndTimes[7][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[7][this.game_profilerPos] - this.game_profilerStartTimes[7][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:7,").append(this.game_profilerEndTimes[7][this.game_profilerPos] - this.game_profilerStartTimes[7][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[8][this.game_profilerPos] = System.currentTimeMillis();
                if (this.players[0].m_bGoingBackward) {
                    for (int i13 = 0; i13 < this.sortedCarsList.length; i13++) {
                        this.sortedCarsList[i13].renderAlpha();
                    }
                } else {
                    for (int length2 = this.sortedCarsList.length - 1; length2 > -1; length2--) {
                        this.sortedCarsList[length2].renderAlpha();
                    }
                }
                this.game_profilerEndTimes[8][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[8][this.game_profilerPos] - this.game_profilerStartTimes[8][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:8,").append(this.game_profilerEndTimes[8][this.game_profilerPos] - this.game_profilerStartTimes[8][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[9][this.game_profilerPos] = System.currentTimeMillis();
                if (this.g_race.m_type == 4) {
                    int i14 = (this.game_xArrowPos << 8) - (this.game_posX << 8);
                    i = (this.game_yArrowPos << 8) - (this.game_posY << 8);
                    i2 = i14;
                } else if (this.g_race.m_type == 0 || this.g_race.m_type == 2) {
                    int i15 = (this.game_xArrowPos << 8) - (this.game_posX << 8);
                    int i16 = (this.game_yArrowPos << 8) - (this.game_posY << 8);
                    int i17 = Integer.MAX_VALUE;
                    if (this.g_roadsideCop != null) {
                        if (this.g_roadsideCop.m_nState != 9 && this.g_roadsideCop.m_nTimeNotVisable > 5000) {
                            this.g_roadsideCop.m_bDisabled = true;
                        }
                        if (this.g_roadsideCop.m_bDisabled || this.g_roadsideCop.m_nState == 9) {
                            int i18 = 0;
                            int i19 = 0;
                            while (i19 < this.track_copPoints.length) {
                                int iApproximateMagnitude = ApproximateMagnitude((this.track_copPoints[i19][0] << 4) - this.players[0].m_xPos, (this.track_copPoints[i19][1] << 4) - this.players[0].m_yPos);
                                if (i17 <= iApproximateMagnitude || i17 <= 15000) {
                                    iApproximateMagnitude = i17;
                                } else {
                                    i18 = i19;
                                }
                                i19++;
                                i17 = iApproximateMagnitude;
                            }
                            if (this.g_nLastRoadSideCopIndex != i18) {
                                this.g_nLastRoadSideCopIndex = i18;
                                this.g_roadsideCop.m_xPos = this.track_copPoints[i18][0] << 4;
                                this.g_roadsideCop.m_yPos = this.track_copPoints[i18][1] << 4;
                                this.g_roadsideCop.m_zPos = (this.track_copPoints[i18][2] << 4) + 1;
                                this.g_roadsideCop.InitCollision();
                                this.g_roadsideCop.m_zLastAveragePos = this.g_roadsideCop.m_zPos;
                                this.g_roadsideCop.m_xVel = 0;
                                this.g_roadsideCop.m_yVel = 0;
                                this.g_roadsideCop.m_zVel = 0;
                                this.g_roadsideCop.m_nLastWheelCount = 0;
                                this.g_roadsideCop.m_nLastAverageCount = 0;
                                this.g_roadsideCop.m_xAngVel = 0;
                                this.g_roadsideCop.m_yAngVel = 0;
                                this.g_roadsideCop.m_zAngVel = 0;
                                this.g_roadsideCop.m_nAverageSplineMovementSpeed = 0;
                                this.g_roadsideCop.UpdatePhysics(100, 655);
                                this.g_roadsideCop.UpdateTrackCollision(100, 655);
                                this.g_roadsideCop.m_xAngVel = 0;
                                this.g_roadsideCop.m_yAngVel = 0;
                                this.g_roadsideCop.m_zAngVel = 0;
                                this.g_roadsideCop.m_xVel = 0;
                                this.g_roadsideCop.m_yVel = 0;
                                this.g_roadsideCop.m_zVel = 0;
                                this.g_roadsideCop.m_zLastAveragePos = this.g_roadsideCop.m_zPos;
                                this.g_roadsideCop.m_nState = 9;
                                this.g_roadsideCop.m_bDisabled = false;
                            }
                        }
                    }
                    int i20 = Integer.MAX_VALUE;
                    while (i4 < this.track_evasionPoints.length) {
                        int iApproximateMagnitude2 = ApproximateMagnitude((this.track_evasionPoints[i4][0] << 4) - this.players[0].m_xPos, (this.track_evasionPoints[i4][1] << 4) - this.players[0].m_yPos);
                        if (i20 > iApproximateMagnitude2) {
                            this.game_closestEvasionPickup = i4;
                        } else {
                            iApproximateMagnitude2 = i20;
                        }
                        i4++;
                        i20 = iApproximateMagnitude2;
                    }
                    this.scene_workerTrans.setIdentity();
                    this.scene_workerTrans.postTranslate(this.track_evasionPoints[this.game_closestEvasionPickup][0] / 16.0f, (this.track_evasionPoints[this.game_closestEvasionPickup][2] / 16.0f) + 1.0f, this.track_evasionPoints[this.game_closestEvasionPickup][1] / 16.0f);
                    this.scene_workerTrans.postRotate(this.game_Time >> 2, 0.0f, 1.0f, 0.0f);
                    this.scene_g3d.render(this.scene_UI_evasion_ind, this.scene_workerTrans);
                    i = i16;
                    i2 = i15;
                } else if ((this.g_race.m_type == 1 || this.g_race.m_type == 3) && (i3 = this.players[0].m_nCurCheckpoint) < this.track_checkpoints.length) {
                    int i21 = (this.track_checkpoints[i3][0] << 12) - (this.game_posX << 8);
                    i = (this.track_checkpoints[i3][1] << 12) - (this.game_posY << 8);
                    this.scene_workerTrans.setIdentity();
                    this.scene_workerTrans.postTranslate(this.track_checkpoints[i3][0] / 16.0f, (this.track_checkpoints[i3][2] / 16.0f) + 1.0f, this.track_checkpoints[i3][1] / 16.0f);
                    this.scene_workerTrans.postRotate(this.game_Time >> 2, 0.0f, 1.0f, 0.0f);
                    this.scene_g3d.render(this.scene_UI_indicator, this.scene_workerTrans);
                    i2 = i21;
                } else {
                    i = 0;
                    i2 = 0;
                }
                int iArctan2 = arctan2(i, i2);
                if (this.game_Time > 6000 && this.game_state == 2) {
                    this.scene_cameraTrans.postTranslate(0.0f, 2.0f, -5.0f);
                    this.scene_cameraTrans.postRotate((((-this.game_angZ) - iArctan2) * 2.1457672E-5f) - 90.0f, 0.0f, 1.0f, 0.0f);
                    this.scene_g3d.render(this.scene_UI_arrow, this.scene_cameraTrans);
                }
                this.scene_g3d.releaseTarget();
                this.game_profilerEndTimes[9][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[9][this.game_profilerPos] - this.game_profilerStartTimes[9][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:9,").append(this.game_profilerEndTimes[9][this.game_profilerPos] - this.game_profilerStartTimes[9][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[10][this.game_profilerPos] = System.currentTimeMillis();
                game_DrawHUD();
                this.game_profilerEndTimes[10][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[10][this.game_profilerPos] - this.game_profilerStartTimes[10][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:10,").append(this.game_profilerEndTimes[10][this.game_profilerPos] - this.game_profilerStartTimes[10][this.game_profilerPos]).toString());
                }
                this.frameCount++;
            } catch (Throwable th) {
                this.scene_g3d.releaseTarget();
                throw th;
            }
        }
    }

    void game_Return() throws Exception {
        menu_End();
        this.scene_nCurrentScene = 8192;
        this.game_waitForInit = true;
        game_LoadAnimationResource();
        this.game_waitForInit = false;
    }

    void game_SetCamera() {
        float f = (this.players[0].m_velocityLastFrame / 1000.0f) + 60.0f;
        if (this.players[0].m_nNitroTimer > 0) {
            f = this.players[0].m_nNitroTimer > 500 ? f + ((2500 - this.players[0].m_nNitroTimer) / 100.0f) : f + (this.players[0].m_nNitroTimer / 25.0f);
        }
        this.camera.setPerspective(f, (this.system_nCanvasWidth / ((this.system_nCanvasHeight - 84) - 18)) / 1.11f, 0.5f, 1000.0f);
        this.scene_cameraTrans.setIdentity();
        this.scene_cameraTrans.postTranslate(this.game_posX * 0.00390625f, this.game_posZ * 0.00390625f, this.game_posY * 0.00390625f);
        this.scene_cameraTrans.postRotate(this.game_cameraAngZ * 2.1457672E-5f, 0.0f, 1.0f, 0.0f);
        if (this.game_Time < 5000) {
            this.scene_cameraTrans.postTranslate(0.0f, 2.0f + ((5000.0f - this.game_Time) / 3000.0f), 5.5f + ((5000.0f - this.game_Time) / 2000.0f));
            return;
        }
        int i = (int) ((6.5f - (f / 60.0f)) * 256.0f);
        this.colResultCamera.f0x = this.players[0].m_colResult[2].f0x;
        this.colResultCamera.f1y = this.players[0].m_colResult[2].f1y;
        this.colResultCamera.f2z = this.players[0].m_colResult[2].f2z;
        this.colResultCamera.nTriangleID = this.players[0].m_colResult[2].nTriangleID;
        int i2 = (((this.sin_Array[(((this.game_cameraAngZ >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.game_cameraAngZ >> 8) >> 8) & 255]) * ((this.game_cameraAngZ >> 8) - ((this.game_cameraAngZ >> 8) & (-256)))) >> 8) + this.sin_Array[((this.game_cameraAngZ >> 8) >> 8) & 255];
        int i3 = -(this.sin_Array[(((this.game_cameraAngZ >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.game_cameraAngZ >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.game_cameraAngZ >> 8) + 49152) >> 8) & 255]) * (((this.game_cameraAngZ >> 8) + 49152) - (((this.game_cameraAngZ >> 8) + 49152) & (-256)))) >> 8));
        int i4 = -i3;
        int i5 = this.game_posX + ((i2 * i) >> 14) + ((i4 * (-300)) >> 14);
        int i6 = this.game_posY + ((i3 * i) >> 14) + ((i2 * (-300)) >> 14);
        this.groundCollision.TestPointForCollision(i5 << 8, (-i6) << 8, this.colResultCamera);
        if (this.colResultCamera.nTriangleID == -1) {
            this.colResultCamera.f0x = i5 << 8;
            this.colResultCamera.f1y = (-i6) << 8;
            this.colResultCamera.f2z = this.game_posZ << 8;
        }
        int i7 = ((((this.colResultCamera.f0x >> 8) - this.game_posX) * i2) + ((((-this.colResultCamera.f1y) >> 8) - this.game_posY) * i3)) >> 14;
        int i8 = this.colResultCamera.f2z;
        this.colResultCamera.f0x = this.players[0].m_colResult[3].f0x;
        this.colResultCamera.f1y = this.players[0].m_colResult[3].f1y;
        this.colResultCamera.f2z = this.players[0].m_colResult[3].f2z;
        this.colResultCamera.nTriangleID = this.players[0].m_colResult[3].nTriangleID;
        int i9 = (this.game_posX + ((i2 * i) >> 14)) - ((i4 * (-300)) >> 14);
        int i10 = (((i * i3) >> 14) + this.game_posY) - ((i2 * (-300)) >> 14);
        this.groundCollision.TestPointForCollision(i9 << 8, (-i10) << 8, this.colResultCamera);
        if (this.colResultCamera.nTriangleID == -1) {
            this.colResultCamera.f0x = i9 << 8;
            this.colResultCamera.f1y = (-i10) << 8;
            this.colResultCamera.f2z = this.game_posZ << 8;
        }
        int i11 = ((((this.colResultCamera.f0x >> 8) - this.game_posX) * i2) + ((((-this.colResultCamera.f1y) >> 8) - this.game_posY) * i3)) >> 14;
        if (i7 <= i11) {
            i11 = i7;
        }
        int i12 = (this.colResultCamera.f2z + i8) >> 9;
        int iArctan2 = i12 > this.game_posZ ? arctan2((i12 - this.game_posZ) << 8, i11 << 8) + 0 : 0;
        this.game_cameraAngX -= iArctan2;
        this.game_cameraAngX = (this.game_cameraAngX * 200) >> 8;
        this.game_cameraAngX = iArctan2 + this.game_cameraAngX;
        this.scene_cameraTrans.postRotate(-(this.game_cameraAngX * 2.1457672E-5f), 1.0f, 0.0f, 0.0f);
        this.scene_cameraTrans.postTranslate(0.0f, 2.0f, i11 * 0.00390625f);
    }

    void game_Start() throws Exception {
        game_CreateBuffer();
        scene_freeWorld();
        this.game_animationsLoaded = false;
        this.background.setColor(5732756);
        asset_LoadImage(138, false);
        asset_LoadImage(134, false);
        asset_LoadImage(130, false);
        asset_LoadImage(278, false);
        asset_LoadImage(126, false);
        asset_LoadImage(394, false);
        asset_LoadImage(394, false);
        asset_LoadImage(232, false);
        for (int i = 0; i < this.g_HudImgs.length; i++) {
            asset_LoadImage(this.g_HudImgs[i], false);
        }
        for (int i2 = 0; i2 < this.hudMPHImages.length; i2++) {
            asset_LoadImage(this.hudMPHImages[i2], false);
        }
        for (int i3 = 0; i3 < this.hudLGImages.length; i3++) {
            asset_LoadImage(this.hudLGImages[i3], false);
        }
        for (int i4 = 0; i4 < this.hudSMImages.length; i4++) {
            asset_LoadImage(this.hudSMImages[i4], false);
        }
        for (int i5 = 0; i5 < this.gearImgsOn.length; i5++) {
            asset_LoadImage(this.gearImgsOn[i5], false);
        }
        this.game_state = (byte) 4;
        game_InitState(4);
        this.game_Time = 0;
        this.game_TimeUpdate = -100000L;
        this.game_cameraAngZ = 0;
        this.players[0].m_zAng = 0;
        this.players[0].m_nLap = 0;
        this.players[0].m_nCurCheckpoint = 0;
        this.players[0].m_bPlayer = true;
        this.game_camlagX = 0;
        this.game_camlagY = 0;
        this.gameover_pause = false;
        this.game_closestEvasionPickup = 0;
        this.game_playerPosition = 1;
        this.game_playingStateHadUpdate = false;
        scene_CreateFlashEffect();
    }

    void game_StartMusic(boolean z) {
        int iSystem_GetRandom;
        try {
            game_StopMusic();
            if (z) {
                do {
                    iSystem_GetRandom = (system_GetRandom() & 255) % this.scene_musicTracks.length;
                } while (iSystem_GetRandom == this.scene_currentMusicTrack);
                this.scene_currentMusicTrack = iSystem_GetRandom;
            }
            if (this.system_nVolume > 0) {
                asset_LoadSound(this.scene_musicTracks[this.scene_currentMusicTrack], -1);
                asset_PlaySoundNowIfPossible(this.scene_musicTracks[this.scene_currentMusicTrack]);
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_share.hpp", 664, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_share.hpp", 664, e2.toString());
        }
    }

    void game_StopMusic() {
        if (this.scene_currentMusicTrack != -1) {
            asset_StopSound(-1);
            asset_FreeSound(this.scene_musicTracks[this.scene_currentMusicTrack]);
        }
    }

    int game_URandom() {
        this.game_random_number_gen++;
        return Math.abs(system_GetRandom());
    }

    void game_Update(int i) throws Exception {
        if (this.game_waitForInit) {
            return;
        }
        if (this.game_state == 2) {
            game_UpdatePlay(i);
        } else if (this.game_state == 4) {
            game_UpdateLevelLoading(i);
        } else if (this.game_state == 3) {
            game_UpdatePaused(i);
        } else if (this.game_state == 5 || this.game_state == 6 || this.game_state == 7) {
            game_UpdateGameOver(i);
        }
        this.game_profilerStartTimes[0][this.game_profilerPos] = i;
    }

    void game_UpdateCamera(int i) {
        this.game_posX = this.players[0].m_xPos;
        this.game_posY = this.players[0].m_yPos;
        this.game_posZ = this.players[0].m_zPos;
        this.game_angZ = this.players[0].m_zAng;
        int i2 = (this.players[0].m_velocityLastFrame >> 2) - 256;
        if (!(this.players[0].m_xVel == 0 && this.players[0].m_yVel == 0) && i2 > 0) {
            this.game_angZ = arctan2((-this.players[0].m_xVel) << 16, (-this.players[0].m_yVel) << 16) & 16777215;
            if (i2 < 1024) {
                int i3 = this.players[0].m_zAng & 16777215;
                if (i3 - this.game_angZ > 8388608) {
                    i3 -= 16777216;
                } else if (i3 - this.game_angZ < -8388608) {
                    i3 += 16777216;
                }
                this.game_angZ = (((i3 - this.game_angZ) >> 10) * (1024 - i2)) + this.game_angZ;
            }
        } else {
            this.game_angZ = this.players[0].m_zAng;
        }
        this.game_angZ &= 16777215;
        if (this.game_cameraAngZ - this.game_angZ > 8388608) {
            this.game_cameraAngZ -= 16777216;
        } else if (this.game_cameraAngZ - this.game_angZ < -8388608) {
            this.game_cameraAngZ += 16777216;
        }
        if (this.game_Time < 5000) {
            int i4 = (int) ((i * 1000.0f) / (5000.0f - this.game_Time));
            if (((i4 * 12) >> 8) <= 256) {
                i = i4;
            }
        }
        this.game_cameraAngZ -= this.game_angZ;
        this.game_cameraAngZ = ((this.game_cameraAngZ >> 4) * ((this.exp_Array[(-((-i) * 12)) >> 8] + (((this.exp_Array[((-((-i) * 12)) >> 8) + 1] - this.exp_Array[(-((-i) * 12)) >> 8]) * ((-((-i) * 12)) - ((-((-i) * 12)) & (-256)))) >> 8)) >> 4)) >> 8;
        this.game_cameraAngZ += this.game_angZ;
        this.game_cameraAngZ &= 16777215;
    }

    void game_UpdateCop_RaceSpecific(int i, boolean z) {
        int length;
        int i2;
        int i3 = this.players[0].m_nAiNode;
        if (z || (system_GetRandom() >= 1644167168 && this.players[0].m_nCurrentHeatRating > 2)) {
            length = i3 + 12;
            this.cops[i].m_nState = 4;
            this.cops[i].m_nLap = this.players[0].m_nLap;
            if (length >= this.cops[i].m_aiSpline.length) {
                length -= this.cops[i].m_aiSpline.length;
                this.cops[i].m_nLap++;
            }
            this.cops[i].m_zAng = ((this.cops[i].m_aiSpline[length][2] << 8) + 8388608) & 16777215;
            this.cops[i].m_bReverseTrack = true;
            this.cops[i].m_bGoingBackward = true;
            i2 = 0;
        } else if (system_GetRandom() >= 1778384896 && this.players[0].m_nCurrentHeatRating > 1) {
            length = i3 + 12;
            this.cops[i].m_nState = 1;
            this.cops[i].m_nLap = this.players[0].m_nLap;
            if (length >= this.cops[i].m_aiSpline.length) {
                length -= this.cops[i].m_aiSpline.length;
                this.cops[i].m_nLap++;
            }
            i2 = this.cops[i].m_nTopSpeed >> 1;
            this.cops[i].m_zAng = ((this.cops[i].m_aiSpline[length][2] << 8) + 8388608 + 4194304) & 16777215;
            this.cops[i].m_bReverseTrack = true;
            this.cops[i].m_bGoingBackward = true;
        } else if (system_GetRandom() >= 1073741824) {
            length = i3 + 12;
            this.cops[i].m_nState = 6;
            this.cops[i].m_nLap = this.players[0].m_nLap;
            if (length >= this.cops[i].m_aiSpline.length) {
                length -= this.cops[i].m_aiSpline.length;
                this.cops[i].m_nLap++;
            }
            i2 = this.players[0].m_velocityLastFrame >> 2;
            this.cops[i].m_zAng = ((this.cops[i].m_aiSpline[length][2] << 8) + 4194304) & 16777215;
            this.cops[i].m_bReverseTrack = false;
            this.cops[i].m_bGoingBackward = false;
        } else {
            length = i3 - 2;
            this.cops[i].m_nState = 0;
            this.cops[i].m_nLap = this.players[0].m_nLap;
            if (length < 0) {
                length += this.cops[i].m_aiSpline.length;
                this.cops[i].m_nLap--;
            }
            i2 = this.players[0].m_velocityLastFrame;
            if (i2 < (this.cops[i].m_nTopSpeed >> 2)) {
                i2 = this.cops[i].m_nTopSpeed >> 2;
            }
            this.cops[i].m_zAng = ((this.cops[i].m_aiSpline[length][2] << 8) + 4194304) & 16777215;
            this.cops[i].m_bReverseTrack = false;
            this.cops[i].m_bGoingBackward = false;
        }
        this.cops[i].m_xPos = this.cops[i].m_aiSpline[length][0] << 4;
        this.cops[i].m_yPos = this.cops[i].m_aiSpline[length][1] << 4;
        this.cops[i].m_nAiNode = length;
        this.cops[i].InitCollisionToSplinePos(length);
        this.cops[i].m_nTimeNotVisable = 2000;
        this.cops[i].m_nTimeSinceSpawn = 0;
        this.cops[i].m_bHitPlayer = false;
        this.cops[i].m_xVel = ((-(this.sin_Array[((this.cops[i].m_zAng >> 8) >> 8) & 255] + (((this.sin_Array[(((this.cops[i].m_zAng >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.cops[i].m_zAng >> 8) >> 8) & 255]) * ((this.cops[i].m_zAng >> 8) - ((this.cops[i].m_zAng >> 8) & (-256)))) >> 8))) * i2) >> 14;
        this.cops[i].m_yVel = (i2 * (this.sin_Array[(((this.cops[i].m_zAng >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.cops[i].m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.cops[i].m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.cops[i].m_zAng >> 8) + 49152) - (((this.cops[i].m_zAng >> 8) + 49152) & (-256)))) >> 8))) >> 14;
        this.cops[i].m_velocityLastFrame = 0;
        this.cops[i].m_bReversing = false;
        this.cops[i].m_nAverageSplineMovementSpeed = 0;
        this.cops[i].m_nAverageSpeed = this.cops[i].m_nTopSpeed;
        this.cops[i].m_nStateTime = 0;
        this.game_timeSinceLastCopSpawn = 0;
    }

    void game_UpdateCops(int i) {
        int i2;
        boolean z;
        if (this.g_race.m_numRacers == 1) {
            i2 = 0;
            for (int i3 = 0; i3 < this.g_race.m_numCops; i3++) {
                i2++;
            }
        } else if (this.g_race.m_numRacers > 1) {
            i2 = 0;
            for (int i4 = 1; i4 < this.g_race.m_numRacers; i4++) {
                if (this.players[i4].m_nTimeNotVisable > 5000 && i2 < this.g_race.m_numCops) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 > 1 && this.players[0].m_nCurrentHeatRating < 3) {
            i2 = 1;
        }
        this.game_timeSinceLastCopSpawn += i;
        int i5 = this.g_race.m_type == 4 ? 10000 : 5000;
        if (i2 > 0 && this.players[0].m_nCurrentHeatRating > 0 && this.game_timeSinceLastCopSpawn > i5 && this.players[0].m_nAverageSplineMovementSpeed > 2000) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (this.cops[i6].m_bDisabled) {
                    if (this.g_race.m_type != 4) {
                        z = false;
                    } else if (system_GetRandom() < 1644167168) {
                        break;
                    } else {
                        z = true;
                    }
                    this.cops[i6].m_bDisabled = false;
                    this.cops[i6].m_nDamagedLevel = 0;
                    this.game_numSpawnedCops++;
                    game_UpdateCop_RaceSpecific(i6, z);
                    break;
                }
            }
        }
        if (this.g_race.m_type != 4) {
            if (this.players[0].m_nAverageSplineMovementSpeed > 2000) {
                for (int i7 = 0; i7 < this.g_race.m_numCops; i7++) {
                    if (!this.cops[i7].m_bDisabled && this.cops[i7].m_nTimeNotVisable > 4000 && this.cops[i7].m_nTimeSinceSpawn > 8000) {
                        this.cops[i7].m_bDisabled = true;
                        this.game_numSpawnedCops--;
                    }
                }
                return;
            }
            return;
        }
        for (int i8 = 0; i8 < this.g_race.m_numCops; i8++) {
            int i9 = this.cops[i8].m_xPos - this.players[0].m_xPos;
            int i10 = this.cops[i8].m_yPos - this.players[0].m_yPos;
            if (!this.cops[i8].m_bDisabled && this.cops[i8].m_nTimeNotVisable > 200 && (Math.abs(i9) + Math.abs(i10)) - (Math.min(Math.abs(i9), Math.abs(i10)) >> 1) < 7680) {
                this.cops[i8].m_bDisabled = true;
                this.game_numSpawnedCops--;
            }
        }
    }

    void game_UpdateGameOver(int i) throws Exception {
        this.scene_timer += i;
        if (this.gameOver_stage == 0) {
            game_UpdatePlay(i);
        }
    }

    void game_UpdateGameTypeSpecifics(int i) {
        if (this.g_race.m_type == 0) {
            if (this.players[0].m_nLap >= this.g_race.m_laps) {
                game_EndRace();
                return;
            } else {
                if (this.game_state == 6 || this.game_state == 5) {
                    return;
                }
                this.game_Time += i;
                return;
            }
        }
        if (this.g_race.m_type == 1) {
            if (this.players[0].m_nCurCheckpoint >= this.track_checkpoints.length) {
                game_EndRace();
                return;
            } else {
                if (this.game_state == 6 || this.game_state == 5) {
                    return;
                }
                this.game_Time += i;
                return;
            }
        }
        if (this.g_race.m_type == 3) {
            if (this.players[0].m_nCurCheckpoint >= this.track_checkpoints.length) {
                game_EndRace();
                return;
            }
            if (this.game_Time >= this.g_race.m_nTimeLimit + 5000) {
                game_EndRace();
                return;
            } else {
                if (this.game_state == 6 || this.game_state == 5) {
                    return;
                }
                this.game_Time += i;
                return;
            }
        }
        if (this.g_race.m_type != 4) {
            if (this.g_race.m_type != 2 || this.game_state == 6 || this.game_state == 5) {
                return;
            }
            this.game_Time += i;
            return;
        }
        if (this.game_Time >= this.g_race.m_nTimeLimit + 5000) {
            game_EndRace();
            return;
        }
        if (this.game_playerPosition != 1) {
            game_EndRace();
        } else {
            if (this.game_state == 6 || this.game_state == 5) {
                return;
            }
            this.game_Time += i;
        }
    }

    void game_UpdateLevelLoading(int i) throws Exception {
        this.loading_timeTotal += System.currentTimeMillis() - this.loading_previousTime;
        this.loading_previousTime = System.currentTimeMillis();
        if (this.game_reloading) {
            if (!game_ReloadLevel()) {
                return;
            }
        } else if (!game_LoadLevel()) {
            return;
        }
        game_ClearLevelLoading();
        game_StartMusic(true);
        game_InitState(2);
    }

    void game_UpdatePaused(int i) throws Exception {
        this.scene_timer += i;
        if (this.paused_action == 0 || !this.paused_hourglass) {
            return;
        }
        wait(100L);
        asset_ChangeVolume(this.system_nVolume);
        if (this.paused_action == 1) {
            if (!this.game_isLoading) {
                game_InitState(7);
                return;
            }
            this.game_waitForInit = true;
            this.game_state = (byte) 4;
            game_ClearLevelLoading();
            this.game_waitForInit = false;
            scene_Transition(4096);
            return;
        }
        if (this.paused_action != 2) {
            System.out.println("Unknown action for pause menu - just doing nothing instead");
            this.paused_action = 0;
            this.paused_hourglass = false;
            return;
        }
        game_StartMusic(false);
        if (!this.game_isLoading) {
            if (this.game_state_before_pause == 7 || this.game_state_before_pause == 6 || this.game_state_before_pause == 5) {
                this.gameover_pause = true;
            }
            this.game_state = this.game_state_before_pause;
            return;
        }
        int i2 = this.game_loadState;
        this.game_waitForInit = true;
        this.game_state = (byte) 4;
        game_InitStateLevelLoading(this.game_reloading);
        this.game_loadState = i2;
        this.game_waitForInit = false;
    }

    void game_UpdatePlay(int i) throws Exception {
        short s;
        short s2;
        int i2;
        int i3;
        if (i > 150) {
            this.slowCount++;
            if (this.slowCount > 5) {
                game_StartMusic(false);
                this.slowCount = -5;
            }
        } else if (this.slowCount > 0) {
            this.slowCount--;
        }
        this.game_profilerStartTimes[1][this.game_profilerPos] = System.currentTimeMillis();
        this.game_playingStateHadUpdate = true;
        this.game_nTimeInState = (short) (this.game_nTimeInState + i);
        this.game_nTimeKeyHeld = (short) (this.game_nTimeKeyHeld + i);
        game_CheckControl();
        this.game_profilerEndTimes[1][this.game_profilerPos] = System.currentTimeMillis();
        if (this.game_profilerEndTimes[1][this.game_profilerPos] - this.game_profilerStartTimes[1][this.game_profilerPos] > 100) {
            System.out.println(new StringBuffer().append("large timer val:1,").append(this.game_profilerEndTimes[1][this.game_profilerPos] - this.game_profilerStartTimes[1][this.game_profilerPos]).toString());
        }
        if (i != 0) {
            try {
                this.game_profilerStartTimes[11][this.game_profilerPos] = System.currentTimeMillis();
                int i4 = 65536 / i;
                for (int i5 = 1; i5 < this.sortedCarsList.length; i5++) {
                    int i6 = this.sortedCarsList[i5].m_nSortDistance;
                    Car car = this.sortedCarsList[i5];
                    int i7 = i5;
                    while (this.sortedCarsList[i7 - 1].m_nSortDistance > i6) {
                        this.sortedCarsList[i7] = this.sortedCarsList[i7 - 1];
                        i7--;
                        if (i7 <= 0) {
                            break;
                        }
                    }
                    this.sortedCarsList[i7] = car;
                }
                this.game_profilerEndTimes[11][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[11][this.game_profilerPos] - this.game_profilerStartTimes[11][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:11,").append(this.game_profilerEndTimes[11][this.game_profilerPos] - this.game_profilerStartTimes[11][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[12][this.game_profilerPos] = System.currentTimeMillis();
                for (int i8 = 0; i8 < this.allCarsList.length; i8++) {
                    this.allCarsList[i8].RealizeNewTransform(i, i4);
                }
                this.game_profilerEndTimes[12][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[12][this.game_profilerPos] - this.game_profilerStartTimes[12][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:12,").append(this.game_profilerEndTimes[12][this.game_profilerPos] - this.game_profilerStartTimes[12][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[13][this.game_profilerPos] = System.currentTimeMillis();
                for (int i9 = 0; i9 < this.allCarsList.length; i9++) {
                    this.allCarsList[i9].UpdatePhysics(i, i4);
                }
                this.game_profilerEndTimes[13][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[13][this.game_profilerPos] - this.game_profilerStartTimes[13][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:13,").append(this.game_profilerEndTimes[13][this.game_profilerPos] - this.game_profilerStartTimes[13][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[14][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_Time < 5000) {
                    for (int i10 = 0; i10 < this.sortedCarsList.length; i10++) {
                        this.sortedCarsList[i10].m_xVel = 0;
                        this.sortedCarsList[i10].m_yVel = 0;
                        this.sortedCarsList[i10].m_nReverseTimer = 0;
                    }
                }
                this.game_profilerEndTimes[14][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[14][this.game_profilerPos] - this.game_profilerStartTimes[14][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:14,").append(this.game_profilerEndTimes[14][this.game_profilerPos] - this.game_profilerStartTimes[14][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[15][this.game_profilerPos] = System.currentTimeMillis();
                this.game_profilerEndTimes[15][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[15][this.game_profilerPos] - this.game_profilerStartTimes[15][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:15,").append(this.game_profilerEndTimes[15][this.game_profilerPos] - this.game_profilerStartTimes[15][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[16][this.game_profilerPos] = System.currentTimeMillis();
                for (int i11 = 0; i11 < this.sortedCarsList.length; i11++) {
                    this.sortedCarsList[i11].m_nSortedPos = i11;
                    int i12 = this.sortedCarsList[i11].m_nSortDistance;
                    for (int i13 = i11 + 1; i13 < this.sortedCarsList.length && i12 + 3 >= this.sortedCarsList[i13].m_nSortDistance; i13++) {
                        this.sortedCarsList[i11].CollideWith(this.sortedCarsList[i13], i, i4);
                    }
                }
                this.game_profilerEndTimes[16][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[16][this.game_profilerPos] - this.game_profilerStartTimes[16][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:16,").append(this.game_profilerEndTimes[16][this.game_profilerPos] - this.game_profilerStartTimes[16][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[17][this.game_profilerPos] = System.currentTimeMillis();
                this.game_profilerEndTimes[17][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[17][this.game_profilerPos] - this.game_profilerStartTimes[17][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:17,").append(this.game_profilerEndTimes[17][this.game_profilerPos] - this.game_profilerStartTimes[17][this.game_profilerPos]).toString());
                }
                this.game_profilerStartTimes[18][this.game_profilerPos] = System.currentTimeMillis();
                game_UpdateCops(i);
                game_UpdateTraffic(i);
                for (int i14 = 0; i14 < this.allCarsList.length; i14++) {
                    this.allCarsList[i14].UpdateTrackCollision(i, i4);
                }
                this.game_profilerEndTimes[18][this.game_profilerPos] = System.currentTimeMillis();
                if (this.game_profilerEndTimes[18][this.game_profilerPos] - this.game_profilerStartTimes[18][this.game_profilerPos] > 100) {
                    System.out.println(new StringBuffer().append("large timer val:18,").append(this.game_profilerEndTimes[18][this.game_profilerPos] - this.game_profilerStartTimes[18][this.game_profilerPos]).toString());
                }
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_play_share.hpp", 834, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_play_share.hpp", 834, e2.toString());
            }
        }
        this.game_profilerStartTimes[19][this.game_profilerPos] = System.currentTimeMillis();
        try {
            if (this.g_race.m_bMission && this.g_race.m_nMissionID == 0 && this.players[0].m_nLap > 0) {
                this.game_nKeyFlags &= -24;
                this.players[0].m_nAccelerateTimer = 0;
                this.players[0].m_nAcceleration = 0;
                this.players[0].m_bReversing = false;
                if (this.game_state == 2) {
                    this.players[0].m_xVel = (int) (this.players[0].m_xVel * 0.99f);
                    this.players[0].m_yVel = (int) (this.players[0].m_yVel * 0.99f);
                } else {
                    this.players[0].m_xVel = 0;
                    this.players[0].m_yVel = 0;
                }
                if (this.players[0].m_velocityLastFrame < 1000) {
                    game_EndRace();
                } else if (this.players[0].m_velocityLastFrame < 8000) {
                    game_popupText(this.g_Text[193], true);
                }
            }
            if (this.g_race.m_type == 4 && this.game_playerPosition != 1) {
                this.game_nKeyFlags &= -24;
                this.players[0].m_nAccelerateTimer = 0;
                this.players[0].m_nAcceleration = 0;
                this.players[0].m_bReversing = false;
                if (this.players[0].m_velocityLastFrame < 1000) {
                    this.players[0].m_xVel = 0;
                    this.players[0].m_yVel = 0;
                } else {
                    this.players[0].m_xVel = (int) (this.players[0].m_xVel * 0.99f);
                    this.players[0].m_yVel = (int) (this.players[0].m_yVel * 0.99f);
                }
            }
            game_UpdateGameTypeSpecifics(i);
            boolean z = true;
            if (this.game_state == 2) {
                if (Math.abs(this.players[0].m_velocityLastFrame) < 3000) {
                    for (int i15 = 0; i15 < this.g_race.m_numCops; i15++) {
                        if (!this.cops[i15].m_bDisabled && this.cops[i15].m_nDamagedLevel < 51200 && this.cops[i15].m_camDist < 2500 && Math.abs(this.cops[i15].m_velocityLastFrame) < 3000) {
                            z = false;
                            this.players[0].m_nBustedness += i;
                            break;
                        }
                    }
                }
                if (this.players[0].m_nBustedness > 0) {
                    if (z) {
                        if (this.players[0].m_nBustedness <= 1000 || this.players[0].m_nBustedness >= 4000) {
                            if (this.players[0].m_nBustedness > 1000) {
                                game_popupText(this.g_Text[194], false);
                            }
                            this.players[0].m_nBustedness = 0;
                        } else {
                            this.players[0].m_nBustedness += i;
                        }
                    }
                    if (this.players[0].m_nBustedness > 1000) {
                        game_popupText(new StringBuffer().append(this.g_Text[195]).append(" ").append(((5000 - this.players[0].m_nBustedness) / 1000) + 1).toString(), false);
                        if (this.g_race.m_type != 4 && this.players[0].m_nBustedness > 5000) {
                            for (int i16 = 0; i16 < this.g_race.m_numCops; i16++) {
                                this.cops[i16].m_nState = 4;
                            }
                            game_InitState(6);
                        }
                    }
                }
            } else if (this.game_state == 6) {
                this.players[0].m_xVel = (int) (this.players[0].m_xVel * 0.9f);
                this.players[0].m_yVel = (int) (this.players[0].m_yVel * 0.9f);
            }
        } catch (Error e3) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_play_share.hpp", 957, e3.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\game_state_play_share.hpp", 957, e4.toString());
        }
        game_UpdateCamera(i);
        int i17 = 500000000;
        int i18 = 500000000;
        int i19 = 500000000;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        int i20 = this.game_posX >> 8;
        int i21 = this.game_posY >> 8;
        int i22 = this.game_posZ >> 8;
        short s6 = 0;
        while (s6 < 200) {
            int i23 = ((this.track_pvsXYZ[s6][0] - i20) * (this.track_pvsXYZ[s6][0] - i20)) + ((this.track_pvsXYZ[s6][1] - i21) * (this.track_pvsXYZ[s6][1] - i21)) + ((this.track_pvsXYZ[s6][2] - i22) * (this.track_pvsXYZ[s6][2] - i22));
            if (i23 < i17) {
                s5 = s4;
                s = s3;
                s2 = s6;
                i19 = i18;
                i2 = i17;
                i3 = i23;
            } else if (i23 < i18) {
                s5 = s4;
                s = s6;
                s2 = s3;
                i19 = i18;
                i2 = i23;
                i3 = i17;
            } else if (i23 < i19) {
                s5 = s6;
                s = s4;
                s2 = s3;
                i19 = i23;
                i2 = i18;
                i3 = i17;
            } else {
                s = s4;
                s2 = s3;
                i2 = i18;
                i3 = i17;
            }
            s6 = (short) (s6 + 1);
            s4 = s;
            s3 = s2;
            i18 = i2;
            i17 = i3;
        }
        this.trackPVSFrame1 = s3;
        this.trackPVSFrame2 = s4;
        this.trackPVSFrame3 = s5;
        this.cameraScopeMask = (1 << ((((this.game_cameraAngZ >> 16) - 64) >> 4) & 15)) | (1 << (((((this.game_cameraAngZ >> 16) - 64) - 11) >> 4) & 15)) | (1 << (((((this.game_cameraAngZ >> 16) - 64) + 11) >> 4) & 15)) | (1 << (((((this.game_cameraAngZ >> 16) - 64) - 22) >> 4) & 15)) | (1 << (((((this.game_cameraAngZ >> 16) - 64) + 22) >> 4) & 15));
        this.game_profilerEndTimes[19][this.game_profilerPos] = System.currentTimeMillis();
        if (this.game_profilerEndTimes[19][this.game_profilerPos] - this.game_profilerStartTimes[19][this.game_profilerPos] > 100) {
            System.out.println(new StringBuffer().append("large timer val:19,").append(this.game_profilerEndTimes[19][this.game_profilerPos] - this.game_profilerStartTimes[19][this.game_profilerPos]).toString());
        }
        this.game_profilerStartTimes[20][this.game_profilerPos] = System.currentTimeMillis();
        game_UpdateTachometer(i);
        this.game_profilerEndTimes[20][this.game_profilerPos] = System.currentTimeMillis();
        if (this.game_profilerEndTimes[20][this.game_profilerPos] - this.game_profilerStartTimes[20][this.game_profilerPos] > 100) {
            System.out.println(new StringBuffer().append("large timer val:20,").append(this.game_profilerEndTimes[20][this.game_profilerPos] - this.game_profilerStartTimes[20][this.game_profilerPos]).toString());
        }
    }

    void game_UpdateTachometer(int i) {
        int i2 = ((this.players[0].m_velocityLastFrame << 4) & 32767) + 4095;
        if (this.game_tachometer_vel < i2) {
            this.game_tachometer_vel += i * 40;
            if (this.game_tachometer_vel > i2) {
                this.game_tachometer_vel = i2;
                return;
            }
            return;
        }
        if (this.game_tachometer_vel > i2) {
            this.game_tachometer_vel -= i * 40;
            if (this.game_tachometer_vel < i2) {
                this.game_tachometer_vel = i2;
            }
        }
    }

    void game_UpdateTraffic(int i) {
        if (this.game_numSpawnedCops == 0) {
            for (int i2 = 0; i2 < this.traffic.length; i2++) {
                if (this.traffic[i2].m_nTimeNotVisable > 2000) {
                    int iAbs = Math.abs(system_GetRandom() >> 16) % this.traffic[i2].m_aiSpline.length;
                    int iAbs2 = Math.abs(this.players[0].m_xPos - (this.traffic[i2].m_aiSpline[iAbs][0] << 4)) + Math.abs(this.players[0].m_yPos - (this.traffic[i2].m_aiSpline[iAbs][1] << 4));
                    if (iAbs2 > 14500 && iAbs2 < 17000) {
                        if (((-(this.sin_Array[((this.game_cameraAngZ >> 8) >> 8) & 255] + (((this.sin_Array[(((this.game_cameraAngZ >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.game_cameraAngZ >> 8) >> 8) & 255]) * ((this.game_cameraAngZ >> 8) - ((this.game_cameraAngZ >> 8) & (-256)))) >> 8))) * ((this.traffic[i2].m_aiSpline[iAbs][0] << 4) - this.game_posX)) + ((this.sin_Array[(((this.game_cameraAngZ >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.game_cameraAngZ >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.game_cameraAngZ >> 8) + 49152) >> 8) & 255]) * (((this.game_cameraAngZ >> 8) + 49152) - (((this.game_cameraAngZ >> 8) + 49152) & (-256)))) >> 8)) * ((this.traffic[i2].m_aiSpline[iAbs][1] << 4) - this.game_posY)) > 0) {
                            this.traffic[i2].m_nState = 0;
                            this.traffic[i2].m_nLap = 0;
                            int i3 = this.traffic[i2].m_nTopSpeed >> 3;
                            this.traffic[i2].m_zAng = ((this.traffic[i2].m_aiSpline[iAbs][2] << 8) + 4194304) & 16777215;
                            this.traffic[i2].m_bReverseTrack = false;
                            this.traffic[i2].m_bGoingBackward = false;
                            this.traffic[i2].m_xPos = this.traffic[i2].m_aiSpline[iAbs][0] << 4;
                            this.traffic[i2].m_yPos = this.traffic[i2].m_aiSpline[iAbs][1] << 4;
                            this.traffic[i2].m_nAiNode = iAbs;
                            this.traffic[i2].InitCollisionToSplinePos(iAbs);
                            this.traffic[i2].m_nTimeNotVisable = 0;
                            this.traffic[i2].m_nTimeSinceSpawn = 0;
                            this.traffic[i2].m_xVel = ((-(this.sin_Array[((this.traffic[i2].m_zAng >> 8) >> 8) & 255] + (((this.sin_Array[(((this.traffic[i2].m_zAng >> 8) >> 8) + 1) & 255] - this.sin_Array[((this.traffic[i2].m_zAng >> 8) >> 8) & 255]) * ((this.traffic[i2].m_zAng >> 8) - ((this.traffic[i2].m_zAng >> 8) & (-256)))) >> 8))) * i3) >> 14;
                            this.traffic[i2].m_yVel = (i3 * (this.sin_Array[(((this.traffic[i2].m_zAng >> 8) + 49152) >> 8) & 255] + (((this.sin_Array[((((this.traffic[i2].m_zAng >> 8) + 49152) >> 8) + 1) & 255] - this.sin_Array[(((this.traffic[i2].m_zAng >> 8) + 49152) >> 8) & 255]) * (((this.traffic[i2].m_zAng >> 8) + 49152) - (((this.traffic[i2].m_zAng >> 8) + 49152) & (-256)))) >> 8))) >> 14;
                            this.traffic[i2].m_velocityLastFrame = 0;
                            this.traffic[i2].m_bReversing = false;
                            this.traffic[i2].m_nAverageSplineMovementSpeed = 0;
                            this.traffic[i2].m_nAverageSpeed = this.traffic[i2].m_nTopSpeed;
                            this.traffic[i2].RealizeNewTransform(i, 65536 / i);
                            this.traffic[i2].m_nStateTime = 0;
                        }
                    }
                }
            }
        }
    }

    void game_WriteInt(byte[] bArr, int i) {
        int i2 = this.map_dataPointer;
        this.map_dataPointer = i2 + 1;
        bArr[i2] = (byte) (i >> 24);
        int i3 = this.map_dataPointer;
        this.map_dataPointer = i3 + 1;
        bArr[i3] = (byte) (i >> 16);
        int i4 = this.map_dataPointer;
        this.map_dataPointer = i4 + 1;
        bArr[i4] = (byte) (i >> 8);
        int i5 = this.map_dataPointer;
        this.map_dataPointer = i5 + 1;
        bArr[i5] = (byte) i;
    }

    void game_clearPopupText() {
        this.popupTimer = 0;
        this.popupString = null;
        this.popupImg = -1;
        this.popupPriority = false;
    }

    void game_popupImg(int i) {
        this.popupTimer = this.game_Time + 1500;
        this.popupString = null;
        this.popupImg = i;
    }

    void game_popupText(String str, boolean z) {
        if (!this.popupPriority || z) {
            this.popupPriority = z;
            this.popupTimer = this.game_Time + 1500;
            this.popupString = str;
            this.popupImg = -1;
        }
    }

    boolean getNextScriptPage() {
        if (this.pagePos == -1) {
            this.pagePos = 0;
            return false;
        }
        if (this.currentPage == "") {
            this.pagePos = 0;
        }
        int iIndexOf = this.script.indexOf("\\n", this.pagePos);
        if (iIndexOf == -1) {
            this.currentPage = this.script.substring(this.pagePos);
            this.pagePos = -1;
        } else {
            this.currentPage = this.script.substring(this.pagePos, iIndexOf);
            this.pagePos = iIndexOf + 2;
        }
        return true;
    }

    public synchronized void hideNotify() {
        try {
            system_Hide();
            asset_StopSound(-1);
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }

    @Override // com.alcatelonetouchx.CanvasPlus
    protected synchronized void keyPressee(int i) {
        try {
            int iSystem_TranslateKeyPressed = system_TranslateKeyPressed(i);
            int gameAction = 0;
            if ((1048560 & iSystem_TranslateKeyPressed) != 589824 && iSystem_TranslateKeyPressed != -14) {
                try {
                    try {
                        gameAction = getGameAction(iSystem_TranslateKeyPressed);
                    } catch (Error e) {
                        End();
                        m_Midlet.notifyDestroyed();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            scene_KeyPressed(iSystem_TranslateKeyPressed, gameAction);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.alcatelonetouchx.CanvasPlus
    protected synchronized void keyReleasee(int i) {
        scene_KeyReleased(system_TranslateKeyPressed(i), getGameAction(i));
    }

    void limbo_KeyPressed(int i, int i2) throws Exception {
        scene_Transition(4097);
    }

    void limbo_Render() {
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 1777631);
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        this.font_text.SetColor(255, 255, 255);
        int iFreeMemory = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        int i = iFreeMemory % 1000;
        String str = i < 100 ? "0" : "";
        if (i < 10) {
            str = "00";
        }
        String string = new StringBuffer().append(str).append(i).toString();
        int i2 = ((iFreeMemory - i) % 1000000) / 1000;
        String str2 = i2 < 100 ? "0" : "";
        if (i2 < 10) {
            str2 = "00";
        }
        int i3 = (((iFreeMemory - i) - i2) % 1000000000) / 1000000;
        String string2 = new StringBuffer().append("MEM = ").append(i3 > 0 ? new StringBuffer().append("").append(i3).append(",").toString() : "").append(new StringBuffer().append(str2).append(i2).toString()).append(",").append(string).append("]").toString();
        this.font_text.DrawSubstring(string2, 0, string2.length(), this.system_nCanvasWidth / 2, (this.system_nCanvasHeight / 2) - 32, 1);
    }

    void limbo_Update(int i) throws Exception {
    }

    boolean loadLastLang() {
        boolean z = true;
        try {
            byte[] bArr = new byte[1];
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("currentLanguage", false);
            RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
            if (recordEnumerationEnumerateRecords.hasNextElement()) {
                this.g_nLanguage = recordStoreOpenRecordStore.getRecord(recordEnumerationEnumerateRecords.nextRecordId())[0];
                recordEnumerationEnumerateRecords.destroy();
                recordStoreOpenRecordStore.closeRecordStore();
                if (this.g_nLanguage <= -1 || this.g_nLanguage >= 2) {
                    this.g_nLanguage = (byte) 0;
                    z = false;
                } else {
                    LoadLanguage(this.g_nLanguage);
                }
            } else {
                this.g_nLanguage = (byte) 0;
                z = false;
            }
            return z;
        } catch (Exception e) {
            clearSavedLang();
            this.g_nLanguage = (byte) 0;
            return false;
        }
    }

    short[][] loadPointSet(int i) {
        int iBinLoad = binLoad(i);
        int iBinGetShort = binGetShort(iBinLoad);
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iBinGetShort, 3);
        for (int i2 = 0; i2 < iBinGetShort; i2++) {
            sArr[i2][0] = binGetShort(iBinLoad);
            sArr[i2][1] = (short) (-binGetShort(iBinLoad));
            sArr[i2][2] = binGetShort(iBinLoad);
        }
        binFree(i);
        return sArr;
    }

    void loadSplineSet(int i, int i2) {
        int iBinLoad = binLoad(i);
        int i3 = (this.asset_DataArray[i + 0] & (-1)) >> 0;
        int i4 = ((short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16)) - 6;
        do {
            int iBinGetShort = binGetShort(iBinLoad);
            this.track_splines[i2] = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iBinGetShort, 5);
            for (int i5 = 0; i5 < iBinGetShort; i5++) {
                this.track_splines[i2][i5][0] = binGetShort(iBinLoad);
                this.track_splines[i2][i5][1] = (short) (-binGetShort(iBinLoad));
                this.track_splines[i2][i5][2] = binGetShort(iBinLoad);
                this.track_splines[i2][i5][3] = -1;
                this.track_splines[i2][i5][4] = 0;
            }
            i2++;
        } while (this.map_dataPointer - i3 < i4);
        binFree(i);
    }

    void make_crc_table() {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (1 & j) != 0 ? (j >> 1) ^ 3988292384L : j >> 1;
            }
            this.crc_table[i] = j;
        }
        this.crc_table_computed = 1;
        for (int i3 = 0; i3 < 256; i3++) {
        }
    }

    int menuCmdToPart(int i) {
        switch (i) {
            case 4096:
                return 0;
            case 8192:
                return 1;
            case 16384:
                return 2;
            case 32768:
                return 3;
            case 65536:
                return 4;
            case 131072:
                return 5;
            case 262144:
                return 6;
            case 524288:
                return 7;
            case 1048576:
                return 8;
            case 2097152:
                return 9;
            case 4194304:
                return 10;
            case 8388608:
                return 11;
            case 16777216:
                return 12;
            case 33554432:
                return 13;
            case 67108864:
                return 14;
            case 134217728:
                return 15;
            case 268435456:
                return 16;
            default:
                System.out.println("UNKNOWN MENU TYPE can't conver to car part type properly will fail");
                return -1;
        }
    }

    void menu_Construct() throws Exception {
        this.menu_startupStage = 1;
        this.menu_sceneLoadStage = 0;
        this.menu_paintCarTimer = 0;
        this.menu_updateCarPaint = false;
        game_msg = new String[42];
        this.menu_intromusicloaded = false;
        this.tryMusicUntil = 0L;
        this.currentColor = 0;
        this.menu_IsPaused = false;
        this.menu_show_mode = (byte) 0;
        asset_LoadImage(2, false);
        if (this.system_bDemoMode) {
            for (int i = 0; i < this.g_missions.length; i++) {
                if (i != 6) {
                    this.g_missions[i].m_reqMission = 0;
                }
            }
        }
        this.menu_nItemsHeight = this.font_text.GetHeight();
        this.menu_nItemsYSpacing = 0;
        this.menu_rowHeight = this.menu_nItemsHeight + this.menu_nItemsYSpacing;
        this.menu_canvasHeight = (((this.system_nCanvasHeight - 20) - 17) / this.menu_rowHeight) * this.menu_rowHeight;
        this.itemColor = 16776960;
        this.selectedColor = 16777215;
        this.menu_max_row_count = (short) (68 / this.menu_rowHeight);
        this.menu_current_top_row = (short) 0;
    }

    void menu_Destroy() {
        if (this.menu_intromusicloaded) {
        }
        asset_FreeImage(2);
        game_msg = null;
    }

    void menu_DrawCar() {
        this.game_cameraAngZ = 0;
        NFSMW_CarAppearance nFSMW_CarAppearance = this.g_cars[this.menu_car];
        this.trans.setIdentity();
        this.trans.postTranslate(0.0f, -0.2f, -4.5f);
        this.trans.postRotate(menu_camerCarAngle, 1.0f, 0.0f, 0.0f);
        this.trans.postRotate(this.car_rot >> 5, 0.0f, 1.0f, 0.0f);
        this.camera.setPerspective(80.0f, 1.0f, 0.5f, 1000.0f);
        this.camera.setTransform(this.trans);
        try {
            this.scene_g3d.bindTarget(m_CurrentGraphics, true, 2);
            this.background.setColor(11386309);
            this.background.setColorClearEnable(true);
            this.background.setDepthClearEnable(true);
            this.scene_g3d.clear(this.background);
            this.scene_g3d.setCamera(this.camera, (Transform) null);
            this.scene_g3d.render(this.menu_Group, this.trans);
            if (this.menu_drawCar) {
                nFSMW_CarAppearance.m_lightAngle = ((((this.car_rot >> 5) * 256) / 360) * 256 * 256) & 16777215;
                if (!nFSMW_CarAppearance.render(this.trans, null, true, true, false)) {
                    menu_refreshCar(this.menu_car);
                }
            }
            if (this.menu_reflectionMesh != null) {
                Texture2D texture = this.menu_reflectionMesh.getAppearance(0).getTexture(0);
                if (texture != null) {
                    texture.setOrientation((-this.car_rot) >> 5, 0.0f, 0.0f, 1.0f);
                }
                this.scene_g3d.render(this.menu_reflectionMesh, this.trans);
            }
            this.scene_g3d.releaseTarget();
            if (!this.menu_refreshCar || this.menu_carUpdateTime >= this.timeInMenu) {
                return;
            }
            asset_DrawImage(2, (this.system_nCanvasWidth >> 1) - 8, (this.system_nCanvasHeight >> 1) - 12);
            this.menu_hourGlass = true;
        } catch (Throwable th) {
            this.scene_g3d.releaseTarget();
            throw th;
        }
    }

    void menu_DrawMenuBG(int i) {
        menu_camerCarAngle = 7;
        if (this.menuCurrent.m_backgroundStyle == 3) {
            system_SetClip(0, 0, this.system_nCanvasWidth, i);
            system_FillRect(0, 0, this.system_nCanvasWidth, i, 1777431);
            asset_DrawImage(this.g_tracks[this.menuTrackSelect.m_selected].m_previewImg, this.system_nCanvasWidth - 120, 50);
            return;
        }
        if (this.menuCurrent.m_backgroundStyle == 2 || this.menuCurrent.m_backgroundStyle == 1) {
            system_FillRect(0, 0, this.system_nCanvasWidth, 60, 0);
            system_FillRect(0, i - 17, this.system_nCanvasWidth, 32, 0);
            if (this.menuCurrent.m_backgroundStyle == 2) {
                if (this.menuCurrent == this.menuCarRimsSelect) {
                    this.car_rot = 2880;
                    menu_camerCarAngle = 7;
                } else if (this.menuCurrent == this.menuCarFrontBmprsSelect) {
                    this.car_rot = 6560;
                    menu_camerCarAngle = 13;
                } else if (this.menuCurrent == this.menuCarRearBmprsSelect) {
                    this.car_rot = 800;
                    menu_camerCarAngle = 12;
                } else if (this.menuCurrent == this.menuCarSpoilerSelect) {
                    this.car_rot = 960;
                    menu_camerCarAngle = 19;
                } else {
                    menu_camerCarAngle = 17;
                }
                this.car_rot += this.car_rot_offset << 5;
            } else if (this.menuCurrent.m_backgroundStyle == 1 && this.menuCurrent == this.menuCarPaintLayout) {
                menu_camerCarAngle = 16;
            }
            menu_DrawCar();
            return;
        }
        system_FillRect(0, 0, this.system_nCanvasWidth, 60, 0);
        system_FillRect(0, i - 17, this.system_nCanvasWidth, 32, 0);
        menu_DrawCar();
        if ((this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type & 1024) != 0) {
            int i2 = this.system_nCanvasWidth >> 1;
            int i3 = i2 - 108;
            int i4 = i - 135;
            for (int i5 = 0; i5 < 12; i5++) {
                asset_DrawImage(916, (i5 * 18) + i3, i4);
            }
            this.font_text.SetColor(16777215);
            this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[11]).append(" : ").append(this.system_nVolume).toString(), 0, new StringBuffer().append(this.g_Text[11]).append(" : ").append(this.system_nVolume).toString().length(), i2, i4 + 5, 1);
            if (this.system_nVolume < 5 && ((this.scene_timer >> 8) & 1) == 1) {
                game_DrawUpIcon(i2 - 99, i4 + 11);
            }
            if (this.system_nVolume <= 0 || ((this.scene_timer >> 8) & 1) != 1) {
                return;
            }
            game_DrawDownIcon(i2 + 99, i4 + 8);
            return;
        }
        if (this.menuCurrent.m_backgroundStyle != 6) {
            if (this.menuCurrent.m_backgroundStyle == 4) {
                system_FillRect(0, 0, this.system_nCanvasWidth, i, 0);
                this.font_text.SetColor(0, 0, 0);
                try {
                    if (!this.menu_bMissionLoaded) {
                        asset_LoadImage(720, false);
                        this.menu_bMissionLoaded = true;
                    }
                    asset_DrawImage(720, 0, 0);
                } catch (Error e) {
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 940, e.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 940, e2.toString());
                }
                NFSMW_Mission nFSMW_Mission = this.g_missions[this.menuCurrent.m_items[this.menuCurrent.m_selected].m_cmd];
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[19]).append(this.g_Text[this.g_missionTypeNames[nFSMW_Mission.m_raceType]]).toString(), 0, new StringBuffer().append(this.g_Text[19]).append(this.g_Text[this.g_missionTypeNames[nFSMW_Mission.m_raceType]]).toString().length(), 18, 1, 0);
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[21]).append(this.g_Text[this.g_worldsPretty[this.g_trackPaths[nFSMW_Mission.m_trackPath].m_nWorld]]).toString(), 0, new StringBuffer().append(this.g_Text[21]).append(this.g_Text[this.g_worldsPretty[this.g_trackPaths[nFSMW_Mission.m_trackPath].m_nWorld]]).toString().length(), 18, 18, 0);
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[18]).append(nFSMW_Mission.m_repWon).toString(), 0, new StringBuffer().append(this.g_Text[18]).append(nFSMW_Mission.m_repWon).toString().length(), 18, 35, 0);
                int i6 = 52;
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[17]).append(nFSMW_Mission.m_cashWon).toString(), 0, new StringBuffer().append(this.g_Text[17]).append(nFSMW_Mission.m_cashWon).toString().length(), 18, 52, 0);
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[20]).append(nFSMW_Mission.m_nLaps).toString(), 0, new StringBuffer().append(this.g_Text[20]).append(nFSMW_Mission.m_nLaps).toString().length(), 143, 52, 0);
                if (nFSMW_Mission.m_nTimeLimit > 0) {
                    int i7 = (nFSMW_Mission.m_nTimeLimit / 1000) % 60;
                    int i8 = nFSMW_Mission.m_nTimeLimit / 60000;
                    String string = new StringBuffer().append(i7 < 10 ? "0" : "").append(i7).toString();
                    String string2 = new StringBuffer().append(i8 < 10 ? "0" : "").append(i8).toString();
                    i6 = 72;
                    this.font_text.DrawSubstring(this.g_Text[22], 0, this.g_Text[22].length(), 18, 72, 0);
                    this.font_text.DrawSubstring(new StringBuffer().append("").append(string2).append(":").append(string).toString(), 0, new StringBuffer().append("").append(string2).append(":").append(string).toString().length(), 167, 72, 0);
                }
                if (nFSMW_Mission.m_raceType == 3 && nFSMW_Mission.m_nreqScore > 0) {
                    i6 += 17;
                    this.font_text.DrawSubstring(this.g_Text[23], 0, this.g_Text[23].length(), 18, i6, 0);
                    this.font_text.DrawSubstring(new StringBuffer().append("").append(nFSMW_Mission.m_nreqScore).toString(), 0, new StringBuffer().append("").append(nFSMW_Mission.m_nreqScore).toString().length(), 167, i6, 0);
                }
                int i9 = i6 + 20;
                if (this.g_player.getTotalRep() < this.g_missions[nFSMW_Mission.m_cmd].m_reqRep) {
                    system_FillRect(0, (this.system_nCanvasHeight >> 2) - 1, this.system_nCanvasWidth, 19, 0);
                    this.font_ingame.DrawSubstring(this.g_Text[13], 0, this.g_Text[13].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                    return;
                }
                if (this.g_missions[nFSMW_Mission.m_cmd].m_reqMission == -1) {
                    this.font_text.DrawSubstringWrapped(this.g_Text[this.scriptScenes[nFSMW_Mission.m_script][0]], 0, this.g_Text[this.scriptScenes[nFSMW_Mission.m_script][0]].length(), this.system_nCanvasWidth - 18, 18, i9, 0, 0);
                    if (this.g_player.m_missionStatus[nFSMW_Mission.m_cmd] == 1) {
                        system_FillRect(0, (this.system_nCanvasHeight >> 2) - 1, this.system_nCanvasWidth, 19, 0);
                        this.font_ingame.DrawSubstring(this.g_Text[25], 0, this.g_Text[25].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                        return;
                    }
                    return;
                }
                if (this.g_player.m_missionStatus[this.g_missions[nFSMW_Mission.m_cmd].m_reqMission] == 0) {
                    system_FillRect(0, (this.system_nCanvasHeight >> 2) - 1, this.system_nCanvasWidth, 19, 0);
                    this.font_ingame.DrawSubstring(this.g_Text[13], 0, this.g_Text[13].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                    return;
                }
                this.font_text.DrawSubstringWrapped(this.g_Text[this.scriptScenes[nFSMW_Mission.m_script][0]], 0, this.g_Text[this.scriptScenes[nFSMW_Mission.m_script][0]].length(), this.system_nCanvasWidth - 18, 18, i9, 0, 0);
                if (this.g_player.m_missionStatus[nFSMW_Mission.m_cmd] == 1) {
                    system_FillRect(0, (this.system_nCanvasHeight >> 2) - 1, this.system_nCanvasWidth, 19, 0);
                    this.font_ingame.DrawSubstring(this.g_Text[25], 0, this.g_Text[25].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                    return;
                }
                return;
            }
            return;
        }
        if (this.menuCurrent.m_selected != 0) {
            try {
                if (!this.menu_bBlacklistLoaded) {
                    asset_LoadImage(this.g_MenuImages[2], false);
                    asset_LoadImage(778, false);
                    this.menu_bBlacklistLoaded = true;
                }
                system_FillRect(0, 0, this.system_nCanvasWidth, i, 16777215);
                asset_DrawImage(this.g_MenuImages[2], 0, 0);
                for (int i10 = 1; i10 < 6 && this.g_player.m_missionStatus[i10] == 1; i10++) {
                    asset_DrawImage(778, 14, 215 - (i10 * 29));
                }
                return;
            } catch (Error e3) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 919, e3.toString());
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 919, e4.toString());
                return;
            }
        }
        system_FillRect(0, 0, this.system_nCanvasWidth, i, 0);
        this.font_text.SetColor(0, 0, 0);
        try {
            if (!this.menu_bMissionLoaded) {
                asset_LoadImage(720, false);
                this.menu_bMissionLoaded = true;
            }
            asset_DrawImage(720, 0, 0);
        } catch (Error e5) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 831, e5.toString());
        } catch (Exception e6) {
            e6.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 831, e6.toString());
        }
        this.font_text.DrawSubstring(this.g_Text[27], 0, this.g_Text[27].length(), 18, 7, 0);
        this.font_text.DrawSubstring(this.g_Text[17], 0, this.g_Text[17].length(), 18, 24, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("$").append(this.g_player.m_cash).toString(), 0, new StringBuffer().append("$").append(this.g_player.m_cash).toString().length(), 208, 24, 2);
        this.font_text.DrawSubstring(this.g_Text[18], 0, this.g_Text[18].length(), 18, 41, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_player.getTotalRep()).toString(), 0, new StringBuffer().append("").append(this.g_player.getTotalRep()).toString().length(), 208, 41, 2);
        int i11 = 0;
        int i12 = 0;
        while (i12 < 36) {
            int i13 = this.g_player.m_missionStatus[i12] != 0 ? i11 + 1 : i11;
            i12++;
            i11 = i13;
        }
        this.font_text.DrawSubstring(this.g_Text[24], 0, this.g_Text[24].length(), 18, 63, 0);
        this.font_text.DrawSubstring(this.g_Text[25], 0, this.g_Text[25].length(), 18, 80, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("  ").append(i11).append("/36").toString(), 0, new StringBuffer().append("  ").append(i11).append("/36").toString().length(), 208, 80, 2);
        this.font_text.DrawSubstring(this.g_Text[26], 0, this.g_Text[26].length(), 18, 97, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("  ").append((i11 * 100) / 36).append("%").toString(), 0, new StringBuffer().append("  ").append((i11 * 100) / 36).append("%").toString().length(), 208, 97, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < 6; i15++) {
            if (this.g_player.m_missionStatus[i15] == 1) {
                i14++;
            }
        }
        int i16 = i14 == 0 ? 1 : i14;
        this.font_text.DrawSubstring(this.g_Text[28], 0, this.g_Text[28].length(), 18, 119, 0);
        this.font_text.DrawSubstring(this.g_Text[33], 0, this.g_Text[33].length(), 18, 136, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("  ").append(i16).append("/").append(6).toString(), 0, new StringBuffer().append("  ").append(i16).append("/").append(6).toString().length(), 208, 136, 2);
        this.font_text.DrawSubstring(this.g_Text[26], 0, this.g_Text[26].length(), 18, 153, 0);
        this.font_text.DrawSubstring(new StringBuffer().append("  ").append((i16 * 100) / 6).append("%").toString(), 0, new StringBuffer().append("  ").append((i16 * 100) / 6).append("%").toString().length(), 208, 153, 2);
    }

    void menu_End() {
        this.menuCurrent = null;
        asset_FreeImage(772);
        asset_FreeImage(768);
        asset_FreeImage(764);
        asset_FreeImage(676);
        asset_FreeImage(672);
        asset_FreeImage(684);
        asset_FreeImage(680);
        asset_FreeImage(958);
        asset_FreeImage(708);
        asset_FreeImage(704);
        asset_FreeImage(700);
        asset_FreeImage(696);
        asset_FreeImage(692);
        asset_FreeImage(688);
        asset_FreeImage(this.g_MenuImages[1]);
        asset_FreeImage(668);
        asset_FreeImage(714);
        asset_FreeImage(916);
        this.menuRoot.freeIcons(true);
        this.menu_reflectionMesh = null;
        scene_FreeTextures();
        scene_FreeMintMesh("menu_background");
        scene_FreeMintMesh("track_01");
        scene_FreeMintMesh("track_02");
        this.menu_Group = null;
        this.menu_Group = new Group();
        this.system_SoftkeyFont = this.system_SoftkeyFontBackup;
        game_FreeBuffer();
        if (this.system_bSoundOn) {
        }
        this.scene_timerUpdate = true;
        this.menu_startupStage = 3;
        System.gc();
    }

    void menu_FreeDoc() {
        this.menu_docArray = null;
        this.menu_docLineAttr = null;
        this.menu_scrolling = false;
        this.menu_IsPaused = false;
        this.menu_show_mode = (byte) 0;
        if (this.menu_nDocument != -1) {
            asset_FreeData(this.menu_nDocument);
        }
        this.itemColor = 16776960;
        this.selectedColor = 16777215;
        this.menu_nDocument = -1;
    }

    void menu_Init() throws Exception {
        this.menu_IsPaused = false;
        this.menu_show_mode = (byte) 0;
        this.background.setColor(2236964);
        this.menu_xOffset = 3;
        this.menu_scrolling = false;
        this.menu_nDocument = -1;
        this.menu_noRender = false;
        this.menu_scrollSpeed = 3072;
        this.menu_level = (short) -1;
        game_CreateBuffer();
        m_CurrentGraphics = this.game_gMapBuffer;
        this.menu_yCanvasOffset = 0;
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        this.system_bReRenderSoftKeys = false;
        menu_refreshCar(this.g_player.m_currentCar);
        this.menu_car = this.g_player.m_currentCar;
        this.g_cars[this.menu_car].setParts(this.g_player.m_carSetups[this.menu_car]);
    }

    void menu_InitDoc(int i, boolean z, boolean z2) throws Exception {
        this.menu_xOffset = 3;
        system_StartDelay();
        this.itemColor = 16777215;
        this.selectedColor = 16776960;
        menu_LoadDoc(i);
        this.menu_scrolling = z;
        this.menu_IsPaused = false;
        this.menu_show_mode = (byte) 1;
        this.menu_yOffset = 0;
        this.menu_yScrollOffset = 0;
        this.game_gMapBuffer.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        this.game_gMapBuffer.setColor(0);
        this.game_gMapBuffer.fillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        if (z) {
            this.menu_yDocStart = (-this.menu_canvasHeight) / this.menu_rowHeight;
            this.menu_yScrollOffset = -(this.menu_rowHeight << 8);
        } else {
            menu_ShowDocPage(0, 0, this.menu_canvasHeight / this.menu_rowHeight);
        }
        if (z2) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void menu_KeyPressed(int i, int i2) throws Exception {
        this.menu_nKeyFlags = i;
        this.timeLastKeyPress = this.timeInMenu;
        this.menu_noRender = true;
        if (this.menu_startupStage == 1) {
            if (i == -6 || i2 == 8 || i == 53) {
                this.menu_startupStage = 2;
                menu_FreeDoc();
                asset_FreeImage(this.g_WarningImgs[this.g_nLanguage]);
                menu_Start();
                return;
            }
            if (this.menu_scrolling) {
                return;
            }
            if (i2 == 1 || i == 50) {
                this.game_nKeyPressed = (byte) 1;
                return;
            } else if (i2 == 6 || i == 56) {
                this.game_nKeyPressed = (byte) 2;
                return;
            } else {
                this.game_nKeyPressed = (byte) 0;
                this.game_nTimeKeyHeld = (short) 0;
                return;
            }
        }
        if (this.menu_startupStage == 2) {
            if (this.menu_sceneLoadStage > 2) {
                asset_FreeImage(this.g_MenuImages[0]);
                this.menu_startupStage = 3;
                menu_Start();
                return;
            }
            return;
        }
        if (this.menu_startupStage == 0 || this.menu_startupStage == 3) {
            return;
        }
        if (this.menu_show_mode == 10) {
            if (i == -6 || i == -7 || i2 == 8 || i == 53) {
                this.menu_show_mode = this.prevShowMode;
                if ((i == -6 || i2 == 8 || i == 53) && this.currentConfirm == 1) {
                    this.menu_show_mode = (byte) 0;
                    menu_OnConfirmed();
                }
            }
            if ((i2 == 2 || i == 52 || i2 == 1 || i == 50) && this.currentConfirm < 1) {
                this.currentConfirm++;
            }
            if ((i2 == 5 || i == 54 || i2 == 6 || i == 56) && this.currentConfirm > 0) {
                this.currentConfirm--;
            }
        } else if (this.menu_show_mode == 11) {
            if (i == -6 || i == -7 || i2 == 8 || i == 53) {
                this.menu_show_mode = this.prevShowMode;
                if (this.menu_IsPaused) {
                    this.menu_IsPaused = false;
                    asset_ChangeVolume(this.system_nVolume);
                    game_StartMusic(false);
                }
            }
        } else if (this.menu_show_mode == 1) {
            if (!this.menu_scrolling) {
                if (i2 == 1 || i == 50) {
                    this.game_nKeyPressed = (byte) 1;
                } else if (i2 == 6 || i == 56) {
                    this.game_nKeyPressed = (byte) 2;
                } else {
                    this.game_nKeyPressed = (byte) 0;
                    this.game_nTimeKeyHeld = (short) 0;
                }
            }
            if (i == -7 || i == 589824 || i == 589829) {
                menu_FreeDoc();
                this.scene_nCurrentScene = 4096;
            }
        } else {
            if (i2 == 2 || i == 52) {
                menu_MenuPrev();
                this.game_nKeyPressed = (byte) 3;
                this.game_nTimeKeyHeld = (short) 0;
            } else if (i2 == 5 || i == 54) {
                menu_MenuNext();
                this.game_nKeyPressed = (byte) 4;
                this.game_nTimeKeyHeld = (short) 0;
            }
            if (i2 == 1 || i == 50) {
                menu_MenuInc();
                this.game_nKeyPressed = (byte) 1;
                this.game_nTimeKeyHeld = (short) 0;
            }
            if (i2 == 6 || i == 56) {
                menu_MenuDec();
                this.game_nKeyPressed = (byte) 2;
                this.game_nTimeKeyHeld = (short) 0;
            }
            if (i == -6 || i2 == 8 || i == 53) {
                menu_OnExecuteItem();
            }
            if (i == -7) {
                if (this.menu_level == 0) {
                    this.system_bExit = true;
                } else {
                    menu_OnBack();
                }
            }
            if (!this.system_bDemoMode) {
                if (this.cheatPosition == this.cheatCode.length) {
                    switch (i) {
                        case 48:
                            this.g_player.m_cash += 100000;
                            this.g_player.m_rep += 100000;
                            break;
                        case 49:
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 50:
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 51:
                            this.g_player.m_rep += this.g_missions[2].m_reqRep;
                            this.g_player.m_missionStatus[1] = 1;
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 52:
                            this.g_player.m_rep += this.g_missions[3].m_reqRep;
                            this.g_player.m_missionStatus[2] = 1;
                            this.g_player.m_rep += this.g_missions[2].m_reqRep;
                            this.g_player.m_missionStatus[1] = 1;
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 53:
                            this.g_player.m_rep += this.g_missions[4].m_reqRep;
                            this.g_player.m_missionStatus[3] = 1;
                            this.g_player.m_rep += this.g_missions[3].m_reqRep;
                            this.g_player.m_missionStatus[2] = 1;
                            this.g_player.m_rep += this.g_missions[2].m_reqRep;
                            this.g_player.m_missionStatus[1] = 1;
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 54:
                            this.g_player.m_rep += this.g_missions[5].m_reqRep;
                            this.g_player.m_missionStatus[4] = 1;
                            this.g_player.m_rep += this.g_missions[4].m_reqRep;
                            this.g_player.m_missionStatus[3] = 1;
                            this.g_player.m_rep += this.g_missions[3].m_reqRep;
                            this.g_player.m_missionStatus[2] = 1;
                            this.g_player.m_rep += this.g_missions[2].m_reqRep;
                            this.g_player.m_missionStatus[1] = 1;
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                        case 55:
                            this.g_player.m_missionStatus[5] = 1;
                            this.g_player.m_rep += this.g_missions[5].m_reqRep;
                            this.g_player.m_missionStatus[4] = 1;
                            this.g_player.m_rep += this.g_missions[4].m_reqRep;
                            this.g_player.m_missionStatus[3] = 1;
                            this.g_player.m_rep += this.g_missions[3].m_reqRep;
                            this.g_player.m_missionStatus[2] = 1;
                            this.g_player.m_rep += this.g_missions[2].m_reqRep;
                            this.g_player.m_missionStatus[1] = 1;
                            this.g_player.m_rep += this.g_missions[1].m_reqRep;
                            this.g_player.m_missionStatus[0] = 1;
                            this.g_player.m_rep += this.g_missions[0].m_reqRep;
                            break;
                    }
                    this.cheatPosition = 0;
                } else if (i == this.cheatCode[this.cheatPosition]) {
                    this.cheatPosition++;
                } else {
                    this.cheatPosition = 0;
                }
            }
        }
        this.menu_noRender = false;
    }

    void menu_KeyReleased(int i, int i2) {
        this.menu_nKeyFlags = 0;
        this.game_nKeyPressed = (byte) 0;
        this.game_nTimeKeyHeld = (short) 0;
    }

    void menu_LoadDoc(int i) throws Exception {
        this.menu_nDocument = i;
        asset_LoadData(i);
        this.docID = (short) ((this.asset_DataArray[((short) ((this.asset_DataArray[i + 1] & 65535) >> 0)) + 0] & (-65536)) >> 16);
        this.docStart = (this.asset_DataArray[i + 0] & (-1)) >> 0;
        this.docEnd = this.docStart + ((short) ((this.asset_DataArray[i + 1] & (-65536)) >> 16));
        this.menu_docLineCount = menu_PreProcessDocPage(true);
        this.menu_docArray = new String[this.menu_docLineCount];
        this.menu_docLineAttr = new int[this.menu_docLineCount];
        menu_PreProcessDocPage(false);
        this.menu_yDocStart = 0;
    }

    void menu_LoadMainMenu() throws Exception {
        menu_Init();
        this.system_SoftkeyFontBackup = this.system_SoftkeyFont;
        this.system_SoftkeyFont = this.font_text;
        this.system_softkeyBackground = 160;
        this.system_softkeyColor = 16777215;
        if (!this.menu_intromusicloaded) {
            this.menu_intromusicloaded = true;
        }
        asset_LoadImage(740, false);
        asset_LoadImage(736, false);
        asset_LoadImage(732, false);
        asset_LoadImage(772, false);
        asset_LoadImage(768, false);
        asset_LoadImage(764, false);
        asset_LoadImage(676, false);
        asset_LoadImage(672, false);
        asset_LoadImage(684, false);
        asset_LoadImage(680, false);
        asset_LoadImage(958, false);
        asset_LoadImage(708, false);
        asset_LoadImage(704, false);
        asset_LoadImage(700, false);
        asset_LoadImage(696, false);
        asset_LoadImage(692, false);
        asset_LoadImage(688, false);
        asset_LoadImage(this.g_MenuImages[1], false);
        asset_LoadImage(668, false);
        asset_LoadImage(714, false);
        asset_LoadImage(916, false);
        if (this.menu_Group.getChildCount() == 0) {
            if (scene_FindMintMesh("menu_background") == null) {
                while (scene_OpenModel("menu_background", 3, false)) {
                }
            }
            for (int i = 0; i < this.trackMeshs.length; i++) {
                if (this.trackMeshs[i] != null) {
                    this.trackMeshs[i].getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                    this.menu_Group.addChild(this.trackMeshs[i]);
                    this.trackMeshs[i] = null;
                }
            }
        }
        if (this.g_race.m_bMission) {
            menu_setCurrentMenu(this.menuMissionTypes);
        } else {
            menu_setCurrentMenu(this.menuRoot);
        }
        menu_Render();
        transition_Start();
        this.game_nKeyPressed = (byte) 0;
        this.game_nTimeKeyHeld = (short) 0;
        this.goingToNextMenu = 0;
        this.lastMenuDirection = 0;
        this.menu_hourGlass = false;
        this.menu_startupStage = 4;
        this.menu_car = this.g_player.m_currentCar;
        this.g_cars[this.menu_car].setParts(this.g_player.m_carSetups[this.menu_car]);
        if (this.menu_SplashPause) {
            asset_ChangeVolume(this.system_nVolume);
            game_StartMusic(true);
            this.menu_SplashPause = false;
        }
    }

    void menu_MenuDec() throws Exception {
        if ((this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type & 1024) != 0) {
            if (this.system_nVolume > 0) {
                this.system_nVolume--;
                asset_ChangeVolume(this.system_nVolume);
            }
            if (this.system_nVolume == 0) {
                game_StopMusic();
            }
            system_SaveAllConfigs();
        }
    }

    void menu_MenuInc() throws Exception {
        if ((this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type & 1024) != 0) {
            int i = this.system_nVolume;
            if (this.system_nVolume < 5) {
                this.system_nVolume++;
                this.system_bSoundOn = true;
                asset_ChangeVolume(this.system_nVolume);
            }
            if (i == 0 && this.system_nVolume > 0) {
                game_StartMusic(false);
            }
            system_SaveAllConfigs();
        }
    }

    void menu_MenuNext() {
        if (this.menuCurrent.m_selected < this.menuCurrent.m_itemCount - 1) {
            this.goingToNextMenu = 1;
            this.lastMenuDirection = 1;
            this.menuTimer = 0;
        }
    }

    void menu_MenuPrev() {
        if (this.menuCurrent.m_selected > 0) {
            this.goingToNextMenu = -1;
            this.lastMenuDirection = -1;
            this.menuTimer = 0;
        }
    }

    void menu_OnBack() throws Exception {
        if (this.menu_bBlacklistLoaded) {
            asset_FreeImage(this.g_MenuImages[2]);
            asset_FreeImage(778);
            this.menu_bBlacklistLoaded = false;
        }
        if (this.menu_bMissionLoaded) {
            asset_FreeImage(720);
            this.menu_bMissionLoaded = false;
        }
        if (this.menuCurrent.m_parent == null) {
            this.menuRoot.m_selected = 5;
            menu_OnExecuteItem();
            return;
        }
        boolean z = this.menuCurrent == this.menuCarPaint;
        if (this.menuCurrent == this.menuCarSelect || this.menuCurrent == this.menuQRCarSelect) {
            this.g_player.m_currentCar = this.g_player.m_equipedCar;
            if (this.menuCurrent == this.menuQRCarSelect) {
                this.g_cars[this.g_player.m_equipedCar].setParts(this.g_player.m_carSetups[this.g_player.m_equipedCar]);
            }
            menu_refreshCar(this.g_player.m_currentCar);
        }
        menu_setCurrentMenu(this.menuCurrent.m_parent);
        this.car_rot_offset = 0;
        if ((this.menuCurrent == this.menuCustomizeVis && !z) || this.menuCurrent == this.menuCarPaint) {
            menu_refreshCar(this.g_player.m_currentCar);
            this.menu_show_mode = (byte) 0;
        }
        this.menu_carUpdateTime = this.timeInMenu + 2000;
    }

    void menu_OnConfirmed() throws Exception {
        NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
        int i = nFSMW_MenuItem.m_type;
        if ((i & 32) != 0) {
            NFSMW_Profile nFSMW_Profile = this.g_player;
            NFSMW_Profile nFSMW_Profile2 = this.g_player;
            byte b = (byte) nFSMW_MenuItem.m_cmd;
            nFSMW_Profile2.m_equipedCar = b;
            nFSMW_Profile.m_currentCar = b;
            this.g_player.saveRecords();
            menu_OnBack();
            return;
        }
        if ((536866816 & i) != 0) {
            int iMenuCmdToPart = menuCmdToPart(i);
            this.g_cars[this.g_player.m_currentCar].setPart(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd);
            this.g_player.m_carSetups[this.g_player.m_currentCar][iMenuCmdToPart] = (byte) nFSMW_MenuItem.m_cmd;
            this.g_player.m_carRep = this.g_cars[this.g_player.m_currentCar].m_modStats[3];
            if (this.g_player.m_partStatus[iMenuCmdToPart][nFSMW_MenuItem.m_cmd] != 1) {
                this.g_player.m_cash -= this.g_carParts[iMenuCmdToPart][nFSMW_MenuItem.m_cmd].m_cost;
                this.g_player.m_partStatus[iMenuCmdToPart][nFSMW_MenuItem.m_cmd] = 1;
            }
            this.g_player.saveRecords();
            menu_OnBack();
            return;
        }
        if ((i & 4) == 0) {
            if ((i & 2048) != 0) {
                clearSavedLang();
                scene_Transition(16384);
                return;
            } else {
                if ((i & 1) != 0) {
                    this.system_bExit = true;
                    return;
                }
                return;
            }
        }
        if (this.menuCurrent == this.menuProfile) {
            this.g_player.saveRecords();
            this.g_player.changeCurrentProfile((byte) nFSMW_MenuItem.m_cmd);
            this.g_player.loadRecords();
        } else {
            this.g_player.clearProfile();
            this.g_player.saveRecords();
        }
        this.g_player.m_currentCar = this.g_player.m_equipedCar;
        this.g_cars[this.g_player.m_currentCar].setParts(this.g_player.m_carSetups[this.g_player.m_currentCar]);
        menu_refreshCar(this.g_player.m_equipedCar);
        menu_OnBack();
    }

    void menu_OnExecuteItem() throws Exception {
        int i;
        int i2;
        int i3 = 0;
        NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
        int i4 = nFSMW_MenuItem.m_type;
        if ((i4 & 1) != 0) {
            menu_ShowConfirmDlg(68);
        }
        if ((i4 & 4) != 0) {
            if (this.menuCurrent == this.menuProfile) {
                menu_ShowConfirmDlg(58);
            } else {
                menu_ShowConfirmDlg(59);
            }
        }
        if ((i4 & 2048) != 0) {
            menu_ShowConfirmDlg(57);
        }
        if ((i4 & 256) != 0) {
            try {
                switch (nFSMW_MenuItem.m_cmd) {
                    case 0:
                        menu_InitDoc(this.g_docs[2], false, true);
                        break;
                    case 1:
                        menu_InitDoc(this.g_docs[3], false, true);
                        break;
                    case 2:
                        menu_InitDoc(this.g_docs[4], false, true);
                        break;
                }
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 127, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 127, e2.toString());
            }
        }
        if ((i4 & 512) != 0) {
            try {
                menu_InitDoc(this.g_docs[1], false, true);
            } catch (Error e3) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 136, e3.toString());
            } catch (Exception e4) {
                e4.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 136, e4.toString());
            }
        }
        if ((i4 & 32) != 0) {
            if (this.menuRoot.m_selected == 0) {
                if (this.g_player.m_missionStatus[nFSMW_MenuItem.m_cmd] == 1 || this.g_player.m_equipedCar == nFSMW_MenuItem.m_cmd) {
                    this.menuTrackSelect.m_parent = this.menuCurrent;
                    menu_setCurrentMenu(this.menuTrackSelect);
                    if (this.system_bDemoMode) {
                        this.menuCurrent.m_selected = 3;
                    }
                    this.g_player.m_currentCar = (byte) nFSMW_MenuItem.m_cmd;
                    menu_refreshCar(nFSMW_MenuItem.m_cmd);
                    menu_OnSelectionChange();
                } else {
                    menu_ShowMessageDlg(55);
                }
            } else if (this.menuRoot.m_selected == 1) {
                if (this.g_player.m_equipedCar == nFSMW_MenuItem.m_cmd) {
                    menu_ShowMessageDlg(71);
                } else if (this.g_player.m_missionStatus[nFSMW_MenuItem.m_cmd] == 1) {
                    menu_ShowConfirmDlg(54);
                } else {
                    menu_ShowMessageDlg(55);
                }
            }
        }
        if ((i4 & 64) == 0) {
            i = i4;
        } else if (this.g_player.getTotalRep() < this.g_missions[nFSMW_MenuItem.m_cmd].m_reqRep) {
            menu_ShowMessageDlg(60);
            i = 0;
        } else if (this.g_player.m_missionStatus[nFSMW_MenuItem.m_cmd] == 1 && this.menuCurrent == this.menuMissionChallenge) {
            menu_ShowMessageDlg(70);
            i = 0;
        } else if (this.g_missions[nFSMW_MenuItem.m_cmd].m_reqMission == -1 || this.g_player.m_missionStatus[this.g_missions[nFSMW_MenuItem.m_cmd].m_reqMission] != 0) {
            NFSMW_Mission nFSMW_Mission = this.g_missions[nFSMW_MenuItem.m_cmd];
            this.g_race.m_type = nFSMW_Mission.m_raceType;
            this.g_race.m_laps = nFSMW_Mission.m_nLaps;
            this.g_race.m_trackPath = nFSMW_Mission.m_trackPath;
            this.g_race.m_nTimeLimit = nFSMW_Mission.m_nTimeLimit;
            this.g_race.m_nSpeedLimit = nFSMW_Mission.m_nreqChkpSpeed;
            this.g_race.m_nFastestLapTime = 0;
            this.g_race.m_nLastLapTime = 0;
            this.g_race.m_quickraceID = 0;
            this.g_race.m_numRacers = this.raceSetups[nFSMW_Mission.m_raceSetup][1];
            this.g_race.m_numCops = this.raceSetups[nFSMW_Mission.m_raceSetup][2];
            this.g_race.m_numTraffic = this.raceSetups[nFSMW_Mission.m_raceSetup][3];
            this.g_race.m_bMission = true;
            this.g_race.m_nMissionID = nFSMW_MenuItem.m_cmd;
            this.g_race.m_difficulty = (this.g_race.m_nMissionID % 6) + 1;
            if (this.g_race.m_nMissionID < 6) {
                this.g_race.m_numRacers = 2;
            }
            i = i4;
        } else {
            menu_ShowMessageDlg(64);
            i = 0;
        }
        if ((i & 128) != 0) {
            if (this.system_bDemoMode && nFSMW_MenuItem.m_cmd != 3) {
                menu_ShowMessageDlg(69);
                i = 0;
            }
            this.g_race.m_type = 0;
            this.g_race.m_laps = 3;
            this.g_race.m_numCops = 2;
            this.g_race.m_numRacers = 3;
            this.g_race.m_numTraffic = 1;
            this.g_race.m_difficulty = 3;
            this.g_race.m_nSpeedLimit = 50;
            this.g_race.m_nFastestLapTime = 0;
            this.g_race.m_nLastLapTime = 0;
            this.g_race.m_quickraceID = nFSMW_MenuItem.m_cmd;
            this.g_race.m_trackPath = this.g_tracks[nFSMW_MenuItem.m_cmd].m_trackPath;
            this.g_race.m_bMission = false;
            this.g_race.m_nMissionID = -1;
        }
        if ((536866816 & i) != 0) {
            int iMenuCmdToPart = menuCmdToPart(i);
            NFSMW_CarPart nFSMW_CarPart = this.g_carParts[iMenuCmdToPart][nFSMW_MenuItem.m_cmd];
            boolean z = (iMenuCmdToPart == 2 || iMenuCmdToPart == 3) && this.g_cars[this.g_player.m_currentCar].m_parts[0] == 0;
            if (this.g_cars[this.g_player.m_currentCar].m_cmd == 5 && (iMenuCmdToPart == 9 || iMenuCmdToPart == 8 || iMenuCmdToPart == 6)) {
                z = true;
            }
            if (!z) {
                if (this.g_cars[this.g_player.m_currentCar].isPartInstalled(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd)) {
                    menu_ShowMessageDlg(66);
                } else if (iMenuCmdToPart >= 10 && this.g_cars[this.g_player.m_currentCar].m_parts[iMenuCmdToPart] > ((byte) nFSMW_MenuItem.m_cmd)) {
                    menu_ShowMessageDlg(67);
                } else if (this.g_player.m_partStatus[iMenuCmdToPart][nFSMW_MenuItem.m_cmd] == 1) {
                    menu_ShowConfirmDlg(52);
                } else if (this.g_player.m_cash >= nFSMW_CarPart.m_cost) {
                    menu_ShowConfirmDlg(53);
                } else {
                    menu_ShowMessageDlg(62);
                }
            }
            i2 = 0;
        } else {
            i2 = i;
        }
        if ((i2 & 8) != 0) {
            for (int i5 = 0; i5 < this.g_tracks.length; i5++) {
                this.g_tracks[i5].freeTrackPreview();
            }
            this.players[0].m_ca = this.g_cars[this.g_player.m_currentCar];
            scene_Transition(8192);
        }
        if ((i2 & 16) != 0) {
            game_Return();
        }
        if ((i2 & 2) != 0) {
            if (nFSMW_MenuItem.m_subMenu == null) {
                throw new Exception("***** omg submenu NOT VALID");
            }
            nFSMW_MenuItem.m_subMenu.m_parent = this.menuCurrent;
            menu_setCurrentMenu(nFSMW_MenuItem.m_subMenu);
            if (this.menuCurrent == this.menuCarSelect) {
                NFSMW_Menu nFSMW_Menu = this.menuCurrent;
                NFSMW_Profile nFSMW_Profile = this.g_player;
                byte b = this.g_player.m_equipedCar;
                nFSMW_Profile.m_currentCar = b;
                nFSMW_Menu.m_selected = b;
                menu_refreshCar(this.g_player.m_equipedCar);
            } else if (this.menuCurrent == this.menuQRCarSelect) {
                while (i3 < 6) {
                    this.g_cars[i3].setParts(this.g_QRcarSetups[i3]);
                    i3++;
                }
                this.menuCurrent.m_selected = this.g_player.m_currentCar;
                menu_refreshCar(this.g_player.m_currentCar);
            } else if (this.menuCurrent == this.menuCarPaintLayout) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[0];
            } else if (this.menuCurrent == this.menuCarVinylSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[5];
            } else if (this.menuCurrent == this.menuCarSpoilerSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[6];
            } else if (this.menuCurrent == this.menuCarRimsSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[7];
            } else if (this.menuCurrent == this.menuCarFrontBmprsSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[8];
            } else if (this.menuCurrent == this.menuCarRearBmprsSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[9];
            } else if (this.menuCurrent == this.menuCarEngineSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[10];
            } else if (this.menuCurrent == this.menuCarTurboSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[11];
            } else if (this.menuCurrent == this.menuCarNitrousSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[12];
            } else if (this.menuCurrent == this.menuCarTransmissionSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[13];
            } else if (this.menuCurrent == this.menuCarTireSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[14];
            } else if (this.menuCurrent == this.menuCarBrakesSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[15];
            } else if (this.menuCurrent == this.menuCarFuelSelect) {
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[16];
            } else if (this.menuCurrent == this.menuCarPaintSelect1) {
                this.menu_show_mode = (byte) 8;
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[1];
            } else if (this.menuCurrent == this.menuCarPaintSelect2) {
                this.menu_show_mode = (byte) 8;
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[2];
            } else if (this.menuCurrent == this.menuCarPaintSelect3) {
                this.menu_show_mode = (byte) 8;
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[3];
            } else if (this.menuCurrent == this.menuCarWindTintSelect) {
                this.menu_show_mode = (byte) 8;
                this.menuCurrent.m_selected = this.g_cars[this.g_player.m_equipedCar].m_parts[4];
            } else if (this.menuCurrent == this.menuCareer) {
                this.g_player.m_currentCar = this.g_player.m_equipedCar;
                this.g_cars[this.g_player.m_equipedCar].setParts(this.g_player.m_carSetups[this.g_player.m_equipedCar]);
                menu_refreshCar(this.g_player.m_currentCar);
                this.g_player.m_carRep = this.g_cars[this.g_player.m_currentCar].m_modStats[3];
            } else if (this.menuCurrent == this.menuMissionCircuits || this.menuCurrent == this.menuMissionCheckpoints || this.menuCurrent == this.menuMissionKnockout || this.menuCurrent == this.menuMissionSpeedCam || this.menuCurrent == this.menuMissionOutrun || this.menuCurrent == this.menuMissionChallenge) {
                if (this.menuCurrent != this.menuMissionChallenge) {
                    if (this.menuCurrent == this.menuMissionCircuits) {
                        i3 = 6;
                    } else if (this.menuCurrent == this.menuMissionCheckpoints) {
                        i3 = 12;
                    } else if (this.menuCurrent == this.menuMissionKnockout) {
                        i3 = 18;
                    } else if (this.menuCurrent == this.menuMissionSpeedCam) {
                        i3 = 24;
                    } else if (this.menuCurrent == this.menuMissionOutrun) {
                        i3 = 30;
                    }
                }
                for (int i6 = i3; i6 < i3 + 6; i6++) {
                    if (this.g_player.m_missionStatus[i6] == 0) {
                        this.menuCurrent.m_selected = i6 - i3;
                    }
                }
            } else if (this.menuCurrent == this.menuProfile) {
                this.menuCurrent.m_selected = this.g_player.m_profileNum;
            }
            menu_OnSelectionChange();
        }
    }

    void menu_OnSelectionChange() {
        NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
        int i = nFSMW_MenuItem.m_type;
        if (this.menu_bBlacklistLoaded) {
            asset_FreeImage(this.g_MenuImages[2]);
            asset_FreeImage(778);
            this.menu_bBlacklistLoaded = false;
        }
        if (this.menu_bMissionLoaded) {
            asset_FreeImage(720);
            this.menu_bMissionLoaded = false;
        }
        if ((i & 32) != 0) {
            if (this.menuCurrent == this.menuCarSelect) {
                this.g_cars[nFSMW_MenuItem.m_cmd].setParts(this.g_player.m_carSetups[nFSMW_MenuItem.m_cmd]);
            }
            this.g_player.m_currentCar = (byte) nFSMW_MenuItem.m_cmd;
            menu_refreshCar(this.g_player.m_currentCar);
        } else if ((i & 128) != 0) {
            for (int i2 = 0; i2 < this.g_tracks.length; i2++) {
                this.g_tracks[i2].freeTrackPreview();
            }
            this.g_tracks[nFSMW_MenuItem.m_cmd].createTrackPreview();
            this.g_race.m_trackPath = this.g_tracks[nFSMW_MenuItem.m_cmd].m_trackPath;
        } else if ((536866816 & i) != 0) {
            int iMenuCmdToPart = menuCmdToPart(i);
            if (iMenuCmdToPart == 0 || iMenuCmdToPart == 1 || iMenuCmdToPart == 2 || iMenuCmdToPart == 3 || iMenuCmdToPart == 4) {
                this.menu_updateCarPaint = true;
                this.menu_paintCarTimer = 0;
            } else {
                this.g_cars[this.g_player.m_currentCar].testPart(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd);
            }
        }
        this.menu_carUpdateTime = this.timeInMenu + 2000;
    }

    void menu_PointerPressed(int i, int i2) throws Exception {
        if (this.menu_startupStage == 2) {
            if (this.menu_sceneLoadStage > 2) {
                asset_FreeImage(this.g_MenuImages[0]);
                this.menu_startupStage = 3;
                menu_Start();
                return;
            }
            return;
        }
        if (this.menu_show_mode == 10) {
            if (i2 > 160 && i2 < 180 && i > 55 && i < 105) {
                if (this.currentConfirm != 1) {
                    this.currentConfirm = 1;
                    return;
                }
                this.menu_show_mode = this.prevShowMode;
                this.menu_show_mode = (byte) 0;
                this.currentConfirm = 1;
                menu_OnConfirmed();
                return;
            }
            if (i2 <= 160 || i2 >= 180 || i <= 135 || i >= 185) {
                return;
            }
            if (this.currentConfirm == 0) {
                this.menu_show_mode = this.prevShowMode;
                return;
            } else {
                this.currentConfirm = 0;
                return;
            }
        }
        if (this.menu_show_mode == 11) {
            if (i2 <= 160 || i2 >= 180 || i <= 95 || i >= 145) {
                return;
            }
            this.menu_show_mode = this.prevShowMode;
            if (this.menu_IsPaused) {
                this.menu_IsPaused = false;
                asset_ChangeVolume(this.system_nVolume);
                game_StartMusic(false);
                return;
            }
            return;
        }
        if (this.menu_show_mode == 1) {
            int i3 = (((this.menu_canvasHeight - 7) * this.menu_yDocStart) / this.menu_docLineCount) + 20;
            if (i3 > i2 && i > 225) {
                this.game_nKeyPressed = (byte) 1;
                return;
            } else {
                if (i3 >= i2 || i <= 225) {
                    return;
                }
                this.game_nKeyPressed = (byte) 2;
                return;
            }
        }
        if (this.menu_show_mode == 8) {
            int i4 = (this.system_nCanvasWidth >> 1) - 88;
            if (i2 <= this.system_nCanvasHeight - 58 || i2 >= (this.system_nCanvasHeight - 58) + 30) {
                return;
            }
            if (i > i4 && i < i4 + 20) {
                menu_KeyPressed(0, 2);
                return;
            } else {
                if (i <= i4 + 156 || i >= i4 + 176) {
                    return;
                }
                menu_KeyPressed(0, 5);
                return;
            }
        }
        int i5 = this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type;
        if ((536866816 & i5) != 0) {
            menuCmdToPart(i5);
            return;
        }
        if (i2 > 258 && i2 < 290) {
            if (i > 63 && i < 117) {
                menu_MenuPrev();
            } else if (i > 127 && i < 156) {
                menu_OnExecuteItem();
            } else if (i > 163 && i < 228) {
                menu_MenuNext();
            }
        }
        if ((i5 & 1024) == 0 || i2 <= 187 || i2 >= 204) {
            return;
        }
        if (i > 11 && i < 28) {
            menu_MenuInc();
        } else {
            if (i <= 211 || i >= 228) {
                return;
            }
            menu_MenuDec();
        }
    }

    void menu_PointerReleased(int i, int i2) {
        this.menu_nKeyFlags = 0;
        this.game_nKeyPressed = (byte) 0;
        this.game_nTimeKeyHeld = (short) 0;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    /* JADX WARN: Code duplicated, block: B:83:0x0202  */
    /* JADX WARN: Code duplicated, block: B:84:0x0205 A[PHI: r5
  0x0205: PHI (r5v23 int) = (r5v22 int), (r5v24 int) binds: [B:42:0x00b4, B:35:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    int menu_PreProcessDocPage(boolean z) {
        boolean z2;
        String str;
        int i;
        int i2;
        String str2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.docStart;
        char[] cArr = new char[400];
        String string = "";
        int i9 = this.menu_xOffset;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i8 < this.docEnd) {
            String string2 = null;
            if (!z) {
                this.menu_docLineAttr[i13] = i12;
            }
            byte b = this.asset_DataBufArray[this.docID][i8];
            if (b < 0) {
                switch (b) {
                    case -9:
                        i = i11;
                        i2 = i9;
                        string2 = new StringBuffer().append("").append(m_Midlet.getAppProperty("MIDlet-Version")).toString();
                        str2 = string;
                        break;
                    case -8:
                        if (z) {
                            i6 = i13 + 1;
                        } else {
                            i6 = i13 + 1;
                            this.menu_docArray[i13] = string;
                        }
                        i = i11;
                        i2 = this.menu_xOffset;
                        str2 = "";
                        i13 = i6;
                        break;
                    case -7:
                        i3 = 1;
                        if (string.length() <= 0 && i13 <= 0) {
                            i = i3;
                            i2 = i9;
                            str2 = string;
                        } else {
                            if (z) {
                                i4 = i13 + 1;
                            } else {
                                i4 = i13 + 1;
                                this.menu_docArray[i13] = string;
                            }
                            i = 1;
                            i2 = this.menu_xOffset;
                            str2 = "";
                            i13 = i4;
                        }
                        break;
                    case -6:
                        i3 = 0;
                        if (string.length() <= 0 && i13 <= 0) {
                            i = i3;
                            i2 = i9;
                            str2 = string;
                        } else {
                            if (z) {
                                i5 = i13 + 1;
                            } else {
                                i5 = i13 + 1;
                                this.menu_docArray[i13] = string;
                            }
                            i = 0;
                            i2 = this.menu_xOffset;
                            str2 = "";
                            i13 = i5;
                        }
                        break;
                    case -5:
                        if (z) {
                            i7 = i13 + 2;
                        } else {
                            int i14 = i13 + 1;
                            this.menu_docArray[i13] = string;
                            i7 = i14 + 1;
                            this.menu_docArray[i14] = "";
                        }
                        i = i11;
                        i2 = this.menu_xOffset;
                        str2 = "";
                        i13 = i7;
                        break;
                    case -4:
                    default:
                        i = i11;
                        i2 = i9;
                        str2 = string;
                        break;
                    case -3:
                        i = i11;
                        i2 = i9;
                        str2 = string;
                        break;
                    case -2:
                        i10 = 4;
                        i = i11;
                        i2 = i9;
                        str2 = string;
                        break;
                    case -1:
                        i10 = 2;
                        i = i11;
                        i2 = i9;
                        str2 = string;
                        break;
                }
                i8++;
                i11 = i;
                i9 = i2;
                str = string2;
                string = str2;
            } else {
                int i15 = 0;
                if (this.asset_DataBufArray[this.docID][i8 + 0] < 96) {
                }
                do {
                    if (this.asset_DataBufArray[this.docID][i8 + 0] < 96) {
                        if (this.asset_DataBufArray[this.docID][i8] != 32) {
                            if (this.asset_DataBufArray[this.docID][i8] == 92) {
                                cArr[i15] = 169;
                                i15++;
                            } else if (this.asset_DataBufArray[this.docID][i8] == 91) {
                                cArr[i15] = 8482;
                                i15++;
                            } else {
                                cArr[i15] = (char) this.asset_DataBufArray[this.docID][i8];
                                i15++;
                            }
                        }
                        i8++;
                        z2 = true;
                    } else {
                        z2 = false;
                        cArr[i15] = (char) ((((this.asset_DataBufArray[this.docID][i8 + 0] - 96) & 15) << 12) | (((this.asset_DataBufArray[this.docID][i8 + 1] - 96) & 15) << 8) | (((this.asset_DataBufArray[this.docID][i8 + 2] - 96) & 15) << 4) | (((this.asset_DataBufArray[this.docID][i8 + 3] - 96) & 15) << 0));
                        i8 += 4;
                        i15++;
                    }
                    if (!z2 || i8 >= this.docEnd) {
                    }
                    if (i15 > 0) {
                        if (z2) {
                            cArr[i15] = ' ';
                            i15++;
                        }
                        str = new String(cArr, 0, i15);
                    } else {
                        str = null;
                    }
                } while (this.asset_DataBufArray[this.docID][i8] > 32);
                if (i15 > 0) {
                    if (z2) {
                        cArr[i15] = ' ';
                        i15++;
                    }
                    str = new String(cArr, 0, i15);
                } else {
                    str = null;
                }
            }
            if (str != null) {
                int iGetSubstringWidth = this.menu_xOffset < 0 ? 0 : this.font_text.GetSubstringWidth(str, 0, str.length());
                if (i9 + iGetSubstringWidth >= (this.system_nCanvasWidth - this.menu_xOffset) - 8) {
                    if (!z) {
                        this.menu_docArray[i13] = string;
                    }
                    i13++;
                    i9 = this.menu_xOffset + iGetSubstringWidth;
                    i12 = i10 | i11;
                    string = str;
                } else {
                    if (string.length() == 0) {
                        i12 = i10 | i11;
                    }
                    i9 += iGetSubstringWidth;
                    string = new StringBuffer().append(string).append(str).toString();
                }
            }
        }
        if (string.length() <= 0) {
            return i13;
        }
        if (z) {
            return i13 + 1;
        }
        this.menu_docLineAttr[i13] = i12;
        int i16 = i13 + 1;
        this.menu_docArray[i13] = string;
        return i16;
    }

    void menu_Render() {
        int i;
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        int i2 = this.system_nCanvasHeight;
        if (this.menu_startupStage == 1 && this.menu_show_mode != 1) {
            system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
            try {
                menu_InitDoc(this.g_docs[0], false, false);
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 3212, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 3212, e2.toString());
            }
        } else if (this.menu_startupStage == 2) {
            system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
            asset_DrawImage(this.g_MenuImages[0], 0, 0);
            if (this.menu_sceneLoadStage < 2) {
                this.font_ingame.DrawSubstringWrapped(this.g_Text[29], 0, this.g_Text[29].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 250, 1, 0);
            } else if (this.menu_sceneLoadStage > 2) {
                this.font_ingame.DrawSubstringWrapped(this.g_Text[12], 0, this.g_Text[12].length(), this.system_nCanvasWidth - 16, this.system_nCanvasWidth >> 1, 250, 1, 0);
            }
            if (this.menu_sceneLoadStage == 1) {
                while (scene_OpenModel("menu_background", 3, false)) {
                }
            }
            this.menu_sceneLoadStage++;
        } else if (this.menu_startupStage == 3) {
            asset_DrawImage(2, (this.system_nCanvasWidth >> 1) - 8, (this.system_nCanvasHeight >> 1) - 12);
            this.menu_hourGlass = true;
        } else if (this.scene_nCurrentScene == 4098 && this.menu_show_mode != 1) {
            system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
            try {
                menu_InitDoc(this.g_docs[5], true, true);
            } catch (Error e3) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 3253, e3.toString());
            } catch (Exception e4) {
                e4.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\menu_share.hpp", 3253, e4.toString());
            }
        } else if (this.menu_show_mode == 1) {
            int i3 = this.menu_yCanvasOffset + (this.menu_yScrollOffset >> 8);
            int i4 = this.menu_yOffset >> 8;
            int i5 = this.menu_yDocStart;
            system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
            int i6 = i5;
            int i7 = i4;
            int i8 = i3;
            for (int i9 = 0; i9 < ((this.menu_canvasHeight - this.menu_yCanvasOffset) / this.menu_rowHeight) + 1; i9++) {
                int i10 = this.menu_canvasHeight - i8;
                if (i10 > this.menu_rowHeight) {
                    i10 = this.menu_rowHeight;
                }
                if (i6 >= 0) {
                    if (i9 == 0) {
                        m_CurrentGraphics.setClip(0, this.menu_yCanvasOffset + 20, this.system_nCanvasWidth, i10);
                    } else {
                        m_CurrentGraphics.setClip(0, i8 + 20, this.system_nCanvasWidth, i10);
                    }
                    m_CurrentGraphics.drawImage(this.game_imageMapBuffer, 0, (i8 - i7) + 20, 20);
                } else {
                    i6++;
                }
                i7 += this.menu_rowHeight;
                i8 += this.menu_rowHeight;
                if (i7 >= this.menu_canvasHeight + this.menu_rowHeight) {
                    i7 = this.menu_yCanvasOffset;
                }
            }
            if (this.menu_docLineCount * this.menu_rowHeight > this.menu_canvasHeight && !this.menu_scrolling) {
                system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
                system_FillRect(this.system_nCanvasWidth - 4, 20, 3, this.menu_canvasHeight, 16711680);
                int i11 = (((this.menu_canvasHeight - 7) * this.menu_yDocStart) / this.menu_docLineCount) + 20;
                int i12 = ((this.menu_canvasHeight - 7) * (this.menu_canvasHeight / this.menu_rowHeight)) / this.menu_docLineCount;
                if (i12 > this.menu_canvasHeight - 7) {
                    i12 = this.menu_canvasHeight - 7;
                }
                system_FillRect(this.system_nCanvasWidth - 3, i11 + 2, 1, i12, 16777215);
            }
            if (this.menu_startupStage == 1) {
                asset_DrawImage(this.g_WarningImgs[this.g_nLanguage], 0, 0);
                drawSoftKey(6, 0);
            } else {
                drawSoftKey(4, 1);
            }
        } else {
            if (this.menuCurrent == null) {
                return;
            }
            system_SetClip(0, 0, this.system_nCanvasWidth, i2);
            menu_DrawMenuBG(i2);
            NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
            int i13 = nFSMW_MenuItem.m_type;
            if (this.menuCurrent.m_backgroundStyle != 4 && this.menuCurrent.m_backgroundStyle != 6) {
                system_SetClip(0, 0, this.system_nCanvasWidth, i2);
                system_FillRect(0, 0, this.system_nCanvasWidth, 18, 0);
                system_FillRect(0, 18, 91, 37, 0);
                asset_DrawImage(740, 91, 18);
                asset_DrawImage(736, 0, 55);
                asset_DrawImage(732, 0, 83);
                boolean z = true;
                if (this.menuCurrent == this.menuCareer || this.menuCurrent == this.menuMissionTypes || this.menuCurrent == this.menuCustomize || this.menuCurrent == this.menuCustomizeVis || this.menuCurrent == this.menuCustomizePerf || this.menuCurrent == this.menuCarPaint) {
                    this.font_text.SetColor(16777215);
                    this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[17]).append(this.g_player.m_cash).toString(), 0, new StringBuffer().append(this.g_Text[17]).append(this.g_player.m_cash).toString().length(), this.system_nCanvasWidth - 122, 0, 0);
                    if (this.menu_drawCar) {
                        this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[18]).append(this.g_player.getTotalRep()).toString(), 0, new StringBuffer().append(this.g_Text[18]).append(this.g_player.getTotalRep()).toString().length(), this.system_nCanvasWidth - 122, 16, 0);
                    }
                    z = false;
                }
                if ((i13 & 32) != 0) {
                    this.font_text.SetColor(16777215);
                    if (this.g_player.m_equipedCar == nFSMW_MenuItem.m_cmd) {
                        this.font_text.DrawSubstring(this.g_Text[30], 0, this.g_Text[30].length(), this.system_nCanvasWidth - 10, 0, 2);
                        z = false;
                    } else if (this.g_player.m_missionStatus[nFSMW_MenuItem.m_cmd] == 1) {
                        this.font_text.DrawSubstring(this.g_Text[31], 0, this.g_Text[31].length(), this.system_nCanvasWidth - 10, 0, 2);
                        z = false;
                    } else {
                        this.font_ingame.DrawSubstring(this.g_Text[13], 0, this.g_Text[13].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                        z = false;
                    }
                }
                if ((536866816 & i13) != 0) {
                    int iMenuCmdToPart = menuCmdToPart(i13);
                    NFSMW_CarPart nFSMW_CarPart = this.g_carParts[iMenuCmdToPart][nFSMW_MenuItem.m_cmd];
                    if (this.g_cars[this.g_player.m_currentCar].m_cmd == 5 && (iMenuCmdToPart == 9 || iMenuCmdToPart == 8 || iMenuCmdToPart == 6)) {
                        this.font_text.SetColor(16777215);
                        this.font_text.DrawSubstring(this.g_Text[32], 0, this.g_Text[32].length(), this.system_nCanvasWidth - 10, 0, 2);
                    } else if (this.g_player.m_partStatus[iMenuCmdToPart][nFSMW_MenuItem.m_cmd] == 1) {
                        this.font_text.SetColor(16777215);
                        this.font_text.DrawSubstring(this.g_Text[33], 0, this.g_Text[33].length(), this.system_nCanvasWidth - 10, 0, 2);
                        if (this.g_cars[this.g_player.m_currentCar].isPartInstalled(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd)) {
                            this.font_text.SetColor(16777215);
                            this.font_text.DrawSubstring(this.g_Text[34], 0, this.g_Text[34].length(), this.system_nCanvasWidth - 10, 16, 2);
                        }
                    } else if (this.g_cars[this.g_player.m_currentCar].isPartInstalled(iMenuCmdToPart, (byte) nFSMW_MenuItem.m_cmd)) {
                        this.font_text.SetColor(16777215);
                        this.font_text.DrawSubstring(this.g_Text[36], 0, this.g_Text[36].length(), this.system_nCanvasWidth - 10, 0, 2);
                        this.font_text.SetColor(16777215);
                        this.font_text.DrawSubstring(this.g_Text[34], 0, this.g_Text[34].length(), this.system_nCanvasWidth - 10, 16, 2);
                    } else {
                        if (this.g_player.m_cash < nFSMW_CarPart.m_cost) {
                            this.font_text.SetColor(16711680);
                        } else {
                            this.font_text.SetColor(16777215);
                        }
                        this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[37]).append(nFSMW_CarPart.m_cost).toString(), 0, new StringBuffer().append(this.g_Text[37]).append(nFSMW_CarPart.m_cost).toString().length(), this.system_nCanvasWidth - 10, 0, 2);
                        this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[38]).append(this.g_player.m_cash).toString(), 0, new StringBuffer().append(this.g_Text[38]).append(this.g_player.m_cash).toString().length(), this.system_nCanvasWidth - 10, 16, 2);
                    }
                    i = nFSMW_MenuItem.m_type;
                    z = false;
                } else {
                    i = i13;
                }
                if (this.menuCurrent.m_backgroundStyle == 2 || this.menuCurrent.m_backgroundStyle == 1 || this.menuCurrent.m_backgroundStyle == 6 || this.menuCurrent.m_backgroundStyle == 3) {
                    z = false;
                }
                if (z) {
                    asset_DrawImage(this.g_MenuImages[1], 14, 0);
                }
                if (this.menuCurrent.m_backgroundStyle == 3) {
                    asset_DrawImage(this.g_MenuImages[1], 14, 0);
                }
                i13 = i;
            }
            if (this.menuCurrent.m_backgroundStyle == 3) {
                int i14 = this.g_player.m_LapTimes[this.menuTrackSelect.m_selected];
                if (i14 < 0) {
                    i14 = 0;
                }
                int i15 = (i14 / 1000) % 60;
                int i16 = i14 / 60000;
                String string = new StringBuffer().append("").append(new StringBuffer().append(i16 < 10 ? "0" : "").append(i16).toString()).append(":").append(new StringBuffer().append(i15 < 10 ? "0" : "").append(i15).toString()).toString();
                this.font_text.SetColor(16777215);
                this.font_text.DrawSubstring(this.g_Text[39], 0, this.g_Text[39].length(), 15, 90, 0);
                this.font_text.DrawSubstring(new StringBuffer().append("").append(this.g_tracks[this.menuTrackSelect.m_selected].m_trackLength).append(" KM").toString(), 0, new StringBuffer().append("").append(this.g_tracks[this.menuTrackSelect.m_selected].m_trackLength).append(" KM").toString().length(), 15, 104, 0);
                this.font_text.DrawSubstring(this.g_Text[45], 0, this.g_Text[45].length(), 15, 122, 0);
                this.font_text.DrawSubstring(string, 0, string.length(), 15, 136, 0);
                this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[20]).append(" 3").toString(), 0, new StringBuffer().append(this.g_Text[20]).append(" 3").toString().length(), 15, 154, 0);
            }
            system_SetClip(0, 0, this.system_nCanvasWidth, i2);
            system_FillRect(0, this.system_nCanvasHeight - 20, 52, 20, 0);
            system_FillRect(52, this.system_nCanvasHeight - 63, this.system_nCanvasWidth, 63, 0);
            asset_DrawImage(772, 0, (this.system_nCanvasHeight - 20) - 93);
            asset_DrawImage(768, 52, (this.system_nCanvasHeight - 63) - 46);
            if ((this.menuCurrent.m_backgroundStyle == 2 || this.menuCurrent.m_backgroundStyle == 1) && this.menu_drawCar) {
                DrawCarStats();
            }
            if (this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type != 0 && this.menuCurrent.m_items[this.menuCurrent.m_selected].m_type != 1024) {
                drawSoftKey(3, 0);
            }
            if (this.menuCurrent == this.menuRoot) {
                drawSoftKey(5, 1);
            } else {
                drawSoftKey(4, 1);
            }
            if (this.menu_show_mode == 3) {
                this.font_text.SetColor(this.itemColor);
                this.font_text.DrawSubstring(this.menu_msg, 0, this.menu_msg.length(), this.system_nCanvasWidth / 2, (this.system_nCanvasHeight / 2) - this.menu_rowHeight, 1);
                return;
            }
            this.font_headings.DrawSubstring(this.g_Text[this.menuCurrent.m_title], 0, this.g_Text[this.menuCurrent.m_title].length(), this.system_nCanvasWidth - 4, (this.system_nCanvasHeight - 58) - 30, 2);
            if (this.menu_show_mode == 8) {
                if ((536866816 & i13) != 0) {
                    int iMenuCmdToPart2 = menuCmdToPart(i13);
                    if (iMenuCmdToPart2 == 1 || iMenuCmdToPart2 == 2 || iMenuCmdToPart2 == 3 || iMenuCmdToPart2 == 4) {
                        int i17 = (this.system_nCanvasWidth >> 1) - 88;
                        asset_DrawImage(714, i17, (this.system_nCanvasHeight - 58) + 2);
                        system_DrawRect((nFSMW_MenuItem.m_cmd * 10) + i17 + 19, (this.system_nCanvasHeight - 58) + 2 + 1, 9, 24, 16756288);
                        if (((this.scene_timer >> 8) & 1) == 1) {
                            asset_DrawImage(708, i17 + 3, (this.system_nCanvasHeight - 58) + 10);
                            asset_DrawImage(696, i17 + 159, (this.system_nCanvasHeight - 58) + 10);
                        } else {
                            asset_DrawImage(704, i17 + 3, (this.system_nCanvasHeight - 58) + 10);
                            asset_DrawImage(692, i17 + 159, (this.system_nCanvasHeight - 58) + 10);
                        }
                    }
                    if ((iMenuCmdToPart2 == 2 || iMenuCmdToPart2 == 3) && this.g_cars[this.g_player.m_currentCar].m_parts[0] == 0) {
                        this.font_ingame.DrawSubstring(this.g_Text[13], 0, this.g_Text[13].length(), this.system_nCanvasWidth >> 1, (this.system_nCanvasHeight >> 2) + 1, 1);
                        return;
                    }
                    return;
                }
                return;
            }
            int i18 = (this.system_nCanvasHeight - 58) - 8;
            int i19 = this.menuCurrent.m_selected - 1;
            if (i19 >= 0) {
                if (this.menuTimer < 300 && this.lastMenuDirection == -1) {
                    asset_DrawImage(700, 72, (this.system_nCanvasHeight - 58) + 5);
                } else if (((this.scene_timer >> 8) & 1) == 1) {
                    asset_DrawImage(708, 72, (this.system_nCanvasHeight - 58) + 5);
                } else {
                    asset_DrawImage(704, 72, (this.system_nCanvasHeight - 58) + 5);
                }
                if (this.goingToNextMenu != 0) {
                    asset_DrawImage(958, 95, i18);
                } else {
                    asset_DrawImage(this.menuCurrent.m_items[i19].m_icon, 95, i18);
                    asset_DrawImage(668, 95, i18);
                }
            }
            int i20 = i19 + 1;
            if (this.goingToNextMenu != 0) {
                asset_DrawImage(958, 130, i18);
                asset_DrawImage(954, 132, i18 + 31);
            } else {
                asset_DrawImage(this.menuCurrent.m_items[i20].m_icon, 130, i18);
                this.font_text.SetColor(this.selectedColor);
                if (this.menuCurrent == this.menuMissionTypes) {
                    int i21 = 0;
                    int i22 = 0;
                    if (this.menuCurrent.m_items[i20].m_subMenu != null) {
                        NFSMW_Menu nFSMW_Menu = this.menuCurrent.m_items[i20].m_subMenu;
                        for (int i23 = 0; i23 < 6; i23++) {
                            if (!menu_isMissionLocked(nFSMW_Menu.m_items[i23].m_cmd)) {
                                i22++;
                                if (this.g_player.m_missionStatus[nFSMW_Menu.m_items[i23].m_cmd] == 1) {
                                    i21++;
                                }
                            }
                        }
                    }
                    int i24 = i22;
                    int i25 = i21;
                    this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[this.menuCurrent.m_items[i20].m_text]).append(" ").append(i25).append("/").append(i24).toString(), 0, new StringBuffer().append(this.g_Text[this.menuCurrent.m_items[i20].m_text]).append(" ").append(i25).append("/").append(i24).toString().length(), 142, i18 + 30, 1);
                } else if (this.menuCurrent == this.menuProfile) {
                    if (this.g_player.m_profileNum == this.menuCurrent.m_selected) {
                        this.font_text.SetColor(255, 255, 0);
                    }
                    this.font_text.DrawSubstring(this.g_Text[this.menuCurrent.m_items[i20].m_text], 0, this.g_Text[this.menuCurrent.m_items[i20].m_text].length(), 142, i18 + 30, 1);
                } else if (this.menuCurrent == this.menuMissionCircuits || this.menuCurrent == this.menuMissionCheckpoints || this.menuCurrent == this.menuMissionKnockout || this.menuCurrent == this.menuMissionSpeedCam || this.menuCurrent == this.menuMissionOutrun || this.menuCurrent == this.menuMissionChallenge) {
                    this.font_text.DrawSubstring(new StringBuffer().append(this.g_Text[this.menuCurrent.m_items[i20].m_text]).append(" ").append(this.menuCurrent.m_selected + 1).toString(), 0, new StringBuffer().append(this.g_Text[this.menuCurrent.m_items[i20].m_text]).append(" ").append(this.menuCurrent.m_selected + 1).toString().length(), 142, i18 + 30, 1);
                } else {
                    this.font_text.DrawSubstring(this.g_Text[this.menuCurrent.m_items[i20].m_text], 0, this.g_Text[this.menuCurrent.m_items[i20].m_text].length(), 142, i18 + 30, 1);
                }
            }
            asset_DrawImage(676, 127, i18 - 1);
            asset_DrawImage(672, 151, i18 - 1);
            asset_DrawImage(680, 151, (i18 + 26) - 4);
            asset_DrawImage(684, 127, (i18 + 26) - 4);
            int i26 = i20 + 1;
            if (i26 < this.menuCurrent.m_itemCount) {
                int i27 = (this.system_nCanvasHeight - 58) - 8;
                if (this.goingToNextMenu != 0) {
                    asset_DrawImage(958, 165, i27);
                } else {
                    asset_DrawImage(this.menuCurrent.m_items[i26].m_icon, 165, i27);
                    asset_DrawImage(668, 165, i27);
                }
                if (this.menuTimer < 300 && this.lastMenuDirection == 1) {
                    asset_DrawImage(688, 200, (this.system_nCanvasHeight - 58) + 5);
                } else if (((this.scene_timer >> 8) & 1) == 1) {
                    asset_DrawImage(696, 200, (this.system_nCanvasHeight - 58) + 5);
                } else {
                    asset_DrawImage(692, 200, (this.system_nCanvasHeight - 58) + 5);
                }
            }
        }
        if (this.menu_show_mode == 10 || this.menu_show_mode == 11) {
            int i28 = (this.system_nCanvasHeight - 58) - 8;
            system_FillRect(19, 69, 202, 115, 16777215);
            system_FillRect(20, 70, 200, 95, 2631720);
            system_FillRect(20, 160, 200, 23, 6316128);
            this.font_text.SetColor(this.itemColor);
            this.font_text.DrawSubstringWrapped(this.g_Text[this.currentConfirmString], 0, this.g_Text[this.currentConfirmString].length(), this.system_nCanvasWidth - 40, this.system_nCanvasWidth / 2, 73, 1, -5);
            if (this.menu_show_mode != 10) {
                this.font_text.SetColor(this.selectedColor);
                int i29 = this.system_nCanvasWidth >> 1;
                system_FillRect(i29 - 20, 162, 40, 19, 0);
                this.font_text.DrawSubstring(this.g_Text[2], 0, this.g_Text[2].length(), i29, 164, 1);
                return;
            }
            this.font_text.SetColor(this.selectedColor);
            int[] iArr = {116, 58};
            iArr[1] = this.system_nCanvasWidth / 3;
            iArr[0] = iArr[1] * 2;
            system_FillRect(iArr[this.currentConfirm] - 20, 162, 40, 19, 0);
            this.font_text.DrawSubstring(this.g_Text[1], 0, this.g_Text[1].length(), iArr[0], 164, 1);
            this.font_text.DrawSubstring(this.g_Text[0], 0, this.g_Text[0].length(), iArr[1], 164, 1);
        }
    }

    void menu_ShowConfirmDlg(int i) {
        if (this.menu_show_mode == 10 || this.menu_show_mode == 11) {
            this.menu_show_mode = this.prevShowMode;
        }
        this.prevShowMode = this.menu_show_mode;
        this.menu_show_mode = (byte) 10;
        this.currentConfirm = 0;
        this.currentConfirmString = i;
    }

    void menu_ShowDocPage(int i, int i2, int i3) {
        m_CurrentGraphics = this.game_gMapBuffer;
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        int i4 = i >> 8;
        for (int i5 = 0; i5 < i3; i5++) {
            system_FillRect(0, i4, this.system_nCanvasWidth, this.menu_rowHeight, 0);
            if (i2 >= this.menu_docLineCount) {
                return;
            }
            if ((this.menu_docLineAttr[i2] & 1) == 1) {
                if (i2 == 0) {
                    system_FillRect(3, i4, (this.system_nCanvasWidth - 3) - 5, this.menu_rowHeight, 8421504);
                }
                this.font_text.SetColor(this.selectedColor);
            } else {
                this.font_text.SetColor(this.itemColor);
            }
            if (this.menu_docArray[i2] != null && this.menu_docArray[i2].length() > 0) {
                if ((this.menu_docLineAttr[i2] & 2) == 2) {
                    this.font_text.DrawSubstring(this.menu_docArray[i2], 0, this.menu_docArray[i2].length(), (this.system_nCanvasWidth / 2) + (this.menu_xOffset / 2), i4, 1);
                } else {
                    this.font_text.DrawSubstring(this.menu_docArray[i2], 0, this.menu_docArray[i2].length(), this.menu_xOffset, i4, 0);
                }
            }
            i4 += this.menu_rowHeight;
            i2++;
        }
    }

    void menu_ShowMessageDlg(int i) {
        if (this.menu_show_mode == 10 || this.menu_show_mode == 11) {
            this.menu_show_mode = this.prevShowMode;
        }
        this.prevShowMode = this.menu_show_mode;
        this.menu_show_mode = (byte) 11;
        this.currentConfirm = 0;
        this.currentConfirmString = i;
    }

    void menu_Start() throws Exception {
        switch (this.menu_startupStage) {
            case 0:
                menu_LoadMainMenu();
                break;
            case 1:
                asset_LoadImage(this.g_WarningImgs[this.g_nLanguage], false);
                menu_Init();
                break;
            case 2:
                asset_LoadImage(this.g_MenuImages[0], false);
                if (!this.menu_SplashPause) {
                    asset_ChangeVolume(this.system_nVolume);
                    game_StartMusic(true);
                }
                break;
            case 3:
                asset_LoadImage(2, false);
                this.menu_hourGlass = false;
                break;
        }
    }

    void menu_Update(int i) throws Exception {
        if (i > 100) {
            i = 100;
        }
        this.timeInMenu += i;
        if (this.menu_startupStage == 2) {
            return;
        }
        if (this.menu_startupStage == 3) {
            if (this.menu_hourGlass) {
                asset_FreeImage(2);
                this.menu_startupStage = 0;
                menu_Start();
                return;
            }
            return;
        }
        if (this.menu_startupStage > 3) {
            if (this.menuCurrent != null) {
                if (this.menu_nKeyFlags == 49 && this.menuCurrent.m_backgroundStyle == 2) {
                    this.car_rot_offset += 5;
                } else if (this.menu_nKeyFlags == 51 && this.menuCurrent.m_backgroundStyle == 2) {
                    this.car_rot_offset -= 5;
                } else if (this.menu_nKeyFlags == 50 && this.menuCurrent.m_backgroundStyle == 2) {
                    this.car_rot_offset = 0;
                }
            }
            this.car_rot += i >> 1;
            RefreshCarPaint(i);
            if (this.menu_refreshCar && this.menu_hourGlass && this.menu_carUpdateTime < this.timeInMenu) {
                for (int i2 = 0; i2 < this.g_cars.length; i2++) {
                    if (i2 != this.menu_nextCar && this.g_cars[i2] != null) {
                        this.g_cars[i2].free();
                    }
                }
                this.menu_car = this.menu_nextCar;
                NFSMW_MenuItem nFSMW_MenuItem = this.menuCurrent.m_items[this.menuCurrent.m_selected];
                int i3 = nFSMW_MenuItem.m_type;
                if ((536866816 & i3) != 0) {
                    this.g_cars[this.g_player.m_currentCar].testPart(menuCmdToPart(i3), (byte) nFSMW_MenuItem.m_cmd);
                } else {
                    this.g_cars[this.menu_car].constructCar(false);
                    this.menu_reflectionMesh = this.g_cars[this.menu_car].m_reflectionMesh;
                    this.g_player.m_carRep = this.g_cars[this.menu_car].m_modStats[3];
                }
                this.menu_refreshCar = false;
                this.menu_hourGlass = false;
                this.menu_drawCar = true;
            }
            this.menuTimer += i;
            if (this.goingToNextMenu != 0) {
                if (this.menuTimer > 100) {
                    this.menuCurrent.m_selected += this.goingToNextMenu;
                    this.goingToNextMenu = 0;
                    menu_OnSelectionChange();
                    return;
                }
                return;
            }
        }
        if (this.menu_show_mode < 3) {
            if (this.menu_scrolling) {
                this.menu_yScrollOffset -= (this.menu_scrollSpeed * i) / 1000;
                if ((this.menu_yScrollOffset >> 8) > (-this.menu_rowHeight)) {
                    menu_ShowDocPage(-(this.menu_canvasHeight << 8), this.menu_yDocStart + ((this.menu_canvasHeight - this.menu_yCanvasOffset) / this.menu_rowHeight), 1);
                    return;
                }
                this.menu_yScrollOffset = 0;
                menu_ShowDocPage(this.menu_yOffset, this.menu_yDocStart + ((this.menu_canvasHeight - this.menu_yCanvasOffset) / this.menu_rowHeight), 1);
                this.menu_yDocStart++;
                this.menu_yOffset += this.menu_rowHeight << 8;
                if ((this.menu_yOffset >> 8) >= this.menu_canvasHeight + this.menu_rowHeight) {
                    this.menu_yOffset = this.menu_yCanvasOffset << 8;
                }
                if (this.menu_yDocStart >= this.menu_docLineCount) {
                    this.menu_scrolling = false;
                    menu_KeyPressed(589829, 0);
                    return;
                }
                return;
            }
            this.game_nTimeKeyHeld = (short) (this.game_nTimeKeyHeld + i);
            if (this.menu_show_mode != 1) {
                if (this.game_nTimeKeyHeld > 400) {
                    if (this.game_nKeyPressed == 1) {
                        menu_MenuInc();
                        return;
                    }
                    if (this.game_nKeyPressed == 2) {
                        menu_MenuDec();
                        return;
                    } else if (this.game_nKeyPressed == 3) {
                        menu_MenuPrev();
                        return;
                    } else {
                        if (this.game_nKeyPressed == 4) {
                            menu_MenuNext();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.game_nTimeKeyHeld > 100) {
                this.game_nTimeKeyHeld = (short) 0;
                if (this.game_nKeyPressed == 1) {
                    if (this.menu_yDocStart > 0) {
                        this.menu_yDocStart--;
                        this.menu_yOffset -= this.menu_rowHeight << 8;
                        if ((this.menu_yOffset >> 8) < 0) {
                            this.menu_yOffset = this.menu_canvasHeight << 8;
                        }
                        menu_ShowDocPage(this.menu_yOffset, this.menu_yDocStart, 1);
                        return;
                    }
                    return;
                }
                if (this.game_nKeyPressed != 2 || this.menu_yDocStart + (this.menu_canvasHeight / this.menu_rowHeight) >= this.menu_docLineCount) {
                    return;
                }
                int i4 = this.menu_yOffset + (this.menu_canvasHeight << 8);
                if (i4 >= ((this.menu_canvasHeight + this.menu_rowHeight) << 8)) {
                    i4 -= (this.menu_canvasHeight + this.menu_rowHeight) << 8;
                }
                menu_ShowDocPage(i4, this.menu_yDocStart + (this.menu_canvasHeight / this.menu_rowHeight), 1);
                this.menu_yDocStart++;
                this.menu_yOffset += this.menu_rowHeight << 8;
                if ((this.menu_yOffset >> 8) >= this.menu_canvasHeight + this.menu_rowHeight) {
                    this.menu_yOffset = 0;
                }
            }
        }
    }

    boolean menu_isMissionLocked(int i) {
        if (this.g_player.m_missionStatus[i] == 1) {
            return false;
        }
        if (this.g_player.getTotalRep() < this.g_missions[i].m_reqRep) {
            return true;
        }
        return this.g_missions[i].m_reqMission != -1 && this.g_player.m_missionStatus[this.g_missions[i].m_reqMission] == 0;
    }

    void menu_refreshCar(int i) {
        this.menu_refreshCar = false;
        this.menu_drawCar = false;
        if (this.g_player.m_missionStatus[i] == 1 || this.g_player.m_equipedCar == i) {
            this.menu_drawCar = true;
        }
        if (this.menu_drawCar) {
            this.menu_refreshCar = true;
            this.menu_drawCar = false;
            this.menu_nextCar = i;
            this.menu_carUpdateTime = this.timeInMenu + 2000;
        }
    }

    void menu_setCurrentMenu(NFSMW_Menu nFSMW_Menu) {
        if (this.menuCurrent != null) {
            this.menuCurrent.freeIcons(false);
        }
        System.gc();
        this.menuCurrent = nFSMW_Menu;
        this.menuCurrent.loadIcons(false);
    }

    void menu_showPauseScreen() {
        if (this.menu_startupStage < 4) {
            this.menu_SplashPause = true;
        } else {
            if (this.menu_IsPaused) {
                return;
            }
            asset_ChangeVolume(0);
            game_StopMusic();
            this.menu_IsPaused = true;
            menu_ShowMessageDlg(186);
        }
    }

    public synchronized void paint(Graphics graphics) {
        try {
            if (this.system_bExit) {
                if (graphics == null) {
                }
                Display.getDisplay(m_Midlet).callSerially(this);
            } else {
                m_CurrentGraphics = graphics;
                if (this.m_bPaintHourglass) {
                    asset_DrawImage(2, (this.system_nCanvasWidth - 16) >> 1, (this.system_nCanvasHeight - 24) >> 1);
                } else if (!this.system_bExit) {
                    scene_Render();
                    if (this.system_bReRenderSoftKeys) {
                        system_RenderSoftkeys(true);
                        this.system_bReRenderSoftKeys = false;
                    }
                }
                m_CurrentGraphics = null;
                Display.getDisplay(m_Midlet).callSerially(this);
            }
        } catch (Error e) {
            ReportError("Error", "Caught in theGame.run()");
            this.system_bExit = true;
        } catch (Exception e2) {
            this.system_bExit = true;
        }
    }

    protected void pointerPressed(int i, int i2) {
        try {
            if (i2 <= 300) {
                scene_PointerPressed(i, i2);
            } else if (i < 90) {
                scene_KeyPressed(-6, 0);
            } else if (i <= 150) {
            } else {
                scene_KeyPressed(-7, 0);
            }
        } catch (Exception e) {
        }
    }

    protected void pointerReleased(int i, int i2) {
        try {
            scene_PointerReleased(i, i2);
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        if (!bAssertionsStarted) {
            bAssertionsStarted = true;
        }
        if (this.system_bAppPaused) {
        }
        if (!this.system_bExit) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.system_nThisFrameTime = (int) (jCurrentTimeMillis - this.system_nLastTime);
                this.system_nLastTime = jCurrentTimeMillis;
                if (this.system_nThisFrameTime > 200) {
                    this.system_nThisFrameTime = 200;
                }
                int i = this.system_nThisFrameTime;
                if (!this.system_bAssetLoading && !this.system_bExit && i > 0) {
                    for (int i2 = 0; i2 < 1; i2++) {
                        scene_Update(i);
                    }
                }
            } catch (Error e) {
                ReportError("Error", "Caught in theGame.run()");
                this.system_bExit = true;
            } catch (Exception e2) {
                this.system_bExit = true;
            }
            this.system_nLoopCount++;
            if (!this.system_bExit) {
                repaint();
            } else if (!bAssertionSet) {
                Display.getDisplay(m_Midlet).setCurrent((Displayable) null);
                hideNotify();
                End();
                m_Midlet.notifyDestroyed();
            }
        } else if (!bAssertionSet) {
            Display.getDisplay(m_Midlet).setCurrent((Displayable) null);
            hideNotify();
            End();
            m_Midlet.notifyDestroyed();
        }
    }

    void saveCurLang() {
        try {
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("currentLanguage", true);
            RecordEnumeration recordEnumerationEnumerateRecords = recordStoreOpenRecordStore.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
            byte[] bArr = {this.g_nLanguage};
            if (recordEnumerationEnumerateRecords.hasNextElement()) {
                int iNextRecordId = recordEnumerationEnumerateRecords.nextRecordId();
                byte[] record = recordStoreOpenRecordStore.getRecord(iNextRecordId);
                record[0] = this.g_nLanguage;
                recordStoreOpenRecordStore.setRecord(iNextRecordId, record, 0, 1);
            } else {
                recordStoreOpenRecordStore.addRecord(bArr, 0, 1);
            }
            recordEnumerationEnumerateRecords.destroy();
            recordStoreOpenRecordStore.closeRecordStore();
        } catch (Exception e) {
            clearSavedLang();
        }
    }

    boolean scene_BuildCar(NFSMW_CarAppearance nFSMW_CarAppearance, boolean z, boolean z2) {
        int i = z ? 2 : 1;
        try {
            if (i == 2) {
                if (!nFSMW_CarAppearance.m_modelName.startsWith("lod_")) {
                    nFSMW_CarAppearance.m_modelName = new StringBuffer().append("lod_").append(nFSMW_CarAppearance.m_modelName).toString();
                }
            } else if (nFSMW_CarAppearance.m_modelName.startsWith("lod_")) {
                nFSMW_CarAppearance.m_modelName = nFSMW_CarAppearance.m_modelName.substring(4);
            }
            while (scene_OpenModel(nFSMW_CarAppearance.m_modelName, i, true)) {
            }
            MintMesh[] mintMeshArrScene_FindMintMesh = scene_FindMintMesh(nFSMW_CarAppearance.m_modelName);
            nFSMW_CarAppearance.m_carMesh = mintMeshArrScene_FindMintMesh[0].m_mesh;
            nFSMW_CarAppearance.m_imgClean = scene_LoadTexImage(mintMeshArrScene_FindMintMesh[0].m_textureName);
            if (!z2) {
                try {
                    short[] sArr = new short[4];
                    int iBinLoad = binLoad(nFSMW_CarAppearance.m_pointsID);
                    for (int i2 = 0; i2 < 11; i2++) {
                        switch (binGetShort(iBinLoad)) {
                            case 1:
                                sArr[3] = binGetShort(iBinLoad);
                                sArr[0] = binGetShort(iBinLoad);
                                sArr[1] = binGetShort(iBinLoad);
                                sArr[2] = binGetShort(iBinLoad);
                                nFSMW_CarAppearance.m_carWheelPos[i2][0] = sArr[0] / 1024.0f;
                                nFSMW_CarAppearance.m_carWheelPos[i2][1] = sArr[2] / 1024.0f;
                                nFSMW_CarAppearance.m_carWheelPos[i2][2] = (-sArr[1]) / 1024.0f;
                                nFSMW_CarAppearance.m_carWheelPos[i2][3] = sArr[3];
                                break;
                            case 2:
                                sArr[3] = binGetShort(iBinLoad);
                                sArr[0] = binGetShort(iBinLoad);
                                sArr[1] = binGetShort(iBinLoad);
                                sArr[2] = binGetShort(iBinLoad);
                                nFSMW_CarAppearance.m_carLightPos[i2 - 4][0] = sArr[0] / 1024.0f;
                                nFSMW_CarAppearance.m_carLightPos[i2 - 4][1] = sArr[2] / 1024.0f;
                                nFSMW_CarAppearance.m_carLightPos[i2 - 4][2] = (-sArr[1]) / 1024.0f;
                                break;
                            case 3:
                                sArr[0] = binGetShort(iBinLoad);
                                sArr[1] = binGetShort(iBinLoad);
                                sArr[2] = binGetShort(iBinLoad);
                                nFSMW_CarAppearance.m_carSpoilerPos[0] = sArr[0] / 1024.0f;
                                nFSMW_CarAppearance.m_carSpoilerPos[1] = sArr[2] / 1024.0f;
                                nFSMW_CarAppearance.m_carSpoilerPos[2] = (-sArr[1]) / 1024.0f;
                                break;
                            case 4:
                                sArr[0] = binGetShort(iBinLoad);
                                sArr[1] = binGetShort(iBinLoad);
                                sArr[2] = binGetShort(iBinLoad);
                                nFSMW_CarAppearance.m_carStreakPos[i2 - 9][0] = sArr[0] / 1024.0f;
                                nFSMW_CarAppearance.m_carStreakPos[i2 - 9][1] = sArr[2] / 1024.0f;
                                nFSMW_CarAppearance.m_carStreakPos[i2 - 9][2] = (-sArr[1]) / 1024.0f;
                                break;
                        }
                    }
                    binFree(nFSMW_CarAppearance.m_pointsID);
                    if (this.headlights == null) {
                        Image2D image2D = new Image2D(100, scene_LoadTexImage("/headlights.png"));
                        Appearance appearance = new Appearance();
                        appearance.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.headlights = new Sprite3D(true, image2D, appearance);
                    }
                    if (this.brakelights == null) {
                        Image2D image2D2 = new Image2D(100, scene_LoadTexImage("/brakelights.png"));
                        Appearance appearance2 = new Appearance();
                        appearance2.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.brakelights = new Sprite3D(true, image2D2, appearance2);
                    }
                    if (this.policelights == null) {
                        Image2D image2D3 = new Image2D(100, scene_LoadTexImage("/policelight.png"));
                        Appearance appearance3 = new Appearance();
                        appearance3.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.policelights = new Sprite3D(true, image2D3, appearance3);
                    }
                    if (this.sparks_sprite == null) {
                        Image2D image2D4 = new Image2D(100, scene_LoadTexImage("/sparks.png"));
                        Appearance appearance4 = new Appearance();
                        appearance4.setCompositingMode(this.compositingMode_ZREAD_Alpha);
                        this.sparks_sprite = new Sprite3D(true, image2D4, appearance4);
                    }
                    if (this.fire_sprites[0] == null) {
                        Image2D image2D5 = new Image2D(100, scene_LoadTexImage("/fire_01.png"));
                        Appearance appearance5 = new Appearance();
                        appearance5.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.fire_sprites[0] = new Sprite3D(true, image2D5, appearance5);
                        Image2D image2D6 = new Image2D(100, scene_LoadTexImage("/fire_02.png"));
                        Appearance appearance6 = new Appearance();
                        appearance6.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.fire_sprites[1] = new Sprite3D(true, image2D6, appearance6);
                        Image2D image2D7 = new Image2D(100, scene_LoadTexImage("/fire_03.png"));
                        Appearance appearance7 = new Appearance();
                        appearance7.setCompositingMode(this.compositingMode_ZWRITE_AlphaAdd);
                        this.fire_sprites[2] = new Sprite3D(true, image2D7, appearance7);
                    }
                } catch (Error e) {
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5926, e.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5926, e2.toString());
                }
                try {
                    if (this.wheelVertes == null) {
                        short s = (short) nFSMW_CarAppearance.m_carWheelPos[0][3];
                        short s2 = (short) (-s);
                        VertexArray vertexArray = new VertexArray(4, 3, 2);
                        VertexArray vertexArray2 = new VertexArray(4, 2, 2);
                        vertexArray.set(0, 4, new short[]{0, s2, s2, 0, s2, s, 0, s, s2, 0, s, s});
                        vertexArray2.set(0, 4, new short[]{0, 0, 0, 1, 1, 0, 1, 1});
                        this.wheelVertes = new VertexBuffer();
                        this.wheelVertes.setDefaultColor(-1);
                        this.wheelVertes.setPositions(vertexArray, 0.0078125f, (float[]) null);
                        this.wheelVertes.setTexCoords(0, vertexArray2, 1.0f, (float[]) null);
                    }
                    VertexBuffer vertexBuffer = this.wheelVertes;
                    TriangleStripArray triangleStripArray = new TriangleStripArray(new int[]{0, 1, 2, 3}, new int[]{4});
                    String str = this.g_carParts[7][nFSMW_CarAppearance.m_parts[7]].m_partName;
                    Texture2D texture2DScene_FindTexture = scene_FindTexture(str);
                    if (texture2DScene_FindTexture == null) {
                        texture2DScene_FindTexture = scene_CreateTexture(str, scene_LoadTexImage(str), true, true);
                    }
                    Appearance appearance8 = new Appearance();
                    appearance8.setTexture(0, texture2DScene_FindTexture);
                    appearance8.setPolygonMode(this.polygonMode_NoPersp);
                    appearance8.setCompositingMode(this.compositingMode_ZREAD_Alpha);
                    nFSMW_CarAppearance.m_wheelMesh = new Mesh(vertexBuffer, triangleStripArray, appearance8);
                    if (!z) {
                        scene_createStreaks(nFSMW_CarAppearance);
                    }
                    if (!z) {
                        scene_createReflectionMesh(nFSMW_CarAppearance);
                    }
                } catch (Error e3) {
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 6015, e3.toString());
                } catch (Exception e4) {
                    e4.printStackTrace();
                    AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 6015, e4.toString());
                }
            }
        } catch (Error e5) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5772, e5.toString());
        } catch (Exception e6) {
            e6.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5772, e6.toString());
        }
        return false;
    }

    boolean scene_BuildTrack(String str) {
        return scene_OpenModel(str, 3, false);
    }

    void scene_Construct() throws Exception {
        for (int i = 0; i < 23; i++) {
            system_GetRandom();
        }
        this.system_bDemoMode = false;
        if (m_Midlet.getAppProperty("Demo-Mode") != null && m_Midlet.getAppProperty("Demo-Mode").equalsIgnoreCase("True")) {
            this.system_bDemoMode = true;
            this.g_player.clearProfile();
        }
        this.scene_g3d = Graphics3D.getInstance();
        scene_ConstructAppearanceParms();
        this.background = new Background();
        this.background.setColor(5732756);
        asset_LoadImage(948, false);
        this.font_text = new CFont(this, null);
        this.font_text.Construct();
        this.font_headings = new CFont(this, null);
        this.font_headings.Construct();
        this.font_ingame = new CFont(this, null);
        this.font_ingame.Construct();
        this.font_text.SetSystem(Font.getFont(64, 0, 8));
        this.font_text.SetColor(255, 255, 255);
        this.font_headings.SetSystem(Font.getFont(64, 0, 8));
        this.font_headings.SetColor(255, 255, 255);
        this.font_ingame.SetSystem(Font.getFont(64, 0, 8));
        this.font_ingame.SetColor(255, 255, 255);
        menu_Construct();
        game_Construct();
        for (int i2 = 0; i2 < 3; i2++) {
            this.players[i2] = new Car(this, i2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.cops[i3] = new Car(this, -i3);
        }
        for (int i4 = 0; i4 < 1; i4++) {
            this.traffic[i4] = new Car(this, (-i4) - 3);
        }
        this.scene_nCurrentScene = 16384;
        this.scene_timer = 0;
        this.scene_timerUpdate = true;
        scene_Start();
    }

    void scene_ConstructAppearanceParms() {
        this.polygonMode_Persp = new PolygonMode();
        this.polygonMode_NoPersp = new PolygonMode();
        this.compositingMode_ZWRITEREAD = new CompositingMode();
        this.compositingMode_ZWRITE = new CompositingMode();
        this.compositingMode_ZNONE = new CompositingMode();
        this.compositingMode_ZREAD_Alpha = new CompositingMode();
        this.compositingMode_ZWRITE_Alpha = new CompositingMode();
        this.compositingMode_ZWRITE_AlphaAdd = new CompositingMode();
        this.compositingMode_ZNONE_AlphaAdd = new CompositingMode();
        this.polygonMode_NoPersp.setPerspectiveCorrectionEnable(false);
        this.polygonMode_NoPersp.setCulling(160);
        this.polygonMode_NoPersp.setShading(164);
        this.polygonMode_Persp.setPerspectiveCorrectionEnable(true);
        this.polygonMode_Persp.setCulling(160);
        this.polygonMode_Persp.setShading(164);
        this.compositingMode_ZNONE.setDepthTestEnable(false);
        this.compositingMode_ZNONE.setDepthWriteEnable(false);
        this.compositingMode_ZWRITE_AlphaAdd.setDepthTestEnable(true);
        this.compositingMode_ZWRITE_AlphaAdd.setDepthWriteEnable(false);
        this.compositingMode_ZWRITE_AlphaAdd.setBlending(65);
        this.compositingMode_ZNONE_AlphaAdd.setDepthTestEnable(false);
        this.compositingMode_ZNONE_AlphaAdd.setDepthWriteEnable(false);
        this.compositingMode_ZNONE_AlphaAdd.setBlending(65);
        this.compositingMode_ZREAD_Alpha.setDepthTestEnable(true);
        this.compositingMode_ZREAD_Alpha.setDepthWriteEnable(true);
        this.compositingMode_ZREAD_Alpha.setBlending(64);
        this.compositingMode_ZWRITE_Alpha.setDepthTestEnable(false);
        this.compositingMode_ZWRITE_Alpha.setDepthWriteEnable(true);
        this.compositingMode_ZWRITE_Alpha.setBlending(64);
        this.compositingMode_ZWRITEREAD.setDepthTestEnable(true);
        this.compositingMode_ZWRITEREAD.setDepthWriteEnable(true);
        this.compositingMode_ZWRITE.setDepthTestEnable(false);
        this.compositingMode_ZWRITE.setDepthWriteEnable(true);
    }

    void scene_CreateFlashEffect() {
        if (this.flash_effect_sprite == null) {
            Image2D image2D = new Image2D(100, this.g_race.m_type == 3 ? scene_LoadTexImage("/speed_effect.png") : scene_LoadTexImage("/badge_game.png"));
            Appearance appearance = new Appearance();
            appearance.setCompositingMode(this.compositingMode_ZNONE_AlphaAdd);
            this.flash_effect_sprite = new Sprite3D(true, image2D, appearance);
        }
    }

    Texture2D scene_CreateTexture(String str, Image image, boolean z, boolean z2) {
        Texture2D texture2D;
        if (str.startsWith("/a_") || str.startsWith("/A_")) {
            z2 = true;
        }
        try {
            texture2D = new Texture2D(z2 ? new Image2D(100, image) : new Image2D(99, image));
            try {
                texture2D.setFiltering(208, 210);
                texture2D.setWrapping(241, 241);
                texture2D.setBlending(228);
            } catch (Error e) {
                e = e;
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5289, e.toString());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5289, e.toString());
            }
        } catch (Error e3) {
            e = e3;
            texture2D = null;
        } catch (Exception e4) {
            e = e4;
            texture2D = null;
        }
        if (z) {
            TextureRef textureRef = new TextureRef(this, str, texture2D, z2);
            this.vTextureList.addElement(textureRef);
            this.tex_ref = textureRef;
        } else {
            this.tex_ref = null;
        }
        return texture2D;
    }

    void scene_Destroy() {
        system_SaveAllConfigs();
        game_Destroy();
        menu_Destroy();
        scene_freeWorld();
    }

    void scene_End() {
        if ((this.scene_nCurrentScene & 8192) != 0) {
            game_End();
            return;
        }
        if ((this.scene_nCurrentScene & 4096) != 0) {
            this.g_player.saveRecords();
            menu_End();
        } else if ((this.scene_nCurrentScene & 16384) != 0) {
            splash_End();
        }
    }

    MintMesh[] scene_FindMintMesh(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.vObjectList.size()) {
                return null;
            }
            ObjectRef objectRef = (ObjectRef) this.vObjectList.elementAt(i2);
            if (str.compareTo(objectRef.m_name) == 0) {
                return objectRef.m_object;
            }
            i = i2 + 1;
        }
    }

    Texture2D scene_FindTexture(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.vTextureList.size()) {
                this.tex_ref = null;
                return null;
            }
            TextureRef textureRef = (TextureRef) this.vTextureList.elementAt(i2);
            if (str.compareTo(textureRef.m_name) == 0) {
                this.tex_ref = textureRef;
                return textureRef.m_texture;
            }
            i = i2 + 1;
        }
    }

    boolean scene_FreeAllMintMesh() {
        for (int i = 0; i < this.vObjectList.size(); i = 1) {
            ObjectRef objectRef = (ObjectRef) this.vObjectList.elementAt(i);
            for (int i2 = 0; i2 < objectRef.m_object.length; i2++) {
                objectRef.m_object[i2].m_mesh = null;
                objectRef.m_object[i2].m_textureName = null;
                objectRef.m_object[i2].m_meshName = null;
                objectRef.m_object[i2] = null;
            }
            this.vObjectList.removeElementAt(i);
        }
        return true;
    }

    boolean scene_FreeMintMesh(String str) {
        for (int i = 0; i < this.vObjectList.size(); i++) {
            ObjectRef objectRef = (ObjectRef) this.vObjectList.elementAt(i);
            if (str.compareTo(objectRef.m_name) == 0) {
                for (int i2 = 0; i2 < objectRef.m_object.length; i2++) {
                    objectRef.m_object[i2].m_mesh = null;
                    objectRef.m_object[i2].m_textureName = null;
                    objectRef.m_object[i2].m_meshName = null;
                    objectRef.m_object[i2] = null;
                    objectRef.m_name = null;
                }
                this.vObjectList.removeElementAt(i);
                return true;
            }
        }
        return false;
    }

    void scene_FreeTextures() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.vTextureList.size()) {
                this.vTextureList.removeAllElements();
                return;
            }
            TextureRef textureRef = (TextureRef) this.vTextureList.elementAt(i2);
            textureRef.m_name = null;
            textureRef.m_texture = null;
            i = i2 + 1;
        }
    }

    void scene_InitTrackSplines() {
        for (int i = 0; i < 3; i++) {
            this.aiPathCollision.Init();
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < this.track_splines[i].length; i4++) {
                if (i3 != this.aiPathCollision.f0x || i2 != this.aiPathCollision.f1y) {
                    this.aiPathCollision.Init();
                }
                i3 = this.track_splines[i][i4][0] << 12;
                i2 = (-this.track_splines[i][i4][1]) << 12;
                this.groundCollision.TestPointForCollision(i3, i2, this.aiPathCollision);
                this.track_splines[i][i4][3] = this.aiPathCollision.nTriangleID;
            }
        }
        for (int i5 = 0; i5 < this.track_splines[2].length; i5++) {
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            for (int i8 = 0; i8 < this.track_splines[0].length; i8++) {
                int iApproximateMagnitude = ApproximateMagnitude(this.track_splines[0][i8][0] - this.track_splines[2][i5][0], this.track_splines[0][i8][1] - this.track_splines[2][i5][1]);
                if (i6 > iApproximateMagnitude) {
                    i7 = i8;
                    i6 = iApproximateMagnitude;
                }
            }
            this.track_splines[2][i5][4] = (short) i7;
        }
    }

    void scene_KeyPressed(int i, int i2) throws Exception {
        try {
            if ((this.scene_nCurrentScene & 32768) != 0) {
                transition_KeyPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 8192) != 0) {
                game_KeyPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 4096) != 0) {
                menu_KeyPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 16384) != 0) {
                splash_KeyPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 131072) != 0) {
                limbo_KeyPressed(i, i2);
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4620, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4620, e2.toString());
        }
    }

    void scene_KeyReleased(int i, int i2) {
        if ((this.scene_nCurrentScene & 8192) != 0) {
            game_KeyReleased(i, i2);
        } else if ((this.scene_nCurrentScene & 4096) != 0) {
            menu_KeyReleased(i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x00e1 A[EDGE_INSN: B:106:0x00e1->B:41:0x00e1 BREAK  A[LOOP:0: B:14:0x0046->B:19:0x005a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:11:0x003a A[Catch: Exception -> 0x0090, Error -> 0x00b3, TRY_LEAVE, TryCatch #11 {Error -> 0x00b3, Exception -> 0x0090, blocks: (B:4:0x0007, B:6:0x000d, B:9:0x0035, B:11:0x003a, B:25:0x0080, B:33:0x00a7, B:14:0x0046, B:41:0x00e1, B:47:0x012f, B:83:0x01f9, B:84:0x01fc, B:90:0x0209, B:92:0x021b, B:80:0x01d5, B:82:0x01e9, B:38:0x00c2, B:40:0x00d3, B:21:0x005f, B:23:0x0071, B:88:0x0203, B:7:0x0030, B:12:0x003f, B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5, B:44:0x010f, B:16:0x0049, B:18:0x004f), top: B:96:0x0007, inners: #12, #10, #9, #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004f A[Catch: Exception -> 0x00c1, Error -> 0x00d2, TRY_LEAVE, TryCatch #7 {Error -> 0x00d2, Exception -> 0x00c1, blocks: (B:16:0x0049, B:18:0x004f), top: B:104:0x0049, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x010d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x013a  */
    /* JADX WARN: Code duplicated, block: B:53:0x017f A[Catch: Exception -> 0x0208, Error -> 0x021a, TryCatch #9 {Error -> 0x021a, Exception -> 0x0208, blocks: (B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5), top: B:100:0x013b, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01a7 A[Catch: Exception -> 0x0208, Error -> 0x021a, TryCatch #9 {Error -> 0x021a, Exception -> 0x0208, blocks: (B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5), top: B:100:0x013b, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:6:0x000d A[Catch: Exception -> 0x0090, Error -> 0x00b3, TRY_LEAVE, TryCatch #11 {Error -> 0x00b3, Exception -> 0x0090, blocks: (B:4:0x0007, B:6:0x000d, B:9:0x0035, B:11:0x003a, B:25:0x0080, B:33:0x00a7, B:14:0x0046, B:41:0x00e1, B:47:0x012f, B:83:0x01f9, B:84:0x01fc, B:90:0x0209, B:92:0x021b, B:80:0x01d5, B:82:0x01e9, B:38:0x00c2, B:40:0x00d3, B:21:0x005f, B:23:0x0071, B:88:0x0203, B:7:0x0030, B:12:0x003f, B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5, B:44:0x010f, B:16:0x0049, B:18:0x004f), top: B:96:0x0007, inners: #12, #10, #9, #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c5 A[Catch: Exception -> 0x0208, Error -> 0x021a, TRY_LEAVE, TryCatch #9 {Error -> 0x021a, Exception -> 0x0208, blocks: (B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5), top: B:100:0x013b, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01f9 A[Catch: Exception -> 0x0090, Error -> 0x00b3, LOOP:2: B:52:0x017d->B:83:0x01f9, LOOP_END, TryCatch #11 {Error -> 0x00b3, Exception -> 0x0090, blocks: (B:4:0x0007, B:6:0x000d, B:9:0x0035, B:11:0x003a, B:25:0x0080, B:33:0x00a7, B:14:0x0046, B:41:0x00e1, B:47:0x012f, B:83:0x01f9, B:84:0x01fc, B:90:0x0209, B:92:0x021b, B:80:0x01d5, B:82:0x01e9, B:38:0x00c2, B:40:0x00d3, B:21:0x005f, B:23:0x0071, B:88:0x0203, B:7:0x0030, B:12:0x003f, B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5, B:44:0x010f, B:16:0x0049, B:18:0x004f), top: B:96:0x0007, inners: #12, #10, #9, #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01fc A[Catch: Exception -> 0x0090, Error -> 0x00b3, LOOP:3: B:64:0x01a5->B:84:0x01fc, LOOP_END, TryCatch #11 {Error -> 0x00b3, Exception -> 0x0090, blocks: (B:4:0x0007, B:6:0x000d, B:9:0x0035, B:11:0x003a, B:25:0x0080, B:33:0x00a7, B:14:0x0046, B:41:0x00e1, B:47:0x012f, B:83:0x01f9, B:84:0x01fc, B:90:0x0209, B:92:0x021b, B:80:0x01d5, B:82:0x01e9, B:38:0x00c2, B:40:0x00d3, B:21:0x005f, B:23:0x0071, B:88:0x0203, B:7:0x0030, B:12:0x003f, B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5, B:44:0x010f, B:16:0x0049, B:18:0x004f), top: B:96:0x0007, inners: #12, #10, #9, #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0200 A[PHI: r0
  0x0200: PHI (r0v8 TheGame$MintMesh[]) = (r0v7 TheGame$MintMesh[]), (r0v37 TheGame$MintMesh[]), (r0v41 TheGame$MintMesh[]), (r0v44 TheGame$MintMesh[]) binds: [B:5:0x000b, B:85:0x01ff, B:90:0x0209, B:93:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x0203 A[Catch: Exception -> 0x0090, Error -> 0x00b3, TryCatch #11 {Error -> 0x00b3, Exception -> 0x0090, blocks: (B:4:0x0007, B:6:0x000d, B:9:0x0035, B:11:0x003a, B:25:0x0080, B:33:0x00a7, B:14:0x0046, B:41:0x00e1, B:47:0x012f, B:83:0x01f9, B:84:0x01fc, B:90:0x0209, B:92:0x021b, B:80:0x01d5, B:82:0x01e9, B:38:0x00c2, B:40:0x00d3, B:21:0x005f, B:23:0x0071, B:88:0x0203, B:7:0x0030, B:12:0x003f, B:51:0x013b, B:53:0x017f, B:59:0x018b, B:60:0x0192, B:62:0x0198, B:63:0x019a, B:65:0x01a7, B:71:0x01b3, B:72:0x01ba, B:74:0x01c0, B:77:0x01c5, B:44:0x010f, B:16:0x0049, B:18:0x004f), top: B:96:0x0007, inners: #12, #10, #9, #8, #7 }] */
    boolean scene_LoadM3GMesh(String str, int i, boolean z) {
        Object3D[] object3DArrLoad;
        int length;
        MintMesh[] mintMeshArr;
        int i2;
        int i3;
        DataInputStream dataInputStream;
        int i4;
        byte[] bArr;
        byte[] bArr2;
        int i5;
        int i6;
        int i7;
        Mesh mesh;
        byte[] bArr3 = null;
        MintMesh[] mintMeshArrScene_FindMintMesh = null;
        int iAvailable = 0;
        int i8 = 0;
        if (z) {
            try {
                mintMeshArrScene_FindMintMesh = scene_FindMintMesh(str);
                if (mintMeshArrScene_FindMintMesh == null) {
                    try {
                        object3DArrLoad = Loader.load(new StringBuffer().append("/").append(str).append("_m3g/").append(str).append(".m3g").toString());
                        while (true) {
                            i3 = i2;
                            if (i3 < object3DArrLoad.length) {
                                break;
                            }
                            try {
                                mesh = (Mesh) object3DArrLoad[i3];
                                if (mesh != null) {
                                    mintMeshArr[i3] = new MintMesh(this);
                                    mintMeshArr[i3].m_mesh = mesh;
                                }
                            } catch (Error e) {
                                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5447, e.toString());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5447, e2.toString());
                            }
                            i2 = i3 + 1;
                        }
                    } catch (Error e3) {
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5417, e3.toString());
                        object3DArrLoad = null;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5417, e4.toString());
                        object3DArrLoad = null;
                    }
                    length = object3DArrLoad.length;
                    mintMeshArr = new MintMesh[length];
                    if (z) {
                        try {
                            this.vObjectList.addElement(new ObjectRef(this, str, mintMeshArr));
                        } catch (Error e5) {
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5430, e5.toString());
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5430, e6.toString());
                        }
                    }
                    i2 = 0;
                    dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(str).append("_fm3d/").append(str).append(".fm3d").toString()));
                    if (dataInputStream == null) {
                        return false;
                    }
                    try {
                        iAvailable = dataInputStream.available();
                        bArr3 = new byte[iAvailable];
                        dataInputStream.readFully(bArr3);
                        dataInputStream.close();
                        i8 = 2;
                        length = (short) ((bArr3[0] & 255) | ((bArr3[1] & 255) << 8));
                        i4 = iAvailable;
                        bArr = bArr3;
                    } catch (Error e7) {
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5472, e7.toString());
                        i4 = iAvailable;
                        bArr = bArr3;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5472, e8.toString());
                        i4 = iAvailable;
                        bArr = bArr3;
                    }
                    bArr2 = new byte[30];
                    bArr2[0] = 47;
                    for (i5 = 0; i5 < length; i5++) {
                        i6 = 1;
                        try {
                            int i9 = (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24);
                            int i10 = i8 + 4;
                            int i11 = (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
                            i8 = i10 + 4;
                            while (i8 < i4) {
                                if (bArr[i8] != 10 && (i6 < 4 || i != 3)) {
                                    bArr2[i6] = bArr[i8];
                                    i6++;
                                }
                                if (bArr[i8] == 10) {
                                    i8++;
                                    break;
                                }
                                i8++;
                            }
                            mintMeshArr[i5].m_meshName = new String(bArr2, 0, i6);
                            i7 = 1;
                            while (i8 < i4) {
                                if (bArr[i8] != 10 && (i7 < 4 || i != 3)) {
                                    bArr2[i7] = bArr[i8];
                                    i7++;
                                }
                                if (bArr[i8] == 10) {
                                    i8++;
                                    break;
                                }
                                i8++;
                            }
                            if (i != 3) {
                                mintMeshArr[i5].m_textureName = new String(bArr2, 0, i7);
                            }
                        } catch (Error e9) {
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5548, e9.toString());
                            mintMeshArrScene_FindMintMesh = mintMeshArr;
                            if (i == 3) {
                                scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
                            }
                            System.gc();
                            return true;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5548, e10.toString());
                            mintMeshArrScene_FindMintMesh = mintMeshArr;
                            if (i == 3) {
                                scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
                            }
                            System.gc();
                            return true;
                        }
                    }
                    mintMeshArrScene_FindMintMesh = mintMeshArr;
                    if (i == 3) {
                        scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
                    }
                } else if (i == 3) {
                    scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
                }
            } catch (Error e11) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5558, e11.toString());
            } catch (Exception e12) {
                e12.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5558, e12.toString());
            }
        } else if (mintMeshArrScene_FindMintMesh == null) {
            object3DArrLoad = Loader.load(new StringBuffer().append("/").append(str).append("_m3g/").append(str).append(".m3g").toString());
            length = object3DArrLoad.length;
            mintMeshArr = new MintMesh[length];
            if (z) {
                this.vObjectList.addElement(new ObjectRef(this, str, mintMeshArr));
            }
            i2 = 0;
            while (true) {
                i3 = i2;
                if (i3 < object3DArrLoad.length) {
                    break;
                    break;
                }
                mesh = (Mesh) object3DArrLoad[i3];
                if (mesh != null) {
                    mintMeshArr[i3] = new MintMesh(this);
                    mintMeshArr[i3].m_mesh = mesh;
                }
                i2 = i3 + 1;
            }
            dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(str).append("_fm3d/").append(str).append(".fm3d").toString()));
            if (dataInputStream == null) {
                return false;
            }
            iAvailable = dataInputStream.available();
            bArr3 = new byte[iAvailable];
            dataInputStream.readFully(bArr3);
            dataInputStream.close();
            i8 = 2;
            length = (short) ((bArr3[0] & 255) | ((bArr3[1] & 255) << 8));
            i4 = iAvailable;
            bArr = bArr3;
            bArr2 = new byte[30];
            bArr2[0] = 47;
            while (i5 < length) {
                i6 = 1;
                int i12 = (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24);
                int i13 = i8 + 4;
                int i14 = (bArr[i13] & 255) | ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13 + 2] & 255) << 16) | ((bArr[i13 + 3] & 255) << 24);
                i8 = i13 + 4;
                while (i8 < i4) {
                    if (bArr[i8] != 10) {
                        bArr2[i6] = bArr[i8];
                        i6++;
                    }
                    if (bArr[i8] == 10) {
                        i8++;
                        break;
                    }
                    i8++;
                }
                mintMeshArr[i5].m_meshName = new String(bArr2, 0, i6);
                i7 = 1;
                while (i8 < i4) {
                    if (bArr[i8] != 10) {
                        bArr2[i7] = bArr[i8];
                        i7++;
                    }
                    if (bArr[i8] == 10) {
                        i8++;
                        break;
                    }
                    i8++;
                }
                if (i != 3) {
                    mintMeshArr[i5].m_textureName = new String(bArr2, 0, i7);
                }
            }
            mintMeshArrScene_FindMintMesh = mintMeshArr;
            if (i == 3) {
                scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
            }
        } else if (i == 3) {
            scene_LoadTrackTextures(mintMeshArrScene_FindMintMesh);
        }
        System.gc();
        return true;
    }

    boolean scene_LoadMeshTexture(Mesh mesh, String str, int i) {
        Texture2D texture2DScene_FindTexture = (i == 1 || i == 2) ? null : scene_FindTexture(str);
        if (texture2DScene_FindTexture == null) {
            texture2DScene_FindTexture = scene_CreateTexture(str, scene_LoadTexImage(str), (i == 1 || i == 2) ? false : true, false);
        }
        try {
            this.appearance = mesh.getAppearance(0);
            if (this.appearance == null) {
                this.appearance = new Appearance();
                mesh.setAppearance(0, this.appearance);
            }
            this.appearance.setTexture(0, texture2DScene_FindTexture);
            this.appearance.setPolygonMode(this.polygonMode_NoPersp);
            if (this.tex_ref != null && this.tex_ref.m_alpha) {
                this.appearance.setCompositingMode(this.compositingMode_ZREAD_Alpha);
            } else {
                this.appearance.setCompositingMode(this.compositingMode_ZWRITEREAD);
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5350, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5350, e2.toString());
        }
        this.appearance = null;
        return true;
    }

    short[][] scene_LoadPVS(String str) {
        if (this.track_pvsStruct == null) {
            this.track_pvsStruct = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 200, 90);
            this.track_pvsMask = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 200, 90);
            this.track_pvsXYZ = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 200, 3);
        }
        for (int i = 0; i < 200; i++) {
            for (int i2 = 0; i2 < 90; i2++) {
                this.track_pvsStruct[i][i2] = -1;
                this.track_pvsMask[i][i2] = 0;
            }
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append(str).append("_pvs/").append(str).append(".pvs").toString()));
            int iAvailable = dataInputStream.available();
            this.track_pvsXYZ[0][0] = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
            this.track_pvsXYZ[0][1] = (short) (-((short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8))));
            this.track_pvsXYZ[0][2] = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
            int i3 = 6;
            short sMax = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < iAvailable) {
                short s = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
                short s2 = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
                i3 += 4;
                if (s2 != -1) {
                    this.track_pvsMask[i5][i4] = s;
                    this.track_pvsStruct[i5][i4] = s2;
                    sMax = (short) Math.max(i4, (int) sMax);
                    i4++;
                } else {
                    this.track_pvsStruct[i5][i4] = -1;
                    i5++;
                    if (i3 + 6 < iAvailable) {
                        this.track_pvsXYZ[i5][0] = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
                        this.track_pvsXYZ[i5][1] = (short) (-((short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8))));
                        this.track_pvsXYZ[i5][2] = (short) ((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8));
                        i3 += 6;
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                }
            }
            dataInputStream.close();
            this.track_maxPVSi = sMax;
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5106, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5106, e2.toString());
        }
        return this.track_pvsStruct;
    }

    Image scene_LoadTexImage(String str) {
        try {
            int iIndexOf = str.indexOf(".png");
            if (iIndexOf <= 0) {
                return null;
            }
            return Image.createImage(new StringBuffer().append(new StringBuffer().append(str.substring(0, iIndexOf)).append("_png").toString()).append(str).toString());
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5260, e.toString());
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5260, e2.toString());
            return null;
        }
    }

    void scene_LoadTrackSplines(int i) {
        loadSplineSet(this.g_trackPaths[i].m_AISpline, 0);
        if (this.g_race.m_type == 1) {
            loadSplineSet(this.g_trackPaths[i].m_AISpline, 1);
        }
        loadSplineSet(this.g_trackPaths[i].m_trafficSpline, 2);
    }

    void scene_LoadTrackTextures(MintMesh[] mintMeshArr) {
        if (mintMeshArr == null) {
            return;
        }
        int length = mintMeshArr.length;
        this.trackBarrier1Count = 0;
        this.trackBarrier2Count = 0;
        this.trackBarrier3Count = 0;
        this.trackBarrier4Count = 0;
        this.numTrackItems = 0;
        for (int i = 0; i < 20; i++) {
            this.trackBarrier1[i] = null;
            this.trackBarrier2[i] = null;
            this.trackBarrier3[i] = null;
            this.trackBarrier4[i] = null;
        }
        for (int i2 = 0; i2 < this.trackMeshs.length; i2++) {
            this.trackMeshs[i2] = null;
            this.trackIsMesh[i2] = false;
        }
        System.gc();
        int length2 = mintMeshArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            try {
                if (mintMeshArr[i3].m_meshName.startsWith("/c1_") || mintMeshArr[i3].m_meshName.startsWith("/C1_")) {
                    this.trackBarrier1[this.trackBarrier1Count] = mintMeshArr[i3].m_mesh;
                    this.trackBarrier1Count++;
                    mintMeshArr[i3].m_mesh.getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                } else if (mintMeshArr[i3].m_meshName.startsWith("/c2_") || mintMeshArr[i3].m_meshName.startsWith("/C2_")) {
                    this.trackBarrier2[this.trackBarrier2Count] = mintMeshArr[i3].m_mesh;
                    this.trackBarrier2Count++;
                    mintMeshArr[i3].m_mesh.getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                } else if (mintMeshArr[i3].m_meshName.startsWith("/c3_") || mintMeshArr[i3].m_meshName.startsWith("/C3_")) {
                    this.trackBarrier3[this.trackBarrier3Count] = mintMeshArr[i3].m_mesh;
                    this.trackBarrier3Count++;
                    mintMeshArr[i3].m_mesh.getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                } else if (mintMeshArr[i3].m_meshName.startsWith("/c4_") || mintMeshArr[i3].m_meshName.startsWith("/C4_")) {
                    this.trackBarrier4[this.trackBarrier4Count] = mintMeshArr[i3].m_mesh;
                    this.trackBarrier4Count++;
                    mintMeshArr[i3].m_mesh.getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                } else if (mintMeshArr[i3].m_meshName.startsWith("/sky")) {
                    this.skyDome = mintMeshArr[i3].m_mesh;
                    Appearance appearance = this.skyDome.getAppearance(0);
                    appearance.setCompositingMode(this.compositingMode_ZNONE);
                    appearance.setPolygonMode(this.polygonMode_NoPersp);
                    appearance.setTexture(0, (Texture2D) null);
                    if (this.g_trackPaths[this.g_race.m_trackPath].m_nWorld == 0) {
                        this.skyDome.getVertexBuffer().setDefaultColor(12437180);
                    } else {
                        this.skyDome.getVertexBuffer().setDefaultColor(11386309);
                    }
                } else {
                    this.trackMeshs[this.numTrackItems] = mintMeshArr[i3].m_mesh;
                    this.trackIsMesh[this.numTrackItems] = true;
                    mintMeshArr[i3].m_mesh.getAppearance(0).setPolygonMode(this.polygonMode_Persp);
                }
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5675, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 5675, e2.toString());
            }
            this.numTrackItems++;
        }
    }

    boolean scene_OpenModel(String str, int i, boolean z) {
        while (!scene_LoadM3GMesh(str, i, z)) {
        }
        return false;
    }

    void scene_Pause(boolean z) {
        this.game_nKeyPressed = (byte) 0;
        this.game_nTimeKeyHeld = (short) 0;
        if (!z) {
            this.system_bReRenderSoftKeys = true;
            return;
        }
        if ((this.scene_nCurrentScene & 8192) != 0) {
            try {
                game_Pause();
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4423, e.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4423, e2.toString());
            }
        }
    }

    void scene_PlaySoundNowIfPossible(int i) {
        if (this.scene_lastSnd == i) {
            return;
        }
        asset_StopSound(-1);
        asset_PlaySoundNowIfPossible(i);
        this.scene_lastSnd = i;
    }

    void scene_PointerPressed(int i, int i2) throws Exception {
        try {
            if ((this.scene_nCurrentScene & 8192) != 0) {
                game_PointerPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 4096) != 0) {
                menu_PointerPressed(i, i2);
            } else if ((this.scene_nCurrentScene & 16384) != 0) {
                splash_PointerPressed(i, i2);
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4577, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4577, e2.toString());
        }
    }

    void scene_PointerReleased(int i, int i2) throws Exception {
        try {
            if ((this.scene_nCurrentScene & 8192) != 0) {
                game_PointerReleased(i, i2);
            } else if ((this.scene_nCurrentScene & 4096) != 0) {
                menu_PointerReleased(i, i2);
            } else if ((this.scene_nCurrentScene & 16384) != 0) {
                splash_PointerReleased(i, i2);
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4594, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4594, e2.toString());
        }
    }

    void scene_Render() {
        try {
            if ((this.scene_nCurrentScene & 32768) != 0) {
                transition_Render();
            } else if ((this.scene_nCurrentScene & 8192) != 0) {
                game_Render();
            } else if ((this.scene_nCurrentScene & 4096) != 0) {
                menu_Render();
            } else if ((this.scene_nCurrentScene & 16384) != 0) {
                splash_Render();
            } else if ((this.scene_nCurrentScene & 131072) != 0) {
                limbo_Render();
            }
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4776, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4776, e2.toString());
        }
    }

    void scene_Show(boolean z) {
        this.game_nKeyPressed = (byte) 0;
        this.game_nTimeKeyHeld = (short) 0;
        if (z) {
            return;
        }
        if ((this.scene_nCurrentScene & 8192) != 0) {
            try {
                scene_Pause(true);
                return;
            } catch (Exception e) {
                system_End();
                m_Midlet.notifyDestroyed();
                return;
            }
        }
        if ((this.scene_nCurrentScene & 4096) != 0) {
            menu_showPauseScreen();
        } else if ((this.scene_nCurrentScene & 16384) != 0) {
            this.menu_SplashPause = true;
        }
    }

    void scene_Start() throws Exception {
        if ((this.scene_nCurrentScene & 8192) != 0) {
            try {
                game_Start();
                return;
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4363, e.toString());
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4363, e2.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 4096) != 0) {
            try {
                menu_Start();
                return;
            } catch (Error e3) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4372, e3.toString());
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4372, e4.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 16384) != 0) {
            try {
                asset_LoadSound(this.scene_musicTracks[0], -1);
                asset_FreeSound(this.scene_musicTracks[0]);
                splash_Start();
            } catch (Error e5) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4387, e5.toString());
            } catch (Exception e6) {
                e6.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4387, e6.toString());
            }
        }
    }

    void scene_Transition(int i) throws Exception {
        scene_End();
        System.gc();
        this.scene_nCurrentScene = i;
        scene_Start();
    }

    void scene_Update(int i) throws Exception {
        if (this.scene_timerUpdate) {
            this.scene_timer += i;
        }
        if ((this.scene_nCurrentScene & 32768) != 0) {
            try {
                transition_Update(i);
                return;
            } catch (Error e) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4524, e.toString());
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4524, e2.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 8192) != 0) {
            try {
                game_Update(i);
                return;
            } catch (Error e3) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4532, e3.toString());
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4532, e4.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 4096) != 0) {
            try {
                menu_Update(i);
                return;
            } catch (Error e5) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4540, e5.toString());
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4540, e6.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 16384) != 0) {
            try {
                splash_Update(i);
                return;
            } catch (Error e7) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4548, e7.toString());
                return;
            } catch (Exception e8) {
                e8.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4548, e8.toString());
                return;
            }
        }
        if ((this.scene_nCurrentScene & 131072) != 0) {
            try {
                limbo_Update(i);
            } catch (Error e9) {
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4556, e9.toString());
            } catch (Exception e10) {
                e10.printStackTrace();
                AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 4556, e10.toString());
            }
        }
    }

    boolean scene_createReflectionMesh(NFSMW_CarAppearance nFSMW_CarAppearance) {
        nFSMW_CarAppearance.m_reflectionMesh = null;
        while (scene_OpenModel(new StringBuffer().append(nFSMW_CarAppearance.m_modelName).append("_reflection").toString(), 1, true)) {
        }
        nFSMW_CarAppearance.m_reflectionMesh = scene_FindMintMesh(new StringBuffer().append(nFSMW_CarAppearance.m_modelName).append("_reflection").toString())[0].m_mesh;
        Appearance appearance = nFSMW_CarAppearance.m_reflectionMesh.getAppearance(0);
        appearance.setPolygonMode(this.polygonMode_NoPersp);
        appearance.setCompositingMode(this.compositingMode_ZNONE_AlphaAdd);
        try {
            Texture2D texture2D = new Texture2D(new Image2D(100, Image.createImage("/reflection_png/reflection.png")));
            texture2D.setFiltering(208, 210);
            texture2D.setWrapping(241, 241);
            texture2D.setBlending(228);
            appearance.setTexture(0, texture2D);
        } catch (Error e) {
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 6133, e.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            AssertExtra(0, "c:\\mobiledevelopment\\nfsmw_cn\\src\\scene_share.hpp", 6133, e2.toString());
        }
        return true;
    }

    boolean scene_createStreaks(NFSMW_CarAppearance nFSMW_CarAppearance) {
        VertexArray vertexArray = new VertexArray(3, 3, 2);
        VertexArray vertexArray2 = new VertexArray(3, 2, 2);
        short[] sArr = {255, 255, 0, 0, 255, 255, 0, 0, 255, 255, 0, 0};
        vertexArray.set(0, 3, new short[]{-100, 0, 0, 0, 0, 3000, 100, 0, 0});
        vertexArray2.set(0, 3, new short[]{0, 0, 1, 1, 2, 0});
        nFSMW_CarAppearance.m_streakVertices = new VertexBuffer();
        nFSMW_CarAppearance.m_streakVertices.setDefaultColor(-65536);
        nFSMW_CarAppearance.m_streakVertices.setPositions(vertexArray, 0.001f, (float[]) null);
        nFSMW_CarAppearance.m_streakVertices.setTexCoords(0, vertexArray2, 0.5f, (float[]) null);
        nFSMW_CarAppearance.m_streakIndexBuffer = new TriangleStripArray(new int[]{0, 1, 2}, new int[]{3});
        Texture2D texture2DScene_FindTexture = scene_FindTexture("/speed_effect.png");
        if (texture2DScene_FindTexture == null) {
            texture2DScene_FindTexture = scene_CreateTexture("/speed_effect.png", scene_LoadTexImage("/speed_effect.png"), true, true);
        }
        if (texture2DScene_FindTexture != null) {
            nFSMW_CarAppearance.m_streakTexture = texture2DScene_FindTexture;
            nFSMW_CarAppearance.m_streakTexture.setBlending(227);
        }
        nFSMW_CarAppearance.m_streakAppearance = new Appearance();
        nFSMW_CarAppearance.m_streakAppearance.setTexture(0, texture2DScene_FindTexture);
        nFSMW_CarAppearance.m_streakAppearance.setPolygonMode(this.polygonMode_NoPersp);
        nFSMW_CarAppearance.m_streakAppearance.setCompositingMode(this.compositingMode_ZREAD_Alpha);
        Texture2D texture2DScene_FindTexture2 = scene_FindTexture("/speedNitro_effect.png");
        if (texture2DScene_FindTexture2 == null) {
            texture2DScene_FindTexture2 = scene_CreateTexture("/speedNitro_effect.png", scene_LoadTexImage("/speedNitro_effect.png"), true, true);
        }
        if (texture2DScene_FindTexture2 != null) {
            nFSMW_CarAppearance.m_streakNitroTexture = texture2DScene_FindTexture2;
            nFSMW_CarAppearance.m_streakNitroTexture.setBlending(227);
        }
        nFSMW_CarAppearance.m_streakNitroAppearance = new Appearance();
        nFSMW_CarAppearance.m_streakNitroAppearance.setTexture(0, texture2DScene_FindTexture2);
        nFSMW_CarAppearance.m_streakNitroAppearance.setPolygonMode(this.polygonMode_NoPersp);
        nFSMW_CarAppearance.m_streakNitroAppearance.setCompositingMode(this.compositingMode_ZREAD_Alpha);
        return true;
    }

    void scene_freeWorld() {
    }

    public synchronized void showNotify() {
        system_Show();
    }

    void splash_End() {
        this.splash_CheatKeyArray = null;
        asset_FreeImage(616);
    }

    void splash_KeyPressed(int i, int i2) throws Exception {
        if (i == this.splash_CheatKeyArray[this.splash_nCheatKey]) {
            this.splash_nTimeInState -= 500;
            if (this.splash_nTimeInState < 0) {
                this.splash_nTimeInState = 0;
            }
            this.splash_nCheatKey++;
            if (this.splash_nCheatKey == 5) {
                this.system_bCheat = true;
                scene_Transition(4097);
                return;
            }
            return;
        }
        if (this.splash_nTimeInState >= 500) {
            if (this.splash_nState == 1) {
                if (i == -6 || i2 == 8 || i == 53) {
                    LoadLanguage(this.splash_langSelection);
                    saveCurLang();
                    this.g_race.m_bMission = false;
                    this.menuCurrent = this.menuRoot;
                    this.menuRoot.m_selected = 0;
                    this.splash_nTimeInState = 0;
                    this.splash_bRendered = false;
                    this.splash_nState++;
                } else {
                    if ((i2 == 2 || i == 52) && this.splash_langSelection > 0) {
                        this.splash_langSelection = (byte) (this.splash_langSelection - 1);
                    } else if ((i2 == 5 || i == 54) && this.splash_langSelection < 1) {
                        this.splash_langSelection = (byte) (this.splash_langSelection + 1);
                    }
                    if ((i2 == 1 || i == 50) && this.splash_langSelection > 0) {
                        this.splash_langSelection = (byte) (this.splash_langSelection - 1);
                    } else if ((i2 == 6 || i == 56) && this.splash_langSelection < 1) {
                        this.splash_langSelection = (byte) (this.splash_langSelection + 1);
                    }
                }
            } else if (this.splash_nTimeInState > 3000) {
                this.splash_nTimeInState = 0;
                this.splash_bRendered = false;
                this.splash_nState++;
                if (this.splash_nState == 1 && loadLastLang()) {
                    this.splash_nState++;
                }
            }
            if (this.splash_nState >= 2) {
                scene_Transition(4097);
            }
        }
    }

    void splash_PointerPressed(int i, int i2) throws Exception {
        if (this.splash_nTimeInState < 500) {
            return;
        }
        if (this.splash_nState == 1) {
            if (i2 > 38 && i2 < 78) {
                this.splash_langSelection = (byte) 0;
            } else if (i2 > 78 && i2 < 120) {
                this.splash_langSelection = (byte) 1;
            }
        } else if (this.splash_nTimeInState > 3000) {
            this.splash_nTimeInState = 0;
            this.splash_bRendered = false;
            this.splash_nState++;
            if (this.splash_nState == 1 && loadLastLang()) {
                this.splash_nState++;
            }
        }
        if (this.splash_nState >= 2) {
            scene_Transition(4097);
        }
    }

    void splash_PointerReleased(int i, int i2) throws Exception {
    }

    void splash_Render() {
        this.splash_bRendered = true;
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        switch (this.splash_nState) {
            case 0:
                system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
                asset_DrawImage(616, (this.system_nCanvasWidth >> 1) - 88, (this.system_nCanvasHeight >> 1) - 74);
                break;
            case 1:
                system_FillRect(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight, 0);
                system_FillRect(30, (this.splash_langSelection * 42) + 42, this.system_nCanvasWidth - 60, 36, 8429708);
                this.font_ingame.DrawSubstring("ENGLISH", 0, "ENGLISH".length(), this.system_nCanvasWidth >> 1, 51, 1);
                this.font_ingame.DrawSubstring("繁體中文", 0, "繁體中文".length(), this.system_nCanvasWidth >> 1, 93, 1);
                if (this.splash_langSelection == 0) {
                    this.g_Text[3] = "SELECT";
                } else {
                    this.g_Text[3] = "選擇";
                }
                drawSoftKey(3, 0);
                break;
        }
    }

    void splash_Start() throws Exception {
        asset_LoadImage(616, false);
        this.splash_CheatKeyArray = new int[5];
        this.splash_CheatKeyArray[0] = 35;
        this.splash_CheatKeyArray[1] = 49;
        this.splash_CheatKeyArray[2] = 50;
        this.splash_CheatKeyArray[3] = 51;
        this.splash_CheatKeyArray[4] = 35;
        this.splash_nCheatKey = 0;
        this.splash_nTimeInState = 0;
        this.splash_nState = 0;
        this.splash_bRendered = false;
    }

    void splash_Update(int i) throws Exception {
        if (this.splash_bRendered) {
            this.splash_nTimeInState += i;
            if (this.splash_nState == 1 || this.splash_nTimeInState <= 4000) {
                return;
            }
            this.splash_nTimeInState = 0;
            this.splash_bRendered = false;
            this.splash_nState++;
            if (this.splash_nState == 1 && loadLastLang()) {
                this.splash_nState++;
            }
            if (this.splash_nState >= 2) {
                scene_Transition(4097);
            }
        }
    }

    int system_Abs(int i) {
        return i < 0 ? -i : i;
    }

    void system_ClearDirtyRects() {
        this.system_xDirty = 0;
        this.system_yDirty = 0;
        this.system_nDirtyWidth = -1;
        this.system_nDirtyHeight = -1;
    }

    void system_Construct() {
        this.system_bInitialised = false;
        this.system_bAppPaused = true;
        this.system_bExit = false;
        this.system_bUpdateDirty = false;
        this.system_bReRenderSoftKeys = false;
        this.system_bCheat = false;
    }

    void system_Destroy() {
    }

    void system_DrawLine(int i, int i2, int i3, int i4, int i5) {
        m_CurrentGraphics.setColor(i5);
        m_CurrentGraphics.setClip(this.system_xClip, this.system_yClip, this.system_nClipWidth, this.system_nClipHeight);
        m_CurrentGraphics.drawLine(i, i2, i3, i4);
    }

    void system_DrawRect(int i, int i2, int i3, int i4, int i5) {
        m_CurrentGraphics.setColor(i5);
        m_CurrentGraphics.setClip(this.system_xClip, this.system_yClip, this.system_nClipWidth, this.system_nClipHeight);
        m_CurrentGraphics.drawRect(i, i2, i3, i4);
    }

    void system_End() {
        this.system_bAppPaused = true;
        if (this.system_bInitialised) {
            scene_End();
            if ((this.scene_nCurrentScene & 8192) != 0) {
                game_End();
            }
            scene_Destroy();
            system_FreeSoftkeys();
            asset_FreeData();
            this.system_bInitialised = false;
            this.system_bExit = true;
            this.scene_nCurrentScene = 0;
        }
    }

    void system_FillRect(int i, int i2, int i3, int i4, int i5) {
        m_CurrentGraphics.setColor(i5);
        m_CurrentGraphics.setClip(this.system_xClip, this.system_yClip, this.system_nClipWidth, this.system_nClipHeight);
        m_CurrentGraphics.fillRect(i, i2, i3, i4);
    }

    int system_FindFirst(String str, int i, int i2, char c) {
        while (i < i2 && str.charAt(i) != c) {
            i++;
        }
        return i;
    }

    void system_FreeSoftkeys() {
        system_SetSoftkeys(0, 0);
        system_imageFirstSoftkey = null;
        system_imageSecondSoftkey = null;
    }

    int system_GetRandom() {
        return this.system_Random.nextInt();
    }

    int system_GetVolume() {
        return this.system_nVolume;
    }

    void system_Hide() {
        scene_Show(false);
        this.system_bAppPaused = true;
    }

    void system_InitSaveGame() {
        this.system_nSaveLevel = 0;
        this.system_nContLevel = 0;
        this.system_nSaveDifficulty = 0;
        this.system_nSaveScore = 0;
        this.system_nScoreSlot = -1;
    }

    void system_InitSoftkeys() throws Exception {
        this.system_SoftkeyFont = new CFont(this, null);
        this.system_SoftkeyFont.Construct();
        this.system_SoftkeyFont.SetSystem(Font.getFont(64, 0, 8));
        system_CalculateSoftkeySizes();
        if (this.system_nCanvasWidth - (this.system_nSoftkeyWidth << 1) < (this.system_nSoftkeyWidth >> 1)) {
            system_CalculateSoftkeySizes();
        }
        this.system_softkeyBackground = 16777215;
        this.system_softkeyColor = 0;
        system_imageFirstSoftkey = Image.createImage(this.system_nSoftkeyWidth, this.system_nSoftkeyHeight);
        system_imageSecondSoftkey = Image.createImage(this.system_nSoftkeyWidth, this.system_nSoftkeyHeight);
        system_graphicsFirstSoftkey = system_imageFirstSoftkey.getGraphics();
        system_graphicsSecondSoftkey = system_imageSecondSoftkey.getGraphics();
    }

    void system_InitSoundSettings() {
        this.system_bSoundOn = true;
        this.system_nVolume = 2;
    }

    void system_LoadAllConfigs() {
        system_InitSaveGame();
        system_InitSoundSettings();
        byte[] bArr = new byte[32];
        int[] iArr = new int[8];
        try {
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("config", false);
            recordStoreOpenRecordStore.getRecord(1, bArr, 0);
            recordStoreOpenRecordStore.closeRecordStore();
            for (int i = 0; i < 8; i++) {
                int i2 = i << 2;
                iArr[i] = (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
            }
            if (iArr[0] != 3) {
                system_SaveAllConfigs();
                return;
            }
            this.system_bSoundOn = iArr[1] != 0;
            this.system_nVolume = iArr[2];
            this.system_bSoundOn = true;
            System.out.println(new StringBuffer().append("Loading system volume = ").append(this.system_nVolume).append(" sound on = ").append(this.system_bSoundOn).toString());
            Assert(3 <= 8, "c:\\mobiledevelopment\\nfsmw_cn\\ndplatformjava\\system_java.hpp", 693);
        } catch (Exception e) {
            system_InitSaveGame();
            system_InitSoundSettings();
            system_SaveAllConfigs();
        } catch (RecordStoreNotFoundException e2) {
            system_SaveAllConfigs();
        }
    }

    void system_RenderSoftkeys(boolean z) {
        m_CurrentGraphics.setClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
        if (this.system_nFirstSoftkey != 0) {
            m_CurrentGraphics.drawImage(system_imageFirstSoftkey, 0, this.system_nCanvasHeight, 36);
        }
        if (this.system_nSecondSoftkey != 0) {
            m_CurrentGraphics.drawImage(system_imageSecondSoftkey, this.system_nCanvasWidth, this.system_nCanvasHeight, 40);
        }
    }

    void system_RenderToSoftkey(Graphics graphics, int i) {
        Graphics graphics2 = m_CurrentGraphics;
        m_CurrentGraphics = graphics;
        graphics.setClip(0, 0, this.system_nSoftkeyWidth, this.system_nSoftkeyHeight);
        graphics.setColor(this.system_softkeyBackground);
        graphics.setColor(0, 0, 0);
        graphics.fillRect(0, 0, this.system_nSoftkeyWidth, this.system_nSoftkeyHeight);
        for (int i2 = 0; i2 < this.system_nSoftkeyHeight; i2++) {
            int iAbs = 130 - (Math.abs((this.system_nSoftkeyHeight >> 1) - i2) * (130 / (this.system_nSoftkeyHeight >> 1)));
            graphics.setColor(iAbs, iAbs, (iAbs * 120) / 100);
            graphics.drawLine(0, i2, this.system_nSoftkeyWidth, i2);
        }
        graphics.setColor(0, 0, 0);
        graphics.drawRect(0, 0, this.system_nSoftkeyWidth - 1, this.system_nSoftkeyHeight - 1);
        this.system_SoftkeyFont.SetColor(this.system_softkeyColor);
        system_SetClip(0, 0, this.system_nSoftkeyWidth, this.system_nSoftkeyHeight);
        this.system_SoftkeyFont.DrawSubstring(this.system_sSoftkeyArray[i & 65535], 0, this.system_sSoftkeyArray[i & 65535].length(), this.system_nSoftkeyWidth >> 1, (this.system_nSoftkeyHeight >> 1) + 1, 5);
        m_CurrentGraphics = graphics2;
        system_SetClip(0, 0, this.system_nCanvasWidth, this.system_nCanvasHeight);
    }

    void system_SaveAllConfigs() {
        int[] iArr = new int[8];
        iArr[0] = 3;
        System.out.println(new StringBuffer().append("Saving system volume = ").append(this.system_nVolume).toString());
        iArr[1] = this.system_bSoundOn ? 1 : 0;
        iArr[2] = this.system_nVolume;
        Assert(true, "c:\\mobiledevelopment\\nfsmw_cn\\ndplatformjava\\system_java.hpp", 566);
        byte[] bArr = new byte[12];
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            int i3 = i << 2;
            bArr[i3] = (byte) (i2 >> 24);
            bArr[i3 + 1] = (byte) (i2 >> 16);
            bArr[i3 + 2] = (byte) (i2 >> 8);
            bArr[i3 + 3] = (byte) i2;
        }
        try {
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore("config", true);
            if (recordStoreOpenRecordStore.getNumRecords() == 0) {
                recordStoreOpenRecordStore.addRecord(bArr, 0, bArr.length);
            } else {
                recordStoreOpenRecordStore.setRecord(1, bArr, 0, bArr.length);
            }
            recordStoreOpenRecordStore.closeRecordStore();
        } catch (Exception e) {
        }
    }

    void system_SeedRandom(int i) {
        this.system_Random.setSeed(i);
    }

    void system_SetClip(int i, int i2, int i3, int i4) {
        this.system_xClip = i;
        this.system_yClip = i2;
        this.system_nClipWidth = i3;
        this.system_nClipHeight = i4;
    }

    void system_SetScreenDirty() {
        this.system_bScreenDirty = true;
    }

    void system_SetSoftkeys(int i, int i2) {
        this.system_nFirstSoftkey = i2;
        this.system_nSecondSoftkey = i;
        if (this.system_nFirstSoftkey != 0 && system_imageFirstSoftkey != null) {
            system_RenderToSoftkey(system_graphicsFirstSoftkey, this.system_nFirstSoftkey);
        }
        if (this.system_nSecondSoftkey == 0 || system_imageSecondSoftkey == null) {
            return;
        }
        system_RenderToSoftkey(system_graphicsSecondSoftkey, this.system_nSecondSoftkey);
    }

    void system_SetVolume(int i) {
        this.system_nVolume = i;
        if (i > 0) {
            this.system_bSoundOn = true;
        } else {
            this.system_bSoundOn = false;
        }
        asset_ChangeVolume(this.system_nVolume);
    }

    void system_Show() {
        this.system_bAppPaused = false;
        this.system_nLastTime = System.currentTimeMillis();
        scene_Show(true);
    }

    void system_Start() throws Exception {
        if (this.system_bInitialised) {
            return;
        }
        this.system_nCanvasWidth = getWidth();
        this.system_nCanvasHeight = getHeight();
        setFullScreenMode(true);
        this.system_nCanvasHeight = 320;
        this.system_xClip = 0;
        this.system_yClip = 0;
        this.system_nClipWidth = this.system_nCanvasWidth;
        this.system_nClipHeight = this.system_nCanvasHeight;
        asset_InitSoundEngine();
        asset_LoadData();
        system_LoadAllConfigs();
        system_SetVolume(this.system_nVolume);
        system_InitSoftkeys();
        this.system_nLastHighScore = -1;
        scene_Construct();
        this.system_bInitialised = true;
        if (bAssertionSet) {
            return;
        }
        Display.getDisplay(m_Midlet).setCurrent(this);
    }

    void system_StartDelay() {
        this.m_bPaintHourglass = true;
        repaint();
        serviceRepaints();
        this.m_bPaintHourglass = false;
    }

    void system_StartDirtyRectUpdates() {
        this.system_bUpdateDirty = true;
    }

    void system_StopDirtyRectUpdates() {
        this.system_bUpdateDirty = false;
    }

    synchronized void system_StopSound() {
    }

    void system_TransitionFromGameOver(int i) throws Exception {
    }

    int system_TranslateKeyPressed(int i) {
        if (i == -6 && this.system_nFirstSoftkey != 0) {
            return this.system_nFirstSoftkey;
        }
        if (i == -7 && this.system_nSecondSoftkey != 0) {
            return this.system_nSecondSoftkey;
        }
        if (i == -23) {
            return 53;
        }
        return i;
    }

    void system_UpdateDirty(int i, int i2, int i3, int i4) {
        if (this.system_bUpdateDirty) {
            if (this.system_nDirtyWidth < 0) {
                this.system_xDirty = i;
                this.system_yDirty = i2;
                this.system_nDirtyWidth = i3;
                this.system_nDirtyHeight = i4;
                return;
            }
            if (this.system_xDirty > i) {
                this.system_nDirtyWidth += this.system_xDirty - i;
                this.system_xDirty = i;
            }
            if (this.system_xDirty + this.system_nDirtyWidth < i + i3) {
                this.system_nDirtyWidth = (i + i3) - this.system_xDirty;
            }
            if (this.system_yDirty > i2) {
                this.system_nDirtyHeight += this.system_yDirty - i2;
                this.system_yDirty = i2;
            }
            if (this.system_yDirty + this.system_nDirtyHeight < i2 + i4) {
                this.system_nDirtyHeight = (i2 + i4) - this.system_yDirty;
            }
        }
    }

    void system_UpdateHiScores() {
        if (this.system_nScoreSlot < 0) {
            for (int i = 0; i < this.system_HighScoreArray.length; i++) {
                if (this.system_HighScoreArray[i] < this.game_score) {
                    this.system_nScoreSlot = i;
                    this.system_HighScoreArray[i] = this.game_score;
                    for (int length = this.system_HighScoreArray.length - 1; length > i; length--) {
                        this.system_HighScoreArray[length] = this.system_HighScoreArray[length - 1];
                    }
                    system_SaveAllConfigs();
                    return;
                }
            }
            return;
        }
        if (this.game_score > this.system_HighScoreArray[this.system_nScoreSlot]) {
            int i2 = this.system_nScoreSlot;
            while (i2 > 0 && this.system_HighScoreArray[i2 - 1] < this.game_score) {
                for (int length2 = this.system_HighScoreArray.length - 1; length2 >= i2; length2--) {
                    this.system_HighScoreArray[length2] = this.system_HighScoreArray[length2 - 1];
                }
                i2--;
            }
            this.system_HighScoreArray[i2] = this.game_score;
            this.system_nScoreSlot = i2;
            system_SaveAllConfigs();
        }
    }

    void transition_End() {
        this.scene_nCurrentScene &= -32769;
        fadeDistance = null;
        if ((this.scene_nCurrentScene & 4096) == 4096) {
            this.system_bReRenderSoftKeys = true;
        }
    }

    void transition_KeyPressed(int i, int i2) throws Exception {
        if (i == 589826 || i2 == 8 || i == 53) {
            this.transitionDoneNextPaint = true;
        }
    }

    void transition_Render() {
        int i = fade_y_offset;
        int i2 = 0;
        for (int i3 = 0; i3 < realMaxRows; i3++) {
            int i4 = fade_x_offset;
            for (int i5 = 0; i5 < realMaxCols; i5++) {
                if ((fadeDistance[i2] >> 8) > 0 && (fadeDistance[i2] >> 8) <= fade_max_distance) {
                    m_CurrentGraphics.setClip(i4 - (fadeDistance[i2] >> 8), i - (fadeDistance[i2] >> 8), (fadeDistance[i2] >> 8) << 1, (fadeDistance[i2] >> 8) << 1);
                    m_CurrentGraphics.drawImage(this.game_imageMapBuffer, 0, 0, 0);
                }
                i4 += fade_block_width;
                i2++;
            }
            i += fade_block_height;
        }
    }

    void transition_Start() {
        this.firstUpdate = true;
        this.transitionDoneNextPaint = false;
        this.system_bScreenDirty = false;
        this.scene_nCurrentScene |= 32768;
        fade_block_width = this.system_nCanvasWidth / 4;
        fade_block_height = this.system_nCanvasHeight / 4;
        if ((fade_block_width & 1) == 1) {
            fade_block_width++;
        }
        if ((fade_block_height & 1) == 1) {
            fade_block_height++;
        }
        fade_x_offset = fade_block_width / 2;
        fade_y_offset = fade_block_height / 2;
        fade_max_distance = fade_x_offset > fade_y_offset ? fade_x_offset : fade_y_offset;
        realMaxCols = (this.system_nCanvasWidth % fade_block_width == 0 ? 0 : 1) + (this.system_nCanvasWidth / fade_block_width);
        realMaxRows = (this.system_nCanvasHeight / fade_block_height) + (this.system_nCanvasHeight % fade_block_height == 0 ? 0 : 1);
        fade_max_block = realMaxCols * realMaxRows;
        fadeDistance = new int[fade_max_block];
        for (int i = 0; i < fade_max_block; i++) {
            fadeDistance[i] = -(i << 8);
        }
        this.transition_done = false;
    }

    void transition_Update(int i) throws Exception {
        if (this.firstUpdate) {
            this.firstUpdate = false;
            i = 0;
        }
        if (this.transition_done) {
            transition_End();
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < fade_max_block; i3++) {
            int[] iArr = fadeDistance;
            iArr[i3] = iArr[i3] + ((i * 30720) / 1000);
            if ((fadeDistance[i3] >> 8) >= fade_max_distance) {
                fadeDistance[i3] = fade_max_distance << 8;
                i2++;
            }
        }
        if (i2 >= fade_max_block) {
            this.transition_done = true;
        }
    }

    long update_crc(long j, byte[] bArr, int i, int i2) {
        if (this.crc_table_computed == 0) {
            make_crc_table();
        }
        for (int i3 = 0; i3 < i; i3++) {
            j = this.crc_table[((int) (((long) bArr[i3 + i2]) ^ j)) & 255] ^ (j >> 8);
        }
        return j;
    }
}
