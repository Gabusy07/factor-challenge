"use strict";(self.webpackChunkfactor_ecommercer=self.webpackChunkfactor_ecommercer||[]).push([[880],{880:(Zn,ct,l)=>{l.r(ct),l.d(ct,{AuthModule:()=>Yn});var A=l(6814),O=l(2253),i=l(4946),Ce=l(7715),Ve=l(5592),Ae=l(7453),be=l(4829),De=l(4564),Me=l(8251),Ee=l(7400),we=l(2714),Se=l(7398);let ht=(()=>{class e{constructor(t,r){this._renderer=t,this._elementRef=r,this.onChange=o=>{},this.onTouched=()=>{}}setProperty(t,r){this._renderer.setProperty(this._elementRef.nativeElement,t,r)}registerOnTouched(t){this.onTouched=t}registerOnChange(t){this.onChange=t}setDisabledState(t){this.setProperty("disabled",t)}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(i.Qsj),i.Y36(i.SBq))};static#e=this.\u0275dir=i.lG2({type:e})}return e})(),g=(()=>{class e extends ht{static#t=this.\u0275fac=function(){let t;return function(o){return(t||(t=i.n5z(e)))(o||e)}}();static#e=this.\u0275dir=i.lG2({type:e,features:[i.qOj]})}return e})();const h=new i.OlP("NgValueAccessor"),Ne={provide:h,useExisting:(0,i.Gpc)(()=>N),multi:!0},Ge=new i.OlP("CompositionEventMode");let N=(()=>{class e extends ht{constructor(t,r,o){super(t,r),this._compositionMode=o,this._composing=!1,null==this._compositionMode&&(this._compositionMode=!function xe(){const e=(0,A.q)()?(0,A.q)().getUserAgent():"";return/android (\d+)/.test(e.toLowerCase())}())}writeValue(t){this.setProperty("value",t??"")}_handleInput(t){(!this._compositionMode||this._compositionMode&&!this._composing)&&this.onChange(t)}_compositionStart(){this._composing=!0}_compositionEnd(t){this._composing=!1,this._compositionMode&&this.onChange(t)}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(i.Qsj),i.Y36(i.SBq),i.Y36(Ge,8))};static#e=this.\u0275dir=i.lG2({type:e,selectors:[["input","formControlName","",3,"type","checkbox"],["textarea","formControlName",""],["input","formControl","",3,"type","checkbox"],["textarea","formControl",""],["input","ngModel","",3,"type","checkbox"],["textarea","ngModel",""],["","ngDefaultControl",""]],hostBindings:function(r,o){1&r&&i.NdJ("input",function(a){return o._handleInput(a.target.value)})("blur",function(){return o.onTouched()})("compositionstart",function(){return o._compositionStart()})("compositionend",function(a){return o._compositionEnd(a.target.value)})},features:[i._Bn([Ne]),i.qOj]})}return e})();function f(e){return null==e||("string"==typeof e||Array.isArray(e))&&0===e.length}function pt(e){return null!=e&&"number"==typeof e.length}const u=new i.OlP("NgValidators"),p=new i.OlP("NgAsyncValidators"),Pe=/^(?=.{1,254}$)(?=.{1,64}@)[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;class b{static min(n){return function mt(e){return n=>{if(f(n.value)||f(e))return null;const t=parseFloat(n.value);return!isNaN(t)&&t<e?{min:{min:e,actual:n.value}}:null}}(n)}static max(n){return function gt(e){return n=>{if(f(n.value)||f(e))return null;const t=parseFloat(n.value);return!isNaN(t)&&t>e?{max:{max:e,actual:n.value}}:null}}(n)}static required(n){return _t(n)}static requiredTrue(n){return function yt(e){return!0===e.value?null:{required:!0}}(n)}static email(n){return function vt(e){return f(e.value)||Pe.test(e.value)?null:{email:!0}}(n)}static minLength(n){return function Ct(e){return n=>f(n.value)||!pt(n.value)?null:n.value.length<e?{minlength:{requiredLength:e,actualLength:n.value.length}}:null}(n)}static maxLength(n){return function Vt(e){return n=>pt(n.value)&&n.value.length>e?{maxlength:{requiredLength:e,actualLength:n.value.length}}:null}(n)}static pattern(n){return function At(e){if(!e)return x;let n,t;return"string"==typeof e?(t="","^"!==e.charAt(0)&&(t+="^"),t+=e,"$"!==e.charAt(e.length-1)&&(t+="$"),n=new RegExp(t)):(t=e.toString(),n=e),r=>{if(f(r.value))return null;const o=r.value;return n.test(o)?null:{pattern:{requiredPattern:t,actualValue:o}}}}(n)}static nullValidator(n){return null}static compose(n){return Ft(n)}static composeAsync(n){return St(n)}}function _t(e){return f(e.value)?{required:!0}:null}function x(e){return null}function bt(e){return null!=e}function Dt(e){return(0,i.QGY)(e)?(0,Ce.D)(e):e}function Mt(e){let n={};return e.forEach(t=>{n=null!=t?{...n,...t}:n}),0===Object.keys(n).length?null:n}function Et(e,n){return n.map(t=>t(e))}function wt(e){return e.map(n=>function Be(e){return!e.validate}(n)?n:t=>n.validate(t))}function Ft(e){if(!e)return null;const n=e.filter(bt);return 0==n.length?null:function(t){return Mt(Et(t,n))}}function Z(e){return null!=e?Ft(wt(e)):null}function St(e){if(!e)return null;const n=e.filter(bt);return 0==n.length?null:function(t){return function Fe(...e){const n=(0,De.jO)(e),{args:t,keys:r}=(0,Ae.D)(e),o=new Ve.y(s=>{const{length:a}=t;if(!a)return void s.complete();const c=new Array(a);let y=a,V=a;for(let q=0;q<a;q++){let dt=!1;(0,be.Xf)(t[q]).subscribe((0,Me.x)(s,qn=>{dt||(dt=!0,V--),c[q]=qn},()=>y--,void 0,()=>{(!y||!dt)&&(V||s.next(r?(0,we.n)(r,c):c),s.complete())}))}});return n?o.pipe((0,Ee.Z)(n)):o}(Et(t,n).map(Dt)).pipe((0,Se.U)(Mt))}}function W(e){return null!=e?St(wt(e)):null}function Ot(e,n){return null===e?[n]:Array.isArray(e)?[...e,n]:[e,n]}function Nt(e){return e._rawValidators}function xt(e){return e._rawAsyncValidators}function $(e){return e?Array.isArray(e)?e:[e]:[]}function G(e,n){return Array.isArray(e)?e.includes(n):e===n}function Gt(e,n){const t=$(n);return $(e).forEach(o=>{G(t,o)||t.push(o)}),t}function Pt(e,n){return $(n).filter(t=>!G(e,t))}class Bt{constructor(){this._rawValidators=[],this._rawAsyncValidators=[],this._onDestroyCallbacks=[]}get value(){return this.control?this.control.value:null}get valid(){return this.control?this.control.valid:null}get invalid(){return this.control?this.control.invalid:null}get pending(){return this.control?this.control.pending:null}get disabled(){return this.control?this.control.disabled:null}get enabled(){return this.control?this.control.enabled:null}get errors(){return this.control?this.control.errors:null}get pristine(){return this.control?this.control.pristine:null}get dirty(){return this.control?this.control.dirty:null}get touched(){return this.control?this.control.touched:null}get status(){return this.control?this.control.status:null}get untouched(){return this.control?this.control.untouched:null}get statusChanges(){return this.control?this.control.statusChanges:null}get valueChanges(){return this.control?this.control.valueChanges:null}get path(){return null}_setValidators(n){this._rawValidators=n||[],this._composedValidatorFn=Z(this._rawValidators)}_setAsyncValidators(n){this._rawAsyncValidators=n||[],this._composedAsyncValidatorFn=W(this._rawAsyncValidators)}get validator(){return this._composedValidatorFn||null}get asyncValidator(){return this._composedAsyncValidatorFn||null}_registerOnDestroy(n){this._onDestroyCallbacks.push(n)}_invokeOnDestroyCallbacks(){this._onDestroyCallbacks.forEach(n=>n()),this._onDestroyCallbacks=[]}reset(n=void 0){this.control&&this.control.reset(n)}hasError(n,t){return!!this.control&&this.control.hasError(n,t)}getError(n,t){return this.control?this.control.getError(n,t):null}}class d extends Bt{get formDirective(){return null}get path(){return null}}class m extends Bt{constructor(){super(...arguments),this._parent=null,this.name=null,this.valueAccessor=null}}class Tt{constructor(n){this._cd=n}get isTouched(){return!!this._cd?.control?.touched}get isUntouched(){return!!this._cd?.control?.untouched}get isPristine(){return!!this._cd?.control?.pristine}get isDirty(){return!!this._cd?.control?.dirty}get isValid(){return!!this._cd?.control?.valid}get isInvalid(){return!!this._cd?.control?.invalid}get isPending(){return!!this._cd?.control?.pending}get isSubmitted(){return!!this._cd?.submitted}}let It=(()=>{class e extends Tt{constructor(t){super(t)}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(m,2))};static#e=this.\u0275dir=i.lG2({type:e,selectors:[["","formControlName",""],["","ngModel",""],["","formControl",""]],hostVars:14,hostBindings:function(r,o){2&r&&i.ekj("ng-untouched",o.isUntouched)("ng-touched",o.isTouched)("ng-pristine",o.isPristine)("ng-dirty",o.isDirty)("ng-valid",o.isValid)("ng-invalid",o.isInvalid)("ng-pending",o.isPending)},features:[i.qOj]})}return e})(),Ut=(()=>{class e extends Tt{constructor(t){super(t)}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(d,10))};static#e=this.\u0275dir=i.lG2({type:e,selectors:[["","formGroupName",""],["","formArrayName",""],["","ngModelGroup",""],["","formGroup",""],["form",3,"ngNoForm",""],["","ngForm",""]],hostVars:16,hostBindings:function(r,o){2&r&&i.ekj("ng-untouched",o.isUntouched)("ng-touched",o.isTouched)("ng-pristine",o.isPristine)("ng-dirty",o.isDirty)("ng-valid",o.isValid)("ng-invalid",o.isInvalid)("ng-pending",o.isPending)("ng-submitted",o.isSubmitted)},features:[i.qOj]})}return e})();const D="VALID",B="INVALID",v="PENDING",M="DISABLED";function Q(e){return(T(e)?e.validators:e)||null}function X(e,n){return(T(n)?n.asyncValidators:e)||null}function T(e){return null!=e&&!Array.isArray(e)&&"object"==typeof e}function Ht(e,n,t){const r=e.controls;if(!(n?Object.keys(r):r).length)throw new i.vHH(1e3,"");if(!r[t])throw new i.vHH(1001,"")}function Lt(e,n,t){e._forEachChild((r,o)=>{if(void 0===t[o])throw new i.vHH(1002,"")})}class I{constructor(n,t){this._pendingDirty=!1,this._hasOwnPendingAsyncValidator=!1,this._pendingTouched=!1,this._onCollectionChange=()=>{},this._parent=null,this.pristine=!0,this.touched=!1,this._onDisabledChange=[],this._assignValidators(n),this._assignAsyncValidators(t)}get validator(){return this._composedValidatorFn}set validator(n){this._rawValidators=this._composedValidatorFn=n}get asyncValidator(){return this._composedAsyncValidatorFn}set asyncValidator(n){this._rawAsyncValidators=this._composedAsyncValidatorFn=n}get parent(){return this._parent}get valid(){return this.status===D}get invalid(){return this.status===B}get pending(){return this.status==v}get disabled(){return this.status===M}get enabled(){return this.status!==M}get dirty(){return!this.pristine}get untouched(){return!this.touched}get updateOn(){return this._updateOn?this._updateOn:this.parent?this.parent.updateOn:"change"}setValidators(n){this._assignValidators(n)}setAsyncValidators(n){this._assignAsyncValidators(n)}addValidators(n){this.setValidators(Gt(n,this._rawValidators))}addAsyncValidators(n){this.setAsyncValidators(Gt(n,this._rawAsyncValidators))}removeValidators(n){this.setValidators(Pt(n,this._rawValidators))}removeAsyncValidators(n){this.setAsyncValidators(Pt(n,this._rawAsyncValidators))}hasValidator(n){return G(this._rawValidators,n)}hasAsyncValidator(n){return G(this._rawAsyncValidators,n)}clearValidators(){this.validator=null}clearAsyncValidators(){this.asyncValidator=null}markAsTouched(n={}){this.touched=!0,this._parent&&!n.onlySelf&&this._parent.markAsTouched(n)}markAllAsTouched(){this.markAsTouched({onlySelf:!0}),this._forEachChild(n=>n.markAllAsTouched())}markAsUntouched(n={}){this.touched=!1,this._pendingTouched=!1,this._forEachChild(t=>{t.markAsUntouched({onlySelf:!0})}),this._parent&&!n.onlySelf&&this._parent._updateTouched(n)}markAsDirty(n={}){this.pristine=!1,this._parent&&!n.onlySelf&&this._parent.markAsDirty(n)}markAsPristine(n={}){this.pristine=!0,this._pendingDirty=!1,this._forEachChild(t=>{t.markAsPristine({onlySelf:!0})}),this._parent&&!n.onlySelf&&this._parent._updatePristine(n)}markAsPending(n={}){this.status=v,!1!==n.emitEvent&&this.statusChanges.emit(this.status),this._parent&&!n.onlySelf&&this._parent.markAsPending(n)}disable(n={}){const t=this._parentMarkedDirty(n.onlySelf);this.status=M,this.errors=null,this._forEachChild(r=>{r.disable({...n,onlySelf:!0})}),this._updateValue(),!1!==n.emitEvent&&(this.valueChanges.emit(this.value),this.statusChanges.emit(this.status)),this._updateAncestors({...n,skipPristineCheck:t}),this._onDisabledChange.forEach(r=>r(!0))}enable(n={}){const t=this._parentMarkedDirty(n.onlySelf);this.status=D,this._forEachChild(r=>{r.enable({...n,onlySelf:!0})}),this.updateValueAndValidity({onlySelf:!0,emitEvent:n.emitEvent}),this._updateAncestors({...n,skipPristineCheck:t}),this._onDisabledChange.forEach(r=>r(!1))}_updateAncestors(n){this._parent&&!n.onlySelf&&(this._parent.updateValueAndValidity(n),n.skipPristineCheck||this._parent._updatePristine(),this._parent._updateTouched())}setParent(n){this._parent=n}getRawValue(){return this.value}updateValueAndValidity(n={}){this._setInitialStatus(),this._updateValue(),this.enabled&&(this._cancelExistingSubscription(),this.errors=this._runValidator(),this.status=this._calculateStatus(),(this.status===D||this.status===v)&&this._runAsyncValidator(n.emitEvent)),!1!==n.emitEvent&&(this.valueChanges.emit(this.value),this.statusChanges.emit(this.status)),this._parent&&!n.onlySelf&&this._parent.updateValueAndValidity(n)}_updateTreeValidity(n={emitEvent:!0}){this._forEachChild(t=>t._updateTreeValidity(n)),this.updateValueAndValidity({onlySelf:!0,emitEvent:n.emitEvent})}_setInitialStatus(){this.status=this._allControlsDisabled()?M:D}_runValidator(){return this.validator?this.validator(this):null}_runAsyncValidator(n){if(this.asyncValidator){this.status=v,this._hasOwnPendingAsyncValidator=!0;const t=Dt(this.asyncValidator(this));this._asyncValidationSubscription=t.subscribe(r=>{this._hasOwnPendingAsyncValidator=!1,this.setErrors(r,{emitEvent:n})})}}_cancelExistingSubscription(){this._asyncValidationSubscription&&(this._asyncValidationSubscription.unsubscribe(),this._hasOwnPendingAsyncValidator=!1)}setErrors(n,t={}){this.errors=n,this._updateControlsErrors(!1!==t.emitEvent)}get(n){let t=n;return null==t||(Array.isArray(t)||(t=t.split(".")),0===t.length)?null:t.reduce((r,o)=>r&&r._find(o),this)}getError(n,t){const r=t?this.get(t):this;return r&&r.errors?r.errors[n]:null}hasError(n,t){return!!this.getError(n,t)}get root(){let n=this;for(;n._parent;)n=n._parent;return n}_updateControlsErrors(n){this.status=this._calculateStatus(),n&&this.statusChanges.emit(this.status),this._parent&&this._parent._updateControlsErrors(n)}_initObservables(){this.valueChanges=new i.vpe,this.statusChanges=new i.vpe}_calculateStatus(){return this._allControlsDisabled()?M:this.errors?B:this._hasOwnPendingAsyncValidator||this._anyControlsHaveStatus(v)?v:this._anyControlsHaveStatus(B)?B:D}_anyControlsHaveStatus(n){return this._anyControls(t=>t.status===n)}_anyControlsDirty(){return this._anyControls(n=>n.dirty)}_anyControlsTouched(){return this._anyControls(n=>n.touched)}_updatePristine(n={}){this.pristine=!this._anyControlsDirty(),this._parent&&!n.onlySelf&&this._parent._updatePristine(n)}_updateTouched(n={}){this.touched=this._anyControlsTouched(),this._parent&&!n.onlySelf&&this._parent._updateTouched(n)}_registerOnCollectionChange(n){this._onCollectionChange=n}_setUpdateStrategy(n){T(n)&&null!=n.updateOn&&(this._updateOn=n.updateOn)}_parentMarkedDirty(n){return!n&&!(!this._parent||!this._parent.dirty)&&!this._parent._anyControlsDirty()}_find(n){return null}_assignValidators(n){this._rawValidators=Array.isArray(n)?n.slice():n,this._composedValidatorFn=function ke(e){return Array.isArray(e)?Z(e):e||null}(this._rawValidators)}_assignAsyncValidators(n){this._rawAsyncValidators=Array.isArray(n)?n.slice():n,this._composedAsyncValidatorFn=function He(e){return Array.isArray(e)?W(e):e||null}(this._rawAsyncValidators)}}class E extends I{constructor(n,t,r){super(Q(t),X(r,t)),this.controls=n,this._initObservables(),this._setUpdateStrategy(t),this._setUpControls(),this.updateValueAndValidity({onlySelf:!0,emitEvent:!!this.asyncValidator})}registerControl(n,t){return this.controls[n]?this.controls[n]:(this.controls[n]=t,t.setParent(this),t._registerOnCollectionChange(this._onCollectionChange),t)}addControl(n,t,r={}){this.registerControl(n,t),this.updateValueAndValidity({emitEvent:r.emitEvent}),this._onCollectionChange()}removeControl(n,t={}){this.controls[n]&&this.controls[n]._registerOnCollectionChange(()=>{}),delete this.controls[n],this.updateValueAndValidity({emitEvent:t.emitEvent}),this._onCollectionChange()}setControl(n,t,r={}){this.controls[n]&&this.controls[n]._registerOnCollectionChange(()=>{}),delete this.controls[n],t&&this.registerControl(n,t),this.updateValueAndValidity({emitEvent:r.emitEvent}),this._onCollectionChange()}contains(n){return this.controls.hasOwnProperty(n)&&this.controls[n].enabled}setValue(n,t={}){Lt(this,0,n),Object.keys(n).forEach(r=>{Ht(this,!0,r),this.controls[r].setValue(n[r],{onlySelf:!0,emitEvent:t.emitEvent})}),this.updateValueAndValidity(t)}patchValue(n,t={}){null!=n&&(Object.keys(n).forEach(r=>{const o=this.controls[r];o&&o.patchValue(n[r],{onlySelf:!0,emitEvent:t.emitEvent})}),this.updateValueAndValidity(t))}reset(n={},t={}){this._forEachChild((r,o)=>{r.reset(n?n[o]:null,{onlySelf:!0,emitEvent:t.emitEvent})}),this._updatePristine(t),this._updateTouched(t),this.updateValueAndValidity(t)}getRawValue(){return this._reduceChildren({},(n,t,r)=>(n[r]=t.getRawValue(),n))}_syncPendingControls(){let n=this._reduceChildren(!1,(t,r)=>!!r._syncPendingControls()||t);return n&&this.updateValueAndValidity({onlySelf:!0}),n}_forEachChild(n){Object.keys(this.controls).forEach(t=>{const r=this.controls[t];r&&n(r,t)})}_setUpControls(){this._forEachChild(n=>{n.setParent(this),n._registerOnCollectionChange(this._onCollectionChange)})}_updateValue(){this.value=this._reduceValue()}_anyControls(n){for(const[t,r]of Object.entries(this.controls))if(this.contains(t)&&n(r))return!0;return!1}_reduceValue(){return this._reduceChildren({},(t,r,o)=>((r.enabled||this.disabled)&&(t[o]=r.value),t))}_reduceChildren(n,t){let r=n;return this._forEachChild((o,s)=>{r=t(r,o,s)}),r}_allControlsDisabled(){for(const n of Object.keys(this.controls))if(this.controls[n].enabled)return!1;return Object.keys(this.controls).length>0||this.disabled}_find(n){return this.controls.hasOwnProperty(n)?this.controls[n]:null}}class Rt extends E{}const C=new i.OlP("CallSetDisabledState",{providedIn:"root",factory:()=>U}),U="always";function w(e,n,t=U){K(e,n),n.valueAccessor.writeValue(e.value),(e.disabled||"always"===t)&&n.valueAccessor.setDisabledState?.(e.disabled),function Re(e,n){n.valueAccessor.registerOnChange(t=>{e._pendingValue=t,e._pendingChange=!0,e._pendingDirty=!0,"change"===e.updateOn&&jt(e,n)})}(e,n),function Ye(e,n){const t=(r,o)=>{n.valueAccessor.writeValue(r),o&&n.viewToModelUpdate(r)};e.registerOnChange(t),n._registerOnDestroy(()=>{e._unregisterOnChange(t)})}(e,n),function je(e,n){n.valueAccessor.registerOnTouched(()=>{e._pendingTouched=!0,"blur"===e.updateOn&&e._pendingChange&&jt(e,n),"submit"!==e.updateOn&&e.markAsTouched()})}(e,n),function Le(e,n){if(n.valueAccessor.setDisabledState){const t=r=>{n.valueAccessor.setDisabledState(r)};e.registerOnDisabledChange(t),n._registerOnDestroy(()=>{e._unregisterOnDisabledChange(t)})}}(e,n)}function H(e,n,t=!0){const r=()=>{};n.valueAccessor&&(n.valueAccessor.registerOnChange(r),n.valueAccessor.registerOnTouched(r)),R(e,n),e&&(n._invokeOnDestroyCallbacks(),e._registerOnCollectionChange(()=>{}))}function L(e,n){e.forEach(t=>{t.registerOnValidatorChange&&t.registerOnValidatorChange(n)})}function K(e,n){const t=Nt(e);null!==n.validator?e.setValidators(Ot(t,n.validator)):"function"==typeof t&&e.setValidators([t]);const r=xt(e);null!==n.asyncValidator?e.setAsyncValidators(Ot(r,n.asyncValidator)):"function"==typeof r&&e.setAsyncValidators([r]);const o=()=>e.updateValueAndValidity();L(n._rawValidators,o),L(n._rawAsyncValidators,o)}function R(e,n){let t=!1;if(null!==e){if(null!==n.validator){const o=Nt(e);if(Array.isArray(o)&&o.length>0){const s=o.filter(a=>a!==n.validator);s.length!==o.length&&(t=!0,e.setValidators(s))}}if(null!==n.asyncValidator){const o=xt(e);if(Array.isArray(o)&&o.length>0){const s=o.filter(a=>a!==n.asyncValidator);s.length!==o.length&&(t=!0,e.setAsyncValidators(s))}}}const r=()=>{};return L(n._rawValidators,r),L(n._rawAsyncValidators,r),t}function jt(e,n){e._pendingDirty&&e.markAsDirty(),e.setValue(e._pendingValue,{emitModelToViewChange:!1}),n.viewToModelUpdate(e._pendingValue),e._pendingChange=!1}function Zt(e,n){const t=e.indexOf(n);t>-1&&e.splice(t,1)}function Wt(e){return"object"==typeof e&&null!==e&&2===Object.keys(e).length&&"value"in e&&"disabled"in e}const S=class extends I{constructor(n=null,t,r){super(Q(t),X(r,t)),this.defaultValue=null,this._onChange=[],this._pendingChange=!1,this._applyFormState(n),this._setUpdateStrategy(t),this._initObservables(),this.updateValueAndValidity({onlySelf:!0,emitEvent:!!this.asyncValidator}),T(t)&&(t.nonNullable||t.initialValueIsDefault)&&(this.defaultValue=Wt(n)?n.value:n)}setValue(n,t={}){this.value=this._pendingValue=n,this._onChange.length&&!1!==t.emitModelToViewChange&&this._onChange.forEach(r=>r(this.value,!1!==t.emitViewToModelChange)),this.updateValueAndValidity(t)}patchValue(n,t={}){this.setValue(n,t)}reset(n=this.defaultValue,t={}){this._applyFormState(n),this.markAsPristine(t),this.markAsUntouched(t),this.setValue(this.value,t),this._pendingChange=!1}_updateValue(){}_anyControls(n){return!1}_allControlsDisabled(){return this.disabled}registerOnChange(n){this._onChange.push(n)}_unregisterOnChange(n){Zt(this._onChange,n)}registerOnDisabledChange(n){this._onDisabledChange.push(n)}_unregisterOnDisabledChange(n){Zt(this._onDisabledChange,n)}_forEachChild(n){}_syncPendingControls(){return!("submit"!==this.updateOn||(this._pendingDirty&&this.markAsDirty(),this._pendingTouched&&this.markAsTouched(),!this._pendingChange)||(this.setValue(this._pendingValue,{onlySelf:!0,emitModelToViewChange:!1}),0))}_applyFormState(n){Wt(n)?(this.value=this._pendingValue=n.value,n.disabled?this.disable({onlySelf:!0,emitEvent:!1}):this.enable({onlySelf:!0,emitEvent:!1})):this.value=this._pendingValue=n}};let Xt=(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275dir=i.lG2({type:e,selectors:[["form",3,"ngNoForm","",3,"ngNativeValidate",""]],hostAttrs:["novalidate",""]})}return e})(),te=(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275mod=i.oAB({type:e});static#n=this.\u0275inj=i.cJS({})}return e})();const it=new i.OlP("NgModelWithFormControlWarning"),on={provide:d,useExisting:(0,i.Gpc)(()=>j)};let j=(()=>{class e extends d{constructor(t,r,o){super(),this.callSetDisabledState=o,this.submitted=!1,this._onCollectionChange=()=>this._updateDomValue(),this.directives=[],this.form=null,this.ngSubmit=new i.vpe,this._setValidators(t),this._setAsyncValidators(r)}ngOnChanges(t){this._checkFormPresent(),t.hasOwnProperty("form")&&(this._updateValidators(),this._updateDomValue(),this._updateRegistrations(),this._oldForm=this.form)}ngOnDestroy(){this.form&&(R(this.form,this),this.form._onCollectionChange===this._onCollectionChange&&this.form._registerOnCollectionChange(()=>{}))}get formDirective(){return this}get control(){return this.form}get path(){return[]}addControl(t){const r=this.form.get(t.path);return w(r,t,this.callSetDisabledState),r.updateValueAndValidity({emitEvent:!1}),this.directives.push(t),r}getControl(t){return this.form.get(t.path)}removeControl(t){H(t.control||null,t,!1),function $e(e,n){const t=e.indexOf(n);t>-1&&e.splice(t,1)}(this.directives,t)}addFormGroup(t){this._setUpFormContainer(t)}removeFormGroup(t){this._cleanUpFormContainer(t)}getFormGroup(t){return this.form.get(t.path)}addFormArray(t){this._setUpFormContainer(t)}removeFormArray(t){this._cleanUpFormContainer(t)}getFormArray(t){return this.form.get(t.path)}updateModel(t,r){this.form.get(t.path).setValue(r)}onSubmit(t){return this.submitted=!0,function qt(e,n){e._syncPendingControls(),n.forEach(t=>{const r=t.control;"submit"===r.updateOn&&r._pendingChange&&(t.viewToModelUpdate(r._pendingValue),r._pendingChange=!1)})}(this.form,this.directives),this.ngSubmit.emit(t),"dialog"===t?.target?.method}onReset(){this.resetForm()}resetForm(t=void 0){this.form.reset(t),this.submitted=!1}_updateDomValue(){this.directives.forEach(t=>{const r=t.control,o=this.form.get(t.path);r!==o&&(H(r||null,t),(e=>e instanceof S)(o)&&(w(o,t,this.callSetDisabledState),t.control=o))}),this.form._updateTreeValidity({emitEvent:!1})}_setUpFormContainer(t){const r=this.form.get(t.path);(function Yt(e,n){K(e,n)})(r,t),r.updateValueAndValidity({emitEvent:!1})}_cleanUpFormContainer(t){if(this.form){const r=this.form.get(t.path);r&&function qe(e,n){return R(e,n)}(r,t)&&r.updateValueAndValidity({emitEvent:!1})}}_updateRegistrations(){this.form._registerOnCollectionChange(this._onCollectionChange),this._oldForm&&this._oldForm._registerOnCollectionChange(()=>{})}_updateValidators(){K(this.form,this),this._oldForm&&R(this._oldForm,this)}_checkFormPresent(){}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(u,10),i.Y36(p,10),i.Y36(C,8))};static#e=this.\u0275dir=i.lG2({type:e,selectors:[["","formGroup",""]],hostBindings:function(r,o){1&r&&i.NdJ("submit",function(a){return o.onSubmit(a)})("reset",function(){return o.onReset()})},inputs:{form:["formGroup","form"]},outputs:{ngSubmit:"ngSubmit"},exportAs:["ngForm"],features:[i._Bn([on]),i.qOj,i.TTD]})}return e})();const ln={provide:m,useExisting:(0,i.Gpc)(()=>at)};let at=(()=>{class e extends m{set isDisabled(t){}static#t=this._ngModelWarningSentOnce=!1;constructor(t,r,o,s,a){super(),this._ngModelWarningConfig=a,this._added=!1,this.name=null,this.update=new i.vpe,this._ngModelWarningSent=!1,this._parent=t,this._setValidators(r),this._setAsyncValidators(o),this.valueAccessor=function nt(e,n){if(!n)return null;let t,r,o;return Array.isArray(n),n.forEach(s=>{s.constructor===N?t=s:function We(e){return Object.getPrototypeOf(e.constructor)===g}(s)?r=s:o=s}),o||r||t||null}(0,s)}ngOnChanges(t){this._added||this._setUpControl(),function et(e,n){if(!e.hasOwnProperty("model"))return!1;const t=e.model;return!!t.isFirstChange()||!Object.is(n,t.currentValue)}(t,this.viewModel)&&(this.viewModel=this.model,this.formDirective.updateModel(this,this.model))}ngOnDestroy(){this.formDirective&&this.formDirective.removeControl(this)}viewToModelUpdate(t){this.viewModel=t,this.update.emit(t)}get path(){return function k(e,n){return[...n.path,e]}(null==this.name?this.name:this.name.toString(),this._parent)}get formDirective(){return this._parent?this._parent.formDirective:null}_checkParentType(){}_setUpControl(){this._checkParentType(),this.control=this.formDirective.addControl(this),this._added=!0}static#e=this.\u0275fac=function(r){return new(r||e)(i.Y36(d,13),i.Y36(u,10),i.Y36(p,10),i.Y36(h,10),i.Y36(it,8))};static#n=this.\u0275dir=i.lG2({type:e,selectors:[["","formControlName",""]],inputs:{name:["formControlName","name"],isDisabled:["disabled","isDisabled"],model:["ngModel","model"]},outputs:{update:"ngModelChange"},features:[i._Bn([ln]),i.qOj,i.TTD]})}return e})(),_=(()=>{class e{constructor(){this._validator=x}ngOnChanges(t){if(this.inputName in t){const r=this.normalizeInput(t[this.inputName].currentValue);this._enabled=this.enabled(r),this._validator=this._enabled?this.createValidator(r):x,this._onChange&&this._onChange()}}validate(t){return this._validator(t)}registerOnValidatorChange(t){this._onChange=t}enabled(t){return null!=t}static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275dir=i.lG2({type:e,features:[i.TTD]})}return e})();const _n={provide:u,useExisting:(0,i.Gpc)(()=>Y),multi:!0};let Y=(()=>{class e extends _{constructor(){super(...arguments),this.inputName="required",this.normalizeInput=i.VuI,this.createValidator=t=>_t}enabled(t){return t}static#t=this.\u0275fac=function(){let t;return function(o){return(t||(t=i.n5z(e)))(o||e)}}();static#e=this.\u0275dir=i.lG2({type:e,selectors:[["","required","","formControlName","",3,"type","checkbox"],["","required","","formControl","",3,"type","checkbox"],["","required","","ngModel","",3,"type","checkbox"]],hostVars:1,hostBindings:function(r,o){2&r&&i.uIk("required",o._enabled?"":null)},inputs:{required:"required"},features:[i._Bn([_n]),i.qOj]})}return e})(),bn=(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275mod=i.oAB({type:e});static#n=this.\u0275inj=i.cJS({imports:[te]})}return e})();class ge extends I{constructor(n,t,r){super(Q(t),X(r,t)),this.controls=n,this._initObservables(),this._setUpdateStrategy(t),this._setUpControls(),this.updateValueAndValidity({onlySelf:!0,emitEvent:!!this.asyncValidator})}at(n){return this.controls[this._adjustIndex(n)]}push(n,t={}){this.controls.push(n),this._registerControl(n),this.updateValueAndValidity({emitEvent:t.emitEvent}),this._onCollectionChange()}insert(n,t,r={}){this.controls.splice(n,0,t),this._registerControl(t),this.updateValueAndValidity({emitEvent:r.emitEvent})}removeAt(n,t={}){let r=this._adjustIndex(n);r<0&&(r=0),this.controls[r]&&this.controls[r]._registerOnCollectionChange(()=>{}),this.controls.splice(r,1),this.updateValueAndValidity({emitEvent:t.emitEvent})}setControl(n,t,r={}){let o=this._adjustIndex(n);o<0&&(o=0),this.controls[o]&&this.controls[o]._registerOnCollectionChange(()=>{}),this.controls.splice(o,1),t&&(this.controls.splice(o,0,t),this._registerControl(t)),this.updateValueAndValidity({emitEvent:r.emitEvent}),this._onCollectionChange()}get length(){return this.controls.length}setValue(n,t={}){Lt(this,0,n),n.forEach((r,o)=>{Ht(this,!1,o),this.at(o).setValue(r,{onlySelf:!0,emitEvent:t.emitEvent})}),this.updateValueAndValidity(t)}patchValue(n,t={}){null!=n&&(n.forEach((r,o)=>{this.at(o)&&this.at(o).patchValue(r,{onlySelf:!0,emitEvent:t.emitEvent})}),this.updateValueAndValidity(t))}reset(n=[],t={}){this._forEachChild((r,o)=>{r.reset(n[o],{onlySelf:!0,emitEvent:t.emitEvent})}),this._updatePristine(t),this._updateTouched(t),this.updateValueAndValidity(t)}getRawValue(){return this.controls.map(n=>n.getRawValue())}clear(n={}){this.controls.length<1||(this._forEachChild(t=>t._registerOnCollectionChange(()=>{})),this.controls.splice(0),this.updateValueAndValidity({emitEvent:n.emitEvent}))}_adjustIndex(n){return n<0?n+this.length:n}_syncPendingControls(){let n=this.controls.reduce((t,r)=>!!r._syncPendingControls()||t,!1);return n&&this.updateValueAndValidity({onlySelf:!0}),n}_forEachChild(n){this.controls.forEach((t,r)=>{n(t,r)})}_updateValue(){this.value=this.controls.filter(n=>n.enabled||this.disabled).map(n=>n.value)}_anyControls(n){return this.controls.some(t=>t.enabled&&n(t))}_setUpControls(){this._forEachChild(n=>this._registerControl(n))}_allControlsDisabled(){for(const n of this.controls)if(n.enabled)return!1;return this.controls.length>0||this.disabled}_registerControl(n){n.setParent(this),n._registerOnCollectionChange(this._onCollectionChange)}_find(n){return this.at(n)??null}}function _e(e){return!!e&&(void 0!==e.asyncValidators||void 0!==e.validators||void 0!==e.updateOn)}let Dn=(()=>{class e{constructor(){this.useNonNullable=!1}get nonNullable(){const t=new e;return t.useNonNullable=!0,t}group(t,r=null){const o=this._reduceControls(t);let s={};return _e(r)?s=r:null!==r&&(s.validators=r.validator,s.asyncValidators=r.asyncValidator),new E(o,s)}record(t,r=null){const o=this._reduceControls(t);return new Rt(o,r)}control(t,r,o){let s={};return this.useNonNullable?(_e(r)?s=r:(s.validators=r,s.asyncValidators=o),new S(t,{...s,nonNullable:!0})):new S(t,r,o)}array(t,r,o){const s=t.map(a=>this._createControl(a));return new ge(s,r,o)}_reduceControls(t){const r={};return Object.keys(t).forEach(o=>{r[o]=this._createControl(t[o])}),r}_createControl(t){return t instanceof S||t instanceof I?t:Array.isArray(t)?this.control(t[0],t.length>1?t[1]:null,t.length>2?t[2]:null):this.control(t)}static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275prov=i.Yz7({token:e,factory:e.\u0275fac,providedIn:"root"})}return e})(),Mn=(()=>{class e{static withConfig(t){return{ngModule:e,providers:[{provide:it,useValue:t.warnOnNgModelWithFormControl??"always"},{provide:C,useValue:t.callSetDisabledState??U}]}}static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275mod=i.oAB({type:e});static#n=this.\u0275inj=i.cJS({imports:[bn]})}return e})();var En=l(9397),wn=l(6306),Fn=l(8504),Sn=l(7337),On=l(9862),Nn=l(5035);let xn=(()=>{class e{constructor(t,r){this.httpClient=t,this.localStorageService=r,this.URL=`${Sn.N.API_BASE_URL}/api/v1/auth/`}login(t){const r=`${this.URL}login`,o=this.getLoginDto(t);return this.localStorageService.set("username",t.username),this.httpClient.post(r,o).pipe((0,En.b)(s=>{if(this.localStorageService.set("sessionToken",s.token),this.localStorageService.set("id",s.id),!s)throw new Error("Credentials are invalid")}),(0,wn.K)(s=>(0,Fn._)(s)))}getLoginDto(t){return{username:t.username,password:t.password}}static#t=this.\u0275fac=function(r){return new(r||e)(i.LFG(On.eN),i.LFG(Nn.n))};static#e=this.\u0275prov=i.Yz7({token:e,factory:e.\u0275fac,providedIn:"root"})}return e})();var ye=l(1384);function Gn(e,n){1&e&&(i.TgZ(0,"small",16),i._uU(1,"Email incorrecto"),i.qZA())}function Pn(e,n){1&e&&(i.TgZ(0,"small",16),i._uU(1,"El campo email no debe estar vac\xedo"),i.qZA())}function Bn(e,n){1&e&&(i.TgZ(0,"small",16),i._uU(1,"El email ingresado no es v\xe1lido"),i.qZA())}function Tn(e,n){if(1&e&&(i.TgZ(0,"div",13),i.YNc(1,Gn,2,0,"small",14),i.YNc(2,Pn,2,0,"small",14),i.YNc(3,Bn,2,0,"small",15),i.qZA()),2&e){const t=i.oxw();i.xp6(1),i.Q6J("ngIf",null==t.Username?null:t.Username.hasError("incorrect")),i.xp6(1),i.Q6J("ngIf",null==t.Username?null:t.Username.hasError("required")),i.xp6(1),i.Q6J("ngIf",null==t.Username?null:t.Username.hasError("username"))}}function In(e,n){1&e&&(i.TgZ(0,"small",16),i._uU(1,"El campo contrase\xf1a no debe estar vac\xedo"),i.qZA())}function Un(e,n){1&e&&(i.TgZ(0,"small",16),i._uU(1,"Contrase\xf1a incorrecta"),i.qZA())}function kn(e,n){1&e&&(i.TgZ(0,"small",18),i._uU(1,"El campo contrase\xf1a debe ser m\xe1s larga"),i.qZA())}function Hn(e,n){1&e&&(i.TgZ(0,"small",18),i._uU(1,"El campo contrase\xf1a debe ser m\xe1s corta"),i.qZA())}function Ln(e,n){if(1&e&&(i.TgZ(0,"div",13),i.YNc(1,In,2,0,"small",15),i.YNc(2,Un,2,0,"small",15),i.YNc(3,kn,2,0,"small",17),i.YNc(4,Hn,2,0,"small",17),i.qZA()),2&e){const t=i.oxw();i.xp6(1),i.Q6J("ngIf",null==t.Password?null:t.Password.hasError("required")),i.xp6(1),i.Q6J("ngIf",null==t.Password?null:t.Password.hasError("incorrect")),i.xp6(1),i.Q6J("ngIf",null==t.Password||null==t.Password.errors?null:t.Password.errors.minlength),i.xp6(1),i.Q6J("ngIf",null==t.Password||null==t.Password.errors?null:t.Password.errors.maxlength)}}const ve=function(e,n){return{"border-red-500":e,"border-green-500":n}},Rn=[{path:"",component:(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275cmp=i.Xpm({type:e,selectors:[["app-auth-layout"]],decls:2,vars:0,consts:[[1,"p-3"]],template:function(r,o){1&r&&(i.TgZ(0,"section",0),i._UZ(1,"router-outlet"),i.qZA())},dependencies:[O.lC],styles:["section[_ngcontent-%COMP%]{display:flex;justify-content:center;align-items:center;background-color:#b0ac6e;height:100vh;width:100vw}"]})}return e})(),children:[{path:"login",component:(()=>{class e{navigateToRegiste(){throw new Error("Method not implemented.")}constructor(t,r,o){this.formBuilder=t,this.route=r,this.loginService=o,this.form=this.initForm()}initForm(){return this.formBuilder.group({username:["",[b.required,b.email]],password:["",[b.required,b.minLength(5),b.maxLength(18)]]})}get Username(){return this.form.get("username")}get Password(){return this.form.get("password")}send(){this.loginService.login(this.form.value).subscribe({next:t=>{alert("Inicio de sesi\xf3n exitoso"),this.route.navigate([""])},error:t=>{"username incorrect"===t.error?this.Username?.setErrors({incorrect:!0}):"password incorrect"===t.error&&this.Password?.setErrors({incorrect:!0}),console.error("Error al iniciar sesi\xf3n ",t.error)}})}static#t=this.\u0275fac=function(r){return new(r||e)(i.Y36(Dn),i.Y36(O.F0),i.Y36(xn))};static#e=this.\u0275cmp=i.Xpm({type:e,selectors:[["app-login"]],decls:22,vars:15,consts:[[1,"bg-gray-100","shadow-md","rounded","px-10","py-5","pt-6","pb-8","mb-4"],[1,"text-xl","font-bold","mb-4"],[1,"mb-4",3,"formGroup","ngSubmit"],[1,"mb-4"],["for","username",1,"block","text-gray-700","text-sm","font-bold","mb-2"],["name","username","type","username","required","","formControlName","username",1,"appearance-none","border","rounded","w-full","py-2","px-3","text-gray-700","leading-tight","focus:outline-none","focus:border-blue-500",3,"ngClass"],["class","mt-2",4,"ngIf"],["for","password",1,"block","text-gray-700","text-sm","font-bold","mb-2"],["name","password","type","password","formControlName","password",1,"appearance-none","border","rounded","w-full","py-2","px-3","text-gray-700","leading-tight","focus:outline-none","focus:border-blue-500",3,"ngClass"],[1,"text-center"],["type","submit",3,"width","color","disabled","label"],[1,"text-center","text-sm"],[1,"text-blue-500",3,"click"],[1,"mt-2"],["class","text-red-500 w-full  underline",4,"ngIf"],["class","text-red-500 w-full underline",4,"ngIf"],[1,"text-red-500","w-full","underline"],["class","text-red-500 underline",4,"ngIf"],[1,"text-red-500","underline"]],template:function(r,o){1&r&&(i.TgZ(0,"div",0)(1,"h5",1),i._uU(2,"Iniciar Sesi\xf3n"),i.qZA(),i.TgZ(3,"form",2),i.NdJ("ngSubmit",function(){return o.send()}),i.TgZ(4,"div",3)(5,"label",4),i._uU(6,"email:"),i.qZA(),i._UZ(7,"input",5),i.YNc(8,Tn,4,3,"div",6),i.qZA(),i.TgZ(9,"div",3)(10,"label",7),i._uU(11,"Contrase\xf1a:"),i.qZA(),i._UZ(12,"input",8),i.YNc(13,Ln,5,4,"div",6),i.qZA(),i.TgZ(14,"div",9),i._UZ(15,"app-button",10),i.qZA()(),i.TgZ(16,"p",11),i._uU(17," No est\xe1s registrado? "),i.TgZ(18,"span"),i._uU(19,"Ingresa "),i.TgZ(20,"a",12),i.NdJ("click",function(){return o.navigateToRegiste()}),i._uU(21,"aqu\xed"),i.qZA()()()()),2&r&&(i.xp6(3),i.Q6J("formGroup",o.form),i.xp6(4),i.Q6J("ngClass",i.WLB(9,ve,(null==o.Username?null:o.Username.errors)&&(null==o.Username?null:o.Username.touched),!(null!=o.Username&&o.Username.errors)&&(null==o.Username?null:o.Username.touched))),i.xp6(1),i.Q6J("ngIf",(null==o.Username?null:o.Username.errors)&&(null==o.Username?null:o.Username.touched)),i.xp6(4),i.Q6J("ngClass",i.WLB(12,ve,(null==o.Password?null:o.Password.errors)&&(null==o.Password?null:o.Password.touched),!(null!=o.Password&&o.Password.errors)&&(null==o.Password?null:o.Password.touched))),i.xp6(1),i.Q6J("ngIf",(null==o.Password?null:o.Password.errors)&&(null==o.Password?null:o.Password.touched)),i.xp6(2),i.Q6J("width","100%")("color","blue")("disabled",!o.form.valid)("label","Ingresar"))},dependencies:[A.mk,A.O5,Xt,N,It,Ut,Y,j,at,ye.r],styles:["form[_ngcontent-%COMP%]{min-width:15rem;width:100%;height:auto}label[_ngcontent-%COMP%]{display:block;font-weight:700;margin-bottom:5px}input[type=text][_ngcontent-%COMP%], input[type=email][_ngcontent-%COMP%], input[type=password][_ngcontent-%COMP%], textarea[_ngcontent-%COMP%]{display:block;width:100%;min-width:175px;padding:10px;margin-bottom:20px;border:1px solid #ccc;border-radius:12px;font-size:16px;font-family:inherit}input[type=submit][_ngcontent-%COMP%]:hover{background-color:#2980b9}a[_ngcontent-%COMP%]{color:#8a2be2}"]})}return e})()}]},{path:"**",redirectTo:""}];let jn=(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275mod=i.oAB({type:e});static#n=this.\u0275inj=i.cJS({imports:[O.Bz.forChild(Rn),O.Bz]})}return e})(),Yn=(()=>{class e{static#t=this.\u0275fac=function(r){return new(r||e)};static#e=this.\u0275mod=i.oAB({type:e});static#n=this.\u0275inj=i.cJS({imports:[A.ez,jn,Mn,ye.r]})}return e})()}}]);